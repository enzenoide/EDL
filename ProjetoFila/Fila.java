package ProjetoFila;

public class Fila implements iFila{
    public int i,f,N,incremento;
    public Object[] data;
    public boolean reverse;
    public int size_;

    public Fila(int N, int incremento){
        this.data = new Object[N];
        this.N = N;
        this.incremento = incremento;
        this.reverse = false;
        this.size_ = 0;
    }

    public void enqueue(Object elemento){
        if(size() == N-1){
            int proximoN;
            if (this.incremento == 0) {
                proximoN = this.N * 2;
            } else {
                proximoN = this.N + this.incremento;
            }
            rearrange(proximoN);
        }
        if(this.reverse){
            this.data[f] = elemento;
            this.f = (this.f - 1 + N) % N;
        }
        else {
            this.data[this.f] = elemento;
            this.f = (this.f + 1) % N;
        }
        this.size_++;
    }
    public int size(){
        return this.size_;
    }
    public boolean isEmpty(){
        return this.i == this.f;
    }
    public Object dequeue() throws FilaVaziaExcecao {
        if(isEmpty())
            throw new FilaVaziaExcecao("A fila está vazia");
        Object temp = this.data[i];
        if(this.reverse)
            this.i = (this.i - 1 + N) % N;
        else
            this.i = (this.i + 1) % N;
        this.size_--;
        if(this.size_ > 0 && this.size_ <= N / 3) {
            int proximoN = N / 2;
            rearrange(proximoN);
        }
        return temp;
    }
    public void reverter(){
        if(isEmpty()){
            this.reverse = !this.reverse;
            return;
        }
        if(!this.reverse){
            //o i agora aponta para o elemento que era o fim da fila,como f aponta para o vazio, i está em f - 1
            int novo_i = (f - 1 + N) % N;
            //o f agora aponta para a vaga q está atras do antigo inicio
            int novo_f = (this.i - 1 + N) % N;
            this.i = novo_i;
            this.f = novo_f;
            this.reverse = true;
        }
        else {
            //o elemento "mais velho" volta a ser o início
            int novo_i = (f + 1) % N;
            //a vaga após o início reverso vira o novo fim
            int novo_f = (i + 1) % N;
            this.i = novo_i;
            this.f = novo_f;
            this.reverse = false;
        }
    }
    //essa função trata o increase_capacity e reduct, para evitar repetição de código ja que os dois métodos
    //são quase idênticos
    public void rearrange(int novoN){
        this.N = novoN;
        Object[] novoArray = new Object[this.N];
        int totalElelementos = size();
        for(int j = 0;j < totalElelementos;++j){
            novoArray[j]= this.data[i];

            // anda com o i para o proximo elemento independente se está reverse ou não
            if(this.reverse)
                this.i = (this.i - 1 + N) % N;
            else
                this.i = (this.i + 1) % N;
        }
        this.i = 0;
        this.data = novoArray;
        this.f = totalElelementos;

        //desentorta a fila, como ela já está copiada de forma inversa, não tem problema
        this.reverse = false;
    }

}