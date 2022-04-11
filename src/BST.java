public class BST<K extends Comparable<K>, V> {

    private Node root;

    public int size() { return size(root); }

    public void add(K key, V value) { root = add(root, key, value); }

    public V get(K key) { return get(root, key); }

    public V getMin() { return root == null ? null : getMin(root); }

    public V getMax() { return root == null ? null : getMax(root); }

    public V getFloor(K key) { return getFloor(root, key); }

    private int size(Node node) { return node == null ? 0 : node.size; }

    public V getNthMax(int n) {
        return root.value;
    }

    public V getNthMin(int n) {
        return root.value;
    }

    private Node add(Node node, K key, V value) {
        if (node == null) return new Node(key, value, 1);

        int comparison = key.compareTo(node.key);
        if (comparison > 0) node.right = add(node.right, key, value);
        else if (comparison < 0) node.left = add(node.left, key, value);
        else node.value = value;

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private V get(Node node, K key) {
        if (node == null) return null;

        int comparison = node.key.compareTo(key);
        if (comparison < 0) return get(node.right, key);
        if (comparison > 0) return get(node.left, key);
        return node.value;
    }

    private V getMin(Node node) {
        if (node.left == null) return node.value;
        return getMin(node.left);
    }

    private V getMax(Node node) {
        if (node.right == null) return node.value;
        return getMax(node.right);
    }

    private V getFloor(Node node, K key) {
        if (node == null) return null;

        int comparison = key.compareTo(node.key);
        if (comparison == 0) return node.value;
        if (comparison < 0) return getFloor(node.left, key);

        V value = getFloor(node.right, key);
        return value == null ? node.value : value;
    }

//    private V getNthMax(Node node, int n) {
//        if (node.left)
//    }

    class Node {
        K key;
        V value;
        Node left, right;
        int size;

        Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
            right = null;
            left = null;
        }
    }
}
