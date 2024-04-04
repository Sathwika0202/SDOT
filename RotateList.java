
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    void rotate(int k) {
        if (head == null || k <= 0) {
            return;
        }

        Node current = head;
        int count = 1;

        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) {
            return;
        }

        Node newHead = current.next;
        current.next = null;

        current = newHead;
        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        head = newHead;
    }

    void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList linkedList = new LinkedList();

        while (true) {
            int data = scanner.nextInt();
            if (data == -1) {
                break;
            }
            linkedList.append(data);
        }

        int rotations = scanner.nextInt();

        // Output before rotation
        System.out.println("Given linked list:");
        linkedList.display();

        // Rotate the linked list
        linkedList.rotate(rotations);

        // Output after rotation
        System.out.println("Rotated Linked list:");
        linkedList.display();
    }
}
