import java.util.Scanner;

public class Magic_Square {
    //Create Variables
    private int N;
    private int[][] twoD_arr;
    private int xindex;
    private int yindex;
    //Initialize Object
    public Magic_Square(int n){
        setN(n);
        setArraySize(n);
        setValues(n);
    }
    //Sets the size of the array and fills each value with 0
    public void setArraySize(int N){
        twoD_arr = new int[N][N];
        for (int x = 0; x < getN(); x++)
            for (int y = 0; y < getN(); y++)
                twoD_arr[x][y] = 0;
    }
    //Gets what the XIndex will be if changed to check if it will roll over or not
    public int getChangeXIndex(int changeBy){
        int x = getXIndex();
        if (x + changeBy == -1) { x = (getN() - 1);}
        else if (x + changeBy == getN()){ x = 0; }
        else x = x + changeBy;
        return x;
    }
    //Gets what the YIndex will be if changed to check if it will roll over or not
    public int getChangeYIndex(int changeBy){
        int y = getYindex();
        if (y + changeBy == -1) { y = (getN() - 1);}
        else if (y + changeBy == getN()){ y = 0; }
        else y = y + changeBy;
        return y;
    }
    //Prints out the Magic Square
    public void printSquare() {
        for (int x = 0; x < twoD_arr.length; x++) {
            System.out.println();
            for (int y = 0; y < twoD_arr[x].length; y++)
                System.out.print(twoD_arr[x][y] + " ");
        }
    }
    //Returns the current Xindex
    public int getXIndex(){
        return xindex;
    }
    //Returns the current Yindex
    public int getYindex(){
        return yindex;
    }
    //Changes the Xindex by an incroment specified
    public void changeXindex(int changeBy){
        int x = getXIndex();
        if (x + changeBy == -1){ xindex = (getN() - 1); }
        else if (x + changeBy == getN()){ xindex = 0; }
        else xindex = x + changeBy;
    }
    //Changes the Yindex by an incroment specified
    public void changeYindex(int changeBy){
        int y = getYindex();
        if (y + changeBy == -1){ yindex = (getN() - 1); }
        else if (y + changeBy == getN()){ yindex = 0; }
        else yindex = y + changeBy;
    }
    //Sets a value within the square when given its coordinates and the value to insert
    public void setArrayValue(int xindex, int yindex, int insert){
        twoD_arr[xindex][yindex] = insert;
    }
    //Gets a value within the square when given its coordinates
    public int getArrayValue(int xindex,int yindex){
        return twoD_arr[xindex][yindex];
    }
    //Generates the magic square by setting all the values within the square to those of which make it magic
    public void setValues(int N){
        xindex = 0;
        yindex = ((getN()+1)/2)-1;
        setArrayValue(xindex,yindex,1);
        for (int i = 2; i < getN() * getN() + 1; i++) {
            if (getArrayValue(getChangeXIndex(-1),getChangeYIndex(-1)) == 0) {
                changeXindex(-1);
                changeYindex(-1);
            }
            else {
                changeXindex(1);
            }
            setArrayValue(getXIndex(),getYindex(),i);
        }
    }
    //Returns the size of the square
    public int getN(){
        return N;
    }
    //Returns the array/Square
    public int[][] getArray(){
        return twoD_arr;
    }
    //Directly sets the Xindex, but doesnt check for rollover
    public void setXindex(int x){
        xindex = x;
    }
    //Directly sets the Yindex, but doesnt check for rollover
    public void setYindex(int y) { yindex = y; }
    //Sets the Size of the Square
    public void setN(int userinp){
        N = userinp;
    }
}
