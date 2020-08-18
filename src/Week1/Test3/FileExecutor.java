package Week1.Test3;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class FileExecutor {
	final static String inputFolderPath = "/home/minhtq/Public/Tests/Input";
	public static HashMap<String, Integer> mainMap;

	public static void sortMap(HashMap<String, Integer> map) {
		HashMap<String, Integer> result = new HashMap<>();
		result = map.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println(result);
		top10Words(result);
		bottom10Words(result);
	}

	public static void startExecute() {
		File dir = new File(inputFolderPath);
		ExecutorService executor = Executors.newFixedThreadPool(5);
		int index = 1;

		if (dir.isDirectory()) {
			File[] items = dir.listFiles();
			for (File item : items) {
				executor.execute(new FileHandler(item, index));
				index++;
			}
			executor.shutdown();

			while (!executor.isTerminated()) {
			}

			System.out.println(mainMap);
			sortMap(mainMap);
		}
	}

	public static void addToMainMap(HashMap<String, Integer> map) {
		map.forEach((k, v) -> mainMap.merge(k, v, (v1, v2) -> v1 + v2));
	}

	public static void top10Words(HashMap<String, Integer> map) {
		ArrayList<String> keyList = new ArrayList<String>(map.keySet());
		int i = 0;

		System.out.println("Top 10 Words:");
		while (i < keyList.size() && i < 10) {
			String key = keyList.get(i);
			int value = map.get(key);
			System.out.println(key + "=" + value);
			i++;
		}
	}

	public static void bottom10Words(HashMap<String, Integer> map) {
		ArrayList<String> keyList = new ArrayList<String>(map.keySet());
		int i = keyList.size()-1;
		int j = 0;

		System.out.println("Bottom 10 Words:");
		while (j < 10 && i >= 0) {
			String key = keyList.get(i);
			int value = map.get(key);
			System.out.println(key + "=" + value);
			i--;
			j++;
		}
	}

	public static void main(String[] args) {
		mainMap = new HashMap<>();
		startExecute();

	}

}
