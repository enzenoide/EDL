package TrabalhoVetor.Array;

public interface iVetor {

    public Object elemAtRank(int r);
    public Object removeAtRank(int r);
    public Object replaceAtRank(int r,Object o);
    public void insertAtRank(int r,Object o);
    public int size();
    public boolean isEmpty();
    public void resize(int novoN);
    public void shiftLeft(int n);
    public void shiftRight(int n);

}
