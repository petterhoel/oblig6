class ArrayMerger{


	public String[] mergeArrays(String[] first, String[] second){
		if (first == null) return second;
		if (second == null) return first;
		int size = first.length + second.length;
		String [] sorted = new String[size];
		int i = 0;
		int j = 0;
		int k = 0;

		while (j < first.length && k < second.length) {
			if (first[j].compareToIgnoreCase(second[k]) < 0)
				sorted[i] = first[j++];
			else 
				sorted[i] = second[k++];
			i++;
		}
		while (j < first.length) {
			sorted[i++] = first[j++];
		}
		while (k < second.length) {
			sorted[i++] = second[k++];
		}
		return sorted;
	}
}