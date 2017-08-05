package occurencetest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;
import org.occurence.FindOccurenceWords;

public class TestFindOccurence {

	@Test
	public void displayFrequentwords() throws FileNotFoundException{
		FindOccurenceWords fo = new FindOccurenceWords();
		ArrayList<String> list = fo.diplayFrequentWords();
		assertEquals(100,list.size());
		assertNotEquals(null, list);
	}
	
	@Test
	public void filenotfound() throws FileNotFoundException {
		
		FindOccurenceWords fo = new FindOccurenceWords();
		String str1 = "mobydick.txt";
		String str2 = "stop-words.txt";
		assertEquals("File found", fo.fileNotFound(str1));
		assertNotEquals("File Not found", fo.fileNotFound(str1));
		assertEquals("File found", fo.fileNotFound(str2));
		assertNotEquals("File Not found", fo.fileNotFound(str2));
	}
	
	@Test
	public void nofilefound() throws FileNotFoundException {
		
		FindOccurenceWords fo = new FindOccurenceWords();
		String str1 = "mobydick1.txt";
		String str2 = "stop-words1.txt";
		assertEquals("File Not found", fo.fileNotFound(str1));
		assertNotEquals("File found", fo.fileNotFound(str1));
		assertEquals("File Not found", fo.fileNotFound(str2));
		assertNotEquals("File found", fo.fileNotFound(str2));
	}
	
	
	@Test
	public void setStopWordsList() throws FileNotFoundException
	{
		FindOccurenceWords fo = new FindOccurenceWords();
		ArrayList<String> list = fo.setStopWords();
		assertNotEquals(null, list);
	}

	@Test
	public void mapsize() throws FileNotFoundException {
		
		FindOccurenceWords fo = new FindOccurenceWords();
		int length = fo.sizeOfMap();
		assertEquals(100,length);
	}
	
	@Test
	public void frequentwords() throws FileNotFoundException {
		
		FindOccurenceWords fo = new FindOccurenceWords();
		assertNotEquals(null,fo.findFrequentWords());
	}


}
