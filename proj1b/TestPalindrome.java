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
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("tet"));
        assertTrue(palindrome.isPalindrome("teet"));
        assertFalse(palindrome.isPalindrome("the"));
        assertFalse(palindrome.isPalindrome("Aa"));
    }

    @Test
    public void testIsPalindrome_offByOne() {
        OffByOne offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertFalse(palindrome.isPalindrome("tet", offByOne));
    }

    @Test
    public void testIsPalindrome_offByN() {
        OffByN offBy1 = new OffByN(1);
        assertTrue(palindrome.isPalindrome("flake", offBy1));
        assertTrue(palindrome.isPalindrome("", offBy1));
        assertTrue(palindrome.isPalindrome("a", offBy1));
        assertFalse(palindrome.isPalindrome("tet", offBy1));

        OffByN offBy0 = new OffByN(0);
        assertTrue(palindrome.isPalindrome("", offBy0));
        assertTrue(palindrome.isPalindrome("a", offBy0));
        assertTrue(palindrome.isPalindrome("tet", offBy0));
        assertTrue(palindrome.isPalindrome("teet", offBy0));
        assertFalse(palindrome.isPalindrome("the", offBy0));
        assertFalse(palindrome.isPalindrome("Aa", offBy0));
    }
}
