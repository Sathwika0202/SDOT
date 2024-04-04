
import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void reverseEveryKNodes(int k) {
        head = reverseKNodes(head, k);
    }

    private Node reverseKNodes(Node start, int k) {
        Node current = start;
        Node next = null;
        Node prev = null;
        int count = 0;

        Node temp = start;
        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }

        if (count == k) {
            count = 0;
            while (count < k && current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            if (next != null) {
                start.next = reverseKNodes(next, k);
            }
            return prev;
        }

        return start;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int data;
        do {
            data = scanner.nextInt();
            if (data != -1) {
                list.insert(data);
            }
        } while (data != -1);

        int k = scanner.nextInt();

        list.reverseEveryKNodes(k);

        list.display();

        scanner.close();
    }
}
 
