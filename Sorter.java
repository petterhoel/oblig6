class Sorter extends Thread{
	
	Monitor monitor;
	String [] unsorted;
	String [] sorted;
	Sorter(Monitor monitor, String [] toSort){
		this.monitor = monitor;
		unsorted = toSort;
	}

	public void run(){
		try{sort();}
		catch (Exception e){System.exit(3);}
	}

	public String[] sort(){
		BinaryTree bt = new BinaryTree();
		for (String s: unsorted) bt.insert(s);
		return bt.toArray(unsorted.length);
	}

	

}