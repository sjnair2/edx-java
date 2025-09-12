package java2.module8;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) {
        String inputFileName = args[0];
        String outputfileName = args[1];
        String word = args[2];

        File fileIn = new File(inputFileName);
        File fileOut = new File(outputfileName);

        Scanner fileScan = null;
        PrintWriter filePrint = null;

        try {
            fileScan = new Scanner(fileIn);
            filePrint = new PrintWriter(fileOut);

            int lineCount = 0;
            filePrint.println("Lines in "+inputFileName+" containing "+word+":");
            while (fileScan.hasNextLine()){
                String line = fileScan.nextLine();
                if (line.contains(word)){
                    filePrint.println(lineCount + ": "+line);
                }
                lineCount++;
            }
        }
        catch (FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }
        finally {
            if (fileScan != null)
                fileScan.close();
            if (filePrint != null)
                filePrint.close();
        }
    }
}
