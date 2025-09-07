package java2.module6;

import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {

    private int numTasks;
    private int taskSpeed;

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed){
        super(name, susLevel);
        if (numTasks>=0)
            this.numTasks=numTasks;
        if (taskSpeed>0)
            this.taskSpeed=taskSpeed;
        
    }

    public BlueAstronaut(String name){
        this(name, 15, 6, 10);
    }

    public void emergencyMeeting(){
        if (this.isFrozen()){
            System.out.println("Frozen players cannot call emergency meeting!");
            return;
        }
        Arrays.sort(Player.getPlayers());
        int i=Player.getPlayers().length-1;
        Player votedPlayer = Player.getPlayers()[i];
        while (votedPlayer.isFrozen()){
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

    public void completeTask(){
        if (this.isFrozen() || this.getNumTasks()==0){
            return;
        }
        int newNumTasks;
        if (this.getTaskSpeed()>20)
            newNumTasks=this.getNumTasks()-2;
        else 
            newNumTasks=this.getNumTasks()-1;
        
        if (newNumTasks<=0){
            System.out.println("I have completed all my tasks");
            this.setNumTasks(0);
            this.setSusLevel(this.getSusLevel()/2);
        }
        else{
            this.setNumTasks(newNumTasks);
        }
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blue = (BlueAstronaut) o;
            return super.equals(o) && this.getNumTasks()==blue.getNumTasks() && this.getTaskSpeed()==blue.getTaskSpeed();
        }
        return false;
    }

    @Override
    public String toString(){
        String blueString=super.toString()+" I have "+this.getNumTasks()+" left over.";
        if (this.getSusLevel()>15){
            return blueString.toUpperCase();
        }
        return blueString;
    }

    public int getTaskSpeed(){
        return taskSpeed;
    }

    public int getNumTasks(){
        return numTasks;
    }

    public void setNumTasks(int numTasks){
        if (numTasks<0)
            this.numTasks=0;
        else
            this.numTasks=numTasks;
    }
    
}
