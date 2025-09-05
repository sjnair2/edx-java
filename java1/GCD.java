public class GCD {
    public static void main(String[] args) {
        System.out.println(findGCD(1482, 819));
    }

    public static int findGCD(int x, int y){
        if (y==0)
            return x;
        return findGCD(y, x%y);
    }
}
