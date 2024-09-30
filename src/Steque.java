public class Steque<Item> {
    //Number of elements within the steque
    private Node first; //First element in the steque
    private Node last; //Last element in the steque

    public Steque() {
        first = null;
        last = null;
    }

    private class Node {
        private Item item;
        private Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public void pop() {
        first = first.next;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public void printList(int limit) {
        int i = 0;
        Node temp = first;
        if (temp != null ) {
            while (temp.next != null && i < limit) {
                ConsoleColors.println(temp.item + " ", "red");
                temp = temp.next;
                i++;
            }
            StdOut.print();
        } else {
            StdOut.println("No items left within queue. Please enqueue more items.");
        }
    }
}
