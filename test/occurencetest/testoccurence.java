  /**
 * 
 */
package occurencetest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.occurence.findOccurence;

/**
 * @author ankurshrivastava
 *
 */
public class testoccurence {
	
	
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
		HashMap<String, Integer> hmap = fo.findfrequentwords();
		assertNotEquals(null,fo.findfrequentwords());
	}
	

}
