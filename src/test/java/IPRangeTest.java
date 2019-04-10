import org.junit.Before;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class IPRangeTest {
    IPRange range1, range2, range3;

    @Before
    public void setUp() throws Exception {

         range1 = new IPRange("10.20.16.26", "10.20.16.26");

         range2 = new IPRange("10.20.16.36", "10.20.16.26");

         range3 = new IPRange("10.20.16.27", "10.20.16.26");
    }



    @Test
    public void findBorders() throws Exception {

        assertEquals("Equals",1, range1.findBorders());
        assertEquals("Suitable values",0, range2.findBorders());
        assertEquals("Sequenced values",2, range3.findBorders());
    }

}