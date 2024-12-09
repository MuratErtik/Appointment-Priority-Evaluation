package Java_Codes;

import java.util.LinkedList;
import java.util.Queue;

public class PatientHeap {
    static class Node {
        Patient patient = new Patient();
       
        Node left, right, parent;

        public Node(int value) {
            
            this.left = null;
            this.right = null;
            this.parent = null;
        }

    }

    private Node root;
    private int size; // Number of elements in the heap

    public PatientHeap() {
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
        while (node.parent != null && node.patient.getPriority() < node.parent.patient.getPriority()) {
            // Swap priorities
            int temp = node.patient.getPriority();
            node.patient.setPriority(node.parent.patient.getPriority());
            node.parent.patient.setPriority(temp);
    
            // Move up to the parent
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
            System.out.print(current.patient + " ");

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }

        System.out.println();
    }
    

}
