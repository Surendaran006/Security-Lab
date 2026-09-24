import java.math.BigInteger;
import java.util.Scanner;
public class RSA {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
// Input two prime numbers
System.out.print("Enter prime number p: ");
BigInteger p = sc.nextBigInteger();
System.out.print("Enter prime number q: ");
BigInteger q = sc.nextBigInteger();
// Calculate n and phi
BigInteger n = p.multiply(q);
BigInteger phi = p.subtract(BigInteger.ONE)
.multiply(q.subtract(BigInteger.ONE));
System.out.println("n = " + n);
System.out.println("phi(n) = " + phi);
// Input public exponent e
System.out.print("Enter public key e: ");
BigInteger e = sc.nextBigInteger();
// Calculate private key d
BigInteger d = e.modInverse(phi);
System.out.println("Public Key = (" + e + ", " + n + ")");
System.out.println("Private Key = (" + d + ", " + n + ")");
// Input message
sc.nextLine();
System.out.print("Enter message (as a number less than n): ");
BigInteger message = new BigInteger(sc.nextLine());
// ---------------- CONFIDENTIALITY ----------------
// Encryption using public key
BigInteger encrypted = message.modPow(e, n);
System.out.println("\n--- CONFIDENTIALITY ---");
System.out.println("Original Message : " + message);
System.out.println("Encrypted Message: " + encrypted);
// Decryption using private key
BigInteger decrypted = encrypted.modPow(d, n);
System.out.println("Decrypted Message: " + decrypted);
// ---------------- AUTHENTICATION ----------------
// Digital signature using private key
BigInteger signature = message.modPow(d, n);
System.out.println("\n--- AUTHENTICATION ---");
System.out.println("Digital Signature: " + signature);
// Verify signature using public key
BigInteger verifiedMessage = signature.modPow(e, n);
System.out.println("Verified Message : " + verifiedMessage);
if (message.equals(verifiedMessage)) {
System.out.println("Authentication Successful!");
} else {
System.out.println("Authentication Failed!");
}
sc.close();
}
} 
