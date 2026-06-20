package LinkedList;

public class LL {

    Node head;
    Node tail;

    public LL() {
        this.head = null;
        this.tail = null;
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void addFront(int value) {
        if (head == null) {
            head = new Node(value);
            tail = head;
            return;
        }
        Node newNode = new Node(value);
        newNode.next = head;
        head =  newNode;
    }

    void addLast(int value) {
        if (tail == null) {
            tail = new Node(value);
            head = tail;
            return;
        }
        Node newNode = new Node(value);
        tail.next = newNode;
        tail = newNode;
    }

    public void reverseIterative() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        tail = head;
        head = prev;
    }

    public Node reverseRecursive(Node currentHead) {
        if (currentHead == null || currentHead.next == null ) {
            return currentHead;
        }

        Node newHead = reverseRecursive(currentHead.next);
        currentHead.next.next = currentHead;
        currentHead.next = null;

        return newHead;
    }

    public boolean contains(int key) {
        Node current = head;
        while (current != null) {
            if (current.value == key) return true;
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        LL ll = new LL();
        ll.addLast(3);
        ll.addFront(2);
        ll.addFront(1);
        ll.print();
        ll.reverseIterative();
        ll.print();
        Node currentHead = ll.head;
        Node newHead = ll.reverseRecursive(currentHead);
        ll.tail = ll.head;
        ll.head = newHead;
        ll.print();
    }
    
}
