package pl.edu.pw.ee;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    public List<Node> pQueue;
    public PriorityQueue() {
        pQueue = new ArrayList<>();
    }

    public int getQueueSize() {
        return pQueue.size();
    }

    public void add(Node node) {
        pQueue.add(node);
        int currentId = pQueue.size() - 1;
        while (currentId != 0) {
            int parentId = (currentId - 1) / 2;
            if (pQueue.get(currentId).getQuantity() < pQueue.get(parentId).getQuantity()) {
                swap(currentId, parentId);
                currentId = parentId;
            } else {
                break;
            }
        }
    }

    public Node remove() {
        int lastId = pQueue.size() - 1;
        Node removedNode = pQueue.get(0);
        pQueue.set(0, pQueue.get(lastId));
        pQueue.remove(lastId);

        int currentId = 0;
        while (true) {
            int leftChildId = 2 * currentId + 1;
            int rightChildId = 2 * currentId + 2;
            int maxId = currentId;

            if (leftChildId < pQueue.size() && pQueue.get(leftChildId).getQuantity() < pQueue.get(maxId).getQuantity()) {
                maxId = leftChildId;
            }

            if (rightChildId < pQueue.size() && pQueue.get(rightChildId).getQuantity() < pQueue.get(maxId).getQuantity()) {
                maxId = rightChildId;
            }

            if (maxId != currentId) {
                swap(currentId, maxId);
                currentId = maxId;
            } else {
                break;
            }
        }

        return removedNode;
    }

    private void swap(int index1, int index2) {
        Node temp = pQueue.get(index1);
        pQueue.set(index1, pQueue.get(index2));
        pQueue.set(index2, temp);
    }
}
