public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    public Frog(String name, int age, double tongueSpeed){
        this.name=name;
        this.age=age;
        this.tongueSpeed=tongueSpeed;
        if (age >= 1 && age < 7){
            isFroglet=true;
        }
        else {
            isFroglet=false;
        }
    }

    public Frog(String name, double ageInYears, double tongueSpeed){
        this(name,(int)(ageInYears*12),tongueSpeed);
    }

    public Frog(String name){
        this(name,5,5.0);
    }

    public void grow(int growth){
        if (age+growth<=12){
            tongueSpeed+=growth;
        }
        else if (age<12 && age+growth>=12 && age+growth<=30){
            tongueSpeed+=12-age;
        }
        else if (age<12 && age+growth>30){
            tongueSpeed+=12-age-(age+growth-30);
        }
        else if (age>=12 && age+growth>30){
            tongueSpeed-=age+growth-30;
        }
        if (tongueSpeed<5){
            tongueSpeed=5;
        }
        age+=growth;
        if (age>=7){
            isFroglet=false;
        }
    }

    public void grow(){
        this.grow(1);
    }

    public void eat(Fly myFly){
        if (myFly.isDead()){
            return;
        }
        boolean isCaught = this.tongueSpeed>myFly.getSpeed();
        if (isCaught){
            if (myFly.getMass()>=0.5*this.age){
                this.grow();
            }
            myFly.setMass(0);
        }
        else if (!isCaught){
            myFly.grow(1);
        }
    }

    public String toString(){
        if (isFroglet){
            return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
        }
        return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
    }

    public static String getSpecies(){
        return species;
    }

    public static void setSpecies(String newSpecies){
        species=newSpecies;
    }

    public static void main(String[] args) {
        
    }
}
