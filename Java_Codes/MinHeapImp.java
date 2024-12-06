package Java_Codes;

import java.util.ArrayList;

public class MinHeapImp {
    private ArrayList<Integer> heap;
    //should be root representation!

    public MinHeapImp() {
        heap = new ArrayList<>();
    }

    // Get the index of parent, left child, and right child
    /*
     * 1
     * 2 3
     * 4 5 6 7
     * for left child i*2 , for right child i*2+1 , for parent int(i/2)
     */

    public int getLeftChildIndex(int i) {
        return i * 2;
    }

    protected int getRightChildIndex(int i) {
        return (i * 2) + 1;
    }

    protected int getParentIndex(int i) {
        return i / 2;
    }

    // check has a node children with array size

    public boolean hasLeftChild(int i) {
        return getLeftChildIndex(i) < heap.size();
    }

    public boolean hasRightChild(int i) {
        return getRightChildIndex(i) < heap.size();
    }

    //get values

    public int getParent(int i) {
        return heap.get(getParentIndex(i));
    }

    public int getLeftChild(int i) {
        return heap.get(getLeftChildIndex(i));
    }

    public int getRightChild(int i) {
        return heap.get(getRightChildIndex(i));
    }

    //insert element and figure-out it!

    //delete element(from root)



}
