import java.io.*;
import java.util.concurrent.CountDownLatch;


class Sort{
	public static void main(String[] args) {
		if (args.length != 3) {System.out.println("Program requrires 3 arguments. Consult http://heim.ifi.uio.no/inf1010/v13/oblig/6/oblig6-2013-1-0.html for more info");System.exit(1);}
		int threadCnt = Integer.parseInt(args[0]);
		String fileToBeSorted = args[1];
		String fileSorted = args[2];
		CountDownLatch cdl = new CountDownLatch(threadCnt);
		CollectWords cw = new CollectWords(fileToBeSorted);
		ArraySplitter as = new ArraySplitter(cw.getWords(), threadCnt, cdl);
		Block[] blocks = as.getBlocks();
		//long startTime = System.currentTimeMillis();
		
		Sorter sorter = new Sorter(blocks); // setter igang sortering av blokkene
		
		try{
			cdl.await();
		}catch(Exception e){
			System.exit(1);
		}

		/*
		long endTime = System.currentTimeMillis();
		long sortTime = endTime-startTime;
		System.out.println();
		System.out.println("Sort time:  " + sortTime + " (using threads)");
		startTime = System.currentTimeMillis();
		*/
		ArrayMerger merger = new ArrayMerger();
		String[] words = new String[0];
		for (Block b: blocks) words = merger.mergeArrays(words, b.getBlock());
		/*
		endTime = System.currentTimeMillis();
		long mergeTime = endTime - startTime;
		System.out.println("Merge time: " + mergeTime + " (not using threads)");
		System.out.println("Total time: " + (sortTime + mergeTime));
		System.out.println("File: " + fileToBeSorted + " containing "+ words.length + " words using " + threadCnt+ " threads (all time measured in milliseconds)");
		System.out.println();
		*/
		writeToFile(words, fileSorted);
	}

public static void writeToFile(String[] arrayToWrite, String filename){
	File outfile = new File(filename);
	try{FileWriter writer = new FileWriter(outfile);
		for (String s: arrayToWrite) writer.write(s + System.getProperty( "line.separator" ));
		writer.close();
	} catch (Exception e){System.out.println("writer failure");System.exit(2);}
}

}