//This is a fun little project to calculate
//the exponantially increasing number of stitches
//in a hyperbolic crochet project
//where in each row, you add increases at a constant ratio

import java.util.Scanner;
import java.util.HashMap;

public class HyperbolicCrochet {
    public static int print(String output){
        System.out.println(output);
        return 0;
    }
    //fun little thing to throw in here and there
    //to make the program look like it is thinking
    public static void sleep(int timeMilli){
        try {
            Thread.sleep(timeMilli);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    //more fun with sleep() to convince the user that 
    //the computer is really crunching those numbers
    public static void animatedElipses(int delayMilli){
        for (int i = 0; i < 4; i++){
            sleep(delayMilli);
            System.out.print(".");
        }
        print("\n");
    }
    


    //consider adding function to calculate yards/meters of yarn
    //would need to add functionality for different size yarn
    //maybe defining varibales for the length of a single crochet for each size, like float worsted = 5.0
    //then a length function, takes total stiches and yarn size as parameters and outputs length of yarn
    //could also split up the length into skiens, using a predefined skein amount, and output
    //sonmething like "this project will be three and a half skiens of worsted yarn (750m)"
    //skiens would need more data because different weight yarn have differing skien lengths
    public static void main(String[] args){

        //values of the hook hashmap are the keys foe the yarn hashmap
        HashMap <String, Double> yarnLength = new HashMap<String, Double>();//string is hook size in mm, double is inches of yarn
        yarnLength.put("2.75", 1.00);
        yarnLength.put("3.50", 1.5);
        yarnLength.put("5.00", 1.8);
        yarnLength.put("6.00", 2.5);
        yarnLength.put("8.00", 2.75);
        HashMap <Integer, String> hookChoice = new HashMap<Integer, String>();
        hookChoice.put(1,"2.75");
        hookChoice.put(2,"3.50");
        hookChoice.put(3,"5.00");
        hookChoice.put(4,"6.00");
        hookChoice.put(5,"8.00");
        String again = "y";
        String userhookChoice;
        String anotherRow;
        Scanner userInput = new Scanner(System.in);
        int currentRow;
        int totalRows;
        int base;
        int currentRowCount;
        int ratio;
        int totalStitches;


        while (again.equals("y")){
            currentRow = 1;

            print("Choose your yarn:\n1. 2.75mm\n2. 3.50mm\n3. 5.0mm\n4. 6.00mm\n5. 8.00mm");
            userhookChoice = userInput.nextLine();

            //user can choose hook size which then checks 
            //a hashmap of a hashmap to find the corresponding yarn
            Double test = yarnLength.get(hookChoice.get(Integer.parseInt(userhookChoice)));
            print("no way this works "+test);
            
            print("\nHow many total rows?");
            totalRows = Integer.parseInt(userInput.nextLine());

            print("\nBase row stitch length: ");
            base = Integer.parseInt(userInput.nextLine());
            currentRowCount = base;

            print("\nChoose a constant increase ratio: ");
            ratio = Integer.parseInt(userInput.nextLine());
            print("\n");
            totalStitches = 0;

            System.out.print("\nCalculating");
            animatedElipses(1000);


            while (currentRow <= totalRows){
                sleep(50);
                
                print("Row "+currentRow+": "+currentRowCount+" stitches");
                //adding each row's stitches to the cummulitive total for whole project
                totalStitches += currentRowCount;
                currentRow += 1;
                
                //each row grows exponentially, but it depends on the ratio and base row chosen
                //the total could be calculated with an exponential function (I think it is something like 1+ratio^x),
                //but that wouldn't give each row... I think? unless x was replaced by currentRowCount, 
                //perhaps that would be more elegant
                if (currentRow <= totalRows){
                    currentRowCount += Math.floor(currentRowCount / ratio);
                }
                else{
                    print("\nTotal stitches for this project: "+totalStitches);
                    sleep(50);
                    print("Stitch count of last row is: "+currentRowCount);
                    sleep(50);
                    print("\nWould you like to add another row? y/n");
                    anotherRow = userInput.nextLine();
                    print("\n");
                    if(anotherRow.equals("y")){
                        totalRows += 1;
                        currentRowCount += Math.floor(currentRowCount / ratio);
                        sleep(500);
                        continue;
                    }
                    else{
                        continue;
                    }
                }
                
            }
            print("\nWould you like to calculate again? y/n");
            again = userInput.nextLine();


        }
        userInput.close();
        sleep(1000);
        print("Thanks for using the Hyperbolic Crochet Calculator.\nHave a lovely day.");
        //could save history to a file, like a log file of some sort, maybe using JSON, or just txt
        sleep(3000);
    }
}
