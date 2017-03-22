/*Name: Taha Rangwala
 * Date: March 6, 2017
 * Purpose: The purpose of this class is to allow the user to have a friendly
 * interface while performing task using the linked list set. 
 */

package GUIs;//from the guis package

import BreezySwing.*;//allows for more window objects

import Sets.*;//imports things from the sets package

import javax.swing.*;//allows for more window objects

import java.awt.Color;//allows for more colors

//listGUI class header
public class listGUI extends GBDialog{

	//Declaring private instance variables
	private setAdmin adminObj;//setAdmin object
	//Declaring window objects
	private JLabel stringLabel1, stringLabel2;
	private JTextField stringField1, stringField2;
	private JTextArea outputArea;
	private JButton Frequency, Intersection, Union, determineSubset, Remove, Exit;
	
	/*Purpose: This constructor method intializes private instance variables and window objects
	 * @param F This is the JFrame object
	 */
	public listGUI(JFrame F) {
		super(F);
		setSize(350,350);//size of the GUI interface
		setTitle("Taha's Linked List Set Program");//title of GUI interface
		setLookAndFeel("MOTIF");//This changes the look of the GUI interface
		setLocationRelativeTo(null);//Location is in center of screen
		getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
		stringLabel1 = addLabel("First String",1,1,1,1);
		stringField1 = addTextField("",1,3,1,1);
		stringLabel2 = addLabel("Second String",2,1,1,1);
		stringField2 = addTextField("",2,3,1,1);
		outputArea = addTextArea("",3,1,3,1);
		Frequency = addButton("Frequency",4,1,1,1);
		Intersection = addButton("Intersection",4,2,1,1);
		Union = addButton("Union",4,3,1,1);
		determineSubset = addButton("Determine Subset",5,1,1,1);
		Remove = addButton("Remove",5,2,1,1);
		Exit = addButton("Exit",5,3,1,1);
		adminObj = new setAdmin();
	}

	/*Purpose: The purpose of this method is to detect which button the user presses and then it performs whatever task
	 * that the button is associated with
	 * @param buttonObj This is the button object which holds the value of what button the user has pressed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == Frequency){//finds frequency in string
			try{
				mainGUI.errorChecking(stringField1.getText().toLowerCase(), "s");
				outputArea.setText(adminObj.getFrequency(stringField1.getText().toLowerCase(), new listSet(stringField1.getText().toLowerCase())));
				stringField1.setText("");
				stringField1.grabFocus();
			}
			catch(IllegalArgumentException E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == Intersection){//finds same values in strings
			try{
				mainGUI.errorChecking(stringField1.getText().toLowerCase().toLowerCase(), stringField2.getText().toLowerCase());
				outputArea.setText(adminObj.valuesInCommon(new listSet(stringField1.getText().toLowerCase()), new listSet(stringField2.getText().toLowerCase())));
				stringField1.setText("");
				stringField2.setText("");
				stringField1.grabFocus();
			}
			catch(IllegalArgumentException E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == Union){//combines strings
			try{
				mainGUI.errorChecking(stringField1.getText().toLowerCase(), stringField2.getText().toLowerCase());
				outputArea.setText(adminObj.combinedSet(new listSet(stringField1.getText().toLowerCase()), new listSet(stringField2.getText().toLowerCase())));
				stringField1.setText("");
				stringField2.setText("");
				stringField1.grabFocus();
			}
			catch(IllegalArgumentException E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == determineSubset){//determines a subset
			try{
				mainGUI.errorChecking(stringField1.getText().toLowerCase(), stringField2.getText().toLowerCase());
				outputArea.setText(adminObj.determineSubset(new listSet(stringField1.getText().toLowerCase()), new listSet(stringField2.getText().toLowerCase())));
				stringField1.setText("");
				stringField2.setText("");
				stringField1.grabFocus();
			}
			catch(IllegalArgumentException E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(buttonObj == Remove){//remove button
			try{
				mainGUI.errorChecking(stringField1.getText().toLowerCase(), stringField2.getText().toLowerCase());
				outputArea.setText(adminObj.Remove(new listSet(stringField1.getText().toLowerCase()), new listSet(stringField2.getText().toLowerCase())).toString());
				stringField1.setText("");
				stringField2.setText("");
				stringField1.grabFocus();
			}
			catch(IllegalArgumentException E){
				JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
			setVisible(false);//closes the program
	}
}
