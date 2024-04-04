import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of elements in the linked list
        int n = scanner.nextInt();

        // Input the elements of the linked list
        ListNode head = null;
        ListNode prev = null;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            ListNode newNode = new ListNode(val);
            if (head == null)
                head = newNode;
            else
                prev.next = newNode;
            prev = newNode;
        }

        // Check if the linked list is a palindrome
        boolean isPalindrome = isPalindrome(head);
        if (isPalindrome)
            System.out.println("True");
        else
            System.out.println("False");

        scanner.close();
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        // Move slow to the middle of the list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode secondHalf = reverse(slow.next);
        ListNode firstHalf = head;

        // Compare first half with reversed second half
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val)
                return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Helper method to reverse a linked list
    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}
