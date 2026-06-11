

public class ItemPri extends Item {
    private final Comparable chave;
    private final Object valor;

    public ItemPri(Comparable chave, Object valor) {
        if (chave == null)
            throw new IllegalArgumentException("Chave não pode ser nula.");

        this.chave = chave;
        this.valor = valor;
    }

    @Override
    public Object key() {
        return this.chave;
    }

    @Override
    public Object value() {
        return this.valor;
    }

    @Override
    public String toString() {
        return "ItemPrioridade{chave=" + chave + ", valor=" + valor + '}';
    }
}
