import java.io.*;

class Sort{
	public static void main(String[] args) {
		if (args.length != 3) {System.out.println("Program requrires 3 arguments. Consult readme.txt for more info");System.exit(1);}
		int threadCnt = Integer.parseInt(args[0]);
		String fileToBeSorted = args[1];
		String fileSorted = args[2];
		CollectWords cw = new CollectWords(fileToBeSorted);
		ArraySplitter as = new ArraySplitter(cw.getWords());
		as.print();
		Merge me = new Merge(as.getSplit());
		System.out.println("i rekkefølge: ");
		for (String s: me.merge())System.out.println(s);
		/*Sorter sorter = new Sorter(cw.getWords());
		String[] sorted = sorter.sort();
		writeToFile(sorted, fileSorted);*/


	}

public static void writeToFile(String[] arrayToWrite, String filename){
	File outfile = new File(filename);
	try{FileWriter writer = new FileWriter(outfile);
		for (String s: arrayToWrite) writer.write(s + System.getProperty( "line.separator" ));
		writer.close();
	} catch (Exception e){System.out.println("writer failure");System.exit(2);}
}

}