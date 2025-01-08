
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.addLast(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.printForward(); // Output: 10 20 30

        dll.addFirst(5);
        dll.printForward(); // Output: 5 10 20 30

        dll.remove(20);
        dll.printForward(); // Output: 5 10 30

        dll.printBackward(); // Output: 30 10 5
        
        dll.insert(5, 0); // Insert at the beginning
        dll.printForward(); // Output: 5 10 20 30

        dll.insert(25, 3); // Insert at position 3
        dll.printForward(); // Output: 5 10 20 25 30

        dll.insert(40, 10); // Insert beyond the last node (at the end)
        dll.printForward(); // Output: 5 10 20 25 30 40
    }
    
}
