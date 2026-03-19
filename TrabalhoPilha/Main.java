package TrabalhoPilha;

public class Main {
    public static void main(String[] args){
        PilhaColorida pilha = new PilhaColorida(10);
        pilha.push_preta(10);
        pilha.push_preta(20);
        pilha.push_preta(30);

        pilha.push_vermelha(1);
        pilha.push_vermelha(2);
        pilha.push_vermelha(3);
        pilha.push_vermelha(4);
        pilha.push_vermelha(5);
        pilha.push_vermelha(6);
        pilha.push_vermelha(7);
        pilha.push_vermelha(8);

        pilha.pop_vermelha();
        pilha.pop_vermelha();
        pilha.pop_vermelha();
        pilha.pop_vermelha();
        pilha.pop_vermelha();
        pilha.pop_vermelha();
        pilha.pop_vermelha();


        System.out.println(pilha.getTopoPilhaPreta());
        System.out.println(pilha.getTopoPilhaVermelha());
        System.out.println(pilha.getCapacity());
    }
}
