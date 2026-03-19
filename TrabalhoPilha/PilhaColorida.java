package TrabalhoPilha;

public class PilhaColorida {
    private Object[] data;
    private int size_;
    private int capacity;
    private int topoPilhaPreta;
    private int topoPilhaVermelha;

    PilhaColorida(int capacity){
        this.size_ = 0;
        this.capacity = capacity;
        this.topoPilhaVermelha = -1;
        this.topoPilhaPreta = capacity;
        this.data = new Object[capacity];
    }
    public int getTopoPilhaPreta(){
        return this.topoPilhaPreta;
    }
    public int getTopoPilhaVermelha(){
        return this.topoPilhaVermelha;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public int size(){
        return this.size_;
    }
    public boolean isEmpty(){
        return this.size_ == 0;
    }

    public void increase_capacity(){
        int oldCapacity = this.capacity;
        int quantidadePreta = oldCapacity - topoPilhaPreta;
        this.capacity *= 2;
        Object[] newData = new Object[capacity];
        for(int i = 0; i <= topoPilhaVermelha;++i){
            newData[i] = data[i];
        }
        int i = capacity - quantidadePreta;
        int j = topoPilhaPreta;
        for(int k = 0; k < quantidadePreta; ++k){
            newData[i] = data[j];
            ++i;
            ++j;
        }
        topoPilhaPreta = capacity - quantidadePreta;
        data = newData;
    }

    public void reduct(){
        int oldCapacity = this.capacity;
        int quantidadePreta = oldCapacity - topoPilhaPreta;
        this.capacity /= 2;
        Object[] newData = new Object[capacity];
        for(int i = 0; i <= topoPilhaVermelha; ++i){
            newData[i] = data[i];
        }
        int i = capacity - quantidadePreta;
        int j = topoPilhaPreta;
        for(int k = 0; k < quantidadePreta;++k){
            newData[i] = data[j];
            ++i;
            ++j;
        }
        topoPilhaPreta = capacity - quantidadePreta;
        data = newData;
    }
    public boolean isFull(){
        return topoPilhaVermelha + 1 == topoPilhaPreta;
    }
    public boolean push_preta(int value){
        if(isFull()){
            increase_capacity();
        }
        data[--topoPilhaPreta] = value;
        this.size_++;
        return true;
    }
    public boolean push_vermelha(int value){
        if(isFull()){
            increase_capacity();
        }
        data[++topoPilhaVermelha] = value;
        this.size_++;
        return true;
    }

    public boolean pop_preta(){
        if(isEmpty())
            return false;
        this.topoPilhaPreta++;
        this.size_--;
        if(this.size_ < this.capacity / 3){
            reduct();
        }
        return true;
    }
    public boolean pop_vermelha(){
        if(isEmpty())
            return false;
        this.topoPilhaVermelha--;
        this.size_--;
        if(this.size_ < this.capacity / 3){
            reduct();
        }
        return true;
    }
}