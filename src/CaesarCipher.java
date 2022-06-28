import java.util.Arrays;
import java.util.Scanner;



public class CaesarCipher {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("1. Шифровка текста");
        System.out.println("2. Расшифровка текста с помощью ключа");
        
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("Введите строку для шифровки:\n");
        String s = scanner.nextLine();
        System.out.print("Зашифрованная строка:\n");


        switch (x) {
            case 1:
                System.out.println(cipher(s, 3));
                break;
            case 2:
                System.out.println(decipher(s, 3));
                break;
            case 3:
                break;
        }

        String functionResult = cipher(s, 3);
        System.out.println(functionResult);

    }


    static String cipher(String message, int offset) {
        StringBuilder result = new StringBuilder();
        for (char character : message.toCharArray()) {
            if (character != ' ') {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + offset) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return result.toString();

    }

    static String decipher(String message, int offset) {
        return cipher(message, 26 - (offset % 26));
    }


}