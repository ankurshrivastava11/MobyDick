package org.occurence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class FindOccurenceWords {
	
	/**
	 * takes name of the file as string in the argument.
	 * 
	 * @param str
	 * @return weather the file was found by the scanner class or not.
	 */
	public String fileNotFound(String str) {
		// TODO Auto-generated method stub
		String message = "";
		Scanner sc = null;
		try {
			sc = new Scanner(new File(str));
		} catch (FileNotFoundException s) {

			System.out.println("File Not found Exception.");
			message = "File Not found";
			return message;
		}
		return "File found";
	}

	/**
	 * @return the size of the list containing occurrences of words.
	 * @throws FileNotFoundException
	 */
	public int sizeOfMap() throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<Entry<String, Integer>> frequentWordsList = findFrequentWords();
		return frequentWordsList.size();

	}

	/**
	 * @return the list containing all of the stop words.
	 * @throws FileNotFoundException
	 */
	public ArrayList<String> setStopWords() throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<String> stopWordsList = new ArrayList<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File("stop-words.txt"));
		} catch (FileNotFoundException s) {
			System.out.println("File Not found Exception.");
			return stopWordsList;
		}
		StringBuilder sb = new StringBuilder();
		while (sc.hasNextLine()) {
			sb.append(sc.next() + " ");
		}
		int lastindex = sb.lastIndexOf("#");
		int start = sb.indexOf("a", lastindex);
		int end = sb.lastIndexOf("z");
		String str = sb.toString().substring(start, end);
		String[] stopwords = str.trim().split(" ");
		for (int i = 0; i < stopwords.length; i++) {
			if (stopwords[i].length() != 1)
				stopWordsList.add(stopwords[i]);
		}
		return stopWordsList;

	}

	/**
	 * @return the list containing 100 most frequent words with the count of
	 *         their occurrences.
	 * @throws FileNotFoundException
	 */
	public ArrayList<Entry<String, Integer>> findFrequentWords() throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<String> stopwords = setStopWords();
		HashMap<String, Integer> frequentWordsMap = new HashMap<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File("mobydick.txt"));
		} catch (FileNotFoundException s) {
			System.out.println("File Not found Exception.");
		}
		StringBuilder sb = new StringBuilder();
		while (sc.hasNext()) {
			String str = sc.next().replaceAll("[^\\w\\s]", "");
			sb.append(str + " ");
		}
		String[] wordList = sb.toString().split(" ");
		for (int i = 0; i < wordList.length; i++) {
			if (!stopwords.contains(wordList[i])) {
				if (frequentWordsMap.containsKey(wordList[i])) {
					int value = frequentWordsMap.get(wordList[i]);
					frequentWordsMap.put(wordList[i], value + 1);
				} else {
					frequentWordsMap.put(wordList[i], 1);
				}
			}
		}
		ArrayList<Entry<String, Integer>> list = entriesSortedByValues(frequentWordsMap);
		ArrayList<Entry<String, Integer>> frquentWordsList = new ArrayList<Entry<String, Integer>>();

		for (int i = 0; i < 100; i++) {
			// System.out.println(list.get(i));
			frquentWordsList.add(list.get(i));
		}
		return frquentWordsList;
	}

	/**
	 * takes a Hashmap in the argument
	 * 
	 * @param map
	 * @return the list of words with the occurrences sorted by the value in
	 *         HashMap.
	 */
	static <K, V extends Comparable<? super V>> ArrayList<Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
		ArrayList<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());
		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});

		return sortedEntries;
	}

	public ArrayList<String> diplayFrequentWords() throws FileNotFoundException {
		ArrayList<Entry<String, Integer>> frequentWordsList = new ArrayList<>();
		frequentWordsList = findFrequentWords();
		ArrayList<String> topFrequwntWordsList = new ArrayList<>();
		int count = 1;
		System.out.println("\n" + "List of 100 most frequent words with the count of their occurrence:" + "\n");
		for (Object o : frequentWordsList) {
			String str = o.toString();
			int index = str.indexOf("=");
			String res = count++ + ". " + "'" + str.substring(0, index) + "' word occurred "
					+ str.substring(index + 1, str.length()) + " times";
			topFrequwntWordsList.add(res);
			System.out.println(res);

		}
		return topFrequwntWordsList;

	}

}
