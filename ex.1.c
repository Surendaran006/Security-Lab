import java.util.Scanner;

public class VigenereCipherUI {

    public static String processVigenere(String text, String key, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        int keyLen = key.length();
       
        for (int i = 0; i < text.length(); i++) {
            char textChar = text.charAt(i);
            char keyChar = key.charAt(i % keyLen);
           
            int textVal = textChar - 32;
            int keyVal = keyChar - 32;
           
            int finalVal;
            if (encrypt) {
                finalVal = (textVal + keyVal) % 95;
            } else {
                finalVal = (textVal - keyVal + 95) % 95;
            }
           
            result.append((char) (finalVal + 32));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("=== ELITE VIGENERE SYSTEM ===");
        System.out.print("Enter secret message: ");
        String message = scanner.nextLine();
       
        System.out.print("Enter secret key word: ");
        String key = scanner.nextLine();
       
        if (key.isEmpty()) key = "DEFAULT";
       
        String encrypted = processVigenere(message, key, true);
        String decrypted = processVigenere(encrypted, key, false);
       
        System.out.println("\n--- CONFIDENTIALITY REPORT ---");
        System.out.println("Original Input   : " + message);
        System.out.println("Encrypted Cipher : " + encrypted);
        System.out.println("Decrypted Check  : " + decrypted);
        System.out.println();
       
        scanner.close();
    }
}