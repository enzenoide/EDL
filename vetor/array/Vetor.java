public class Vetor{
    public int size_;
    private int capacity;
    public int start;
    public Object data[];

    Vetor(int capacity){
        this.size_ = 0;
        this.start = 0;
        this.capacity = capacity;
        this.data = new Object[this.capacity];
    }

    public Object elemAtRank(int r){
        if(r >= this.size_)
            return null;
        return this.data[(start + r) % capacity];
    }
    public Object replaceAtRank(int r, Object o){
        Object temp = this.data[(start + r) % capacity];
        this.data[(start + r) % capacity] = o;
        return temp;
    }
    public void insertAtRank(int r, Object o){
        this.data[(start + r) % capacity] = o;
        this.size_++;
    }
    public int size(){
        return this.size_;
    }
    public boolean isEmpty(){
        return this.size_ == 0;
    }
    public Object removeAtRank(int r){
        Object temp = this.data[(start + r) % capacity];
        for(int i = r; i < this.size_; ++i){
            this.data[(start + i) % capacity] = this.data[(start + i + 1) % capacity];
        }
        this.size_--;
        return temp;
    }
    public void increaseCapacity(){
        int nova_capacity = this.capacity * 2;
        Object novo = new Object[nova_capacity];
        for(int i = 0; i < this.size_;++i){
            novo[i] = this.data[(start + i) % nova_capacity];
        }
        this.data = novo;
        this.capacity = nova_capacity;
        this.start = 0;
    }
    

}