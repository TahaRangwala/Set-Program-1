/*Name: Taha Rangwala
 * Date: March 6, 2017
 * Purpose: The purpose of this interface is to allow class to implement
 * and make a form of polymorphism.
 */

package Sets;//from the sets package

import java.util.Iterator;//allows the use of iterator

//SetADT interface header
public interface SetADT<T> {

	/*Purpose: Checks if the set is empty
	 * @return Returns boolean value of whether or not the set is empty
	 */
	public boolean isEmpty();
	
	/*Purpose: Gets the size of the set
	 * @return Returns an integer value of the size of the set
	 */
	public int size();
	
	/*Purpose: Adds element to the set
	 * @param Element element being added to the set
	 * @return Returns a boolean value of whether or not the element is added
	 */
	public boolean add(T Element);
	
	/*Purpose: Removes elements from the set
	 * @param Element element being removed from the set
	 * @return Returns a boolean value of whether or not the element is removed
	 */
	public boolean remove(T Element);
	
	/*Purpose: Checks if elements are in the set
	 * @param Element element being checked for
	 * @return Returns a boolean value of whether or not the element is in the set
	 */
	public boolean contains(T Element);
	
	/*Purpose: Turns set into an iterator
	 * @Return Returns iterator form of the set
	 */
	public Iterator iterator();
	
}
