import java.math.BigInteger;
import java.util.Scanner;
public class DiffieHellman {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
// Public values
System.out.print("Enter prime number q: ");
BigInteger q = sc.nextBigInteger();
System.out.print("Enter primitive root a: ");
BigInteger a = sc.nextBigInteger();
// Private keys
System.out.print("Enter private key of User A: ");
BigInteger privateA = sc.nextBigInteger();
System.out.print("Enter private key of User B: ");
BigInteger privateB = sc.nextBigInteger();
// ---------------- USER A ----------------
// Calculate public key of User A
BigInteger publicA = a.modPow(privateA, q);
System.out.println("\n--- USER A ---");
System.out.println("Private Key A : " + privateA);
System.out.println("Public Key A : " + publicA);
// ---------------- USER B ----------------
// Calculate public key of User B
BigInteger publicB = a.modPow(privateB, q);
System.out.println("\n--- USER B ---");
System.out.println("Private Key B : " + privateB);
System.out.println("Public Key B : " + publicB);
// ---------------- SECRET KEY ----------------
// User A calculates shared secret
BigInteger secretA =
publicB.modPow(privateA, q);
// User B calculates shared secret
BigInteger secretB =
publicA.modPow(privateB, q);
System.out.println("\n--- SHARED SECRET ---");
System.out.println("Secret Key calculated by A: " + secretA);
System.out.println("Secret Key calculated by B: " + secretB);
// Check whether both secret keys are equal
if (secretA.equals(secretB)) {
System.out.println("Key Exchange Successful!");
} else {
System.out.println("Key Exchange Failed!");
}
sc.close();
}
} 
