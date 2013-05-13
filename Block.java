class Block extends Thread{

	String[] words;

	Block(String[] words){
		this.words = words;
	}

	public String[] getBlock(){
		return words;
	}

	public void run(){
		sort();
	}


	public void sort(){
		BinaryTree bt = new BinaryTree();
		for (String s: words) bt.insert(s);
		this.words = bt.toArray(words.length);; 
	}

	public void print(){
		for (String s: words) System.out.println(s);
	}
}