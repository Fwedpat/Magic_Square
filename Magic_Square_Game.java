import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;
public class Magic_Square_Game {
    private Magic_Square Scrambled_Square;

    public Magic_Square_Game(Magic_Square Square) {

        Scrambled_Square = new Magic_Square(Square.getN());
        Scramble(Scrambled_Square);
        Scanner ReadLine = new Scanner(System.in);
        while(Arrays.deepEquals(Scrambled_Square.getArray(), Square.getArray()) != true){
            Scrambled_Square.printSquare();
            boolean correctImp = false;
            String UserInp = "";
            while (correctImp == false) {
                System.out.println("");
                System.out.println("Enter which item you want to swap: ");
                UserInp = ReadLine.nextLine();
                try {
                    String array[] = UserInp.split(" ");
                    int xindex = Integer.parseInt(array[0]) - 1;
                    int yindex = Integer.parseInt(array[1]) - 1;
                    String Direction = array[2];
                    Swap(xindex, yindex, Direction);
                    correctImp = true;
                }
                catch (Exception e){
                    System.out.println("Swap by entering in the format 'i j Direction' e.g. '1 1 U'.");
                }
            }
        }
        System.out.println("Congratulations, you win!");
    }


    public void Swap(int xindex, int yindex, String Dir){
        Scrambled_Square.setXindex(xindex);
        Scrambled_Square.setYindex(yindex);
        String Direction = Dir;
        if (Direction.equals("D")){
            int TempStoreSwap = Scrambled_Square.getArrayValue(Scrambled_Square.getChangeXIndex(1), yindex);
            Scrambled_Square.setArrayValue(Scrambled_Square.getChangeXIndex(1),yindex, Scrambled_Square.getArrayValue(xindex,yindex));
            Scrambled_Square.setArrayValue(xindex,yindex, TempStoreSwap);
        }
        if (Direction.equals("U")){
            int TempStoreSwap = Scrambled_Square.getArrayValue(Scrambled_Square.getChangeXIndex(-1), yindex);
            Scrambled_Square.setArrayValue(Scrambled_Square.getChangeXIndex(-1),yindex, Scrambled_Square.getArrayValue(xindex,yindex));
            Scrambled_Square.setArrayValue(xindex,yindex, TempStoreSwap);
        }
        if (Direction.equals("L")){
            int TempStoreSwap = Scrambled_Square.getArrayValue(xindex, Scrambled_Square.getChangeYIndex(-1));
            Scrambled_Square.setArrayValue(xindex, Scrambled_Square.getChangeYIndex(-1), Scrambled_Square.getArrayValue(xindex,yindex));
            Scrambled_Square.setArrayValue(xindex,yindex, TempStoreSwap);
        }
        if (Direction.equals("R")){
            int TempStoreSwap = Scrambled_Square.getArrayValue(xindex, Scrambled_Square.getChangeYIndex(1));
            Scrambled_Square.setArrayValue(xindex, Scrambled_Square.getChangeYIndex(1), Scrambled_Square.getArrayValue(xindex,yindex));
            Scrambled_Square.setArrayValue(xindex,yindex, TempStoreSwap);
        }
    }

    public void Scramble(Magic_Square Scrambled_Square){
        Random rand = new Random();
        int xindex = 0;
        int yindex = 0;
        for (int x = 0; x < Scrambled_Square.getN() * Scrambled_Square.getN(); x++) {
            xindex = rand.nextInt((Scrambled_Square.getN() - 1) + 1) + 0;
            yindex = rand.nextInt((Scrambled_Square.getN() - 1) + 1) + 0;
            String Direction = RandomDirection();
            Swap(xindex, yindex, Direction);
        }
    }
    public String RandomDirection(){
        String[] DirectionArray = {"U", "D", "L", "R"};
        Random rand = new Random();
        return DirectionArray[rand.nextInt((3-1) + 1) + 0];
    }

}