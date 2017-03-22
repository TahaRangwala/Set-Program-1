/*Name: Taha Rangwala
 * Date: March 6, 2017
 * Purpose: This class is a SetADT and it uses the SetADT interface to perform tasks
 * that the interface provides using a linked list.
 */

package Sets;//from the set package

import java.util.Iterator;//allows for the use of iterators

//listADT class header
public class listSet <T extends Comparable <T>> implements SetADT<T>{//implemenet this interface
	
	//Declaring private instance variables
	private LinkedList setList;//linked list holding values in set
	
	/*Purpose: Constructor method to intialize private instance variables
	 * @param Element Element being added to set
	 */
	public listSet(T Element){
		setList = new LinkedList();
		String S = Element.toString().trim();
		for(int i = 0; i < S.length(); i++){
			add((T) new Character(S.charAt(i)));
		}
	}

	/*Purpose: Checks if the set is empty
	 * @return Returns boolean value of whether or not the set is empty
	 */
	public boolean isEmpty() {
		return setList.getHead() == null;
	}

	/*Purpose: Gets the size of the set
	 * @return Returns an integer value of the size of the set
	 */
	public int size() {
		int Size = 0;
		Iterator iter = iterator();
		while(iter.hasNext()){
			iter.next();
			Size++;
		}
		return Size;
	}

	/*Purpose: Adds element to the set
	 * @param Element element being added to the set
	 * @return Returns a boolean value of whether or not the element is added
	 */
	public boolean add(T Element) {
		if(!contains(Element)){
			setList.addLast(Element);
			return true;
		}
		return false;
	}

	/*Purpose: Removes elements from the set
	 * @param Element element being removed from the set
	 * @return Returns a boolean value of whether or not the element is removed
	 */
	public boolean remove(T Element){
		Iterator iter = iterator();
		while(iter.hasNext()){
			if(Element.compareTo((T) iter.next()) == 0){
				iter.remove();
				return true;
			}
		}
		return false;
	}

	/*Purpose: Checks if elements are in the set
	 * @param Element element being checked for
	 * @return Returns a boolean value of whether or not the element is in the set
	 */
	public boolean contains(T Element) {
		Iterator iter = iterator();
		while(iter.hasNext()){
			if(Element.compareTo((T) iter.next()) == 0)
				return true;
		}
		return false;
	}

	/*Purpose: Turns set into an iterator
	 * @Return Returns iterator form of the set
	 */
	public Iterator iterator() {
		return setList.iterator();
	}
	
	/*Purpose: Gets all values in set
	 * @Return Returns a string value of the values in the set
	 */
	public String toString(){
		String S = "";
		Iterator iter = iterator();
		while(iter.hasNext()){
			S += iter.next().toString() + " ";
		}
		return S;
	}
	
}
