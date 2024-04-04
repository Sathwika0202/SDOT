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
        int size1 = scanner.nextInt();
        ListNode list1 = createList(scanner, size1);
        int size2 = scanner.nextInt();
        ListNode list2 = createList(scanner, size2);
        
        ListNode mergedList = mergeLists(list1, list2);
        
        printList(mergedList);
    }
    
    public static ListNode createList(Scanner scanner, int size) {
        if (size == 0)
            return null;
        
        ListNode head = new ListNode(scanner.nextInt());
        ListNode current = head;
        for (int i = 1; i < size; i++) {
            current.next = new ListNode(scanner.nextInt());
            current = current.next;
        }
        return head;
    }
    
    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        if (list1 != null)
            current.next = list1;
        else
            current.next = list2;
        
        return dummy.next;
    }
    
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null)
                System.out.print("->");
            current = current.next;
        }
        System.out.println("->NULL");
    }
}
