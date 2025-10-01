package princeton.algorihms.course;

public class DesignStack {

    // Linked List approach
    private class Node {
        int val;
        Node next;
    }
    // Use of first
    Node first = null;

    public void pushValue(Node n) {
        Node oldNode = first;
        first = new Node();
        first.val = n.val;
        first.next = oldNode;

    }

    public int pop() {
        int returnItem = first.val;
        first = first.next;
        return returnItem;
    }


    // Array Approach


}
