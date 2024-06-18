package chegg;

import java.io.*;
import java.util.*;

public class TestScores {

    Integer[] validScores = new Integer[50];
    int validScoresSize = 0;
    Integer[] inValidScores = new Integer[50];
    int inValidScoresSize = 0;

    public void getInput(){
        try {
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter the name of the input file: ");
            String fileName = sc.nextLine();
            String path = "/Users/kapilchoudhary/IdeaProjects/HelloWorld/src/resources/".concat(fileName);

            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String scoreString;

            while ((scoreString = br.readLine()) != null) {
                int score = Integer.parseInt(scoreString);

                if (score <= 100 && score >= 0)
                    validScores[validScoresSize++] = score;
                else
                    inValidScores[inValidScoresSize++] = score;
            }
            fr.close();
            br.close();

            /*FileWriter fw = new FileWriter(f1);
            BufferedWriter out = new BufferedWriter(fw);
            for(String s : lines) {
                out.write(s);
                out.newLine();
            }
            out.flush();
            out.close();*/

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void printScores(Integer[] scores){
        for (int i=0; i < scores.length; i = i + 5){
            if (scores[i] != null) {
                System.out.println(scores[i] + "   " + scores[i + 1] + "   " + scores[i + 2]
                        + "   " + scores[i + 3] + "   " + scores[i + 4] + "\n");
            }
            else
                break;
        }
    }

    public void printHighestLowestAvgScore(){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i=0; i < validScoresSize; i++){
            sum += validScores[i];
            max = validScores[i] > max ? validScores[i] : max;
            min = validScores[i] < min ? validScores[i] : min;
        }

        System.out.println("Highest Score is: " + max);
        System.out.println("Lowest Score is: " + min);
        System.out.println("Average Score is: " + (float)sum/validScoresSize);
    }

    public void sortValidScores(){
        Arrays.sort(validScores, 0, validScoresSize);
        System.out.println("Sorted Good Scores: ");
        printScores(validScores);
    }

    public static void main(String[] args){
        TestScores testScores = new TestScores();
        testScores.getInput();
        testScores.printScores(testScores.validScores);
        testScores.printScores(testScores.inValidScores);
        testScores.printHighestLowestAvgScore();
        testScores.sortValidScores();

        try {
            PrintStream out = new PrintStream(
                    new FileOutputStream(
                            "/Users/kapilchoudhary/IdeaProjects/HelloWorld/src/resources/outputFile.txt", true));
            System.setOut(out);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
