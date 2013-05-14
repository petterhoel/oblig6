import java.io.*;
import java.util.concurrent.CountDownLatch;


class Sort{
	public static void main(String[] args) {
		if (args.length != 3) {System.out.println("Program requrires 3 arguments. Consult readme.txt for more info");System.exit(1);}
		int threadCnt = Integer.parseInt(args[0]);
		String fileToBeSorted = args[1];
		String fileSorted = args[2];
		CollectWords cw = new CollectWords(fileToBeSorted);
		ArraySplitter as = new ArraySplitter(cw.getWords(), threadCnt);
		CountDownLatch cdl = new CountDownLatch(threadCnt);
		Block[] blocks = as.getBlocks();
		long startTime = System.currentTimeMillis();
		Sorter sorter = new Sorter(blocks); // setter igang sortering av blokkene
		long endTime = System.currentTimeMillis();
		System.out.println("Sort time: " + (endTime-startTime) + "("+ threadCnt+" threads)");
		ArrayMerger merger = new ArrayMerger();
		String[] words = new String[0];
		// trenger å merge i tråder
		for (Block b: blocks) words = merger.mergeArrays(words, b.getBlock());
		/*try{
			cdl.await(); // <-----Main
		}catch(Exception e){
			System.exit(1);
		}*/
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