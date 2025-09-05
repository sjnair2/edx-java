public class FrogTester {
    public static void main(String[] args) {
        // Constructor tests
        Frog f1 = new Frog("Freddy", 5, 6.0);
        System.out.println("Expect name=Freddy age=5 tongue=6.0 froglet=true species=Rare Pepe");
        System.out.println(f1);

        Frog f2 = new Frog("Yoda", 1.5, 4.5); // 1.5 years = 18 months
        System.out.println("Expect age=18 froglet=false");
        System.out.println(f2);

        Frog f3 = new Frog("Baby"); // default constructor
        System.out.println("Expect age=5 tongue=5.0 froglet=true");
        System.out.println(f3);

        // Grow tests
        System.out.println("\n--- Grow tests ---");
        f1.grow(3); // age 5→8, tongue 6→9
        System.out.println("Expect age=8 tongue=9 froglet=false");
        System.out.println(f1);

        Frog oldFrog = new Frog("Oldie", 29, 10.0);
        oldFrog.grow(2); // age 29→31, tongue decreases to 9
        System.out.println("Expect age=31 tongue=9");
        System.out.println(oldFrog);

        f3.grow(); // age 5→6, tongue 5→6
        System.out.println("Expect age=6 tongue=6 froglet=true");
        System.out.println(f3);

        // Eat tests
        System.out.println("\n--- Eat tests ---");
        Frog hunter = new Frog("Hunter", 10, 7.0);
        Fly fly1 = new Fly(10, 5.0);
        hunter.eat(fly1); // caught, ages since 10 >= 0.5*10
        System.out.println("Expect fly mass=0, hunter age=11");
        System.out.println("Fly mass: " + fly1.getMass());
        System.out.println(hunter);

        Frog hunter2 = new Frog("Hunter2", 10, 7.0);
        Fly fly2 = new Fly(3, 5.0);
        hunter2.eat(fly2); // caught, but too small to grow
        System.out.println("Expect fly mass=0, hunter age=10");
        System.out.println("Fly mass: " + fly2.getMass());
        System.out.println(hunter2);

        Frog hunter3 = new Frog("Hunter3", 10, 5.0);
        Fly fly3 = new Fly(4, 10.0); // not caught
        hunter3.eat(fly3);
        System.out.println("Expect fly mass=5 (grows by 1), hunter unchanged");
        System.out.println("Fly mass: " + fly3.getMass() + ", fly speed: " + fly3.getSpeed());
        System.out.println(hunter3);

        Frog eater = new Frog("Lazy", 5, 5.0);
        Fly deadFly = new Fly(0, 5.0); // already dead
        eater.eat(deadFly);
        System.out.println("Expect nothing changes for frog or fly");
        System.out.println("Fly mass: " + deadFly.getMass());
        System.out.println(eater);

        // Species setter/getter
        System.out.println("\n--- Species tests ---");
        Frog.setSpecies("Tree Frog");
        Frog f4 = new Frog("One", 5, 5.0);
        Frog f5 = new Frog("Two", 10, 7.0);
        System.out.println("Expect species=Tree Frog for all frogs");
        System.out.println(f4.getSpecies());
        System.out.println(f5.getSpecies());
        System.out.println(Frog.getSpecies());
    }
}
