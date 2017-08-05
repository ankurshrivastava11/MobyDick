package org.occurence;

import java.util.*;
import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class findOccurence {

	public findOccurence() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return
	 * @throws FileNotFoundException
	 */
	public int sizeofMap() throws FileNotFoundException {
		// TODO Auto-generated method stub
//		ArrayList<String> stopwords = setstopwords();
//		HashMap<String, Integer> hmap = new HashMap<>();
//		File file = new File("mobydick.txt");
//		Scanner sc = new Scanner(file);
//		StringBuilder sb = new StringBuilder();
//		while (sc.hasNext()) {
//			String str = sc.next().replaceAll("[^\\w\\s]", "");
//			sb.append(str + " ");
//		}
//		String[] wordList = sb.toString().trim().split(" ");
//		for (int i = 0; i < wordList.length; i++) {
//			if (!stopwords.contains(wordList[i])) {
//				if (hmap.containsKey(wordList[i])) {
//					int value = hmap.get(wordList[i]);
//					hmap.put(wordList[i], value + 1);
//				} else {
//					hmap.put(wordList[i], 1);
//				}
//			}
//		}
		HashMap<String, Integer> hmap = findfrequentwords();
		ArrayList map = entriesSortedByValues(hmap);
		int lenthofmap = 0;
		for (int i = 0; i < 100; i++) {
			System.out.println(map.get(i));
			lenthofmap++;
		}
		return lenthofmap;

	}

	public ArrayList<String> setstopwords() throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = null;
		try {
			sc = new Scanner(new File("stop-words.txt"));
		} catch (FileNotFoundException s) {
			System.out.println("File does Not Exist Please Try Again: ");
		}
		ArrayList<String> list = new ArrayList<>();
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
				list.add(stopwords[i]);
		}
		return list;

	}

	public HashMap<String, Integer> findfrequentwords() throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<String> stopwords = setstopwords();
		HashMap<String, Integer> hmap = new HashMap<>();
		Scanner sc = null;
		try {
			sc = new Scanner(new File("mobydick.txt"));
		} catch (FileNotFoundException s) {
			System.out.println("File does Not Exist Please Try Again: ");
		}
		StringBuilder sb = new StringBuilder();
		while (sc.hasNext()) {
			String str = sc.next().replaceAll("[^\\w\\s]", "");
			sb.append(str + " ");
		}
		String[] wordList = sb.toString().split(" ");
		for (int i = 0; i < wordList.length; i++) {
			if (!stopwords.contains(wordList[i])) {
				if (hmap.containsKey(wordList[i])) {
					int value = hmap.get(wordList[i]);
					hmap.put(wordList[i], value + 1);
				} else {
					hmap.put(wordList[i], 1);
				}
			}
		}
		ArrayList map = entriesSortedByValues(hmap);
		for (int i = 0; i < 100; i++) {
			System.out.println(map.get(i));
		}
		return hmap;
	}

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

	public String fileNotfound(String str1) {
		// TODO Auto-generated method stub
		return null;
	}

}
