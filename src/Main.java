import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("Input: ");
            String input = scanner.nextLine();
            try {
                String result = calc(input);
                System.out.println("Outout: " + result);
            } catch (Exception e) {
                System.out.println("Error: "+ e.getMessage());
                break;
            }
        }
    }
    public static String calc(String input) { String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }    int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[2]);
        String operator = parts[1];

        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10) {
            throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        }
        int result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемый оператор");
        }


        return String.valueOf(result);
    }
}
