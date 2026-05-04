public class No{
    private No prev,next;
    private Object elemento;
    
    public No getNext(){
        return this.next;
    }
    public No getPrev(){
        return this.prev;
    }
    public Object getElemento(){
        return this.elemento;
    }
    public void setNext(No novoNo){
        this.next = novoNo;
    }
    public void setPrev(No novoNo){
        this.prev = novoNo;
    }
    public void setElemento(Object novoElemento){
        this.elemento = novoElemento;
    }

}