// { Driver Code Starts
import java.util.*;
class Nodea
{
    int data;
    Nodea next;

    Nodea(int d)
    {
        data = d;
        next = null;
    }
}
class DeleteNodea
{
    Nodea head;
    void printList(Nodea head)
    {
        Nodea temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void addToTheLast(Nodea Nodea)
    {
        if (head == null)
        {
            head = Nodea;
        } else
        {
            Nodea temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = Nodea;
        }}
    public static void main(String args[])
    {

        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();

        while(t>0)
        {
            int n = sc.nextInt();
            //int k = sc.nextInt();
            DeleteNodea llist = new DeleteNodea();
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Nodea head = new Nodea(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                llist.addToTheLast(new Nodea(a));
            }
            int x = sc.nextInt();
            //System.out.println(llist.head.data);
            DeleteNodeaSingleLinkedList g = new DeleteNodeaSingleLinkedList();
            //System.out.println(k);
            //System.out.println(g.getNthFromLast(llist.head,k));
            Nodea result = g.deleteNodea(llist.head, x);
            llist.printList(result);
            t--;
        }
    }
}// } Driver Code Ends


/* Linklist Nodea structure
class Nodea
{
	int data;
	Nodea next;
	
	Nodea(int d)
	{
		data = d;
		next = null;
	}
}*/
/*You are required to complete below method*/
class DeleteNodeaSingleLinkedList
{
    Nodea deleteNodea(Nodea head, int x)
    {
        Nodea current;
        if (x == 1) return head.next;
        else {
            current = head;
            for (int i = 1; current.next != null && i < x - 1; i++) current = current.next;
            current.next = current.next.next;
        }
        return head;
    }
}