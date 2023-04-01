package mx.uv.fiee.iinf.poo.primerparcial;

class Entry<K, V> {
    K key;
    V value;

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public String toString() {
        return String.format("Entry{key=%s, value=%s}", key.toString(), value.toString());
    }
}