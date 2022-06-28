public class LinkedListCompare {

    static class Node {
        char data;
        Node next;

        public Node(char data) {
            this.data = data;
        }
    }

    public static int linked_list_compare(Node head1, Node head2) {
        if (head1 == null && head2 == null) return 0;
        else if (head1 == null) return -head2.data;
        else if (head2 == null) return head1.data;
        else {
            while (head1 != null && head2 != null && head1.data == head2.data) {
                head1 = head1.next;
                head2 = head2.next;
            }
            if (head1 == null && head2 == null) return 0;
            else if (head1 == null) return -head2.data;
            else if (head2 == null) return -head1.data;
            else return head1.data - head2.data;
        }
    }
}
