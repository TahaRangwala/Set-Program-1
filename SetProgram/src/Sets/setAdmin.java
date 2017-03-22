/*Name: Taha Rangwala
 * Date: March 6, 2017
 * Purpose: This class holds the methods that perform certain tasks using the calculations from
 * the setCalculations class. These tasks are what the user uses to complete his or her agenda.
 */

package Sets;//from the Sets package

import java.util.Iterator;//allows for the iterator to be used

//setAdmin class header
public class setAdmin<T extends Comparable<T>> {

	/*Purpose: Gets the frequency of elements in the string inputted
	 * @param Element The Element the user inputted
	 * @param set1 Holds the unique letters in S in a set
	 * @return Returns a string value of the frequency of elements in S
	 */
	public String getFrequency(T Element, SetADT<T> set1){
		String S = Element.toString().trim();
		String Output = "Frequency of Letters in " + S + ":\n";
		Iterator iter = set1.iterator();
		T Current;
		int Count = 0;
		while(iter.hasNext()){
			Current = (T) iter.next();
			Output += Current.toString() + ": ";
			for(int i = 0; i < S.length(); i++){
				if(Current.compareTo((T) new Character(S.charAt(i))) == 0)
					Count++;
			}
			Output += Count + "\n";
			Count = 0;
		}
		return Output;
	}
	
	/*Purpose: Gets the values in common of two sets
	 * @param s1 Holds the unique values of the first element in a set
	 * @param s2 Holds the unique values of the second element in a set
	 * @return Returns a string value of the values in common
	 */
	public String valuesInCommon(SetADT<T> s1, SetADT<T> s2){
		SetADT<T> s3 = setCalculations.intersection(s1, s2);
		if(s3.isEmpty())
			return "No Values in Common";
		return "Values in Common: \n" + s3.toString();
	}
	
	/*Purpose: Combines the values in the two sets
	 * @param s1 Holds the unique values of the first element in a set
	 * @param s2 Holds the unique values of the second element in a set
	 * @return Returns a string value of the combined sets
	 */
	public String combinedSet(SetADT<T> s1, SetADT<T> s2){
		return "Values Combined: \n" + setCalculations.union(s1, s2).toString();
	}
	
	/*Purpose: Determines if s2 is a subset of s1
	 * @param s1 Holds the unique values of the first element in a set
	 * @param s2 Holds the unique values of the second element in a set
	 * @return Returns a string value letting the user know of s2 is a subset
	 */
	public String determineSubset(SetADT<T> s1, SetADT<T> s2){
		if(setCalculations.subset(s1, s2))
			return "The unique values of String 2 are in String 1";
		else
			return "Not all of the unique values of String 2 are not in String 1";
	}
	
	/*Purpose: Removes values in
	 * @param s1 unique values of first element inputted
	 * @param s2 Holds the unique values of the second element in a set
	 * @return Returns changed set 1
	 */
	public SetADT<T> Remove(SetADT<T> s1, SetADT<T> s2){
		Iterator <T> iter = s1.iterator();
		while(iter.hasNext()){
			if(s2.contains(iter.next()))
				iter.remove();
		}
		return s1;
	}
	
}
