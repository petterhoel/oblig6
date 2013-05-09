class Sorter{
	
	String [] unsorted;
	Sorter(String [] toSort){
		unsorted = toSort;
	}


	public String[] getSorted(){
		BinaryTree bt = new BinaryTree();
		for (String s: unsorted) bt.insert(s);
		return bt.toArray(unsorted.length);
	}

}