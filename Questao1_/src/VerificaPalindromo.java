
import javax.swing.JOptionPane;

public class VerificaPalindromo {

    public static void main(String[] args) {
        
        String palavra = JOptionPane.showInputDialog(null,"Digite uma palavra ");
        
        
        if (isPalindrome(palavra)) {
           JOptionPane.showMessageDialog(null,palavra + " é um palindromo");
        } else 
           JOptionPane.showMessageDialog(null,palavra + " não é um palindromo.");
        }
    

    static boolean isPalindrome(String palavra) {
        int indiceEsquerda = 0;
        int indiceDireita = palavra.length() - 1;

        while (indiceEsquerda < indiceDireita) {
            if (palavra.charAt(indiceEsquerda) != palavra.charAt(indiceDireita)) {
                return false;
            }
            indiceEsquerda++;
            indiceDireita--;
        }

        return true;
    }
}