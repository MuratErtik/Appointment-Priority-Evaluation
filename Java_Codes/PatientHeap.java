package Java_Codes;
import java.util.LinkedList;
import java.util.Queue;

public class PatientHeap {
    static class Node {
        Patient patient;
        Node left, right, parent;

        public Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    private Node root;
    private int size;

    public PatientHeap() {
        root = null;
        size = 0;
    }

    public void insert(Patient patient) {
        Node newNode = new Node(patient);
        size++;

        if (root == null) {
            root = newNode;
            return;
        }

        Node parent = findParent(size);
        newNode.parent = parent;

        if (parent.left == null) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

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
            int temp = node.patient.getPriority();
            node.patient.setPriority(node.parent.patient.getPriority());
            node.parent.patient.setPriority(temp);
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
            System.out.print(current.patient.toString() + " ");

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }

        System.out.println();
    }

    // Method to remove the root node
    public void removeRoot() {
        if (root == null) {
            System.out.println("Heap is empty. Cannot remove root.");
            return;
        }

        // Replace root with the last node
        Node lastNode = getLastNode();
        if (lastNode == root) {
            root = null; // If there's only one node, just make root null
        } else {
            root.patient = lastNode.patient;
            removeLastNode();
            heapifyDown(root);
        }
    }

    // Get the last node (rightmost node)
    private Node getLastNode() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node lastNode = null;

        while (!queue.isEmpty()) {
            lastNode = queue.poll();

            if (lastNode.left != null) queue.add(lastNode.left);
            if (lastNode.right != null) queue.add(lastNode.right);
        }

        return lastNode;
    }

    // Remove the last node (rightmost node)
    private void removeLastNode() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left != null) {
                if (current.left.left == null && current.left.right == null) {
                    current.left = null;
                    return;
                }
                queue.add(current.left);
            }
            if (current.right != null) {
                if (current.right.left == null && current.right.right == null) {
                    current.right = null;
                    return;
                }
                queue.add(current.right);
            }
        }
    }

    // Heapify down to restore heap property
    private void heapifyDown(Node node) {
        while (node.left != null || node.right != null) {
            Node smallest = node;

            if (node.left != null && node.left.patient.getPriority() < smallest.patient.getPriority()) {
                smallest = node.left;
            }

            if (node.right != null && node.right.patient.getPriority() < smallest.patient.getPriority()) {
                smallest = node.right;
            }

            if (smallest != node) {
                int temp = node.patient.getPriority();
                node.patient.setPriority(smallest.patient.getPriority());
                smallest.patient.setPriority(temp);
                node = smallest;
            } else {
                break;
            }
        }
    }
}
