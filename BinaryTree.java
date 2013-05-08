class BinaryTree{

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
			if (node.getValue().compareTo(getValue()) > 0) {
				if (right == null) right = node;
				else right.insert(node);
			}
			else {
				if (left == null) left = node;
				else left.insert(node);
			}
		}

		public void print(){
			if (right != null) right.print();
			printValue();
			if  (left != null) left.print();
		}

		private void printValue(){
			System.out.println(value.toString());
		}


	}






}