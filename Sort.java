class Sort{
	public static void main(String[] args) {
		if (args.length != 3) {System.out.println("Program requrires 3 arguments. Consult readme.txt for more info");System.exit(1);}
		int threadCnt = Integer.parseInt(args[0]);
		String fileToBeSorted = args[1];
		String fileSorted = args[2];
		CollectWords cw = new CollectWords(fileToBeSorted);
		Sorter sorter = new Sorter(cw.getWords());
		String[] sorted = sorter.getSorted();
	}
}