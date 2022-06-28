import java.util.*;

public class RemoveLoopInLinkedList {
    //Function to remove a loop in the linked list.
    public static void removeLoop(Node head){
        HashSet<Node> set = new HashSet<>();
        Node current = head;
        set.add(current);
        while (current.next != null) {
            if (!set.contains(current.next)) set.add(current);
            else {
                current.next = null;
                break;
            }
            current = current.next;
        }
    }
}
