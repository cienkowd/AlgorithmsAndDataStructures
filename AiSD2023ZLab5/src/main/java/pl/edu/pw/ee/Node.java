package pl.edu.pw.ee;

public class Node {
    private Node leftChild;
    private Node rightChild;
    private int quantity = 0;
    private byte character;

    public Node(Node leftChild, Node rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.quantity = leftChild.quantity + rightChild.quantity;
    }

    public Node(byte character, int quantity) {
        this.character = character;
        this.quantity = quantity;
        this.leftChild = null;
        this.rightChild = null;
    }

    public byte getCharacter() {
        return character;
    }

    public int getQuantity() {
        return quantity;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
}
