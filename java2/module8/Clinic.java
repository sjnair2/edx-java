package java2.module8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalTime;

public class Clinic {
    private File patientFile;
    private int day;

    public Clinic(File patientFile) {
        this.patientFile = patientFile;
        this.day = 1;
    }

    public Clinic(String filename){
        this(new File("java2/module8",filename));
    }

    public String nextDay(File f) throws FileNotFoundException {
        String dayOutput = "";
        try (
            Scanner consoleScanner = new Scanner(System.in);
            Scanner fileScanner = new Scanner(f)
        ) {
            while (fileScanner.hasNextLine()) {

                //parse line from file
                String line = fileScanner.nextLine();
                String[] fields = line.split(",");
                String name = fields[0];
                String type = fields[1];
                if (type == null || (!type.toLowerCase().equals("cat") && !type.toLowerCase().equals("dog"))) {
                    throw new InvalidPetException("Invalid pet type: " + type);
                }
                String attribute = fields[2];
                double attributeNum = Double.parseDouble(fields[2]);
                int time = Integer.parseInt(fields[3]);
                LocalTime entryTime = LocalTime.of(time / 100, time % 100);

                //get health and pain level from user
                double health = 0.0;
                int painLevel = 0;
                boolean success = false;
                while (!success) {
                    try {
                        System.out.printf("Consultation for %s the %s at %s.\nWhat is the health of %s?\n", name, type, entryTime, name);
                        health = consoleScanner.nextDouble();
                        success = true;
                    } catch (InputMismatchException e) {
                        consoleScanner.nextLine(); // Clear the invalid input
                        System.out.println("Invalid input for health. Please enter a number between 0.0 and 1.0.");
                    }
                }
                success = false;
                while (!success) {
                    try {
                        System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
                        painLevel = consoleScanner.nextInt();
                        success = true;
                    } catch (InputMismatchException e) {
                        consoleScanner.nextLine(); // Clear the invalid input
                        System.out.println("Invalid input for pain level. Please enter an integer between 1 and 10.");
                    }
                }
                
                //create pet, have it speak, treat it, and record appointment info
                LocalTime exitTime = entryTime; 
                int treatmentTime;
                if (type.toLowerCase().equals("cat")) {
                    Cat cat = new Cat(name, health, painLevel, (int)attributeNum);
                    cat.speak();
                    treatmentTime = cat.treat();
                    exitTime = entryTime.plusMinutes(treatmentTime);
                } else if (type.toLowerCase().equals("dog")) {
                    Dog dog = new Dog(name, health, painLevel, attributeNum);
                    dog.speak();
                    treatmentTime = dog.treat();
                    exitTime = entryTime.plusMinutes(treatmentTime);
                }
                dayOutput += String.format("%s,%s,%s,Day %d,%d,%d,%.1f,%d\n",name,type,attribute,day,entryTime.getHour()*100+entryTime.getMinute(),exitTime.getHour()*100+exitTime.getMinute(),health,painLevel);
            }
        }
        day++;
        return dayOutput.trim();
    }

    public String nextDay(String filename) throws FileNotFoundException {
        return nextDay(new File("java2/module8",filename));
    }

    public boolean addToFile(String patientInfo){
        // Read existing lines from the file
        ArrayList<String> lines = new ArrayList<>();
        try (Scanner scanner = new Scanner(patientFile)) {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Patient file not found: " + e.getMessage());
        }

        // Check if patient already exists and update or add new entry
        String[] newPatientFields = patientInfo.split(",");
        String newName = newPatientFields[0];
        boolean exists = false;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).startsWith(newName + ",")) {
                for (int j = 3; j < newPatientFields.length; j++) {
                    lines.set(i, lines.get(i) + "," + newPatientFields[j]);
                }
                exists = true;
                break;
            }
        }
        if (!exists) {
            lines.add(patientInfo);
        }

        // Write updated lines back to the file
        try (PrintWriter writer = new PrintWriter(patientFile)) {
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
            }
            return true;
        } catch (IOException e) {
            System.err.println("Error writing to patient file: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        Clinic clinic = new Clinic("Patients.csv");
        clinic.addToFile("Pillow,Cat,5,Day 1,1839,1841,0.4,7");
    }
}
