package TrabalhoLista;

public class Lista implements iLista{
    public int capacity;
    public Object[] data;
    public int size_;
    public int start;

    public Lista(int capacity){
        this.data = new Object[capacity];
        this.capacity = capacity;
        this.size_ = 0;
        this.start = 0;
    }
    public int size(){
        return this.size_;
    }
    public boolean isEmpty(){
        return this.size_ == 0;
    }
    public boolean isFirst(Object o){
        return o == data[start];
    }
    public boolean isLast(Object o){
        return o == this.data[(start + this.size_ - 1) % capacity];
    }
    public Object first(){
        if(isEmpty())
            return null;
        return this.data[start];
    }
    public Object last(){
        if(isEmpty())
            return null;
        return this.data[(start + this.size_ - 1) % capacity];
    }
    public void insertFirst(Object o){
        if(this.size_ == this.capacity){
            resize(this.capacity * 2);
        }
        //move o start uma casa pra trás
        this.start = (start - 1 + capacity) % capacity;
        this.data[start] = o;
        this.size_++;
    }
    //inserir excecao
    public void insertLast(Object o){
        if(this.size_ == this.capacity){
            resize(this.capacity * 2);
        }
        this.data[(start + this.size_) % capacity] = o;
        this.size_++;
    }
    public Object remove(int n){
        if(n < 0 || n > this.size_ - 1){
            indexOutOfBounds();
        }
        Object temp = this.data[(start + n) % capacity];
        for(int i = n;i < this.size_ - 1; ++i){
            this.data[(start + i) % capacity] = this.data[(start + i + 1) % capacity]   ;
        }
        this.size_--;
        if(this.size_ > 0  && this.size_ < this.capacity / 3){
            resize(this.capacity / 2);
        }
        return temp;
    }
    public Object replaceElements(int n, Object o){
        if(n < 0 || n > this.size_ - 1){
            indexOutOfBounds();
        }
        Object temp = this.data[(start + n) % capacity];
        this.data[(start + n) % capacity] = o;
        return temp;
    }
    public void swapElements(int n,int q){
        if(n < 0 || n >= this.size_ || q < 0 || q >= this.size_){
            indexOutOfBounds();
        }
        Object temp = this.data[(start + n)%capacity];
        this.data[(start + n) % capacity] = this.data[(start + q) % capacity];
        this.data[(start + q) % capacity] = temp;
    }
    public void insertBefore(int n, Object o){
        if(n < 0 || n >= this.size_){
            indexOutOfBounds();
        }
        if(this.size_ == this.capacity){
            resize(this.capacity * 2);
        }
        if(n < this.size_ / 2)
            shiftLeft(n);
        else
            shiftRight(n);
        this.data[(start + n) % capacity] = o;
        this.size_++;
    }
    public void insertAfter(int n, Object o){
        if(n < 0 || n > this.size_ - 1){
            indexOutOfBounds();
        }
        if(this.size_ == this.capacity){
            resize(this.capacity * 2);
        }
        if(n < this.size_ / 2)
            shiftLeft(n + 1);
        else
            shiftRight(n + 1);
        this.data[(start + n + 1) % capacity] = o;
        this.size_++;
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
    public void indexOutOfBounds() throws ListaException{
        throw new ListaException("Index out of bounds");
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
