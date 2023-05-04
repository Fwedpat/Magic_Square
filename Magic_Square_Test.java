import java.util.Arrays;
import java.util.Scanner;

public class Magic_Square_Test {


    public static void main(String[] args) {
        String UserInp = "";
        boolean correctImp = false;
        Scanner ReadLine = new Scanner(System.in);
        while (correctImp == false) {
            System.out.println("");
            System.out.println("Enter an odd number, to create a magic square of that size:");
            UserInp = ReadLine.nextLine();
            try {
                if (Integer.parseInt(UserInp) % 2 == 1) {
                    correctImp = true;
                }
            }
            catch(Exception e){
                System.out.println("Incorrect input, Please enter an odd number.");
            }

        }
        Magic_Square No1 = new Magic_Square(Integer.parseInt(UserInp));
        System.out.println("");
        Magic_Square_Game Game = new Magic_Square_Game(No1);
    }
}

