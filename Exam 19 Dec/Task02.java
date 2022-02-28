import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int successfulRegistrations = 0;
        for (int i = 0; i < n; i++) {
            String text = scan.nextLine();
            String expression = "U\\$(?<user>[A-Z][a-z]{2,})U\\$P@\\$(?<pass>[A-Za-z]{5,}[0-9]+)P@\\$";
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()) {
                successfulRegistrations++;
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", matcher.group("user"), matcher.group("pass"));
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.println("Successful registrations: " + successfulRegistrations);
    }
}
