package Week1.Test3;

import java.io.*;
import java.util.*;

public class FileHandler implements Runnable {
	File file;
	int index;

	public FileHandler(File file, int index) {
		this.file = file;
		this.index = index;
	}

	public static void countWords(File file) {
		HashMap<String, Integer> words = new HashMap<String, Integer>();
		Scanner sc = null;
		try {
			 sc = new Scanner(file);
			while (sc.hasNext()) {
				String word = sc.next();
				word = word.replace(",", "").replace(".", "");
				Integer count = words.get(word);
				if (count != null)
					count++;
				else
					count = 1;
				words.put(word, count);
			}
			FileExecutor.addToMainMap(words);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " Starting process " + index);
			countWords(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
