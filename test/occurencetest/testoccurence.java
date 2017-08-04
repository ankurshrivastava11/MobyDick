  /**
 * 
 */
package occurencetest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;
import org.occurence.findOccurence;

/**
 * @author ankurshrivastava
 *
 */
public class testoccurence {

	@Test
	public void test() throws FileNotFoundException {
		
		findOccurence fo = new findOccurence();
		assertEquals(100,fo.sizeofMap());
		

	}

}
