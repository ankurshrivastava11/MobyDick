package org.occurence;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class findOccurence {

	public findOccurence() {
		// TODO Auto-generated constructor stub
	}

	public long sizeofMap() throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("mobydick.txt");
		System.out.println("here");
		Scanner sc = new Scanner(file);
		while(sc.next()!=null){
			System.out.print(sc.next());
		}
		
		return 100;
		
		
	}
	
	

}
