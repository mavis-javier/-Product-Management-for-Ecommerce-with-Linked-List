// Contains an implementation or imitation of the singly linked list of Java API
public class SinglyLinkedList<AnyType extends IDedObject> {

    /** variables */
    // contains size of singly linked list    
    private int size;
    // contains first data
    private singlyNode<AnyType> head;
    // contains last data
    private singlyNode<AnyType> tail;

    /** methods */
    // constructor
    public SinglyLinkedList() {}

    // empties list
    public void makeEmpty(){
        size = 0;
        head = tail = null;
    }

    // returns AnyType that matches given ID number
    public AnyType findID(int ID) {
        singlyNode<AnyType> current = head;

        while(current != null) {
            if(current.getElement().getID() == ID)
                return current.getElement();
            current = current.getNext();
        }
        return null;
    }
    
    // returns true if new node is inserted in front of list, false otherwise (ID may have exist)
    public boolean insertAtFront(AnyType x) {
        // return false if ID already exists
        if(findID(x.getID()) != null)
            return false;
        
        // create new node and insert in front of head
        head = new singlyNode<>(x, head);
        // set tail to head if list was intitially empty
        if(isEmpty()) 
            tail = head;                
        
        // increment size 
        size++;
        // element is successfully inserted
        return true;
    }

    public AnyType deleteFromFront() {
        singlyNode<AnyType> node = head;
        head = head.next;
        size--;
        return node.getElement();
    }

    public AnyType delete(int ID) {
        if(findID(ID) == null)
            return null;
        singlyNode<AnyType> node = head;
        while(node != null  && node.next.getElement().getID() != ID) {
            node = node.next;
        }
        singlyNode<AnyType> temp = node.getNext();
        node.setNext(node.next.next);
        size--;
        return temp.getElement();
    }

    public void printAllRecords() {
        singlyNode<AnyType> node = head;
        while(node != null) {
            node.getElement().printID();
            node = node.getNext();            
        }
    }

    /* Additional methods */
    public boolean isEmpty() {
        return size == 0;
    }

    public AnyType first() {
        if(isEmpty())
            return null;
        return head.getElement();
    }

    public AnyType last() {
        if(isEmpty()) 
            return null;
        return tail.getElement();
    }

    private static class singlyNode<AnyType extends IDedObject> {
        private AnyType element;
        private singlyNode<AnyType> next;
        public singlyNode(AnyType element, singlyNode<AnyType> next) {
            this.element = element;
            this.next = next;
        }
        
        public AnyType getElement() {
            return element;
        }

        public singlyNode<AnyType> getNext() {
            return next;
        }

        public void setNext(singlyNode<AnyType> node) {
            next = node;
        }
      
    }     
}