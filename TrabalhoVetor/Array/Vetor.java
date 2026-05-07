package TrabalhoVetor.Array;

public class Vetor {
    public int capacity;
    public Object[] data;
    public int size_;
    public int start;

    Vetor(int capacity){
        this.data = new Object[capacity];
        this.capacity = capacity;
        this.size_ = 0;
        this.start = 0;
    }
    public Object elemAtRank(int r){
        if(r >= this.size_)
            indexOutOfBounds();
        return this.data[(start + r) % capacity];
    }
    public Object replaceAtRank(int r,Object o){
        if(r >= this.size_)
            indexOutOfBounds();
        Object temp = this.data[(start + r) % capacity];
        this.data[(start + r) % capacity] = o;
        return temp;
    }
    public void insertAtRank(int r,Object o){
        if(r >= this.size_)
            indexOutOfBounds();
        if(this.size_ == this.capacity){
            resize(this.capacity * 2);
        }
        if(n < this.size_ / 2)
            shiftLeft(int r);
        else
            shiftRight(int r);
        this.data[(start + r) % this.capacity] = o;
        this.size_++;
    }
    public Object removeAtRank(int r){
        if(r >= this.size_)
            indexOutOfBounds();
        Object elemento = this.data[(start + r) % this.capacity];
        if(n < this.size_ / 2)
            shiftLeft(int r);
        else
            shiftRight(int r);
        this.size_--;
        if(this.size_ > 0  && this.size_ < this.capacity / 3){
            resize(this.capacity / 2);
        }
        return elemento;
    }
    public int size(){
        return this.size_;
    }
    public boolean isEmpty(){
        return size_ == 0;
    }
    public void resize(int novoN){
        Object[] novoArray = new Object[novoN];
        for(int j = 0;j < this.size_;++j){
            novoArray[j]= this.data[(start + j) % this.capacity];
        }
        this.data = novoArray;
        this.capacity = novoN;
        this.start = 0;
    }
    public void indexOutOfBounds() throws VetorException{
        throw new VetorException("Index out of bounds");
    }
    public void shiftRight(int n){
        for(int i = this.size_; i > n; --i){
            this.data[(start + i) % capacity] = this.data[(start + i - 1) % capacity];
        }

    }
    public void shiftLeft(int n){
        this.start = (start - 1 + capacity) % capacity;
        for(int i = 0; i < n; ++i){
            this.data[(start + i) % capacity] = this.data[(start + i + 1) % capacity];
        }
    }
}
