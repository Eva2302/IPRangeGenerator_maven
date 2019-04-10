import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IPAddressTest {
    IPAddress ip;

    @Before
    public void setUp() throws Exception {
        ip = new IPAddress("192.178.15.16");
    }

    @Test
    public void split() throws Exception {
        int[] members = {192,178,15,16};
        ip.split();

        assertTrue("Arrays are not equal", java.util.Arrays.equals(members, ip.members));

    }

}