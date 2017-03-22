/*Name: Taha Rangwala
 * Date: March 6, 2017
 * Purpose: This class is a SetADT and it uses the methods from the SetADt interface to
 * perform tasks using an arraylist
 */

package Sets;//from the sets package

import java.util.*;//allows iterators and arraylists

//arraySet class header
public class arraySet<T extends Comparable<T>> implements SetADT<T> {//implementing interface

	//Declaring private instance variables
	private T[] setArray;//arraylist holding values in set
	private int Count;//number of values in array

	/*Purpose: Constructor method to intialize private instance variables
	 * @param Element Element being added to set
	 */
	public arraySet(T Element) {
		setArray = (T[]) (new Comparable[10]);
		Count = -1;
		String S = Element.toString().trim();
		for (int i = 0; i < S.length(); i++) {
			add((T) new Character(S.charAt(i)));
		}
	}

	/*
	 * Purpose: Checks if the set is empty
	 * @return Returns boolean value of whether or not the set is empty
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/*
	 * Purpose: Gets the size of the set
	 * @return Returns an integer value of the size of the set
	 */
	public int size() {
		return Count + 1;
	}

	/*
	 * Purpose: Adds element to the set
	 * @param Element element being added to the set
	 * @return Returns a boolean value of whether or not the element is added
	 */
	public boolean add(T Element) {
		if (!contains(Element)) {
			Count++;
			if(Count == setArray.length)
				doubleSize();
			setArray[Count] = Element;
			return true;
		}
		return false;
	}
	
	// This method doubles the size of the heap array when there is no longer
	// any space
	private void doubleSize() {
		T[] subArray = (T[]) (new Comparable[setArray.length * 2]);
		for (int i = 0; i <= Count - 1; i++) {
			subArray[i] = setArray[i];
		}
		setArray = subArray;
	}

	/*
	 * Purpose: Removes elements from the set
	 * @param Element element being removed from the set
	 * @return Returns a boolean value of whether or not the element is removed
	 */
	public boolean remove(T Element) {
		Iterator<T> iter = iterator();
		while (iter.hasNext()) {
			if (Element.compareTo(iter.next()) == 0) {
				iter.remove();
				return true;
			}
		}
		return false;
	}

	/*
	 * Purpose: Checks if elements are in the set
	 * @param Element element being checked for
	 * @return Returns a boolean value of whether or not the element is in the
	 * set
	 */
	public boolean contains(T Element) {
		Iterator<T> iter = iterator();
		while (iter.hasNext()) {
			if (Element.compareTo(iter.next()) == 0) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Purpose: Turns set into an iterator
	 * @Return Returns iterator form of the set
	 */
	public Iterator iterator() {
		return new ArrayIterator();
	}

	/*
	 * Purpose: Gets all values in set
	 * @Return Returns a string value of the values in the set
	 */
	public String toString() {
		String S = "";
		Iterator iter = iterator();
		while (iter.hasNext()) {
			S += iter.next().toString() + " ";
		}
		return S;
	}

	/*
	 * Name: Taha Rangwala Date: March 6, 2017 Purpose: The purpose of this
	 * class is to act as an iterator. It implements iterator allowing it to use
	 * the hasNext, next, and remove methods.
	 */
	
	// ArrayIterator class header
	public class ArrayIterator<T> implements Iterator<T> {
		private int current; // the current position in the iteration
		private boolean removable;//determines if remove can be called

		//Sets up this iterator using the specified items.
		public ArrayIterator(){
			current = -1;
		}

		/*Purpose: Determines if there is a next value
		 * @return Returns true if this iterator has at least one more element
		*/
		public boolean hasNext() {
			return (current < Count);
		}

		/*Purpose: Gets next value
		 * @return Returns next value in iterator
		*/
		public T next() {
			if (!hasNext())
				throw new IllegalArgumentException("No Values Are Next");
			current++;
			removable = true;
			return (T) setArray[current];
		}

		//Removes current value from iterator
		public void remove() {
			if(!removable)
				throw new IllegalArgumentException("Next must be called first!");
			if(Count == current){
				current--;
				Count--;
			}
			else{
				for(int i = current; i < Count; i++){
					setArray[i] = setArray[i+1];
				}
				Count--;
				current--;
			}
			removable = false;
		}
	}
}
