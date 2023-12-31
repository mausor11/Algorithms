package HuffmanTreeAlgorithm;


import HuffmanTreeAlgorithm.Dictionary.Dictionary;
import HuffmanTreeAlgorithm.PriorityQueue.PriorityQueue;
import HuffmanTreeAlgorithm.Tree.Node;
import HuffmanTreeAlgorithm.Tree.Tree;

public class HuffmanTree {
    private Dictionary dictionary;
    private PriorityQueue priorityQueue;
    private Tree huffmanTree;
    private int leaves;
    public HuffmanTree(PriorityQueue priorityQueue) {
        this.priorityQueue = priorityQueue;
        this.dictionary = new Dictionary();
        this.leaves = priorityQueue.size();
        makeHTree();

        makeDictionary(huffmanTree.getRoot(), new StringBuilder(), 0);

    }
    public HuffmanTree(Tree tree) {
        this.huffmanTree = tree;
        this.dictionary = new Dictionary();
        makeDictionary(huffmanTree.getRoot(), new StringBuilder(), 0);
    }
    public Node getRoot() {
        return huffmanTree.getRoot();
    }
    public Dictionary getDictionary() {
        return dictionary;
    }
    private void makeHTree() {
        int size = priorityQueue.size();
        for(int i=0; i < size -1; i++) {
            Node parent = new Node(0,0);
            Node leftChild = priorityQueue.heapDown();
            Node rightChild = priorityQueue.heapDown();
            parent.setLeft(leftChild);
            parent.setRight(rightChild);
            parent.setCounter(leftChild.getCounter() + rightChild.getCounter());
            priorityQueue.heapUp(parent);
        }
        huffmanTree =  new Tree(priorityQueue.heapDown());
    }

    private void makeDictionary(Node root, StringBuilder code, int level) {
        if(root != null) {
            if (root.getLeft() == null && root.getRight() == null) {
                dictionary.put(root.getSign(), code.toString(), level);
            } else {
                code.append('0');
                makeDictionary(root.getLeft(), code, level + 1);
                code.deleteCharAt(code.length() - 1);

                code.append('1');
                makeDictionary(root.getRight(), code, level + 1);
                code.deleteCharAt(code.length() - 1);
            }
        }
    }

    public void readHTree() {
        readHTree(huffmanTree.getRoot(), 0);
    }

    private void readHTree(Node root, int level) {
        if (root != null) {
            level++;
            System.out.println(root + " | " + level);
            readHTree(root.getLeft(), level);
            readHTree(root.getRight(), level);
        }
    }

    private void codeTreeToFile(Node root) {
        if(root.getLeft() == null && root.getRight() == null) {
            System.out.print('1');
            System.out.print ((char)root.getSign());
        } else {
            System.out.print('0');
        }
        if(root.getLeft() != null) {
            codeTreeToFile(root.getLeft());
        }
        if(root.getRight() != null) {
            codeTreeToFile(root.getRight());
        }
    }



}
