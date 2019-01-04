import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("aaaaabbbaaaaa"));
        assertTrue(palindrome.isPalindrome("cc"));
        assertTrue(palindrome.isPalindrome("cac"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("caccccccccccccccc"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("ca"));
    }


    @Test
    public void testisPalindromeby1() {
        CharacterComparator obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("detrude", obo));
        assertTrue(palindrome.isPalindrome("ab", obo));
        assertTrue(palindrome.isPalindrome("acdcdb", obo));

    }

    @Test
    public void testisPalindromebyN() {
        CharacterComparator obn = new OffByN(5);
        assertTrue(palindrome.isPalindrome("binding", obn));



    }

}
