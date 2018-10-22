/*
 * linkedList: creates a generic linked list class to be used
 */

import java.util.*;

public class linkedList<AnyType extends IDedObject>{
	
	private int size;
	private Node<AnyType> startMark;
	
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> next;
		public Node(AnyType dataIn, Node<AnyType> nextIn) {
			data = dataIn;
			next = nextIn;
		}
	}
	
	//constructor for linkedList
	public linkedList() {
		startMark = new Node<>(null, null);
		size = 0;
	}
	
	//empties list
	public void makeEmpty() {
		startMark = new Node<>(null, null);
		size = 0;
	}
	
	public AnyType findID(int id) {
		Node<AnyType> temp = startMark;
		
		for(int i = 0; i < size; i++) {
			if(temp.data.getID() == id)
				return temp.data;
			else
				temp = temp.next;
		}
		return null;
	}
	
	//add an element to the front of the list
	public boolean insertAtFront(AnyType node) {
		Node<AnyType> temp = startMark;
	    for(int i = 0; i < size; i++){
	        if(temp.data.getID() == node.getID())
	            return false;
	        else
	            temp = temp.next;
	    }
	    
	    startMark = new Node<>(node,startMark);
	    size++;
	    return true;
	}
	
	//removing the first element from the list and returning the data
	public AnyType deleteFromFront(){
	    if(size == 0 )
	        return null;
	    else{
	        Node<AnyType> temp = startMark;
	        startMark = startMark.next;  
	        
	        size--;
	        return temp.data;
	    }
	}
	
	//finding the ID in the list and deleting it. 
	public AnyType delete(int id){
	    if(startMark.data.getID() == id)	//delete where it's at
	        return deleteFromFront();
	    else{								//finding the ID somewhere else
	        Node<AnyType> temp1 = startMark;
	        for(int i = 1; i < size; i++){
	            if(temp1.next.data.getID() == id){
	                Node<AnyType> temp2 = temp1.next;
	                temp1.next = temp1.next.next;
	                
	                size--;
	                return temp2.data;
	            }        
	            else 
	                temp1 = temp1.next;
	        }
	    }
	    return null;
	}
	
	//prints all records in the linked list.
	public void printAllRecords(){
	    if(size == 0)
	        System.out.println("The list is empty");
	    else{
	        Node<AnyType> temp = startMark;
	        
	         for(int i = 0; i < size; i++){
	            temp.data.printID();
	            temp = temp.next;
	        }
	    }
	}
	
	
}
