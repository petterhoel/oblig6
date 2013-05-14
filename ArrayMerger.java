/**
*An arraymerger does nothing besides merging two arrays
*/
class ArrayMerger{

	/**
	*Merges two arrays of Strings in an sorted order. 
	*The merging is CaSeInSeNsItIvE
	*This algorithm fills a string[], by always putting the smallest 
	*value first. 
	*
	*In the case of any of the parameter Sting [] pointing to null
	*the other parameter is returned. 
	*/
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