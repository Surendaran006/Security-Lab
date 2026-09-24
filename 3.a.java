import javax.crypto.Cipher;

import javax.crypto.KeyGenerator;

import javax.crypto.SecretKey;
import java.util.Base64;
public class DES {
public static void main(String[] args) throws Exception {
String plaintext = "Hello World";
// Generate DES key
KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
SecretKey secretKey = keyGenerator.generateKey();
// Create DES cipher
Cipher cipher = Cipher.getInstance("DES");
// Encryption
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] encrypted = cipher.doFinal(plaintext.getBytes());
String encryptedText = Base64.getEncoder().encodeToString(encrypted);
System.out.println("Original Text : " + plaintext);
System.out.println("Encrypted Text : " + encryptedText);
// Decryption
cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] decrypted = cipher.doFinal(encrypted);
System.out.println("Decrypted Text : " + new String(decrypted));
}
} 
