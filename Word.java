// to word or to string?


class Word implements Comparable<String>{

	String value;

	Word(String value){
		this.value = value;
	}

	public int compareTo(String anotherString){
		return value.compareTo(anotherString);
	}
	
}