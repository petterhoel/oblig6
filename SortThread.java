
class SortThread extends Thread { 
	Block words; 
	
 	SortThread(Block words){ 
 		this.words = words;
 	}

	public void run(){ 
		System.out.println("Thread started");
		words.sort();
		notify(); 
		/*waitForAll(); 
		if (parent != null) { 
 			// signaler at denne tråden er ferdig med jobben: 
			parent.done(); 
 		} 
		else {System.out.println("Done");} */
 	} // end of run 


 	/*void sorter(String[] words) { 
		if (words.length > smallestArray) { 
			numOfChildren += 2;
			System.out.println("Thread started"); 
			String[][] splitted = new ArraySplitter(words).getSplit();
			new SortThread(splitted[0], this, id, smallestArray).start(); 
			new SortThread(splitted[1], this, id+1, smallestArray).start(); 
			//sorter(words); // rekursivt kall
		} 
		else sort(words);
 	} */
 

 	/*synchronized void waitForAll() { 
 		while (numOfChildren != 0) { // antall barn ikke ferdig 
 			try { 
				wait(); 
 			} 
 			catch (InterruptedException e) { 
 				System.out.println(" Unexpected error "); 
 				System.exit(0); 
 			} 
 		} 
 	} */

 	/*
 	synchronized void done(){ 
 		numOfChildren--;

 		notify(); 
 	} 


 	void sort(String[] words){ 
 			this.words = new Sorter(words).sort();
 	} 
 	*/

	
} 