import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws NullPointerException {
        System.out.print("Введите выражение из двух чисел: ");
        String ansver = calculator();
        System.out.print(ansver);
    }
    public static String calculator() throws NullPointerException {
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();


        if(expression.contains("IIII")) {
            throw new NullPointerException("Некорректное выражение");
        }

        String[] data = expression.split(" ");
        if (data.length != 3) {
            throw new NullPointerException("Некорректное выражение");
        }
        if (converter.isRoman(data[0]) == converter.isRoman(data[2])) {
            int a;
            int b;
            String action = data[1];

            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {
                try {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[2]);
                } catch (NumberFormatException x) {
                    throw new NullPointerException("Некорректное выражение");
                }
            } else {
                try {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[2]);
                } catch (NumberFormatException x) {
                    throw new NullPointerException("Некорректное выражение");
                }
            }
            if (a > 10) {
                throw new NullPointerException("Числа от 0 до 10 или от I до X");
            }
            if (b > 10) {
                throw new NullPointerException("Числа от 0 до 10 или от I до X");
            }
            int result;
            switch (action) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
                default:
                    throw new NullPointerException("Недопустимое действие");
            }

            String ansver;
            if (isRoman) {
                ansver = converter.intToRoman(result);
                return ansver;
            } else {
                ansver = Integer.toString(result);
                return ansver;
            }
        } else {
            throw new NullPointerException("Числа должны быть в одном формате");
        }
    }
}
