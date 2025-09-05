import java.util.Scanner;
public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Farenheit value: ");
        int fValue = input.nextInt();
        double cValue = (5.0/9) * (fValue-32);
        System.out.println("Celsius: "+cValue);
    }
}
