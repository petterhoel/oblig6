/**
*A sorter holds an array of Blocks and sorts each block when instansiated. 
*/
class Sorter{
	
	private Block[] blocks;

	Sorter(Block[] blocks){
		this.blocks = blocks;
		sortBlocks();
	}

	private void sortBlocks(){
		for (Block b: blocks) b.start();
	}
}