class Sorter{
	
	Block[] blocks;

	Sorter(Block[] blocks){
		this.blocks = blocks;
		sortBlocks();
	}

	private void sortBlocks(){
		for (Block b: blocks) b.start();
	}
}