import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n=== NUMBER SYSTEM CONVERTER ===");
            System.out.println("1. Binary to Decimal");
            System.out.println("2. Decimal to Binary");
            System.out.println("3. Octal to Decimal");
            System.out.println("4. Decimal to Octal");
            System.out.println("5. Hexadecimal to Decimal");
            System.out.println("6. Decimal to Hexadecimal");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            sc.nextLine();

            String number;
            String result;

            switch (choice) {

                case 1:
                    System.out.print("Enter Binary Number: ");
                    number = sc.nextLine();

                    result = convert(number, 2, 10);

                    System.out.println("Decimal: " + result);
                    break;

                case 2:
                    System.out.print("Enter Decimal Number: ");
                    number = sc.nextLine();

                    result = convert(number, 10, 2);

                    System.out.println("Binary: " + result);
                    break;

                case 3:
                    System.out.print("Enter Octal Number: ");
                    number = sc.nextLine();

                    result = convert(number, 8, 10);

                    System.out.println("Decimal: " + result);
                    break;

                case 4:
                    System.out.print("Enter Decimal Number: ");
                    number = sc.nextLine();

                    result = convert(number, 10, 8);

                    System.out.println("Octal: " + result);
                    break;

                case 5:
                    System.out.print("Enter Hexadecimal Number: ");
                    number = sc.nextLine();

                    result = convert(number, 16, 10);

                    System.out.println("Decimal: " + result);
                    break;

                case 6:
                    System.out.print("Enter Decimal Number: ");
                    number = sc.nextLine();

                    result = convert(number, 10, 16);

                    System.out.println("Hexadecimal: " + result);
                    break;

                case 7:
                    System.out.println("Program Ended.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);

        sc.close();
    }

    public static int toDecimal(String number, int base) {
        int decimal = 0;

        for (int i = 0; i < number.length(); i++) {
            char c = Character.toUpperCase(number.charAt(i));
            int digit;

            if (c >= '0' && c <= '9') {
                digit = c - 0;
            } else {
                digit = c - 'A' + 10;
            }

            decimal = decimal * base + digit;
        }
        return decimal;
    }

    public static String fromDecimal(int decimal, int base) {
        String digits = "0123456789ABCDEF";
        String result = "";

        while (decimal > 0) {
            int remainder = decimal % base;
            result = digits.charAt(remainder) + result;
            decimal = decimal / base;
        }
        return result;
    }

    public static String convert(String number, int fromBase, int toBase) {
        int decimal = toDecimal(number, fromBase);

        if (toBase == 10) {
            return String.valueOf(decimal);
        } else {
            return fromDecimal(decimal, toBase);
        }
    }
}
