import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String total = "";


        for (int i = 0; i<message.length();i++){
            char ch = message.charAt(i);
            if (ch>='X'&& ch<= 'Z'){total += (char) (ch-23);}
            else if (ch == 'x'){total += 'a';}

            else if (ch == 'y'){
                total += 'b';
            }
            else if (ch == 'z'){
               total += 'c' ;
            }
            else if (ch>= 65 && ch <= 90 || ch>= 97 && ch<= 122){
            total += (char)(ch +3);
            }
            else{
                total += ch;
            }
        }

        return total;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String total = "";


        for (int i = 0; i<message.length();i++){
            char ch = message.charAt(i);
            if (ch=='A'){total += 'X';}
            else if (ch == 'B'){total += 'Y';}
            else if (ch== 'C'){total += 'Z';}
            else if (ch == 'a'){total += 'x';}
            else if (ch == 'b'){total += 'y';}
            else if (ch == 'c'){total += 'z' ;}
            else if (ch>= 65 && ch <= 90 || ch>= 97 && ch<= 122){
                total += (char)(ch -3);
            }
            else{
                total += ch;
            }
        }

        return total;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        key = key % 26;
        int goback = 26 - key;
        String total = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if ((ch > 'Z' - key && ch <= 'Z') || ch > 'z' - key && ch <= 'z') {
                total += (char) (ch - goback);
            } else if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
                total += (char) (ch + key);
            } else if ((ch < 'a' || ch > 'z') || (ch < 'A' || ch > 'Z')) {
                total += (char) (ch);
            }
        }
        return total;
    }

        // Given a String and a key corresponding to a shift, decrypts
        // the String using the given key and returns the original String
        // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
        //  v w x y z a b c d e f g h i j k l m n o p q r s t u
        //  a b c d e f g h i j k l m n o p q r s t u v w x y z
        //  v w x y z a b c d e f g h i j k l m n o p q r s t u
        public static String decryptCaesarKey (String message,int key) {
        //to decrypt something, you take each letter, and subtract the key from it e.g. b goes to a if the key is 1.
            // make sure that any character that isn't a-z or A-Z remains the same,
            //it gets tricky when there's the bending of the alphabet.
            key = key % 26;
            int gofurther = 26 - key;
            String total = "";
            for (int i = 0; i < message.length(); i++) {
                char ch = message.charAt(i);
                //this is the turn around part
                if ((ch >= 'A' && ch <= 'A' + key) || ch >= 'a' && ch <= 'a' + key) {
                    total += (char) (ch + gofurther);
                    //this is the normal decryption method
                } else if (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z') {
                    total += (char) (ch - key);
                    //this is for non alphabet chars
                } else if ((ch < 'a' && ch>'Z' || ch > 'z' )||( ch < 'A' || ch > 'Z' && ch<'a') ){
                    total += (char) (ch);
                }
            }
            return total;
        }

            // The main method is already provided for you
            // You do not need to edit this code until Part 2
            public static void main (String[]args){
                Scanner scan = new Scanner(System.in);

                System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
                String command = scan.nextLine().trim().toLowerCase();

                if (command.equals("encrypt")) {
                    System.out.println("Please enter your message to be encrypted: ");
                    String message = scan.nextLine();
                    System.out.println("Here is your encrypted message: ");
                    System.out.println(encryptCaesar(message));
                } else if (command.equals("decrypt")) {
                    System.out.println("Please enter your message to be decrypted: ");
                    String message = scan.nextLine();
                    System.out.println("Here is your decrypted message: ");
                    System.out.println(decryptCaesar(message));
                } else {
                    System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
                }

                scan.close();
            }
        }
