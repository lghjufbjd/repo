import java.awt.*;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {

    public static int lastmoveRow = 0, lastmoveCol = 0;
    public static Scanner read = new Scanner(System.in);

    public static void cls(){
        out.print("\033[H\033[2J");
        out.flush();
    }
    public static Scanner getRead() {
        return read;
    }


    public static void main(String[] args) {
        cls();
        Eq eq = new Eq();
         eq.addItem("basicSword");
        eq.toString();
        //  new Map("drop");
      //  new Map("spawn");
       // eq.toString();
     //  new Map("map");
      //  new Map("controller");

    }
}