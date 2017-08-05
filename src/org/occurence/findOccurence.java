package org.occurence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class findOccurence {
	
	ArrayList<String> list;
	public findOccurence() {
		// TODO Auto-generated constructor stub
	}

	public long sizeofMap() throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("mobydick.txt");
		System.out.println("here");
		System.out.println(list);
		Scanner sc = new Scanner(file);
		ArrayList<String> list = setstopwords();
		StringBuilder sb = new StringBuilder();
//		while(sc.hasNext()){
//			 System.out.println();
//			list.add(sc.next().replaceAll("[^a-zA-Z0-9]", ""));
//			
//		}
//		while(sc1.hasNext()){
//			System.out.println();
//			list1.add(sc1.next().replaceAll("[^a-zA-Z0-9]", ""));
//		}
//		System.out.println(list);
//		System.out.println(list1);
		return 100;
		
		
	}

	public ArrayList<String> setstopwords() throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("stop-words.txt");
		Scanner sc = new Scanner(file);
		ArrayList<String> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		while(sc.hasNextLine())
		{
			sb.append(sc.next()+" ");
		}
		int lastindex = sb.lastIndexOf("#");
		int start = sb.indexOf("a", lastindex);
		int end = sb.lastIndexOf("z");
		String str = sb.toString().substring(start, end);
		String[] stopwords = str.split(" ");
		for(int i = 0; i<stopwords.length; i++)
		{
			if(stopwords[i].length() != 1) list.add(stopwords[i]);
		}
		//for(String str1: list) System.out.println(str1);
		return list;
		
		
		
	}

	public HashMap<String,Integer> findfrequentwords() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
