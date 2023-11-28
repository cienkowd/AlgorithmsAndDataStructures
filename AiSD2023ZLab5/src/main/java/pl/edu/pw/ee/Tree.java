package pl.edu.pw.ee;

public class Tree {

    private Node root;

    private PriorityQueue queue = new PriorityQueue();

    public void addNodesToPriorityQueue(byte[] charactersQuantity) {
        for (int i = 0; i < charactersQuantity.length; i++) {
            if (charactersQuantity[i] > 0) {
                Node node = new Node((byte) i, charactersQuantity[i]);
                queue.add(node);
            }
        }
    }

    public void buildTree() {
        while (queue.getQueueSize() > 1) {
            Node left = queue.remove();
            Node right = queue.remove();

            Node newNode = new Node(left, right);
            queue.add(newNode);

        }
        root = queue.remove();
    }

    public void dfs(Node node, String code) {
        if (node.isLeaf()) {
            System.out.println("Znak: " + (char) node.getCharacter() + ", Kod: " + code);
            return;
        }

        if (!node.isLeaf()) {
            dfs(node.getLeftChild(), code + "0");
        }

        if (!node.isLeaf()) {
            dfs(node.getRightChild(), code + "1");
        }
    }
    public Node getRoot () {
        return root;
    }
}
