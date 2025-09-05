public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species;

    public static void main(String[] args) {
        Frog myFrog = new Frog("harry",1.5,5.0);
        System.out.println(myFrog);

    }

    public Frog(String name, int age, double tongueSpeed){
        this.name=name;
        this.age=age;
        this.tongueSpeed=tongueSpeed;
        if (age>=1 && age <7)
            this.isFroglet = true;
        else
            this.isFroglet = false;
    }
    public Frog(String name, double ageInYears, double tongueSpeed){
        this(name,(int)(ageInYears*12),tongueSpeed);
    }
    public Frog(String name){
        this(name,5,5.0);
    }
    public String toString(){
        if (this.isFroglet){
            return String.format("My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f",this.name, this.age, this.tongueSpeed);
        }
        return String.format("My name is %s and I'm a rare frog. I'm %d months old and my tongue has a speed of %.2f.",this.name, this.age, this.tongueSpeed);
    }
}
