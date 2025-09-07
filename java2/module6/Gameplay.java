package java2.module6;

public class Gameplay {
    public static void main(String[] args) {
        // --- Create Players ---
        RedAstronaut red1 = new RedAstronaut("RedOne", 10, "experienced");
        RedAstronaut red2 = new RedAstronaut("RedTwo", 25, "expert");
        BlueAstronaut blue1 = new BlueAstronaut("BlueOne", 15, 6, 10);
        BlueAstronaut blue2 = new BlueAstronaut("BlueTwo", 20, 2, 30);
        BlueAstronaut blue3 = new BlueAstronaut("BlueThree"); // uses defaults

        // --- Basic toString ---
        System.out.println("--- toString Tests ---");
        System.out.println(red1);   // should be normal case
        System.out.println(red2);   // susLevel > 15 → all caps
        System.out.println(blue1);  
        System.out.println(blue2);  
        System.out.println(blue3);  

        // --- Equality Tests ---
        System.out.println("\n--- equals Tests ---");
        BlueAstronaut blueCopy = new BlueAstronaut("BlueOne", 15, 6, 10);
        System.out.println("blue1 equals blueCopy? " + blue1.equals(blueCopy)); // true
        System.out.println("blue1 equals blue2? " + blue1.equals(blue2));       // false

        // --- CompareTo Tests ---
        System.out.println("\n--- compareTo Tests ---");
        System.out.println("blue1 vs blue2: " + blue1.compareTo(blue2)); // should be negative (15 < 20)
        System.out.println("red2 vs red1: " + red2.compareTo(red1));     // should be positive (25 > 10)

        // --- completeTask Tests ---
        System.out.println("\n--- completeTask Tests ---");
        blue1.completeTask(); // taskSpeed=10 → subtract 1
        System.out.println(blue1); // numTasks should decrease to 5
        blue2.completeTask(); // taskSpeed=30 → subtract 2
        System.out.println(blue2); // numTasks should decrease from 2 to 0, print task completion msg & sus drop

        // --- sabotage Tests ---
        System.out.println("\n--- sabotage Tests ---");
        red1.sabotage(blue1); // red1 susLevel=10 (<20) → +50% sus
        System.out.println(blue1);
        red2.sabotage(blue3); // red2 susLevel=25 (>=20) → +25% sus
        System.out.println(blue3);

        // --- freeze Tests ---
        System.out.println("\n--- freeze Tests ---");
        red1.freeze(blue1); // susLevel(10) < target’s susLevel → success
        System.out.println(blue1); // should now be frozen
        red1.freeze(blue2); // try again with already frozen target → no effect
        red2.freeze(red1);  // cannot freeze another impostor → no effect

        // --- emergencyMeeting Tests ---
        System.out.println("\n--- emergencyMeeting Tests ---");
        blue3.emergencyMeeting(); // should freeze the most sus unfrozen player
        for (Player p : Player.getPlayers()) {
            System.out.println(p);
        }
    }
}

