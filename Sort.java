import java.io.*;

class Sort{
	public static void main(String[] args) {
		if (args.length != 3) {System.out.println("Program requrires 3 arguments. Consult readme.txt for more info");System.exit(1);}
		int threadCnt = Integer.parseInt(args[0]);
		String fileToBeSorted = args[1];
		String fileSorted = args[2];
		CollectWords cw = new CollectWords(fileToBeSorted);
		ArraySplitter as = new ArraySplitter(cw.getWords(), threadCnt);
		Sorter sorter = new Sorter(as.getBlocks(), cw.getWords().length);
		//for (String s: sorter.getSorted()) System.out.println(s);

		//for (Block b: blocks) b.print();
		//System.out.println();
		
		//writeToFile(thread.words, fileSorted);


	}

public static void writeToFile(String[] arrayToWrite, String filename){
	File outfile = new File(filename);
	try{FileWriter writer = new FileWriter(outfile);
		for (String s: arrayToWrite) writer.write(s + System.getProperty( "line.separator" ));
		writer.close();
	} catch (Exception e){System.out.println("writer failure");System.exit(2);}
}

}