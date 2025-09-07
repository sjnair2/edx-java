package java2.module6;
import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private String skill;

    public RedAstronaut(String name, int susLevel, String skill){
        super(name, susLevel);
        this.skill=skill.toLowerCase();
    }

    public RedAstronaut(String name){
        this(name,15,"experienced");
    }

    public void emergencyMeeting(){
        if (this.isFrozen()){
            System.out.println("Frozen players cannot call emergency meeting!");
            return;
        }
        Arrays.sort(Player.getPlayers());
        int i=Player.getPlayers().length-1;
        Player votedPlayer = Player.getPlayers()[i];
        while (votedPlayer.isFrozen() || votedPlayer.equals(this)){
            if (i==0){
                System.out.println("No players eligible to be frozen!");
                return;
            }
            i--;
            votedPlayer = Player.getPlayers()[i];
        }
        if (i>0 && votedPlayer.getSusLevel() == Player.getPlayers()[i-1].getSusLevel()){
            System.out.println("No player frozen!");
        }
        System.out.println("Player "+votedPlayer.getName()+" voted out!");
        votedPlayer.setFrozen(true);
        Player.gameOver();
    }

    public void freeze(Player p){
        if (this.isFrozen() || p.isFrozen() || p instanceof Impostor){
            return;
        }
        if (this.getSusLevel() < p.getSusLevel()){
            System.out.println("Player "+p.getName()+" frozen!");
            p.setFrozen(true);
        }
        else {
            this.setSusLevel(this.getSusLevel()*2);
        }
        Player.gameOver();
    }

    public void sabotage(Player p){
        if (this.isFrozen() || p.isFrozen() || p instanceof Impostor){
            return;
        }
        System.out.print("Player "+p.getName()+"'s old SusLevel: "+p.getSusLevel()+". ");
        if (this.getSusLevel()<20){
            p.setSusLevel((int)(p.getSusLevel()*1.5));
        }
        else {
            p.setSusLevel((int)(p.getSusLevel()*1.25));
        }
        System.out.println("Player "+p.getName()+"'s new SusLevel: "+p.getSusLevel()+".");
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut red = (RedAstronaut) o;
            return super.equals(o) && this.getSkill()==red.getSkill();
        }
        return false;
    }

    @Override
    public String toString(){
        String redString=super.toString()+" I am an "+this.getSkill()+" player!";
        if (this.getSusLevel()>15){
            return redString.toUpperCase();
        }
        return redString;
    }

    public String getSkill(){
        return this.skill;
    }
}
