  /**
 * 
 */
package occurencetest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
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
		assertEquals(list, fo.setstopwords());
	}

	@Test
	public void test() throws FileNotFoundException {
		
		findOccurence fo = new findOccurence();
		assertEquals(100,fo.sizeofMap());
		

	}

}
