import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
public class AES {
static String key = "1234567890123456"; // 16 bytes = AES-128
public static String encrypt(String text) throws Exception {
SecretKeySpec secretKey = new SecretKeySpec(
key.getBytes(), "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] encrypted = cipher.doFinal(text.getBytes());
return Base64.getEncoder().encodeToString(encrypted);
}
public static String decrypt(String encryptedText) throws Exception {
SecretKeySpec secretKey = new SecretKeySpec(
key.getBytes(), "AES");
Cipher cipher = Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] decrypted = cipher.doFinal(
Base64.getDecoder().decode(encryptedText));
return new String(decrypted);
}
public static void main(String[] args) throws Exception {
String plaintext = "Hello World";
String encrypted = encrypt(plaintext);
String decrypted = decrypt(encrypted);
System.out.println("Original Text : " + plaintext);
System.out.println("Encrypted Text : " + encrypted);
System.out.println("Decrypted Text : " + decrypted);
}
} 
