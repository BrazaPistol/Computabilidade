import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class VerificaPalindromoTest {

    @Test
    public void testIsPalindrome() {
        assertEquals(true, VerificaPalindromo.isPalindrome("abba"));
        assertEquals(true, VerificaPalindromo.isPalindrome("aaaaaaa"));
        assertEquals(true, VerificaPalindromo.isPalindrome("ababa"));
        assertEquals(true, VerificaPalindromo.isPalindrome("bbbbbbbbbbbbb"));
        assertEquals(true, VerificaPalindromo.isPalindrome("baaab"));
        assertEquals(true, VerificaPalindromo.isPalindrome("baaaaaaaaaaab"));
        assertEquals(false, VerificaPalindromo.isPalindrome("bba"));
        assertEquals(false, VerificaPalindromo.isPalindrome("abbb"));
        assertEquals(false, VerificaPalindromo.isPalindrome("bbbaaa"));
        assertEquals(false, VerificaPalindromo.isPalindrome("aabbbb"));
        assertEquals(false, VerificaPalindromo.isPalindrome("babababa"));
    }
}