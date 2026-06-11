public class Teste {
    public static void main(String[] args) {
        FilaPri fila = new FilaPri();

        fila.insert(new ItemPri(10, "A"));
        fila.insert(new ItemPri(5, "B"));
        fila.insert(new ItemPri(15, "C"));
        fila.insert(new ItemPri(2, "D"));
        fila.insert(new ItemPri(8, "E"));

        System.out.println("Minimo atual: " + fila.min());
        System.out.println("Removendo min: " + fila.removeMin());
        System.out.println("Novo minimo: " + fila.min());
        System.out.println("Tamanho da fila: " + fila.size());
    }
}
