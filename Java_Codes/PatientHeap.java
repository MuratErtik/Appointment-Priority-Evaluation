package Java_Codes;

import java.util.ArrayList;
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
    private ArrayList<Patient> removedPatients;

    public PatientHeap() {
        root = null;
        size = 0;
        removedPatients = new ArrayList<>();
        initializeDefaultPatients(); 
    }

    private void initializeDefaultPatients() {
        // Default Patients from pdf
        ArrayList<Patient> defaultPatients = new ArrayList<>();
        defaultPatients.add(new Patient(101, 5, 30));
        defaultPatients.add(new Patient(102, 3, 40));
        defaultPatients.add(new Patient(103, 8, 20));
        defaultPatients.add(new Patient(104, 1, 60));
        defaultPatients.add(new Patient(105, 7, 15));
        defaultPatients.add(new Patient(106, 2, 50));
        defaultPatients.add(new Patient(107, 4, 45));
        defaultPatients.add(new Patient(108, 6, 25));
        defaultPatients.add(new Patient(109, 3, 35));
        defaultPatients.add(new Patient(110, 2, 30));
        defaultPatients.add(new Patient(111, 8, 10));

        for (Patient patient : defaultPatients) {
            insert(patient);
        }
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
            Patient temp = node.patient;
            node.patient = node.parent.patient;
            node.parent.patient = temp;
            node = node.parent;
        }
    }

    private void heapifyDown(Node node) {
        while (true) {
            Node smallest = node;

            if (node.left != null && node.left.patient.getPriority() < smallest.patient.getPriority()) {
                smallest = node.left;
            }

            if (node.right != null && node.right.patient.getPriority() < smallest.patient.getPriority()) {
                smallest = node.right;
            }

            if (smallest == node) {
                break;
            }

            Patient temp = node.patient;
            node.patient = smallest.patient;
            smallest.patient = temp;

            node = smallest;
        }
    }

    private Node getLastNode() {
        String path = Integer.toBinaryString(size).substring(1);
        Node current = root;

        for (char direction : path.toCharArray()) {
            current = (direction == '0') ? current.left : current.right;
        }

        return current;
    }

    private void removeLastNode() {
        String path = Integer.toBinaryString(size).substring(1);
        Node current = root;
        Node parent = null;

        for (char direction : path.toCharArray()) {
            parent = current;
            current = (direction == '0') ? current.left : current.right;
        }

        if (parent != null) {
            if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        size--;
    }

    public void removeRoot() {
        if (root == null) {
            System.out.println("Heap is empty. Cannot remove root.");
            return;
        }

        removedPatients.add(root.patient);

        Node lastNode = getLastNode();
        if (lastNode == root) {
            root = null;
        } else {
            root.patient = lastNode.patient;
            removeLastNode();
            heapifyDown(root);
        }
    }

    public ArrayList<Patient> getRemovedPatients() {
        return removedPatients;
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
                System.out.println("\n");
        }

        System.out.println();
    }
}
