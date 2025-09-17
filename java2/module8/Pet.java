package java2.module8;

public abstract class Pet {
    private String name;
    private double health;
    private int painLevel;

    public Pet(String name, double health, int painLevel){
        if (health>1.0) this.health=1.0;
        else if (health<0.0) this.health=0.0;
        else this.health = health;

        if (painLevel>10) this.painLevel=10;
        else if (painLevel<1) this.painLevel=1;
        else this.painLevel=painLevel;

        this.name=name;
    }

    public String getName() {
        return name;
    }
    public double getHealth() {
        return health;
    }
    public int getPainLevel() {
        return painLevel;
    }

    public abstract int treat();

    public void speak(){
        String text = "Hello! My name is "+name;
        if (getPainLevel()>5){
            text = text.toUpperCase();
        }
        System.out.println(text);
    }

    public boolean equals(Object o){
        if (o instanceof Pet){
            Pet other = (Pet) o;
            return this.getName().equals(other.getName());
        }
        return false;
    }

    protected void heal(){
        health=1.0;
        painLevel=1;
    }
}
