package TrabalhoVetor.Linked;

import TrabalhoVetor.Array.VetorException;

public class Vetor {
    private No head;
    private No tail;
    public int size_;

    public Vetor(){
        this.head = new No();
        this.tail = new No();
        this.head.setNext(tail);
        this.tail.setPrev(head);
        this.size_ = 0;
    }
    public void insertAtRank(int r,Object o){
        if(r >= this.size_)
            indexOutOfBounds();
        No current = this.head.getNext();
        for(int i = 0; i < r;++i){
           current = current.getNext();
        }
        No antecessor = current.getPrev();

        No novo = new No();
        novo.setElemento(o);
        novo.setNext(current);
        novo.setPrev(antecessor);

        antecessor.setNext(novo);
        current.setPrev(novo);
        this.size_++;
    }
    public Object removeAtRank(int r){
        if(r >= this.size_)
            indexOutOfBounds();
        No current = this.head.getNext();
        for(int i = 0; i < r; ++i){
            current = current.getNext();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        this.size_--;
        return current.getElemento();
    }
    public Object replaceAtRank(int r,Object o){
        if(r >= this.size_)
            indexOutOfBounds();
        No current = this.head.getNext();
        for(int i = 0; i < r; ++i){
            current = current.getNext();
        }
        Object temp = current.getElemento();
        current.setElemento(o);
        return temp;
    }
    public Object elemAtRank(int r){
        if(r >= this.size_)
            indexOutOfBounds();
        No current = this.head.getNext();
        for(int i = 0; i < r; ++i){
            current = current.getNext();
        }
        return current.getElemento();
    }
    public int size(){
        return this.size_;
    }
    public void indexOutOfBounds() throws TrabalhoVetor.Array.VetorException {
        throw new VetorException("Index out of bounds");
    }
}
