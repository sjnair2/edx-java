public class Dog extends Canine {

    protected String name;

    public Dog(String name, double size){
        super(size);
        this.name=name;
    }

    public void fetch(){
        System.out.println("Run");
        System.out.println("Clinch");
        System.out.println("Return");
    }

    public void groom(){}
    
    public boolean equals(Object o){
        if (!(o instanceof Dog)){
            return false;
        }
        Dog doggy = (Dog) o;
        return ((doggy.size==this.size) && (doggy.name.equals(this.name)));
    }
}
