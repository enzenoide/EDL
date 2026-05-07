#include <memory>
#include <vector>
#include <algorithm>
#include <any>
#include <stdexcept>

class tree {
public:
    struct No {
        std::any value;
        No* pai;
        std::vector<std::unique_ptr<No>> children;

        No(No* p, std::any v) : value(v), pai(p) {}

        void addChild(std::unique_ptr<No> child) {
            children.push_back(std::move(child));
        }

        void removeChild(No* childPtr) {
            children.erase(std::remove_if(children.begin(), children.end(),
                [childPtr](const std::unique_ptr<No>& ptr) {
                    return ptr.get() == childPtr;
                }),
                children.end());
        }

        size_t children_number() const {
            return children.size();
        }
    };

private:
    std::unique_ptr<No> raiz;
    size_t tamanho;

public:
    tree(std::any elemento) {
        raiz = std::make_unique<No>(nullptr, elemento);
        tamanho = 1;
    }

    No* root() const {
        return raiz.get();
    }

    No* Parent(No* node) const {
        return node->pai;
    }

    bool isExternal(No* node) const {
        return node->children_number() == 0;
    }

    bool isInternal(No* node) const {
        return node->children_number() > 0;
    }

    bool isRoot(No* node) const {
        return node == raiz.get();
    }

    void addChild(No* node, std::any element) {
        auto novo = std::make_unique<No>(node, element);
        node->addChild(std::move(novo));
        tamanho++;
    }

    std::any remove(No* node) {
        No* pai = node->pai;
        if (pai != nullptr && isExternal(node)) {
            std::any o = node->value;
            pai->removeChild(node);
            tamanho--;
            return o;
        }
        throw std::runtime_error("Não foi possível remover: No possui filhos ou é a raiz.");
    }

    size_t depth(No* node) const {
        size_t count = 0;
        No* atual = node;
        while (!isRoot(atual)) {
            count++;
            atual = atual->pai;
        }
        return count;
    }

    size_t size() const {
        return tamanho;
    }

    bool isEmpty() const {
        return false;
    }

    std::any replace(No* node, std::any element) {
        std::any antigo = node->value;
        node->value = element;
        return antigo;
    }

    void swapElements(No* node1, No* node2) {
        std::any temp = node1->value;
        node1->value = node2->value;
        node2->value = temp;
    }
};
