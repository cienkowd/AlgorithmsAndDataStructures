package pl.edu.pw.ee;

public class Tree {

    private Node root;

    private PriorityQueue queue = new PriorityQueue();

    private int treeCost;

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

    public void dfs(Node node, String code, int treeHeight) {
        if (node.isLeaf()) {
            if(node.getCharacter() < 0) {
                treeCost += (0.5 * treeHeight * node.getQuantity());
            }
            else {
                treeCost += treeHeight * node.getQuantity();
            }
            System.out.println("Znak: " + (char) node.getCharacter() + ", Kod: " + code + ", Ilosc: " + node.getQuantity() + ", Level: " + treeHeight + ", Cost: " + treeCost);
            return;
        }

        if (!node.isLeaf()) {
            dfs(node.getLeftChild(), code + "0",treeHeight + 1);
        }

        if (!node.isLeaf()) {
            dfs(node.getRightChild(), code + "1", treeHeight + 1);
        }
    }

    public static int treeHeight(Node root) {
        if (root == null) {
            return -1;
        }
        else {
            int leftHeight = treeHeight(root.getLeftChild());
            int rightHeight = treeHeight(root.getRightChild());

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    public Node getRoot () {
        return root;
    }

    public int getTreeCost() {
        return treeCost;
    }
}
