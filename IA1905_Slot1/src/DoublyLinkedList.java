
public class DoublyLinkedList {
    // Node class
    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head; // Head node of the list
    private Node tail; // Tail node of the list

    // Constructor
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Add a node at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a node at the beginning
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Remove a node by value
    public void remove(int data) {
        if (head == null) return;

        Node current = head;

        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }
    
    public void removeAt(int index) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (index == 0) { // Remove the head node
            if (head.next == null) { // Only one node in the list
                head = null;
                tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            return;
        }

        Node current = head;
        int currentIndex = 0;

        // Traverse to the node at the given index
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) { // Index out of bounds
            System.out.println("Index out of bounds.");
            return;
        }

        if (current.next == null) { // Remove the tail node
            tail = current.prev;
            tail.next = null;
        } else { // Remove a middle node
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }
    
    // Insert a node at a specific position
    public void insert(int data, int position) {
        Node newNode = new Node(data);

        // If inserting at the beginning
        if (position == 0) {
            addFirst(data);
            return;
        }

        Node current = head;
        int currentIndex = 0;

        // Traverse the list to find the position
        while (current != null && currentIndex < position - 1) {
            current = current.next;
            currentIndex++;
        }

        // If position is beyond the last node, insert at the end
        if (current == null) {
            addLast(data);
        } else {
            // Insert in between nodes
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;

            // Update the tail if inserted at the end
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    // Print the list from head to tail
    public void printForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Print the list from tail to head
    public void printBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
    
     // Search for a value from head to tail
    public boolean searchForward(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true; // Found the value
            }
            current = current.next;
        }
        return false; // Value not found
    }

    // Search for a value from tail to head
    public boolean searchBackward(int data) {
        Node current = tail;
        while (current != null) {
            if (current.data == data) {
                return true; // Found the value
            }
            current = current.prev;
        }
        return false; // Value not found
    }
}
