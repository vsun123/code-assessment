/**
 * Unit test for code solution.
 */
package dedup;

import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;



/**
 *
 * @author Vincent
 */
public class DeDupTest {

	private int[] sortNoDups = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 25, 26, 34, 43, 45, 85, 86, 10000};


    public DeDupTest() {
    }

    private DeDup dedup;
    
    @Before
    public void before() {
        dedup = new DeDup();
    }
    
    @After
    public void after() {
        dedup = null;
    }


    @Test
    public void testRemoveDuplicates() {
        int[] noDups = dedup.removeDuplicates(dedup.randomIntegers);
        dedup.quickSort(noDups, 0, noDups.length-1);
        Assert.assertTrue(Arrays.equals(noDups, sortNoDups));
    }
    
    @Test
    public void testRemoveDuplicatesWithOrder() {
        int[] noDups = dedup.removeDuplicatesWithOrder(dedup.randomIntegers);
        dedup.quickSort(noDups, 0, noDups.length-1);
        Assert.assertTrue(Arrays.equals(noDups, sortNoDups));
    }
    
    @Test
    public void testRemoveDuplicatesAndSort() {
        int[] noDups = dedup.removeDuplicatesAndSort(dedup.randomIntegers);
        Assert.assertTrue(Arrays.equals(noDups, sortNoDups));
    }

}
