package occurencetest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.Test;
import org.occurence.findOccurence;

/**
 * @author ankurshrivastava
 *
 */
public class testoccurence {
	
	@Test
	public void filenotfound() throws FileNotFoundException {
		
		findOccurence fo = new findOccurence();
		String str1 = "mobydick.txt";
		String str2 = "stop-words.txt";
		assertEquals("File found", fo.fileNotfound(str1));
		assertNotEquals("File Not found", fo.fileNotfound(str1));
		assertEquals("File found", fo.fileNotfound(str2));
		assertNotEquals("File Not found", fo.fileNotfound(str2));
	}
	
	@Test
	public void nofilefound() throws FileNotFoundException {
		
		findOccurence fo = new findOccurence();
		String str1 = "mobydick1.txt";
		String str2 = "stop-words1.txt";
		assertEquals("File Not found", fo.fileNotfound(str1));
		assertNotEquals("File found", fo.fileNotfound(str1));
		assertEquals("File Not found", fo.fileNotfound(str2));
		assertNotEquals("File found", fo.fileNotfound(str2));
	}
	
	
	@Test
	public void setStopWordsList() throws FileNotFoundException
	{
		findOccurence fo = new findOccurence();
		ArrayList<String> list = fo.setstopwords();
		assertNotEquals(null, list);
	}

	@Test
	public void mapsize() throws FileNotFoundException {
		
		findOccurence fo = new findOccurence();
		int length = fo.sizeofMap();
		assertEquals(100,length);
	}
	
	@Test
	public void frequentwords() throws FileNotFoundException {
		
		findOccurence fo = new findOccurence();
		assertNotEquals(null,fo.findfrequentwords());
	}
	

}
