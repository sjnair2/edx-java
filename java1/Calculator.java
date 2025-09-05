import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String operation = scanner.nextLine();
        operation = operation.toLowerCase();
        int int1; int int2; double double1; double double2; String word1; String word2;
        switch (operation) {
            case "add":
                System.out.println("Enter two integers:");
                try {
                    int1 = scanner.nextInt();
                    int2 = scanner.nextInt();
                    System.out.println("Answer: "+(int1+int2));
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "subtract":
                System.out.println("Enter two integers:");
                try{
                    int1 = scanner.nextInt();
                    int2= scanner.nextInt();
                    System.out.println("Answer: "+(int1-int2));
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "multiply":
                System.out.println("Enter two doubles:");
                try {
                    double1 = scanner.nextDouble();
                    double2 = scanner.nextDouble();
                    System.out.printf("Answer: %.2f%n",double1*double2);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            case "divide":
                System.out.println("Enter two doubles:");
                try{
                    double1 = scanner.nextDouble();
                    double2 = scanner.nextDouble();
                    if (double2 == 0.0)
                        System.err.println("Invalid input entered. Terminating...");
                    else
                        System.out.printf("Answer: %.2f%n",double1/double2);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            
            case "alphabetize":
                System.out.println("Enter two words:");
                try {
                    word1 = scanner.next();
                    word2 = scanner.next();
                    int comparison = word1.toLowerCase().compareTo(word2.toLowerCase());
                    if (comparison>0)
                        System.out.println(word2+" comes before "+word1+" alphabetically.");
                    else if (comparison<0)
                        System.out.println(word1+" comes before "+word2+" alphabetically.");
                    else
                        System.out.println("Chicken or Egg.");

                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;

            default:
                System.out.println("Invalid input entered. Terminating...");
                break;
        }
        scanner.close();
    }
}
