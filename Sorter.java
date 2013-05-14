class Sorter{
	
	Block[] blocks;
	//String[] sorted;

	Sorter(Block[] blocks){
		this.blocks = blocks;
		sortBlocks();
	}

	private void sortBlocks(){
		for (Block b: blocks) b.start();
	}

	
	/*public String[] getSorted(){
		return sorted;
	}*/

	
}