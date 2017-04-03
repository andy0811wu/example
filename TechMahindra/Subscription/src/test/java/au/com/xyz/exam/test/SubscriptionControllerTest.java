package au.com.xyz.exam.test;

import au.com.xyz.exam.SubscriptionController;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Andy Wu on 1/04/2017.
 */

public class SubscriptionControllerTest {
    private SubscriptionController sc;

    @Before
    public void setup() {
        sc = new SubscriptionController();
    }

    @Test
    public void testStringLengthGreatThanMaxSize()  {
        String input = "123456789012345678901234567890";
        Integer maxSize = 25;
        String expectedString = "12 ... (truncated) ... 90";

        String returnString = sc.truncate(input, maxSize);
        assertEquals(expectedString, returnString);
    }

    @Test
    public void testNoWayToRestrictMaxSizeAsInputLengthLessThanReplaceLength()  {
        String input = "1234567890";
        Integer maxSize = 5;
        String expectedString = "1234567890";

        String returnString = sc.truncate(input, maxSize);
        assertEquals(expectedString, returnString);
    }

    @Test
    public void testStringLengthLessThanMaxSize()  {
        String input = "123456789012345678901234567890";
        Integer maxSize = 31;
        String expectedString = "123456789012345678901234567890";

        String returnString = sc.truncate(input, maxSize);
        assertEquals(expectedString, returnString);
    }

    @Test
    public void testStringLengthEqualToMaxSize()  {
        String input = "123456789012345678901234567890";
        Integer maxSize = 30;
        String expectedString = "123456789012345678901234567890";

        String returnString = sc.truncate(input, maxSize);
        assertEquals(expectedString, returnString);
    }

    @Test
    public void testNoWayToRestrictMaxSizeAsInputLengthEqualToReplaceLength()  {
        String input = "123456789012345678901"; // 21 characters
        Integer maxSize = 10;
        String expectedString = "123456789012345678901";

        String returnString = sc.truncate(input, maxSize);
        assertEquals(expectedString, returnString);
    }
}
