import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        String str = ""+ch;
        String encrypted_char = Caesar.encryptCaesarKey(str, key);

        return encrypted_char.charAt(0);
    }

    public static char decryptCaesarLetter(char ch, int key) {
        String str = ""+ch;
        String decrypted_char = Caesar.decryptCaesarKey(str, key);

        return decrypted_char.charAt(0);
    }
    public static String encryptVigenere(String message, String key) {
        String new_message = "";
        int keyIndex = 0;

        for (int i = 0; i<message.length(); i++) {
            char ch = message.charAt(i);
            if ((ch<'A' || (ch>'Z' && ch<'a'))||((ch<'a' && ch>'Z') || ch>'z')){
                new_message += ch;
            }
            else {
                if (keyIndex == key.length()) {
                    keyIndex = 0;
                }

                char ch_of_message = message.charAt(i);
                int shift = (char) (key.charAt(keyIndex)) - 65;
                new_message += encryptCaesarLetter(ch_of_message, shift);
                keyIndex++;
            }
        }
        return new_message;

    }

    public static String decryptVigenere(String message, String key) {
        String new_message = "";
        int keyIndex = 0;

        for (int i = 0; i<message.length(); i++) {
            char ch = message.charAt(i);
            if ((ch<'A' || (ch>'Z'&& ch < 'a' ))||((ch<'a' && ch>'z') || ch>'z')){
                new_message += ch;
            }
            else {
                if (keyIndex == key.length()) {
                    keyIndex = 0;
                }

                char ch_of_message = message.charAt(i);
                int shift = (char) (key.charAt(keyIndex)) - 65;
                new_message += decryptCaesarLetter(ch_of_message, shift);
                keyIndex++;
            }
        }
        return new_message;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
