class Merge{
	String [] merged;

	Merge(String[][] toMerge){
		merged = merge(toMerge);
	}

	public String[] merge(){
		return merged;
	}

	private String[] merge(String[][] toMerge){
		int size  = toMerge[0].length + toMerge[1].length;
		BinaryTree bt = new BinaryTree();
		for (int i = 0; i < toMerge[0].length; i++) bt.insert(toMerge[0][i]);
		for (int i = 0; i < toMerge[1].length; i++) bt.insert(toMerge[1][i]);
		return bt.toArray(size);
	}
}