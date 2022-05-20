import java.util.*;

public class Run {
    public static void main(String args []) {
        Scanner input = new Scanner(System.in);
        // user input
        int reply;
        // ID number
        int ID;
        // Product object for testing
        Product x;

        SinglyLinkedList<Product> list = new SinglyLinkedList<>();
        do {
            displayPrompt();
            reply = input.nextInt();
            switch(reply) {
                case 1:
                    if(!list.isEmpty()) {
                        list.makeEmpty();
                        System.out.println("Done");
                    }
                    else
                        System.out.println("List is already empty");
                    break;
                case 2:
                    System.out.print("ID No: ");
                    ID = input.nextInt(); 
                    if(list.findID(ID) != null)                   
                        list.findID(ID).printID();
                    else
                        System.out.println("ID not found");
                    break;
                case 3:
                    System.out.print("Enter Product ID: ");
                    ID = input.nextInt();
                    input.nextLine();
                    if(list.findID(ID) == null) {
                        x = new Product();
                        x.setID(ID);
                        System.out.print("Enter Product Name: ");
                        x.setProd(input.nextLine());
                        System.out.print("Enter SupplierName: ");
                        x.setSup(input.nextLine());
                        list.insertAtFront(x);
                        System.out.println("Product Added");
                    }  else {
                        System.out.println("ID already exists with data: ");
                        list.findID(ID).printID();
                    }                     
                    break;
                case 4:
                    if(list.isEmpty())
                    System.out.println("List is already empty");
                    else {
                        list.deleteFromFront().printID();
                        System.out.println("First item deleted");
                    }                        
                    break;
                case 5:
                System.out.print("Enter Product ID: ");
                ID = input.nextInt();
                input.nextLine();
                if(list.findID(ID) == null)
                    System.out.println("ID not found");
                else {
                    list.delete(ID).printID();
                    System.out.println("Product deleted");
                }
                    break;
                case 6:
                    if(list.isEmpty())
                        System.out.println("No Records");
                    else {
                        list.printAllRecords();
                        System.out.println("...");
                        System.out.println("Done");
                    }                    
                    break;
                case 7: 
                    break;
                default:
                    System.out.println("must enter a number from 1 to 7 only");

            }
        }
        while(reply != 7);

        input.close();
    }

    public static void displayPrompt() {
        System.out.println("Operations on List: ");
        System.out.println("    1. Make Empty");
        System.out.println("    2. Find ID");
        System.out.println("    3. Insert At Front");
        System.out.println("    4. Delete From Front");
        System.out.println("    5. Delete ID");
        System.out.println("    6. Print All Records");
        System.out.println("    7. Done");
        System.out.print("          Your Choice: ");
    }
}
