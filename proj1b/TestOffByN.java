import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByN(1);

    @Test
    public void testEqualChars() {
        // Your tests go here.
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('d', 'c'));
        assertFalse(offByOne.equalChars('a', 'a'));

        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('D', 'C'));
        assertFalse(offByOne.equalChars('a', 'B'));
        assertFalse(offByOne.equalChars('b', 'A'));

        assertTrue(offByOne.equalChars('&', '%'));
        assertTrue(offByOne.equalChars('%', '&'));
        assertFalse(offByOne.equalChars('!', '('));
        assertFalse(offByOne.equalChars('@', '*'));
        //Uncomment this class once you've created your CharacterComparator interface and OffByOne class.
    }
}
