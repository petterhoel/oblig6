class Sorter{
	
	Block[] blocks;
	String[] sorted;
	boolean firstMerge;

	Sorter(Block[] blocks, int size){
		this.blocks = blocks;
		firstMerge = true;
		sorted = new String[size];
		sortBlocks();
		System.out.println("MERGING");
		merge();
		System.out.println("DONE MERGING");
	}

	private void sortBlocks(){
		for (Block b: blocks) b.start();
	}

	private void merge(){
		for (Block b: blocks) sorted = merge(sorted, b.getBlock());
	}
	
	public String[] getSorted(){
		return sorted;
	}

	private String[] merge(String[] merge1, String[] merge2){
		int size  = merge1.length + merge2.length;
		BinaryTree bt = new BinaryTree();
		if (!firstMerge) for (int i = 0; i < merge1.length; i++) bt.insert(merge1[i]);
		for (int i = 0; i < merge2.length; i++) bt.insert(merge2[i]);
		firstMerge = false;
		return bt.toArray(size);
	}

}