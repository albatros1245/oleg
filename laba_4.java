import java.util.InputMismatchException;
import java.util.Scanner;

public class laba_4 {
    public static void main(String[] args) {
        
        double a = 2.5;
        double b = 4.0;
        double y = 10.0; 
        
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Введіть номер вашого варіанту (N): ");
            int N = scanner.nextInt(); 
            
            // Обчислення меж інтервалу та кроку згідно із завданням
            double startX = -10 - 2.5 * N;
            double endX = 5 + 1.2 * N;
            double stepX = 0.5 + (double) N / 20.0;
            
            System.out.printf("\nІнтервал X: [%.2f; %.2f], крок: %.2f\n", startX, endX, stepX);
            
            // СПОСІБ 1: Використання циклу FOR

            System.out.println("\n--- Обчислення за допомогою циклу FOR ---");
            // Додано 1e-9 (дуже мале число) до endX для компенсації похибки при роботі з double
            for (double x = startX; x <= endX + 1e-9; x += stepX) {
                
                // Перевірка ОДЗ з переходом на наступну ітерацію (continue)
                if (x + b - a < 0 || y <= 0 || Math.atan(b + a) == 0) {
                    System.out.printf("x = %8.3f | Пропущено (не задовольняє ОДЗ)\n", x);
                    continue; 
                }
                
                double numerator = Math.sqrt(x + b - a) + Math.log(y);
                double denominator = Math.atan(b + a);
                double T = numerator / denominator;
                
                System.out.printf("x = %8.3f | T = %.4f\n", x, T);
            }

            // СПОСІБ 2: Використання циклу WHILE

            System.out.println("\n--- Обчислення за допомогою циклу WHILE ---");
            double currentX = startX;
            
            while (currentX <= endX + 1e-9) {
                
                // Перевірка ОДЗ
                if (currentX + b - a < 0 || y <= 0 || Math.atan(b + a) == 0) {
                    System.out.printf("x = %8.3f | Пропущено (не задовольняє ОДЗ)\n", currentX);
                    // Важливо: у циклі while перед continue обов'язково треба збільшити лічильник, 
                    // інакше програма зациклиться назавжди!
                    currentX += stepX;
                    continue;
                }
                
                double numerator = Math.sqrt(currentX + b - a) + Math.log(y);
                double denominator = Math.atan(b + a);
                double T = numerator / denominator;
                
                System.out.printf("x = %8.3f | T = %.4f\n", currentX, T);
                
                // Збільшення лічильника в кінці успішної ітерації
                currentX += stepX;
            }
            
        } catch (InputMismatchException e) {
            // Перехоплення помилки, якщо замість числа N користувач ввів текст або букви
            System.out.println("Виняткова ситуація: Некоректний формат числа! Будь ласка, введіть ціле число (номер варіанту).");
        } catch (Exception e) {
            System.out.println("Сталася невідома помилка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nРоботу програми завершено.");
        }
    }
}