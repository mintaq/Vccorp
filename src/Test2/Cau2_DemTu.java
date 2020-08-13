package Test2;
import java.io.*;
import java.util.*;

public class Cau2_DemTu {
	final static String inputFilePath = "/home/minhtq/Public/Tests/Input/text1.txt";
	final static String outputFilePath = "/home/minhtq/Public/Tests/Output/output1.txt";
	
	public static void countWords(File file, Map<String, Integer> words)  {		
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
			String word = sc.next();
			Integer count = words.get(word);
			if (count != null) count++;
			else count = 1;
			words.put(word, count);
			}
			sc.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}		
	}	
	
	public static void printOutputFile(File outputFile, Map<String, Integer> words) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(outputFile));
			for (Map.Entry<String, Integer> entry: words.entrySet()) {
				bw.write(entry.getKey() + ": " + entry.getValue());
				bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();			
		}
	}

	public static void main(String[] args){
		File inputFile = new File(inputFilePath);
		File outputFile = new File(outputFilePath);
		Map<String, Integer> words = new HashMap<String, Integer>();
		
		
		countWords(inputFile, words);
		printOutputFile(outputFile, words);		
	}
}
