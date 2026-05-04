package TrabalhoVetor.Array;

public class TesteVetor {
    public static void main(String[] args) {
        // 1. Inicializa com capacidade pequena para testar o resize rápido
        Vetor v = new Vetor(4);
        System.out.println("--- Teste de Inserção e Resize ---");

        v.insertAtRank(0, "A"); // [A]
        v.insertAtRank(1, "B"); // [A, B]
        v.insertAtRank(2, "C"); // [A, B, C]
        v.insertAtRank(0, "Z"); // [Z, A, B, C] - Inseriu no início

        System.out.println("Tamanho após 4 inserções: " + v.size()); // 4

        // Esta inserção deve disparar o resize de 4 para 8
        v.insertAtRank(4, "D");
        System.out.println("Tamanho após resize: " + v.size()); // 5
        System.out.println("Capacidade atual: " + v.capacity); // 8

        printVetor(v); // Esperado: Z, A, B, C, D

        System.out.println("\n--- Teste de Substituição ---");
        Object antigo = v.replaceAtRank(2, "B-Modificado");
        System.out.println("Elemento antigo no rank 2: " + antigo);
        printVetor(v);

        System.out.println("\n--- Teste de Remoção ---");
        v.removeAtRank(0); // Remove "Z"
        System.out.println("Após remover Rank 0:");
        printVetor(v); // Esperado: A, B-Modificado, C, D

        v.removeAtRank(2); // Remove "C"
        System.out.println("Após remover Rank 2:");
        printVetor(v); // Esperado: A, B-Modificado, D

        System.out.println("\n--- Teste de Esvaziamento ---");
        while(!v.isEmpty()) {
            System.out.println("Removendo: " + v.removeAtRank(0));
        }
        System.out.println("Vetor está vazio? " + v.isEmpty());
        System.out.println("Capacidade final (após reduções): " + v.capacity);
    }

    // Método auxiliar para imprimir o vetor rank por rank
    public static void printVetor(Vetor v) {
        System.out.print("Conteúdo Lógico: [ ");
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.elemAtRank(i) + " ");
        }
        System.out.println("]");
    }
}