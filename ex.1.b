import java.util.Scanner;
public class PlayfairCipherUI {

    private static String matrix = "";

    private static void setupMatrix(String key) {
        String clean = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I") + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clean.length(); i++) {
            String ch = String.valueOf(clean.charAt(i));
            if (sb.indexOf(ch) == -1) {
                sb.append(ch);
            }
        }
        matrix = sb.toString();
    }

    private static String prepareText(String text) {
        String clean = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clean.length(); i++) {
            sb.append(clean.charAt(i));
            if (i + 1 < clean.length() && clean.charAt(i) == clean.charAt(i + 1)) {
                sb.append('X');
            }
        }
        if (sb.length() % 2 != 0) {
            sb.append('X');
        }
        return sb.toString();
    }

    private static String process(String text, int direction) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            int p1 = matrix.indexOf(text.charAt(i));
            int p2 = matrix.indexOf(text.charAt(i + 1));
           
            int r1 = p1 / 5, c1 = p1 % 5;
            int r2 = p2 / 5, c2 = p2 % 5;

            if (r1 == r2) {
                c1 = (c1 + direction + 5) % 5;
                c2 = (c2 + direction + 5) % 5;
            } else if (c1 == c2) {
                r1 = (r1 + direction + 5) % 5;
                r2 = (r2 + direction + 5) % 5;
            } else {
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }
            result.append(matrix.charAt(r1 * 5 + c1)).append(matrix.charAt(r2 * 5 + c2));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.println("=== PLAYFAIR CIPHER ===");
        System.out.print("Key: ");
        String key = scanner.nextLine();
        setupMatrix(key);
       
        System.out.print("Message: ");
        String msg = scanner.nextLine();
        String formatted = prepareText(msg);
       
        String encrypted = process(formatted, 1);
        String decrypted = process(encrypted, -1);
       
        System.out.println("\nEncrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
       
        scanner.close();
    }
}