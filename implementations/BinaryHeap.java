import java.util.Arrays;

public class BinaryHeap {
    private static final int DEFAULT_CAPACITY = 10;

    private int[] data;
    private int lastNode;

    public BinaryHeap() {
        data = new int[DEFAULT_CAPACITY];
        lastNode = -1;
    }

    public boolean isEmpty() {
        return lastNode == -1;
    }

    public void insert(int x) {
        lastNode++;
        if (lastNode == data.length) {
            resizeData();
        }
        data[lastNode] = x;
        heapifyUp();
    }

    public int extract() throws Exception {
        if (isEmpty()) {
            throw new Exception("BinaryHeap is empty.");
        }
        int best = data[0];
        data[0] = data[lastNode];
        lastNode--;
        heapifyDown();
        return best;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("BinaryHeap is empty.");
        }
        return data[0];
    }

    private boolean isBetter(int x, int y) {
        return y < x;
    }

    private void resizeData() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    private void heapifyUp() {
        int node = lastNode;
        while (node > 0) {
            int parent = (node - 1) / 2;
            if (isBetter(data[node], data[parent])) {
                swap(node, parent);
                node = parent;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int node = 0;
        while (node < lastNode) {
            int leftChild = node * 2 + 1;
            int rightChild = node * 2 + 2;
            if (lastNode < leftChild && lastNode < rightChild) {
                break;
            }
            if (leftChild <= lastNode && lastNode < rightChild) {
                if (isBetter(data[node], data[leftChild])) {
                    break;
                } else {
                    swap(node, leftChild);
                    node = leftChild;
                }
            } else {
                if (isBetter(data[node], data[leftChild]) && isBetter(data[node], data[rightChild])) {
                    break;
                } else {
                    if (isBetter(data[leftChild], data[rightChild])) {
                        swap(node, leftChild);
                        node = leftChild;
                    } else {
                        swap(node, rightChild);
                        node = rightChild;
                    }
                }
            }
        }
    }

    private void swap(int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
