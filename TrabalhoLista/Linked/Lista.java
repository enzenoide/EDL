public class Lista{
    private No tail,head;
    public int size_;
    public Lista(){
        this.head = new No();
        this.tail = new No();
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.size_ = 0;
    }
    public int size(){
        return this.size_;
    }
    public boolean isEmpty(){
        return this.size_ == 0;
    }
    public No first(){
        return this.head.getNext();
    }
    public No Last(){
        return this.tail.getPrev();
    }
    public No after(No n){return n.getNext();}
    public No before(No n){return n.getPrev();}
    public boolean isFirst(No n){
        return this.head.getNext() == n;
    }
    public boolean isLast(No n){
        return this.tail.getPrev() == n;
    }
    public void insertFirst(Object elemento){
        No novoNo = new No();
        novoNo.setElemento(elemento);
        this.head.getNext().setPrev(novoNo);
        this.head.setNext(novoNo);
        novoNo.setPrev(this.head);
    }
    public void insertLast(Object elemento){
        No novoNo = new No();
        novoNo.setElemento(elemento);
        this.tail.getPrev().setNext(novoNo);
        this.tail.setPrev(novoNo);
        novoNo.setNext(this.tail);
    }
    public Object remove(No n){
        n.getPrev().setNext(n.getNext());
        n.getNext().setPrev(n.getPrev());
        return n.getElemento();
    }
    public void insertBefore(No n,Object elemento){
        No novoNo = new No();
        novoNo.setElemento(elemento)

        novoNo.setNext(n);
        novoNo.setPrev(n.getPrev());

        n.getPrev().setNext(novoNo);
        n.setPrev(novoNo);
    }
    public void insertAfter(No n, Object elemento){
        No novoNo = new No();
        novoNo.setElemento(elemento)

        novoNo.setPrev(n);
        novoNo.setNext(n.getNext())

        n.getNext().setPrev(novoNo);
        n.setNext(novoNo);
    }
    public void replaceElement(No n, Object elemento){
        n.setElemento(elemento);
    }
    // FALTA EXCECOES AQUI
    public void swapElements(No n, No q){
        No primeiro = n;
        No segundo = q;
        No prevPrimeiro = primeiro.getPrev();
        No nextPrimeiro = primeiro.getNext();
        No prevSegundo = segundo.getPrev();
        No nextSegundo = segundo.getNext();
        prevPrimeiro.setNext(segundo);
        nextPrimeiro.setPrev(segundo);
        prevSegundo.setNext(primeiro);
        nextSegundo.setPrev(primeiro);
        
        segundo.setPrev(prevPrimeiro);
        segundo.setNext(nextPrimeiro);
        primeiro.setPrev(prevSegundo);
        primeiro.setNext(nextSegundo);
    }
}