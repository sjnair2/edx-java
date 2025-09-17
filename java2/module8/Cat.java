package java2.module8;

public class Cat extends Pet {
    private int miceCaught;

    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) this.miceCaught = 0;
        else this.miceCaught = miceCaught;
    }
    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }
    public int getMiceCaught() {
        return miceCaught;
    }
    public int treat() {
        heal();
        if (getMiceCaught() < 4) {
            return (int)((getPainLevel()*2)/getHealth()) + 1;
        } else if (getMiceCaught() <= 7) {
            return (int)(getPainLevel()/getHealth()) + 1;
        } else {
            return (int)(getPainLevel()/(getHealth()*2)) + 1;
        }
    }
    @Override
    public void speak() {
        super.speak();
        String meows = "";
        for (int i = 0; i < getMiceCaught(); i++) {
            meows += "meow ";
        }
        if (getPainLevel() > 5) {
            meows = meows.toUpperCase();
        }
        System.out.println(meows.trim());
    }
    @Override
    public boolean equals(Object o) { 
        if (o instanceof Cat) {
            Cat other = (Cat) o;
            return super.equals(other) && this.getMiceCaught() == other.getMiceCaught();
        }
        return false;
    }
    
    
}
