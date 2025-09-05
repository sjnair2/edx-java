public class PrimitiveOperations {
    public static void main(String[] args) {
        // Declare and initialize primitive variables
        int intValue = 42;
        double doubleValue = 3.14;
        System.out.println(intValue);
        System.out.println(doubleValue);

        // Perform arithmetic operations
        double product = intValue * doubleValue;
        System.out.println(product);

        float intAsFloat = (float)intValue;
        System.out.println(intAsFloat);

        int doubleAsInt = (int)doubleValue;
        System.out.println(doubleAsInt);

        char upperChar = 'A';
        System.out.println(upperChar);

        char lowerChar = (char)((int)upperChar + 32);
        System.out.println(lowerChar);
    }
}
