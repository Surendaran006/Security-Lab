public class ex2a {
    public static String encrypt(String message, int columns) {

        message = message.replaceAll("\\s+", "").toUpperCase();

        int rows = (int) Math.ceil((double) message.length() / columns);
        char[][] matrix = new char[rows][columns];

        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (index < message.length()) {
                    matrix[i][j] = message.charAt(index++);
                } else {
                    matrix[i][j] = 'X';
                }
            }
        }

        StringBuilder cipherText = new StringBuilder();

        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                cipherText.append(matrix[i][j]);
            }
        }

        return cipherText.toString();
    }

    public static String decrypt(String cipherText, int columns) {

        int rows = (int) Math.ceil((double) cipherText.length() / columns);
        char[][] matrix = new char[rows][columns];

        int index = 0;
        for (int j = 0; j < columns; j++) {
            for (int i = 0; i < rows; i++) {
                matrix[i][j] = cipherText.charAt(index++);
            }
        }

        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                plainText.append(matrix[i][j]);
            }
        }

        return plainText.toString().replaceAll("X+$", "");
    }

    public static void main(String[] args) {

        String message = "DELIVER GOODS AT NOON";
        int columns = 4;

        String encrypted = encrypt(message, columns);
        String decrypted = decrypt(encrypted, columns);

        System.out.println("Original Message  : " + message);
        System.out.println("Encrypted Message : " + encrypted);
        System.out.println("Decrypted Message : " + decrypted);
    }
}

