import java.util.concurrent.CountDownLatch;

/**
*Class splits an array of Strings into blocks of words, held by an array of Blocks
*A CountDownLatch is passed to each block. 
*/
class ArraySplitter{
	CountDownLatch cdl;
	private int numOfBlocks;
	private int blockSize; // poor name as some blocks have an extra word, sorry!
	private Block[] blocksOfWords;
	private int blocksWithOneMore;

	ArraySplitter(String[] words, int numOfBlocks, CountDownLatch cdl){
		this.cdl = cdl;
		this.numOfBlocks = numOfBlocks;
		blockSize = words.length/numOfBlocks;
		blocksWithOneMore = words.length%numOfBlocks;
		blocksOfWords = toBlocks(words);
	}


	public Block[] getBlocks(){
		return blocksOfWords;
	}


	/*
	*Makes the blocks of words and fills the array of blocks
	*Depending on the number of blocks and number of words (strings)
	*some blocks will have an extra word. They are made first. 
	*/
	private Block[] toBlocks(String[] words){
		Block[] blocks = new Block[numOfBlocks];
		for (int i = 0; i < blocksWithOneMore; i++){
			blocks[i] = new Block(getWords(words, i, true), cdl);
		}
		for (int i = blocksWithOneMore; i < numOfBlocks; i++) {
			blocks[i] = new Block(getWords(words, i, false), cdl);
		}
		return blocks;
	}


	/**
	*Finds the appropriate words in param words and returns an array of Stings
	*containing only the approriate words. 
	*/
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