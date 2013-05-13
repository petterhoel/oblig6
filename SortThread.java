/*
class SortThread extends Thread { 
	String [] words; 
	int numOfChildren; 
	private int smallestArray; 
	SortThread parent; // parent er null i roten 
 	int id = 0;


 	// child 
 	SortThread(String[] words, SortThread parent, int id, int smallestArray){ 
 		this.smallestArray = smallestArray;
 		this.words = words; 
 		this.parent = parent; 
 		this.id = id+1; 
 		numOfChildren = 0;
 	}


 	// root 
 	SortThread(String[] words, int threadCnt){ 
 		smallestArray = (words.length/threadCnt)+1;
 		this.words = words;  
 		parent = null; 
 		id = 1; 
 		numOfChildren = 0; 
 	} 


	public void run(){ 
		sorter(words); 
		waitForAll(); 
		if (parent != null) { 
 			// signaler at denne tråden er ferdig med jobben: 
			parent.done(); 
 		} 
		else {System.out.println("Done");} 
 	} // end of run 


 	void sorter(String[] words) { 
		if (words.length > smallestArray) { 
			numOfChildren += 2;
			System.out.println("Thread started"); 
			String[][] splitted = new ArraySplitter(words).getSplit();
			new SortThread(splitted[0], this, id, smallestArray).start(); 
			new SortThread(splitted[1], this, id+1, smallestArray).start(); 
			//sorter(words); // rekursivt kall
		} 
		else sort(words);
 	} 
 

 	synchronized void waitForAll() { 
 		while (numOfChildren != 0) { // antall barn ikke ferdig 
 			try { 
				wait(); 
 			} 
 			catch (InterruptedException e) { 
 				System.out.println(" Unexpected error "); 
 				System.exit(0); 
 			} 
 		} 
 	} 


 	synchronized void done(){ 
 		numOfChildren--;

 		notify(); 
 	} 


 	void sort(String[] words){ 
 			this.words = new Sorter(words).sort();
 	} 
 	

	
} */