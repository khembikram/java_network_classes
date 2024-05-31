//  Ask number from user and find even or odd
import java.util.Scanner;

/**
 * revision1_java
 */
public class revision1_java {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number");

        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("The  number is even");
        }else{
            System.out.println("The number is odd");
        }

        scanner.close();
    }
}