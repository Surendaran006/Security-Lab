import java.util.Scanner;
public class HillCipherUI {

    private static final int[][] KEY = { {3, 3}, {2, 5} };
    private static final int[][] INV_KEY = { {15, 17}, {20, 9} };

    private static String process(String text, int[][] matrixKey) {
        StringBuilder result = new StringBuilder();

        if (text.length() % 2 != 0) {
            text += "X";
        }

        for (int i = 0; i < text.length(); i += 2) {
            int p1 = text.charAt(i) - 'A';
            int p2 = text.charAt(i + 1) - 'A';

            int c1 = (matrixKey[0][0] * p1 + matrixKey[0][1] * p2) % 26;
            int c2 = (matrixKey[1][0] * p1 + matrixKey[1][1] * p2) % 26;

            result.append((char) (c1 + 'A'));
            result.append((char) (c2 + 'A'));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== HILL CIPHER SYSTEM ===");
        System.out.print("Enter secret message (Letters only): ");
        String message = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        if (message.isEmpty()) {
            System.out.println("Invalid input!");
            scanner.close();
            return;
        }

        String encrypted = process(message, KEY);
        String decrypted = process(encrypted, INV_KEY);

        System.out.println("\n--- CONFIDENTIALITY REPORT ---");
        System.out.println("Original Input   : " + message);
        System.out.println("Encrypted Cipher : " + encrypted);
        System.out.println("Decrypted Check  : " + decrypted);
        System.out.println();

        scanner.close();
    }
}