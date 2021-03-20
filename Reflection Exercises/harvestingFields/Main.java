package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] declaredFields = clazz.getDeclaredFields();

        String line = scan.nextLine();
        while (!line.equals("HARVEST")) {
            String modifier = line;
            Field[] fields = Arrays.stream(declaredFields).filter(f -> Modifier.toString(f.getModifiers()).equals(modifier))
                    .toArray(Field[]::new);

            if (fields.length == 0) {
                printFields(declaredFields);
            } else {
                printFields(fields);
            }

            line = scan.nextLine();
        }
    }

    private static void printFields(Field[] declaredFields) {
        Arrays.stream(declaredFields).forEach(f -> System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName()));
    }
}
