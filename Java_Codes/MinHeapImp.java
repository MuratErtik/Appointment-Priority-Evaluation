package Java_Codes;

import java.util.LinkedList;
import java.util.Queue;


public class MinHeapImp {

    // Node class to represent each element in the tree

    static class Node {
        int value;
        Node left, right, parent;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

    }

    private Node root;
    private int size; // Number of elements in the heap

    public MinHeapImp() {
        root = null;
        size = 0;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        size++;

        if (root == null) {
            root = newNode;
            return;
        }

        // Find the parent node
        Node parent = findParent(size);
        newNode.parent = parent;

        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

        // Restore the heap property
        heapifyUp(newNode);
    }

    private Node findParent(int index) {
        int parentIndex = index / 2;
        String path = Integer.toBinaryString(parentIndex).substring(1);
        Node current = root;

        for (char direction : path.toCharArray()) {
            current = (direction == '0') ? current.left : current.right;
        }

        return current;
    }

    private void heapifyUp(Node node) {
        while (node.parent != null && node.value < node.parent.value) {
            int temp = node.value;
            node.value = node.parent.value;
            node.parent.value = temp;

            node = node.parent;
        }
    }

    public void printLevelOrder() {
        if (root == null) {
            System.out.println("Heap is empty");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " ");

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }

        System.out.println();
    }
}