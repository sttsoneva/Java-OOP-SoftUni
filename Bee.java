import java.util.Arrays;
import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int beeRowPosition = -1;
        int beeColumnPosition = -1;
        String[][] beeTerritory = new String[n][];
        for (int i = 0; i < n; i++) {
            beeTerritory[i] = scan.nextLine().split("");
            if (Arrays.toString(beeTerritory[i]).contains("B")) {
                beeRowPosition = i;
                for (int j = 0; j < n; j++) {
                    if (beeTerritory[beeRowPosition][j].equals("B")) {
                        beeColumnPosition = j;
                    }
                }
            }
        }

        int pollinatedFlowers = 0;
        String command = scan.nextLine();
        while (!command.equals("End")) {
            beeTerritory[beeRowPosition][beeColumnPosition] = ".";
            String field = "";
            switch (command) {
                case "up":
                    beeRowPosition--;
                    break;
                case "down":
                    beeRowPosition++;
                    break;
                case "left":
                    beeColumnPosition--;
                    break;
                case "right":
                    beeColumnPosition++;
                    break;
            }

            try {
                field = beeTerritory[beeRowPosition][beeColumnPosition];
                if (field.equals("f")) {
                    pollinatedFlowers++;
                    beeTerritory[beeRowPosition][beeColumnPosition] = "B";
                } else if (field.equals("O")) {
                    beeTerritory[beeRowPosition][beeColumnPosition] = ".";
                    continue;
                } else {
                    beeTerritory[beeRowPosition][beeColumnPosition] = "B";
                }
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("The bee got lost!");
                break;
            }
            command = scan.nextLine();
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }

        for (int i = 0; i < beeTerritory.length; i++) {
            for (int j = 0; j < beeTerritory[i].length; j++) {
                System.out.print(beeTerritory[i][j]);
            }
            System.out.println();
        }
    }
}
