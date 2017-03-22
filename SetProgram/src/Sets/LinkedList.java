/*Name: Taha Rangwala
 * Date: March 6, 2017
 * Purpose: The purpose of this class is to take all the information from all the other classes
 * and do some calculations and relay them back to the gui class for the user to see. This class essentially
 * holds all the information that the user wants to see and does necessary calculations as well.
 */

package Sets;//from the sets package

import java.util.Iterator;//allows for the use of an iterator

import BreezySwing.Format;//imports more formatting options

//LinkedList class header
public class LinkedList <T>{
	
	//Declaring private instance variables
	private ListNode Head;//Head of the list node
	
	/*Purpose: This is the constructor method which initializes all of the instance variables in this class
	 */
	public LinkedList(){
		Head = null;
	}
	
	/*Purpose: The purpose of this method is to add the value of the first node of the list node
	 * @param newValue This is the value added to the first node of the list node
	 */
	public void addFirst(T newValue){
		ListNode Temp = Head;
		Head = new ListNode(newValue, Temp);
	}
	
	/*Purpose: The purpose of this method is to add the value of the last node of the list node
	 * @param newValue This is the value added to the last node of the list node
	 */
	public void addLast(T newValue){
		if(Head != null){
			ListNode Temp = Head;
			while(Temp.getNext() != null){
				Temp = Temp.getNext();
			}
			Temp.setNext(new ListNode(newValue, null));
		}
		else addFirst(newValue);
	}
	
	/*Purpose: This method prints all of the information from the list node
	 * @return This returns a string value of all of the information in the list node
	 */
	public String printAll(){
		if(Head == null)
			throw new IllegalArgumentException("No Values Have Been Inputted");
		String Output = "";
		Output += Head.getValue().toString();
		ListNode Temp = Head;
		while(Temp.getNext() != null){
			Temp = Temp.getNext();
			Output += Temp.getValue().toString();
		}
		return Output;
	}
	
	/*Purpose: This method prints all of the information of the first node
	 * @return This returns a string value of all of the information of the first node
	 */
	public String printFirst(){
		if(Head == null)
			throw new IllegalArgumentException("No Values Have Been Inputted");
		return Head.getValue().toString();
	}
	
	/*Purpose: This method prints all of the information of the last node
	 * @return This returns a string value of all of the information of the last node
	 */
	public String printLast(){
		if(Head == null)
			throw new IllegalArgumentException("No Values Have Been Inputted");
		ListNode Temp = Head;
		while(Temp.getNext() != null){
			Temp = Temp.getNext();
		}
		return Temp.getValue().toString();
	}
	
	/*Purpose: This method removes the first node in the list node
	 */
	public void removeFirst(){
		if(Head == null)
			throw new IllegalArgumentException("No Values Have Been Inputted");
		if(Head.getNext() != null)
			Head = Head.getNext();
		else Head = null;
	}
	
	/*Purpose: This method removes the last node in the list node
	 */
	public void removeLast(){
		if(Head == null)
			throw new IllegalArgumentException("No Values Have Been Inputted");
		else if(Head.getNext() != null){
			ListNode Temp = Head;
			while(Temp.getNext() != null  && Temp.getNext().getNext() != null){
				Temp = Temp.getNext();
			}
			Temp.setNext(null);
		}
		else 
			Head = null;
	}
	
	public ListNode <T> getHead(){
		return Head;
	}
	
	public LinkedListIterator <T> iterator(){
		return new LinkedListIterator();
	}
	
	/*Name: Taha Rangwala
	 * Date: March 6, 2017
	 * Purpose: The purpose of this class is to ask as an iterator. It implements iterator allowing it to use the
	 * hasNext, next, and remove methods.
	 */
	//LinkedListIterator class header
	public class LinkedListIterator<T> implements Iterator{

		 //Instance Variables
        private ListNode<T> current; //Tracks the current node
        private ListNode<T> previous; //Tracks the previous node
        private boolean removable; //If removable, can use the remove method
       
        //This constructor method initializes the private instance variables
        public LinkedListIterator(){
            removable = false;
            current = new ListNode<T>(null, Head);
            previous = null;
        }
        
        /*Purpose: This method checks if there is a next node
         * @return Returns a boolean value denoting if the next node is available or not
         */
        public boolean hasNext() {
            return current.getNext()!=null;
        }
   
        /*Purpose: This method gets the next node and increments the iterator
         * @return Returns the node after the current 
         */
        public T next() {
        	if(!hasNext())
        		throw new IllegalArgumentException("No Values Are Next");
            removable = true;
            previous = current;
            current = current.getNext();
            return current.getValue();
        }
         //This method removes an item from the list using the iterator
        public void remove(){
            if(!removable)
                throw new IllegalArgumentException("Must call next before removing");
            if(previous.getValue() == null)
                Head = current.getNext();
            else{
                previous.setNext(current.getNext());
            }
            removable = false;     
        }
	}
}