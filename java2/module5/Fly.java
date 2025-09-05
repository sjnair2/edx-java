public class Fly {
    private double mass;
    private double speed;

    public Fly(double mass, double speed){
        this.mass = mass;
        this.speed = speed;
    }

    public Fly(double mass){
        this(mass, 10.0);
    }

    public Fly(){
        this(5.0);
    }

    public double getMass(){
        return this.mass;
    }

    public double getSpeed(){
        return this.speed;
    }

    public void setMass(double mass){
        if (mass>=0){
            this.mass = mass;
        }
    }

    public void setSpeed(double speed){
        if (speed>=0){
            this.speed=mass;
        }
    }

    public String toString(){
        if (mass == 0){
            return "I'm dead, but I used to be a fly with a speed of "+speed+".";
        }
        return "I’m a speedy fly with "+speed+" speed and "+mass+" mass.";
    }

    public void grow(int growth){
        if (mass+growth<=20){
            speed+=growth;
        }
        else if (mass<20 && mass+growth>20){
            speed+=20-mass-0.5*(mass+growth-20);
        }
        else {
            speed-=0.5*growth;
        }
        mass+=growth;
    }

    public boolean isDead(){
        if (mass==0.0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Fly myFly = new Fly();
        System.out.println(myFly);
        myFly.grow(10);
        System.out.println(myFly);
        myFly.grow(10);
        System.out.println(myFly);
        myFly.grow(10);
        System.out.println(myFly);
    }
}
