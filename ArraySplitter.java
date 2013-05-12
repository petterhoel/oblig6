import java.util.Arrays;

class ArraySplitter{
	String[][] values;
	int length;

	ArraySplitter(String[] words){
		length = words.length/2;
		values = new String[][] {Arrays.copyOfRange(words, 0, length), 
								 Arrays.copyOfRange(words, length, words.length)};
	}

	
	public String[][] getSplit(){
		return values;
	}


	//test
	/*public void print(){
		System.out.println(values.length);
		System.out.println("Array one: " + values[0].length);
		for (int i = 0; i < values[0].length; i++) System.out.println(values[0][i]);
		System.out.println("Array two: " + values[1].length);
		for (int i = 0; i < values[1].length; i++) System.out.println(values[1][i]);
	}*/
	
}