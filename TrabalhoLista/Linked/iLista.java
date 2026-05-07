public interface iLista{
    public int size();
    public boolean isEmpty();
    public boolean isFirst(No n);
    public boolean isLast(No n);
    public No first();
    public No last();
    public No before(No n);
    public No after(No n);
    public void replaceElement(No n,Object o);
    public void swapElements(No n, No q);
}