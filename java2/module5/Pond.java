public class Pond {
    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw",4.6,5);
        Frog peepee = new Frog("Peepee");

        Fly fly1 = new Fly(1.0, 3.0);
        Fly fly2 = new Fly(6.0);
        Fly fly3 = new Fly();

        Frog.setSpecies("1331Frogs");
        System.out.println(peepo);
        peepo.eat(fly2);
        System.out.println(fly2);
        peepo.grow(8);
        peepo.eat(fly2);
        System.out.println(fly2);
        System.out.println(peepo);
        System.out.println(peepee);
        peepaw.grow(4);
        System.out.println(peepaw);
        System.out.println(pepe);
        
    }
}
