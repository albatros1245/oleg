public class Main {
    
import java.util.Scanner;

public class MathCalculator {
    public static void main(String[] args) {
        
        double a = 2.5;
        double b = 4.0;
        double y = 10.0; 
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть значення x: ");
        double x = scanner.nextDouble();
        

        boolean isDomainValid = true;
        
        if (x + b - a < 0) {
            System.out.println("Помилка: Вираз під квадратним коренем не може бути від'ємним. Спробуйте більше значення x.");
            isDomainValid = false;
        } 
        
        if (y <= 0) {
            System.out.println("Помилка: Значення змінної 'y' для логарифма має бути строго більшим за 0.");
            isDomainValid = false;
        }
        
        if (Math.atan(b + a) == 0) {
            System.out.println("Помилка: Знаменник дорівнює нулю (ділення на нуль неможливе).");
            isDomainValid = false;
        }

        if (isDomainValid) {
            double numerator = Math.sqrt(x + b - a) + Math.log(y);
            double denominator = Math.atan(b + a);
            double T = numerator / denominator;
            
            System.out.println("Задані значення: a = " + a + ", b = " + b + ", y = " + y);
            System.out.printf("Результат T = %.4f%n", T);
        }
        
        scanner.close();
    }
}


}
