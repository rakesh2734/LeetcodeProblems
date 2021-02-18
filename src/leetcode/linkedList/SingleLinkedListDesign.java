package leetcode.linkedList;
/*Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

MyLinkedList() Initializes the MyLinkedList object.
int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
void addAtTail(int val) Append a node of value val as the last element of the linked list.
void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.*/
public class SingleLinkedListDesign {
          /** Initialize your data structure here. */
        int length;
        Node head;

        class Node {
            int val;
            Node next;
            Node(int x){
                this.val = x;
            }
        }
        public SingleLinkedListDesign() {
            this.length = 0;
            this.head = null;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if(index < 0 || index >= this.length){
                return -1;
            }
            else {
                Node current = head;
                for (int i = 0; i < index; i++) {
                    current = current.next;
                }
                return current.val;
            }
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node newNode = new Node(val);
            newNode.next = this.head;
            this.head = newNode;
            this.length++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {

            if(this.length ==0){
                addAtHead(val);
                return;
            }
            else{
                Node newNode = new Node(val);
                Node temp = head;
                while(temp.next != null){
                    temp = temp.next;
                }
                //traverse until the last node
                temp.next = newNode;
                newNode.next = null;
                this.length++;
            }
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            Node newNode = new Node(val);
            Node temp = head;
            int counter = 0;
            if(index == 0){
                addAtHead(val);
                return;
            }
            if(index == this.length){
                addAtTail(val);
                return;
            }
            if(index > this.length){
                return;
            }
            while(counter != (index-1)){
                temp = temp.next;
                counter++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            this.length++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if(index >= this.length)
                return;
            this.length--;
            if(index == 0)
                head = head.next;
            else{
                Node current = head;
                for(int i=0; i< index-1; i++){
                    current = current.next;
                }
                current.next = current.next.next;
            }
        }

    public static void main(String[] args) {
//  Input: ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
//        [[], [1], [3], [1, 2], [1], [1], [1]]
          //Your MyLinkedList object will be instantiated and called as such:
          SingleLinkedListDesign obj = new SingleLinkedListDesign();
//          int param_1 = obj.get(index);
          obj.addAtHead(1);
          obj.addAtTail(3);
          obj.addAtIndex(1, 2);    // linked list becomes 1->2->3
          obj.get(1);              // return 2
          obj.deleteAtIndex(1);    // now the linked list is 1->3
          obj.get(1);              // return 3
    }

}
