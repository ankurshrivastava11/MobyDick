  /**
 * 
 */
package occurencetest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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
		assertNotEquals(list, null);
	}

	@Test
	public void mapsize() throws FileNotFoundException {
		
		findOccurence fo = new findOccurence();
		assertEquals(100,fo.sizeofMap());
	}
	
	@Test
	public void frequentwords() throws FileNotFoundException {
		
		findOccurence fo = new findOccurence();
		assertNotEquals(fo.findfrequentwords(),null);
	}
	

}
