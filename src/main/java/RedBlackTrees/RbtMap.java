package RedBlackTrees;


import RedBlackTrees.services.MapInterface;

public class RbtMap<K extends Comparable<K>, V> implements MapInterface<K, V> {

    private final RedBlackTree<K, V> tree;
    private int nElems;
    public <K, V> RbtMap() {
        tree = new RedBlackTree<>();
    }
    @Override
    public void setValue(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Params (key, value) cannot be null.");
        }
        tree.put(key, value);
        nElems = tree.getElems();
    }

    @Override
    public V getValue(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Cannot get value by null key.");
        }
        return tree.get(key);
    }
    public Node getRoot() {
        return tree.getRoot();
    }

}
