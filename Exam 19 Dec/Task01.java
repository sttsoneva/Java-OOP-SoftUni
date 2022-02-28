import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "Translate":
                    String symbol = command[1];
                    String replacementSymbol = command[2];
                    text = (text.replace(symbol, replacementSymbol));
                    System.out.println(text);
                    break;
                case "Includes":
                    String word = command[1];
                    if (text.contains(word)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String beginning = command[1];
                    int length = beginning.length();
                    if (text.substring(0, length).equals(beginning)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    symbol = command[1];
                    System.out.println(text.lastIndexOf(symbol));
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(command[1]);
                    int count = Integer.parseInt(command[2]);
                    text = text.substring(0, startIndex) + text.substring(startIndex + count);
                    System.out.println(text);
                    break;
            }
            input = scan.nextLine();
        }
    }
}
