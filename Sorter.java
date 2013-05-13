class Sorter extends Thread{
	
	String [] unsorted;
	Sorter(String [] toSort){
		unsorted = toSort;
	}

	
	public String[] sort(){
		BinaryTree bt = new BinaryTree();
		for (String s: unsorted) bt.insert(s);
		return bt.toArray(unsorted.length);
	}

	

}