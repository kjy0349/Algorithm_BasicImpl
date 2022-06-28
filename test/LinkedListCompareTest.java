import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListCompareTest {

    @Test
    void compare_test(String list1, String list2, int except) {
        LinkedListCompare.Node head1 = null;
        if (list1.length() > 0) {
            head1 = new LinkedListCompare.Node(list1.charAt(0));
            LinkedListCompare.Node current = head1;
            for (int i = 1; i < list1.length(); i++) {
                current.next = new LinkedListCompare.Node(list1.charAt(i));
                current = current.next;
            }
        }
        LinkedListCompare.Node head2 = null;
        if (list2.length() > 0) {
            head2 = new LinkedListCompare.Node(list2.charAt(0));
            LinkedListCompare.Node current = head2;
            for (int i = 1; i < list2.length(); i++) {
                current.next = new LinkedListCompare.Node(list2.charAt(i));
                current = current.next;
            }
        }
        Assertions.assertEquals(except, LinkedListCompare.linked_list_compare(head1, head2));
    }


    @Test
    void compare_testlists() {
        compare_test("geeksa", "geeksb", 'a' - 'b');
        compare_test("Ruth", "Ruth", 0);
        compare_test("Gehrig", "Ruth", 'G' - 'R');
        compare_test("", "Ruth", -'R');
        compare_test("", "Ruth", -'R');
        compare_test("Ruth", "", 'R');
        compare_test("", "", 0);
    }
}