import java.util.Scanner;
public class RailFence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine();

        System.out.print("Enter number of rails: ");
        int rails = sc.nextInt();

        StringBuilder cipher = new StringBuilder();

        for (int r = 0; r < rails; r++) {
            for (int i = r; i < text.length(); i += rails) {
                cipher.append(text.charAt(i));
            }
        }

        System.out.println("Encrypted text: " + cipher);

        sc.close();
    }
}

