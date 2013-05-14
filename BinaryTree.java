class BinaryTree{
	private int size = 0;
	private Node root;
	private static int counter = 0;

	class Node{
		private String value;
		private Node left;
		private Node right;

		Node(String value){
			this.value = value;
		}

		public String getValue(){
			return value;
		}

		/**
		*Inserts a new node to the tree. If the nodes value is lexicographically 
		*smaller than this.value it is sent to the left if it is the same or larger
		*it will be sent to the right.  
		*/
		public void insert(Node node){
			if (node.getValue().compareToIgnoreCase(getValue()) < 0) {
				if (left == null) left = node;
				else left.insert(node);
			}
			else {
				if (right == null) right = node;
				else right.insert(node);
			}
		}

		// for testing debugging
		/*
		public void print(){
			if (left != null) left.print();
			System.out.println(value);
			if  (right != null) right.print();
		}
		*/

		protected int toArray(String[] sorted, int index){
			if (left != null) index = left.toArray(sorted, index);
			sorted[index++] = value;
			if  (right != null) index = right.toArray(sorted, index);
			return index;
		}
	}

	/**
	*Method returns an array of Strings that is sorted
	*lexicographically, ignoring case differences.
	*/
	public String[] toArray(int size){
		String[] sorted = new String[size];
		root.toArray(sorted, 0);
		return sorted;
	}


	public void insert(String value){
		if (root == null) root = new Node(value);
		else root.insert(new Node(value));
		size++;
	}


	//for testing and debugging
	/*
	public void print(){
		root.print();
	}
	*/



}