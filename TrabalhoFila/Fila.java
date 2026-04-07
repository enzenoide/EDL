public class Fila implements iFila{
    private No head;
    private No tail;

    public Fila(){
        this.head = null;
        this.tail = null;
    }

    public int size(){
        int i = 0;
        if(head == null){
            return 0;
        }
        if(head == tail){
            return 1;
        }
        No current = this.head;
        while(current != null){
            current = current.getNext();
            i++;
        }
        return i;
    }
    public Object first(){
        if(isEmpty()){
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        return this.head.getElemento();
    }
    public boolean isEmpty(){
        return head == null;
    }
    public Object dequeue(){
        if(isEmpty()){
            throw new FilaVaziaExcecao("A fila está vazia");
        }
        if(head == tail){
            Object elemento = head.getElemento();
            head = null;
            tail = null;
            return elemento;
        }
        No to_delete = this.head;
        this.head = to_delete.getNext();
        to_delete.setNext(null);
        return to_delete.getElemento();
    }
    public void enqueue(Object elemento){
        No novo = new No();
        if(isEmpty()){
            this.head = novo;
            this.tail = novo;
            novo.setElemento(elemento);
            return;
        }
        novo.setElemento(elemento);
        this.tail.setNext(novo);
        this.tail = novo;
    }

}
