public class Fly {
    private double mass;
    private double speed;

    public static void main(String[] args) {
        Fly myFly = new Fly(20);
        myFly.grow(20);
        System.out.println(myFly);
    }

    public Fly(double mass, double speed){
        this.mass=mass;
        this.speed=speed;
    }
    public Fly(double mass){
        this(mass, 10.0);
    }
    public Fly(){
        this(5.0, 10.0);
    }

    public double getMass(){
        return this.mass;
    }
    public double getSpeed(){
        return this.speed;
    }
    public void setMass(double mass){
        this.mass=mass;
    }
    public void setSpeed(double speed){
        this.speed=speed;
    }
    public String toString(){
        if (this.mass==0.0)
            return String.format("I'm dead, but I used to be a fly with a speed of %.2f",this.speed);
        return String.format("I'm a speedy fly with %.2f speed and %.2f mass.",this.speed, this.mass);

    }
    
    public void grow(int growth){
        if (this.mass<20){
            if (growth > 20-this.mass){
                this.speed += 20-this.mass;
                this.speed -= (growth-(20-this.mass))/2.0;
            }
            if (growth <= 20-this.mass)
                this.speed += growth;
        }
        else
            this.speed -= growth/2.0;
        this.mass+=growth;
    }
}
