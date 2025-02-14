/**
 *
 * @author Ouda
 */

//importing the libraries that will be needed in this program

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Arrays;

//The class that has all the sorts in it
public class SortShow extends JPanel {


		// An array to hold the lines_lengths to be sorted
		public int[] lines_lengths;
		//The amount of lines needed
		public final int total_number_of_lines = 256;
		 // An array to holds the scrambled lines_lengths
		public int[] scramble_lines;
		//A temp Array that is used later for sorts
		public int[] tempArray;

		//the default constructor for the SortShow class
		public SortShow() {
			//assigning the size for the lines_lengths below
			lines_lengths = new int[total_number_of_lines];
			for (int i = 0; i < total_number_of_lines; i++)
				lines_lengths[i] = i + 5;
		}


		//A method that scrambles the lines
		public void scramble_the_lines(){
			//A random generator
			Random num = new Random();
			//Randomly switching the lines
			for(int i = 0; i < total_number_of_lines; i++){
				//getting a random number using the nextInt method (a number between 0 to i + 1)
				int j = num.nextInt(i + 1);
				//swapping The element at i and j
				swap(i, j);
			}
			//assigning the size for the scramble_lines below
			scramble_lines = new int[total_number_of_lines];
			//copying the now scrambled lines_lengths array into the scramble_lines array
			//to store for reuse for other sort methods
			//so that all sort methods will use the same scrambled lines for fair comparison
			for (int i = 0; i < total_number_of_lines; i++)
			{
				scramble_lines[i] = lines_lengths[i];
			}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}

		//Swapping method that swaps two elements in the lines_lengths array
		public void swap(int i, int j){
			//storing the i element in lines_lengths in temp
			int temp = lines_lengths[i];
			//giving i element in lines_lengths the value of j element in lines_lengths
			lines_lengths[i] = lines_lengths[j];
			//giving j element in lines_lengths the value of temp
			lines_lengths[j] = temp;
		}

	//Bubble Sort/////////////////////////////////////////////////////////////////////////////////
		// implemented by Evan Trejo
		public void BubbleSort(){
			//get time when starting
			Calendar start = Calendar.getInstance();

			//Outer loop for iterating all elements
			for(int i=0; i < total_number_of_lines - 1; i++){
				//After outer loop, last element i is sorted so reduce loop range
				for(int j=0; j < total_number_of_lines - (i+1); j++) {

					//if current element is greater than next element
					if (lines_lengths[j] > lines_lengths[j + 1]) {
						//swap current element with the next
						swap(j, j + 1);
						//redraw lines
						paintComponent(this.getGraphics());
						//delay
						delay(10);
					}
				}
			}

			//get time when ending
			Calendar end = Calendar.getInstance();

			//calc time taken for bubble sort
			SortGUI.bubbleTime = end.getTime().getTime() - start.getTime().getTime();
		}
		//Selection Sort//////////////////////////////////////////////////////////////////////////////
		// implemented by Joseph Hargus
		public void SelectionSort() {
			//getting the date and time when the selection sort starts
			Calendar start = Calendar.getInstance();
			//Using the selection sort to lines_lengths sort the array

			for(int i = 0; i < total_number_of_lines; i++){
				// find smallest element
				int smallest = getIndexOfSmallest(i, total_number_of_lines - 1);
				// swap the smallest element with first unsorted element
				swap(i, smallest);
				// update GUI after each swap
				paintComponent(this.getGraphics());
				// delay
				delay(50);
			}

			//getting the date and time when the selection sort ends
			Calendar end = Calendar.getInstance();
			//getting the time it took for the selection sort to execute
			//subtracting the end time with the start time
	        SortGUI.selectionTime = end.getTime().getTime() - start.getTime().getTime();
		}

		//this method gets the smallest element in the array of lines_lengths
		// implemented by Joseph Hargus
		public int getIndexOfSmallest(int first, int last){
			int min_index = first;

			for(int i = first; i <= last; i++){
				if (lines_lengths[i] < lines_lengths[min_index]){
					min_index = i;
				}
			}

			return min_index;
		}
		//Insertion Sort/////////////////////////////////////////////////////////////////////////////////
		// implemented by Evan Trejo
		public void InsertionSort(){
			//get time when starting
			Calendar start = Calendar.getInstance();

			//loop through elements starting from index 1 (2nd element)
			for(int i = 1; i < total_number_of_lines; i++){
				int currentValue = lines_lengths[i]; //value put into sorted portion
				int j = i-1; //last index of sorted portion

				//shift elements of sorted portion to the right to make room for currentValue
				while(j >= 0 && lines_lengths[j] > currentValue){
					lines_lengths[j+1] = lines_lengths[j];
					j--;
				}

				//insert currentValue into its correct position
				lines_lengths[j+1] = currentValue;

				//redraw lines
				paintComponent(this.getGraphics());

				//delay
				delay(10);

			}

			//get time when ending
			Calendar end = Calendar.getInstance();

			//calc time taken for insertion sort
			SortGUI.insertionTime = end.getTime().getTime() - start.getTime().getTime();
		}

	//Recursive Merge Sort/////////////////////////////////////////////////////////////////////////////////
	//implemented by Kaitlyn Self
	//recursive merge sort method
	public void R_MergeSort(){
		//getting the date and time when the recursive merge sort starts
		Calendar start = Calendar.getInstance();
		//assigning the size for the tempArray below
		tempArray = new int[total_number_of_lines];

		//initial MergeSort increments
		R_MergeSort(0, total_number_of_lines-1);

		Calendar end = Calendar.getInstance();
		//getting the time it took for the iterative merge sort to execute
		//subtracting the end time with the start time
		SortGUI.rmergeTime = end.getTime().getTime() - start.getTime().getTime();

	}

	//recursive merge sort method
	public void R_MergeSort(int first, int last){
		//assigning midpoint
		int mid = (first + last) / 2;

		if(first < last) {
			//dividing until length is 1
			R_MergeSort(first, mid);
			//System.out.println("First end reached");
			R_MergeSort(mid + 1, last);
			R_Merge(first,mid,last);

			paintComponent(this.getGraphics());
			//Causing a delay for 10ms
			delay(10);
		}

	}

	//recursive merge sort method
	public void R_Merge(int first, int mid, int last){
		//divvying up the list to be merged
		int start1 = first;
		int end1 = mid;
		int start2 = mid + 1;
		int end2 = last;

		//merging the two subarrays
		int index = start1;
		for (; start1 <= end1 && start2 <= end2; index++) {
			if (lines_lengths[start1] <= lines_lengths[start2]) {
				tempArray[index] = lines_lengths[start1];
				start1++;
				//System.out.println("start1 added");
			}
			else if (lines_lengths[start1] > lines_lengths[start2]) {
				tempArray[index] = lines_lengths[start2];
				start2++;
			}
		}

		//emptying array 1
		for (; start1 <= end1; index++) {
			tempArray[index] = lines_lengths[start1];
			start1++;
		}

		//emptying array 2
		for (; start2 <= end2; index++) {
			tempArray[index] = lines_lengths[start2];
			start2++;
		}

		for (index = first; index <= last; index++) {
			lines_lengths[index] = tempArray[index];
		}

	}


	//////////////////////////////////////////////////////////////////////////////////////////

		//iterative merge sort method
		public void I_MergeSort()
		{
		//getting the date and time when the iterative merge sort starts
		Calendar start = Calendar.getInstance();
		//assigning the size for the tempArray below
		tempArray = new int[total_number_of_lines];
		//saving the value of total_number_of_lines
		int beginLeftovers = total_number_of_lines;


		for (int segmentLength = 1; segmentLength <= total_number_of_lines/2; segmentLength = 2*segmentLength)
		{
			beginLeftovers = I_MergeSegmentPairs(total_number_of_lines, segmentLength);
			int endSegment = beginLeftovers + segmentLength - 1;
			if (endSegment < total_number_of_lines - 1)
			{
			I_Merge(beginLeftovers, endSegment, total_number_of_lines - 1);
			}
		}

		// merge the sorted leftovers with the rest of the sorted array
		if (beginLeftovers < total_number_of_lines) {
			I_Merge(0, beginLeftovers-1, total_number_of_lines - 1);
		}
		//getting the date and time when the iterative merge sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the iterative merge sort to execute
		//subtracting the end time with the start time
	    SortGUI.imergeTime = end.getTime().getTime() - start.getTime().getTime();
	}

	// Merges segments pairs (certain length) within an array
	public int I_MergeSegmentPairs(int l, int segmentLength)
	{
		//The length of the two merged segments

		//You suppose  to complete this part (Given).
		int mergedPairLength = 2 * segmentLength;
		int numberOfPairs = l / mergedPairLength;

		int beginSegment1 = 0;
		for (int count = 1; count <= numberOfPairs; count++)
		{
			int endSegment1 = beginSegment1 + segmentLength - 1;

			int beginSegment2 = endSegment1 + 1;
			int endSegment2 = beginSegment2 + segmentLength - 1;
			I_Merge(beginSegment1, endSegment1, endSegment2);

			beginSegment1 = endSegment2 + 1;
			//redrawing the lines_lengths
			paintComponent(this.getGraphics());
			//Causing a delay for 10ms
			delay(10);
		}
		// Returns index of last merged pair
		return beginSegment1;
		//return 1;//modify this line
	}

	public void I_Merge(int first, int mid, int last)
	{
		//You suppose  to complete this part (Given).
		// Two adjacent sub-arrays
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		// While both sub-arrays are not empty, copy the
		// smaller item into the temporary array
		int index = beginHalf1; // Next available location in tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++)
		{
			// Invariant: tempArray[beginHalf1..index-1] is in order
			if (lines_lengths[beginHalf1] < lines_lengths[beginHalf2])
			{
				tempArray[index] = lines_lengths[beginHalf1];
				beginHalf1++;
			}
			else
			{
				tempArray[index] = lines_lengths[beginHalf2];
				beginHalf2++;
			}
		}
		//redrawing the lines_lengths
		//paintComponent(this.getGraphics());

		// Finish off the nonempty sub-array

		// Finish off the first sub-array, if necessary
		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
			// Invariant: tempArray[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf1];

		// Finish off the second sub-array, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
			// Invariant: tempa[beginHalf1..index-1] is in order
			tempArray[index] = lines_lengths[beginHalf2];

		// Copy the result back into the original array
		for (index = first; index <= last; index++)
			lines_lengths[index] = tempArray[index];
	}

	//Quick Sort//////////////////////////////////////////////////////////////////////////
	// implemented by Joseph Hargus
	public void QuickSort(){
		//getting the date and time when the quick sort starts
		Calendar start = Calendar.getInstance();

		InPlaceQuickSort(0, total_number_of_lines - 1);

		//getting the date and time when the quick sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the quick sort to execute
		//subtracting the end time with the start time
		SortGUI.quickTime = end.getTime().getTime() - start.getTime().getTime();
	}

	// in place quick-sort
	private void InPlaceQuickSort(int left, int right){
		if (left >= right) return;

		int p = lines_lengths[right]; //pivot
		int l = left;
		int r = right - 1;

		while (l <= r) {
			while (l <= r && lines_lengths[l] <= p) l++;
			while(l <= r && lines_lengths[r] > p) r--;
			if (l < r) {
				swap(l, r);
				paintComponent(this.getGraphics());
				delay(50);
			}
		}
		swap(l, right);
		paintComponent(this.getGraphics());
		delay(50);

		InPlaceQuickSort(left, l-1);
		InPlaceQuickSort(l+1, right);

	}

	//Radix Sort//////////////////////////////////////////////////////////////////////////
	// implemented by Joseph Hargus
	public void RadixSort(){
		//getting the date and time when the radix sort starts
		Calendar start = Calendar.getInstance();
		//Using the radix sort to lines_lengths sort the array

		// create and initialize 10 buckets
		ArrayList<Integer>[] buckets = new ArrayList[10];
		for(int i = 0; i < 10; i++){
			buckets[i] = new ArrayList<>();
		}

		// iterate through 3 digits
		for(int i = 0; i < 3; i++)
		{
			// add elements to the correct bucket
			for(int j = 0; j < lines_lengths.length; j++){
				int digit = (lines_lengths[j] / (int)Math.pow(10.0, (double)i)) % 10;
				buckets[digit].add(lines_lengths[j]);
			}

			// place elements back in array
			int bucket = 0;
			for(int j = 0; j < lines_lengths.length; j++)
			{
				if (buckets[bucket].isEmpty()){
					bucket++;
				}
				lines_lengths[j] = buckets[bucket].remove(0);

				// update GUI
				paintComponent(this.getGraphics());
				// delay
				delay(50);
			}
		}

		//getting the date and time when the radix sort ends
		Calendar end = Calendar.getInstance();
		//getting the time it took for the radix sort to execute
		//subtracting the end time with the start time
		SortGUI.radixTime = end.getTime().getTime() - start.getTime().getTime();
	}

	//Shell Sort//////////////////////////////////////////////////////////////////////////
	//implemented by Kaitlyn Self
	public void ShellSort(){
		//setting time start on activation
		Calendar start = Calendar.getInstance();

		//determining initial space
		int space = total_number_of_lines / 4;

		//for loop decreasing the space by 1 each round
		for (; space >=1 ; space--) {
			//going through the given interval
			for (int i = space; i < total_number_of_lines; i=i+space){
				int currentVal = lines_lengths[i];
				int j = i - space;
				//moving elements as needed
				while (j >= 0 && lines_lengths[j] > currentVal) {
					lines_lengths[j + space] = lines_lengths[j];
					j=j-space;
				}

				lines_lengths[j + space] = currentVal;
				//redrawing the lines
				paintComponent(this.getGraphics());
				//time delay between intervals
				delay(10);
			}
		}

		//checking datetime when shellSort ends
		Calendar end = Calendar.getInstance();

		//subtracting end - start to find shellTime
		SortGUI.shellTime = end.getTime().getTime() - start.getTime().getTime();

	}

	//Helper Functions////////////////////////////////////////////////////////////////////

		//This method resets the window to the scrambled lines display
		public void reset(){
			if(scramble_lines != null)
			{
				//copying the old scrambled lines into lines_lengths
				for (int i = 0; i < total_number_of_lines; i++)
				{
					lines_lengths[i] = scramble_lines[i] ;
				}
			//Drawing the now scrambled lines_lengths
			paintComponent(this.getGraphics());
		}
			}


		//This method colours the lines and prints the lines
		public void paintComponent(Graphics g){
 			super.paintComponent(g);
			//A loop to assign a colour to each line
			for(int i = 0; i < total_number_of_lines; i++){
				//using eight colours for the lines
				if(i % 8 == 0){
					g.setColor(Color.green);
				} else if(i % 8 == 1){
					g.setColor(Color.blue);
				} else if(i % 8 == 2){
					g.setColor(Color.yellow);
				} else if(i%8 == 3){
					g.setColor(Color.red);
				} else if(i%8 == 4){
					g.setColor(Color.black);
				} else if(i%8 == 5){
					g.setColor(Color.orange);
				} else if(i%8 == 6){
					g.setColor(Color.magenta);
				} else
					g.setColor(Color.gray);

				//Drawing the lines using the x and y-components
				g.drawLine(4*i + 25, 300, 4*i + 25, 300 - lines_lengths[i]);
			}

		}

		//A delay method that pauses the execution for the milliseconds time given as a parameter
		public void delay(int time){
			try{
	        	Thread.sleep(time);
	        }catch(InterruptedException ie){
	        	Thread.currentThread().interrupt();
	        }
		}

}