class Merge{
	//String [] merged;

	/*Merge(String[] merge1, String[] merge2){
		merged = merge(merge1, merge2);
	}*/

	/*public String[] merge(){
		return merged;
	}*/

	public String[] merge(String[] merge1, String[] merge2){
		int size  = merge1.length + merge2.length;
		BinaryTree bt = new BinaryTree();
		for (int i = 0; i < merge1.length; i++) bt.insert(merge1[i]);
		for (int i = 0; i < merge2.length; i++) bt.insert(merge2[i]);
		return bt.toArray(size);
	}
}