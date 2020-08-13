package Test3;

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
		ExecutorService executor = Executors.newFixedThreadPool(6);
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
		ArrayList keyList = new ArrayList(map.keySet());

		System.out.println("Top 10 Words:");
		for (int i = 0; i < 10; i++) {
			String key = (String) keyList.get(i);
			int value = map.get(key);
			System.out.println(key + "=" + value);

		}
	}

	public static void bottom10Words(HashMap<String, Integer> map) {
		ArrayList keyList = new ArrayList(map.keySet());

		System.out.println("Bottom 10 Words:");
		for (int i = keyList.size() - 1; i > keyList.size() - 11; i--) {
			String key = (String) keyList.get(i);
			int value = map.get(key);
			System.out.println(key + "=" + value);

		}
	}

	public static void main(String[] args) {
		mainMap = new HashMap<>();
		startExecute();

	}

}
