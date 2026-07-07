package ume.marisa.iridescent.utils;

/**
 * KV
 */

public class KV<K, V> {
    private K k;
    private V v;

    private KV(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public static <K, V> KV<K, V> of(K k, V v) {
        return new KV<>(k, v);
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }
}
