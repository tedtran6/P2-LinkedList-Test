/*
 * TestLinkedList: this is the tester we use to accept user input data and do whatever the user wants
 * the program to do.
 */

import java.util.*;

public class TestLinkedList{
    // Main method
    public static void main( String [ ] args ){
        linkedList<Magazine> testing = new linkedList<>( );
        
        Scanner scan = new Scanner(System.in);
        
        int choice;
        String magName;
        String pubName;
        String operations = "Operations on List\n  1. Make Empty\n  2. Find ID\n  3. Insert At Front\n  "
        		+ "4. Delete From Front\n  5. Delete ID\n  6. Print All Records\n  7. Done \n\nYour choice: ";
        System.out.print(operations);
        
        choice = scan.nextInt();
        
        //enters if 0 through 6. Exits if above.
        while (choice > 0 && choice <= 6){
            switch (choice) {
                //case 1 deletes all items in the list
                case 1: testing.makeEmpty();
                        System.out.print(operations);
                        choice = scan.nextInt();   
                        break;
                        
                //case 2 tries to find an magazine based on it's ID and outputs it's data
                case 2: System.out.print("ID No: ");
                        choice = scan.nextInt();
                        if(testing.findID(choice) != null){
                            testing.findID(choice).printID();
                        }
                        else
                            System.out.println("Magazine not found");
                        System.out.print(operations);
                        choice = scan.nextInt();
                        break;
                
                //case 3 tries to input a new magazine into the list
                case 3: System.out.print("Magazine ID: ");
                        choice = scan.nextInt();
                        
                        System.out.print("Magazine Name: ");
                        magName = scan.next();
                        
                        System.out.print("Publisher Name: ");
                        pubName = scan.next();
                        
                        Magazine mag = new Magazine(choice,magName,pubName);
                        if(testing.insertAtFront(mag))
                            System.out.println("Magazine Added");
                        else
                            System.out.println("Different magazine in list has the same ID, can't be added.");
                        
                        System.out.print(operations);
                        choice = scan.nextInt();
                        break;
                       
                //case 4 tries to delete an item from the front of the list
                case 4: Magazine temp = testing.deleteFromFront();
                        if(temp != null){
                            temp.printID();
                            System.out.println("First Item Deleted");
                        }        
                        else
                            System.out.println("Can't delete from front");
                        
                        System.out.print(operations);
                        choice = scan.nextInt();
                        break;
                        
                //case 5 tries to find the magazine in the list and delete it
                case 5: System.out.print("Enter Magazine ID: ");
                        choice = scan.nextInt();
                        
                        if(testing.findID(choice) != null){
                            testing.delete(choice).printID();
                            System.out.println("Item was Deleted");
                        }        
                        else
                            System.out.println("Item wasn't in list");
                        
                        System.out.print(operations);
                        choice = scan.nextInt();
                        break;
                        
                //case 6 prints all records in the list
                case 6: testing.printAllRecords();
                        System.out.print(operations);
                        
                        choice = scan.nextInt();
                        break;
                        
                default: break;     
            }
        }
        System.out.println("Done."); 
    }
}
