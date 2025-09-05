public class PRT {
    public static void main(String[] args) {
        System.out.println(solvePRT(5));
        System.out.println(solvePRT2(5));

        
    }
    private static int solvePRT(int i){
        if (i==0)
            return 1;
        if (i==1)
            return 3;
        return 3*solvePRT(i-1)+4*solvePRT(i-2);
    }

    private static int solvePRT2(int i){
        if (i==0)
            return 1;
        if (i==1)
            return 3;
        return 13*solvePRT(i-2);
    }
}
