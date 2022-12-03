import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;


public class Main{
    public static void main(String[] args){
        try {
            Collection<Integer> listOfCalories = new LinkedList<Integer>();
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
            int maxCalories=0;
            int actualCalories=0;
            for(Integer i: listOfCalories){
                if(i!=emptyLine) {
                    actualCalories+=i;
                }
                else{
                    if(actualCalories>maxCalories){
                        maxCalories=actualCalories;
                    }
                    actualCalories=0;
                }
            }
            System.out.println("The elf with the most calories has: "+maxCalories+" calories.");

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("The input does not respect the format");
        }
    }
}