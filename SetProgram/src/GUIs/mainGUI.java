/*Name: Taha Rangwala
 * Date: March 6, 2017
 * Purpose: The purpose of this class is to allow the user to have an interface
 * to select what type of program that they want.
 */

package GUIs;//from the guis package

import BreezySwing.*;//allows for more window objects

import javax.swing.*;//allows for more window objects

import java.awt.Color;//allows for more color

//mainGUI class header
public class mainGUI extends GBFrame{
	
	//Declaring window objects
	private JButton arraySet, listSet;
	
	//Constructor method to initialize window objects
	public mainGUI(){
		arraySet = addButton("Array Set",1,1,1,1);
		listSet = addButton("List Set",1,2,1,1);
	}
	
	/*Purpose: The purpose of this method is to detect which button the user presses and then it performs whatever task
	 * that the button is associated with
	 * @param buttonObj This is the button object which holds the value of what button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == arraySet){//choose array set
			arrayGUI GUI = new arrayGUI(this);
			GUI.setVisible(true);
			setVisible(false);
		}
		else{//choose linked list set
			listGUI GUI = new listGUI(this);
			GUI.setVisible(true);
			setVisible(false);
		}
	}
	
	/*Purpose: Error checks two string values and throws an exception if there is an error
	 * @param S1 the first string being checked
	 * @param S2 the second string being checked
	 */
	public static void errorChecking(String S1, String S2){
		if(S1.trim().equals("") || S2.trim().equals(""))
			throw new IllegalArgumentException("Please Input A String!");
	}

	// Main method to set up the GUI
	public static void main (String [] args){
		mainGUI theMainGUI = new mainGUI();
		theMainGUI.setSize(300,100);//size of the GUI interface
		theMainGUI.setTitle("Chose A Set");//title of GUI interface
		theMainGUI.setLookAndFeel("MOTIF");//This changes the look of the GUI interface
		theMainGUI.setVisible(true);//visibility of interface
		theMainGUI.setLocationRelativeTo(null);//Location is in center of screen
		theMainGUI.getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
}
