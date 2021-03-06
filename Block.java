import java.util.concurrent.CountDownLatch;

/**
*A block holds a block of words in an array of Sting
*
*A block is a thread and can sort itself by calling its start() method
*/
class Block extends Thread{

	private String[] words;
	private int size;
	private CountDownLatch cdl;

	Block(String[] words, CountDownLatch cdl){
		size = words.length;
		this.cdl = cdl;
		this.words = words;
	}


	public String[] getBlock(){
		return words;
	}

	public void run(){
		sort();
		cdl.countDown();
	}

	/**
	*Uses a binary tree to sort the contents of words
	*/
	protected void sort(){
		BinaryTree bt = new BinaryTree();
		for (String s: words) bt.insert(s);
		this.words = bt.toArray(words.length);
	}

	/**
	*Returns the number of strings in block as an int
	*/
	public int size(){
		return size;
	}

	// method for testing and debugging purposes below
	/*
	public void print(){
		for (String s: words) System.out.println(s);
	}
	*/
}