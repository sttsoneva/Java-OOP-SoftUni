import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(roses::offer);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(lilies::push);

        int wreaths = 0;
        int spareFlowers = 0;
        while (!roses.isEmpty() && !lilies.isEmpty()) {

            int bunchOfRoses = roses.poll();
            int bunchOfLilies = lilies.pop();
            int sumFlowers = bunchOfRoses + bunchOfLilies;

            if (sumFlowers == 15) {
                wreaths++;
            } else if (sumFlowers < 15) {
                spareFlowers += sumFlowers;
            } else {
                while (sumFlowers > 15) {
                    bunchOfLilies -= 2;
                    sumFlowers -= 2;
                    if (sumFlowers == 15) {
                        wreaths++;
                    } else if (sumFlowers < 15) {
                        spareFlowers += sumFlowers;
                    }
                }
            }
        }
        int additionalWreaths = spareFlowers / 15;
        wreaths += additionalWreaths;

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
