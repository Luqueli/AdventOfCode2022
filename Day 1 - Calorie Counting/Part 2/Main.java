import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;


public class Main<E>{

    private static int [] getTopThree(Collection<Integer> loc, int emptyLine){
        int [] toReturn = new int[]{0, 0, 0};
        int actualCalories=0;
        for(Integer i: loc){
            if(i!=emptyLine){
                actualCalories+=i;
            }
            else{
                if(actualCalories>toReturn[0]){
                    toReturn[2]=toReturn[1];
                    toReturn[1]=toReturn[0];
                    toReturn[0]=actualCalories;
                }
                else{
                    if(actualCalories>toReturn[1]){
                        toReturn[2]=toReturn[1];
                        toReturn[1]=actualCalories;
                    }
                    else{
                        if(actualCalories>toReturn[2]){
                            toReturn[2]=actualCalories;
                        }
                    }
                }
                actualCalories=0;
            }
        }
        return toReturn;
    }
    public static void main(String[] args){
        try {
            Collection<Integer> listOfCalories = new LinkedList<Integer>();
            int [] topThree;
            BufferedReader reader;
            String calories;
            Boolean endInput = false;
            final int emptyLine= -1;



            System.out.println("**Format: Enter one integer at a time, or copy and paste the input with an extra enter at the end.**");
            System.out.println("Enter input (enter 'End' for finish the input):");
            reader = new BufferedReader(new InputStreamReader(System.in));
            while (!endInput) {
                calories = reader.readLine();
                if(!calories.isEmpty()){
                    if(!calories.equals("End")){
                        listOfCalories.add(Integer.parseInt(calories));
                    }
                    else{
                        endInput=true;
                    }
                }
                else{
                    listOfCalories.add(emptyLine);
                }
            }

            topThree = getTopThree(listOfCalories, emptyLine);

            System.out.println("The elves with the most calories has: ");
            System.out.println("1st :"+topThree[0]);
            System.out.println("2st :"+topThree[1]);
            System.out.println("3st :"+topThree[2]);
            int plusTopThree=topThree[0]+topThree[1]+topThree[2];
            System.out.println("Between the three elves they have "+plusTopThree+" calories");

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("The input does not respect the format");
        }
    }


}


