import java.util.concurrent.CountDownLatch;



class ArraySplitter{
	CountDownLatch cdl;
	int numOfBlocks;
	int blockSize;
	Block[] blocksOfWords;
	int blocksWithOneMore;

	ArraySplitter(String[] words, int numOfBlocks, CountDownLatch cdl){
		this.cdl = cdl;
		this.numOfBlocks = numOfBlocks;
		blockSize = words.length/numOfBlocks;
		blocksWithOneMore = words.length%numOfBlocks;
		//System.out.println("Blocks with one more: " + blocksWithOneMore);
		blocksOfWords = toBlocks(words);
	}


	public Block[] getBlocks(){
		return blocksOfWords;
	}


	private Block[] toBlocks(String[] words){
		Block[] blocks = new Block[numOfBlocks];
		for (int i = 0; i < blocksWithOneMore; i++){
			blocks[i] = new Block(getWords(words, i, true), cdl);
			//System.out.println(blocks[i].words.length);
		}
		for (int i = blocksWithOneMore; i < numOfBlocks; i++) {
			blocks[i] = new Block(getWords(words, i, false), cdl);
			//System.out.println(blocks[i].words.length);
		}
		return blocks;
	}

	private String[] getWords(String[] words, int index, boolean extraword){
		int startPosition;
		int endPosition;
		if (extraword) {
			startPosition = (index * blockSize) + index;
			endPosition = startPosition + blockSize + 1;
		} else {
			startPosition = (index * blockSize) + blocksWithOneMore;
			endPosition = startPosition + blockSize;
		}
		int size = endPosition - startPosition;
		String [] blockOfWords = new String[size];
		int counter = 0;
		for (int i = startPosition; i < endPosition; i++){
			blockOfWords[counter] = words[i];
			counter++;
		}
		return blockOfWords; 
	}
	
}