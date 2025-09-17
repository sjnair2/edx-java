package java2.module8;

public class Dog extends Pet {
    private double droolRate;

    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        if (droolRate <= 0) this.droolRate = 0.5;
        else this.droolRate = droolRate;
    }

    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }

    public double getDroolRate() {
        return droolRate;
    }

    public int treat() {
        heal();
        if (getDroolRate() < 3.5) {
            return (int)((getPainLevel()*2)/getHealth()) + 1;
        } else if (getDroolRate() <= 7.5) {
            return (int)(getPainLevel()/getHealth()) + 1;
        } else {
            return (int)(getPainLevel()/(getHealth()*2)) + 1;
        }
    }

    @Override
    public void speak() {
        super.speak();
        String barks="";
        for (int i = 0; i<getPainLevel(); i++) {
            barks += "bark ";
        }
        if (getPainLevel() > 5) {
            barks = barks.toUpperCase();
        }
        System.out.println(barks.trim());
    }

    @Override
    public boolean equals(Object o) { 
        if (o instanceof Dog) {
            Dog other = (Dog) o;
            return super.equals(other) && this.getDroolRate() == other.getDroolRate();
        }
        return false;
    }
    
}
