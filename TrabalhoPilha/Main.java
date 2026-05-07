package TrabalhoPilha;

public class Main {
    public static void main(String[] args){
        PilhaColorida pilha = new PilhaColorida(10);


        pilha.push_vermelha(1);
        pilha.push_vermelha(2);


        pilha.pop_vermelha();
        pilha.pop_preta();
        System.out.println(pilha.getTopoPilhaPreta());
        System.out.println(pilha.getTopoPilhaVermelha());
        System.out.println(pilha.getCapacity());
    }
}
