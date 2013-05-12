class BinaryTree{
	int size = 0;
	Node root;
	static int counter = 0;

	class Node{
		String value;
		Node left;
		Node right;

		Node(String value){
			this.value = value;
		}

		public String getValue(){
			return value;
		}

		public void insert(Node node){
			if (node.getValue().compareToIgnoreCase(getValue()) > 0) {
				if (right == null) right = node;
				else right.insert(node);
			}
			else {
				if (left == null) left = node;
				else left.insert(node);
			}
		}

		public void print(){
			if (left != null) left.print();
			System.out.println(value);
			if  (right != null) right.print();
		}

		public int toArray(String[] sorted, int index){
			if (left != null) index = left.toArray(sorted, index);
			sorted[index++] = value;
			if  (right != null) index = right.toArray(sorted, index);
			return index;
		}
	}


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

	public void print(){
		root.print();
	}




}