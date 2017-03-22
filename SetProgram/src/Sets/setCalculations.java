/*Name: Taha Rangwala
 * Date: March 6, 2017
 * Purpose: The purpose of this class is to do certain calculations that the setAdmin
 * class will use.
 */

package Sets;//from the set package

import java.util.Iterator;//allows for the use of iterators

//setCalculations class header
public class setCalculations<T extends Comparable<T>> {

	/*Purpose: Determines if two sets are equal
	 * @param s1 first set
	 * @param s2 second set
	 * @return Returns a boolean value denoting if the sets are equal or not
	 */
	public static <T> boolean equals(SetADT<T> s1, SetADT<T> s2){
		if(s1.size() != s2.size())
			return false;
		else{
			Iterator <SetADT<T>>iter1 = s1.iterator();
			while(iter1.hasNext()){
				if(!s2.contains((T) iter1.next()))
					return false;
			}
			return true;
		}
	}
	
	/*Purpose: Finds all common values in both sets
	 * @param s1 first set
	 * @param s2 second set
	 * @return Returns a set with the common values
	 */
	public static <T> SetADT<T> intersection(SetADT<T> s1, SetADT<T> s2){
		if(equals(s1,s2))
			return s1;
		boolean isIter = false;
		SetADT<T> sub;
		Iterator iter;
		if(s1.size() > s2.size()){
			iter = s2.iterator();
			sub = s1;
		}
		else{
			iter = s1.iterator();
			isIter = true;
			sub = s2;
		}
		while(iter.hasNext()){
			T value = (T) iter.next();
			if(!sub.contains(value))
				iter.remove();
		}
		if(isIter)
			return s1;
		return s2;
	}
	
	/*Purpose: Combines sets
	 * @param s1 first set
	 * @param s2 second set
	 * @return Returns a set that is the combination of s1 and s2
	 */
	public static <T> SetADT<T> union(SetADT<T> s1, SetADT<T> s2){
		SetADT<T> sub;
		Iterator iter;
		if(s1.size() > s2.size()){
			iter = s2.iterator();
			sub = s1;
		}
		else{
			iter = s1.iterator();
			sub = s2;
		}
		while(iter.hasNext()){
			T value = (T) iter.next();
			if(!sub.contains(value))
				sub.add(value);
		}
		return sub;
	}
	
	/*Purpose: Determines if s2 is a subset of s1
	 * @param s1 first set
	 * @param s2 second set
	 * @return Returns a boolean value denoting if there is a subset
	 */
	public static <T> boolean subset(SetADT<T> s1, SetADT<T> s2){
		if(equals(s1, s2))
			return true;
		else if(s1.size() < s2.size())
			return false;
		else{
			Iterator iter = s2.iterator();
			while(iter.hasNext()){
				if(!s1.contains((T) iter.next()))
					return false;
			}
			return true;
		}
	}
	
}
