/**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//the class with button and main method
public class SortGUI {

	// import javax.swing.JFrame;

	// variables that hold the amount of time for the sort to execute
	public static double bubbleTime = 0.0;
	public static double insertionTime = 0.0;
	public static double selectionTime = 0.0;
	public static double rmergeTime = 0.0;
	public static double imergeTime = 0.0;
	public static double radixTime = 0.0;
	public static double quickTime = 0.0;
	public static double shellTime = 0.0;

	//Boolean variable that keep track of whether or not the sort has already been used
	public boolean Bubble_Done = false;
	public boolean Insertion_Done = false;
	public boolean Selection_Done = false;
	public boolean Recersive_Merge_Done = false;
	public boolean Iterative_Merge_Done = false;
	public boolean Radix_Done = false;
	public boolean Quick_Done = false;
	public boolean Shell_Done = false;

	//Making a object from the class SortShow
	SortShow sortArea = new SortShow();
	
	//Default constructor for SortGUI
	public SortGUI() {
		//making a MyScreen object

		// You need to adjust the following values to your Screen dimensions

		MyScreen screen = new MyScreen();
		//Setting a title to the GUI window
		screen.setTitle("Assignment 1 - Group 15 - Joseph Hargus, Kaitlyn Self, Evan Trejo");
		//setting the size of the window 
		screen.setSize(975+sortArea.total_number_of_lines, 450);
		//the operation when the frame is closed
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//is set to true to display the frame
		screen.setVisible(true);
	}
	//A public class that extends JFrame
	public class MyScreen extends JFrame {
		//Making buttons for each action, each with text on it displaying its use
		JRadioButton bubble = new JRadioButton("Bubble Sort");
		JRadioButton insertion = new JRadioButton("Insertion Sort");
		JButton scramble_button = new JButton("Scramble Lines");
		JRadioButton selection = new JRadioButton("Selection");
		JRadioButton rmerge = new JRadioButton("Merge Recursive");
		JRadioButton imerge = new JRadioButton("Merge Iterative");
		JRadioButton radix = new JRadioButton("Radix");
		JRadioButton quick = new JRadioButton("Quick");
		JRadioButton shell = new JRadioButton("Shell");
		JRadioButton reset = new JRadioButton("Reset");


		//Labels that display the time it took for the sorts to execute
		JLabel bubble_time_label = new JLabel("Bubble Sort Time");
		JLabel bubble_time_taken = new JLabel(""); 
		JLabel insertion_time_label = new JLabel("Insertion Sort Time");
		JLabel insertion_time_taken = new JLabel(""); 
		JLabel selection_time_label = new JLabel("Selection Time");
		JLabel selection_time_taken = new JLabel(""); 
		JLabel rmerge_time_label = new JLabel("Merge-Rec Time");
		JLabel rmerge_time_taken = new JLabel("");
		JLabel imerge_time_label = new JLabel("Merge-Ita Time");
		JLabel imerge_time_taken = new JLabel("");
		JLabel radix_time_label = new JLabel("Radix Time");
		JLabel radix_time_taken = new JLabel("");
		JLabel quick_time_label = new JLabel("Quick Time");
		JLabel quick_time_taken = new JLabel("");
		JLabel shell_time_label = new JLabel("Shell Time");
		JLabel shell_time_taken = new JLabel("");
	
		//the default constructor for the class MyScreen
		public MyScreen() {
			// Panel where sorted lines_lengths will displayed

			//The time displayed for each sort will be the colour red
			bubble_time_taken.setForeground(Color.RED);
			insertion_time_taken.setForeground(Color.RED);
			selection_time_taken.setForeground(Color.RED);
			rmerge_time_taken.setForeground(Color.RED);
			imerge_time_taken.setForeground(Color.RED);
			radix_time_taken.setForeground(Color.RED);
			quick_time_taken.setForeground(Color.RED);
			shell_time_taken.setForeground(Color.RED);

			//Each button's text will be the colour blue
			bubble.setForeground(Color.BLUE);
			insertion.setForeground(Color.BLUE);
			selection.setForeground(Color.BLUE);
			rmerge.setForeground(Color.BLUE);
			imerge.setForeground(Color.BLUE);
			radix.setForeground(Color.BLUE);
			scramble_button.setForeground(Color.BLUE);
			quick.setForeground(Color.BLUE);
			shell.setForeground(Color.BLUE);

			//setting the font of scramble button
			scramble_button.setFont(new Font("Arial", Font.BOLD, 15));
			//A Panel to hold the radio_button_selection and set the GridLayout
			JPanel radio_button_selection_Panel = new JPanel(new GridLayout(4, 1, 3, 3));

			//Adding each sort button to the radio_button_selection_Panel
			radio_button_selection_Panel.add(bubble);
			radio_button_selection_Panel.add(insertion);
			radio_button_selection_Panel.add(selection);
			radio_button_selection_Panel.add(rmerge);
			radio_button_selection_Panel.add(imerge);
			radio_button_selection_Panel.add(radix);
			radio_button_selection_Panel.add(quick);
			radio_button_selection_Panel.add(reset);
			radio_button_selection_Panel.add(shell);

			//giving the radio_button_selection_Panel a border with a title 
			radio_button_selection_Panel.setBorder(new javax.swing.border.TitledBorder("Sort Algorithms"));

			//A Panel to hold the time_Panel and set the GridLayout
			JPanel time_Panel = new JPanel(new GridLayout(6, 1, 3, 3));

			//Adding each sort_time_label and sort_time_taken to the time_Panel
			time_Panel.add(bubble_time_label);
			time_Panel.add(bubble_time_taken);
			time_Panel.add(insertion_time_label);
			time_Panel.add(insertion_time_taken);
			time_Panel.add(selection_time_label);
			time_Panel.add(selection_time_taken);
			time_Panel.add(rmerge_time_label);
			time_Panel.add(rmerge_time_taken);
			time_Panel.add(imerge_time_label);
			time_Panel.add(imerge_time_taken);
			time_Panel.add(radix_time_label);
			time_Panel.add(radix_time_taken);
			time_Panel.add(quick_time_label);
			time_Panel.add(quick_time_taken);
			time_Panel.add(shell_time_label);
			time_Panel.add(shell_time_taken);

			//A Panel to hold the buttons_area_Panel and set the GridLayout
			//This buttons_area_Panel will hold scrambleButton, radio_button_selection and the time_Panel
			JPanel buttons_area_Panel = new JPanel(new GridLayout(5, 1, 5, 5));
			//adding scramble_button to the buttons_area_Panel
			buttons_area_Panel.add(scramble_button);
			//adding radio_button_selection_Panel to the buttons_area_Panel
			buttons_area_Panel.add(radio_button_selection_Panel);
			//adding time_Panel to the buttons_area_Panel
			buttons_area_Panel.add(time_Panel);

			//placing the buttons_area_Panel to the east side of the window
			add(buttons_area_Panel, BorderLayout.EAST);
			//placing the sortArea object in the center of the window
			add(sortArea, BorderLayout.CENTER);
			//setting all booleans to false
			Set_Available_Chooses(false, false, false, false, false, false, false, false, false);

			//The following code is for creating a listener for each GUI element 

			//Creating an action listener for scramble button
			//This button will be used to scramble the lines in a random way
			//this same scrambled lines will be used for all threes sort methods used in this program
			scramble_button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Scrambling the lines_lengths array
					sortArea.scramble_the_lines(); 
					//Since it has already been clicked, it will no longer be enabled
					scramble_button.setEnabled(false); 
					//setting all booleans true except for reset
					Set_Available_Chooses(true, true, true, true, true, true, true, true, false);
				}
			});

			//Creating an action listener for selection button
			selection.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the selection sort method
					sortArea.SelectionSort(); 
					//Selection sort has finished/been clicked
					Selection_Done = true;
					//The amount of time taken for selection sort took
					selection_time_taken.setText(selectionTime / 1000 + " Seconds");
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});
			
			// action listener for bubble sort
			bubble.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//sorting the array in the bubble sort method
					sortArea.BubbleSort();
					//amount of time taken for bubble sort
					bubble_time_taken.setText((bubbleTime / 1000) + " Seconds");
					//bubble sort has finished
					Bubble_Done = true;
					//setting all booleans to false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false, true);
				}
			});

			// action listener for insertion sort
			insertion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//sorting the array in the insertion sort method
					sortArea.InsertionSort();
					//amount of time taken for insertion sort
					insertion_time_taken.setText((insertionTime / 1000) + " Seconds");
					//insertion sort has finished
					Insertion_Done = true;
					//setting all booleans to false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, false,true);
				}
			});

			//Creating an action listener for recursive merge button
			rmerge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the recursive merge sort method
					sortArea.R_MergeSort();
					//The amount of time taken for recursive merge sort took
					rmerge_time_taken.setText((rmergeTime / 1000) + " Seconds");
					//recursive merge sort has finished/been clicked
					Recersive_Merge_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});
			
			//Creating an action listener for iterative merge button
			imerge.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the iterative merge sort method
					sortArea.I_MergeSort();
					//The amount of time taken for iterative merge sort took
					imerge_time_taken.setText((imergeTime / 1000) + " Seconds");
					//iterative merge sort has finished/been clicked
					Iterative_Merge_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for Radix button
			radix.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Sorting the array in the radix sort method
					sortArea.RadixSort();
					//The amount of time taken for radix sort
					radix_time_taken.setText((radixTime / 1000) + " Seconds");
					//radix sort has finished/been clicked
					Radix_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for Quick button
			quick.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//sorting the array in the quick sort method
					sortArea.QuickSort();
					//The amount of time taken for quick sort
					quick_time_taken.setText((quickTime / 1000) + " Seconds");
					//quick sort has finished/been clicked
					Quick_Done = true;
					//setting all booleans false except for reset
					Set_Available_Chooses(false, false, false, false, false, false, false, true);
				}
			});

			//Creating an action listener for reset button
			reset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//disabling reset since it was clicked
					reset.setEnabled(false);
					//reseting the lines_lengths to its scrambled lines
					sortArea.reset();

					//There are many different combinations of what could be clicked 
					//The following code below covers all possibilities
					//FOr the following use the same comments as above 
					if (Bubble_Done && Insertion_Done && Selection_Done && Recersive_Merge_Done && Iterative_Merge_Done && Radix_Done && Quick_Done) {
						//
						scramble_button.setEnabled(true);
						
						Bubble_Done = false;
						Insertion_Done = false;
						Recersive_Merge_Done = false;
						Iterative_Merge_Done = false;
						Selection_Done = false;
						Radix_Done = false;
						Quick_Done = false;
						Set_Available_Chooses(false, false, false, false, false, false, false, false);
						bubble_time_taken.setText("");
						insertion_time_taken.setText("");
						selection_time_taken.setText("");
						rmerge_time_taken.setText("");
						imerge_time_taken.setText("");
						radix_time_taken.setText("");
						quick_time_taken.setText("");

					} else {
						Set_Available_Chooses(!Bubble_Done, !Insertion_Done, !Selection_Done, !Recersive_Merge_Done, !Iterative_Merge_Done, !Radix_Done, !Quick_Done, false);

					}



					/*else if (Selection_Done && Recersive_Merge_Done && Iterative_Merge_Done) {
						Set_Available_Chooses(false, false, false, true, false);


					} else if(Recersive_Merge_Done && Iterative_Merge_Done && Radix_Done) {
						Set_Available_Chooses(true, false, false, false, false);

					} else if(Selection_Done && Recersive_Merge_Done && Radix_Done) {
						Set_Available_Chooses(false, false, true, false, false);

					} else if(Selection_Done && Iterative_Merge_Done && Radix_Done) {
						Set_Available_Chooses(false, true, false, false, false);

					} else if (Recersive_Merge_Done && Iterative_Merge_Done) {
						Set_Available_Chooses(true, false, false,true, false);

					} else if (Selection_Done && Recersive_Merge_Done) {
						Set_Available_Chooses(false, false, true, true,false);

					} else if (Selection_Done && Iterative_Merge_Done) {
						Set_Available_Chooses(false, true, false, true,false);

					} else if (Selection_Done && Radix_Done) {
						Set_Available_Chooses(false, true, true,false, false);

					} else if (Recersive_Merge_Done && Radix_Done) {
						Set_Available_Chooses(true, false, true, false, false);

					} else if (Iterative_Merge_Done && Radix_Done) {
						Set_Available_Chooses(true, true, false, false, false);

					} else if (Selection_Done) {
						Set_Available_Chooses(false, true, true,true, false);

					} else if (Recersive_Merge_Done) {
						Set_Available_Chooses(true, false, true, true,false);

					} else if (Iterative_Merge_Done){
						Set_Available_Chooses(true, true, false, true,false);

					} else if (Radix_Done) {
						Set_Available_Chooses(true, true, true, false, false);
					}*/
				}
			});

		}

		//A method that sets if the button are enabled or disabled
		public void Set_Available_Chooses(boolean bubble_state, boolean insertion_state, boolean selection_state, boolean rmerge_state, boolean imerge_state,
										  boolean radix_state, boolean quick_state, boolean shell_state, boolean reset_state) {
			this.bubble.setEnabled(bubble_state);
			this.insertion.setEnabled(insertion_state);
			this.selection.setEnabled(selection_state);
			this.rmerge.setEnabled(rmerge_state);
			this.imerge.setEnabled(imerge_state);
			this.radix.setEnabled(radix_state);
			this.quick.setEnabled(quick_state);
			this.shell.setEnabled(quick_state);
			this.reset.setEnabled(reset_state);
		}
	}

	//The main method
	public static void main(String[] args) {
		//initialize the class
		SortGUI sort_GUI = new SortGUI();

	}

}


