package TrabalhoVetor.Linked;

public class No {
    public No next,prev;
    public Object value;

    public No getNext(){
        return this.next;
    }
    public void setNext(No next){
        this.next = next;
    }
    public No getPrev(){
        return this.prev;
    }
    public void setPrev(No prev){
        this.prev = prev;
    }
    public Object getElemento(){
        return value;
    }
    public void setElemento(Object value){
        this.value = value;
    }
}
