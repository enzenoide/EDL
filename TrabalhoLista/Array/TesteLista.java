package TrabalhoLista;

public class TesteLista {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO BATERIA DE TESTES ===");
        
        try {
            // 1. Teste de Inicialização
            Lista lista = new Lista(5);
            System.out.println("\n[1] Lista vazia criada (Capacidade: 5)");
            imprimirStatus(lista);

            // 2. Teste de Inserção Básica (insertLast)
            System.out.println("\n[2] Inserindo no final: A, B, C");
            lista.insertLast("A");
            lista.insertLast("B");
            lista.insertLast("C");
            imprimirStatus(lista);

            // 3. Teste de Inserção no Início (insertFirst)
            System.out.println("\n[3] Inserindo no início: Z (Testa o recuo do start)");
            lista.insertFirst("Z");
            imprimirStatus(lista); // Esperado: Z, A, B, C

            // 4. Teste do insertBefore (Metade inicial -> deve chamar shiftLeft)
            System.out.println("\n[4] Inserindo 'X' antes do índice 1 (que é o 'A')");
            lista.insertBefore(1, "X");
            imprimirStatus(lista); // Esperado: Z, X, A, B, C

            // 5. Teste de Redimensionamento (Resize)
            System.out.println("\n[5] Forçando Resize (inserindo 'Y' no final)");
            lista.insertLast("Y"); 
            imprimirStatus(lista); // Capacidade deve dobrar para 10. Esperado: Z, X, A, B, C, Y

            // 6. Teste do insertAfter (Metade final -> deve chamar shiftRight)
            System.out.println("\n[6] Inserindo 'W' após o índice 3 (que é o 'B')");
            lista.insertAfter(3, "W");
            imprimirStatus(lista); // Esperado: Z, X, A, B, W, C, Y

            // 7. Teste de Remoção
            System.out.println("\n[7] Removendo o índice 2 (que é o 'A')");
            Object removido = lista.remove(2);
            System.out.println("Elemento removido: " + removido);
            imprimirStatus(lista); // Esperado: Z, X, B, W, C, Y

            // 8. Teste de Substituição (replaceElements)
            System.out.println("\n[8] Substituindo índice 0 por 'K'");
            lista.replaceElements(0, "K");
            imprimirStatus(lista); // Esperado: K, X, B, W, C, Y

            // 9. Teste de Troca (swapElements)
            System.out.println("\n[9] Trocando índice 1 ('X') com índice 4 ('C')");
            lista.swapElements(1, 4);
            imprimirStatus(lista); // Esperado: K, C, B, W, X, Y

            System.out.println("\n=== TODOS OS TESTES EXECUTADOS COM SUCESSO ===");

        } catch (ListaException e) {
            System.err.println("\nERRO: Exceção disparada! -> " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nERRO INESPERADO (Pode ser erro nos limites do array):");
            e.printStackTrace();
        }
    }

    /**
     * Método auxiliar para visualizar a lista logicamente,
     * ignorando os buracos do array físico.
     */
    public static void imprimirStatus(Lista lista) {
        System.out.print("Conteúdo Lógico: [ ");
        for (int i = 0; i < lista.size(); i++) {
            // Acessa o dado usando a mesma lógica da sua classe para garantir que está certo
            Object elemento = lista.data[(lista.start + i) % lista.capacity];
            System.out.print(elemento + (i < lista.size() - 1 ? ", " : ""));
        }
        System.out.println(" ]");
        System.out.println("Tamanho atual: " + lista.size() + " | Capacidade: " + lista.capacity + " | Index do Start: " + lista.start);
    }
}