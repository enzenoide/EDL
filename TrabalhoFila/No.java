public class No {
    private Object elemento;
    private No proximo;

    public Object getElemento(){
        return elemento;
    }
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    public void setNext(No next){
        this.proximo = next;
    }
    public No getNext(){
        return this.proximo;
    }
}
