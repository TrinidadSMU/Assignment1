public class Steque<Item> {
    private int n; //Number of elements within the steque
    private Node first; //First element in the steque
    private Node last; //Last element in the steque

    public Steque() {
        first = null;
        last = null;
        n = 0;
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
        n++;
    }

    public void pop() {
        first = first.next;
        n--;
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
        n++;
    }

    public void printList() {
        Node temp = first;
        if (temp != null) {
            while (temp.next != null) {
                StdOut.print(temp.item + " ");
                temp = temp.next;
            }
            StdOut.print();
            StdOut.println(last.item);
        } else {
            StdOut.println("No items left within queue. Please enqueue more items.");
        }
    }

    //Running this code can help show how the methods all work. The methods are all usable even if this main method implementation is removed.
    public static void main(String[] args) {
        Steque<String> queue = new Steque<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                if (item.equals("push")) {
                    String pushItem = StdIn.readString();
                    queue.push(pushItem);
                    queue.printList();
                } else {
                    queue.enqueue(item);
                    queue.printList();
                }
            } else if (!queue.isEmpty()) {
                queue.pop();
                queue.printList();
            }
        }
        StdOut.println("(" + queue.n + " items left in queue)");

    }
}
