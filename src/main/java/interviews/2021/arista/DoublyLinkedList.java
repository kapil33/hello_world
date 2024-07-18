package gfg.interviews.arista;

class Node{
    int val;
    Node next;
    Node prev;

    Node(){}

    Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    Node(int val, Node next, Node prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

public class DoublyLinkedList {

    public Node createDLL(int numberOfNode){
        Node head = new Node(1, null, null);
        Node trav = head;

        for(int i=2; i<=numberOfNode; i++){
            Node temp = new Node(i, null, trav);
            trav.next = temp;
            trav = trav.next;
        }

        return head;
    }

    public void print(Node head){
        while (head.next != null){
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);

        while (head.prev != null){
            System.out.println(head.val);
            head = head.prev;
        }
        System.out.println(head.val);
    }

    private Node subtract(Node head, int k, int c){
        Node trav = head;

        while (trav.val != k){
            trav = trav.next;
        }
        trav.val -= c;

        while (trav.prev != null && trav.val < trav.prev.val){
            Node previous = trav.prev;
            Node next = trav.next;

            previous.next = next;
            if(next != null)
                next.prev = previous;

            trav.prev = previous.prev;
            trav.next = previous;

            if (previous.prev != null)
                previous.prev.next = trav;
            previous.prev = trav;
        }

        if (trav.prev == null)
            return trav;
        else
            return head;
    }

    private Node addition(Node head, int k, int c){
        Node trav = head;
        while (trav.val != k){
            trav = trav.next;
        }
        trav.val += c;

        while (trav.next != null && trav.val > trav.next.val){
            Node previous = trav.prev;
            Node next = trav.next;

            previous.next = next;
            next.prev = previous;

            trav.next = next.next;
            trav.prev = next;

            if (next.next != null)
                next.next.prev = trav;
            next.next = trav;
        }

        return head;
    }

    public static void main(String[] args){
        DoublyLinkedList dll = new DoublyLinkedList();
        Node head = dll.createDLL(5);
        dll.print(head);

        System.out.println("Linked list after subtraction is: ");
        Node head2 = dll.subtract(head, 5, 5);
        dll.print(head2);

        System.out.println("Linked list after addition is: ");
        Node head3 = dll.addition(head2, 2, 2);
        dll.print(head3);
    }
}
