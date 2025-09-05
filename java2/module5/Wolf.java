public class Wolf extends Canine {

    protected int rank;

    public Wolf(double size, int rank){
        super(size);
        this.rank=rank;
    }

    public int getRank(){
        return this.rank;
    }

    public void bark(){
        for (int i=1; i<=3; i++){
            super.bark();
        }
    }

    public void groom(){}
    
}
