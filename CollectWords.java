import java.util.*;
import java.io.*;

class CollectWords{
	int counter = 0; //default start value
	File file;
	Scanner sc;
	String word;
	String[] words;


	public CollectWords(String fileWithWords){
		file = new File(fileWithWords);
		try{
			sc = new Scanner(file);
			int numberFromFile = sc.nextInt();
			words = new String[numberFromFile];
			sc.nextLine();
			while(sc.hasNext()){
				if (counter >= words.length) {System.out.println("too many words");};
				word = sc.nextLine().trim();
				if (!word.equals("")) words[counter++] = word;	
				System.out.println(counter + "\t " +word);
			}
			
		} catch (Exception e){System.exit(1);System.out.println("ERROR: something went wrong reading file");}

	}

	public String[] getWords(){
		return words;
	}


}