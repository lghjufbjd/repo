import java.util.Random;

import static java.lang.System.out;

public class Map {
    private static int lastmoveRow = 0, lastmoveCol = 0;
    public static ANSIcolors color =new ANSIcolors();
                                                  //0          1        2         3        4        5
    private static String[] state = new String[]{"|____|", "█████", "|_ME_|", "|_!!_|","|_BS_|","|_¿¿_|"};
    
    private static String[][] roomStates = new String[][]{
            {state[0], state[0], state[0], state[0]},
            {state[3], state[0], state[0], state[0]},
            {state[0], state[0], state[0], state[0]},
            {state[0], state[0], state[0], state[0]},
            {state[0], state[0], state[0], state[0]},
            {state[0], state[0], state[0], state[0]},
            {state[0], state[0], state[0], state[0]}
    };
    private  void moveto(int row, int col) {
        Main.cls();
        roomStates[row][col] = state[2];
    }

    private  void checkEvent() {
        if (roomStates[lastmoveRow][lastmoveCol] == state[3]) {
               Enemy.enemy.setHealth(Enemy.enemy.getMaxHP());
            moveto(lastmoveRow, lastmoveCol);
            map();
             Battle battle = new Battle(Character.player, Enemy.enemy);
        }
        else if (roomStates[lastmoveRow][lastmoveCol] == state[4]) {
            Random r = new Random();
            Enemy.enemy = Enemy.chooseEnemy(3);
            Enemy.enemy.setHealth(Enemy.enemy.getMaxHP());
            moveto(lastmoveRow, lastmoveCol);
            map();
            Battle battle = new Battle(Character.player, Enemy.enemy);
            Enemy.enemy = Enemy.chooseEnemy(Math.abs(r.nextInt()) % 1);
        }
        else if (roomStates[lastmoveRow][lastmoveCol] == state[5]) {
            Random r = new Random();
            Eq eq = new Eq();
            eq.addItem("basicSword");
            out.println("You got a nice looking sword");

            moveto(lastmoveRow, lastmoveCol);
            map();
        }
    }

    private  void moveTemplate(String direction) {
        int row = lastmoveRow, col = lastmoveCol;

        if (direction.equals("up")) row = lastmoveRow - 1;
        else if (direction.equals("down")) row = lastmoveRow + 1;
        else if (direction.equals("right")) col = lastmoveCol + 1;
        else if (direction.equals("left")) col = lastmoveCol - 1;
        roomStates[lastmoveRow][lastmoveCol] = state[0];
        lastmoveRow = row;
        lastmoveCol = col;
        checkEvent();
        moveto(lastmoveRow, lastmoveCol);
        map();
    }

    private  void move(String move) {
        String wallErr = color.RED() + "trafiłeś na ściane" + color.RESET();
        switch (move) {
            case "1":
                if (lastmoveRow != 0) {
                    moveTemplate("up");
                } else
                    out.println(wallErr);
                break;
            case "2":
                if (lastmoveCol != 0) {
                    moveTemplate("left");
                } else
                    out.println(wallErr);
                break;
            case "3":
                if (lastmoveCol != 3) {
                    moveTemplate("right");
                } else
                    out.println(wallErr);

                break;
            case "4":
                if (lastmoveRow != 6) {
                    moveTemplate("down");
                } else
                    out.println(wallErr);
                break;
        }
    }
    private static void drawmapTemplate(int row, int col) {
        switch (col) {
            case 1:
                out.print(roomStates[row][0]);
                break;
            case 2:
                out.print(roomStates[row][1]);
                break;
            case 3:
                out.print(roomStates[row][2]);
                break;
            case 4:
                out.println(roomStates[row][3]);
                break;
        }}
    private static void drawmap ( int row,int col)
        {
            switch (row) {
                case 1://row1
                    drawmapTemplate(row, col);
                    out.print("1");

                case 2://row2
                    drawmapTemplate(row, col);
                    out.print("2");

                case 3://row3
                    drawmapTemplate(row, col);
                    out.print("3");

                case 4://row4
                    drawmapTemplate(row, col);
                    out.print("4");

                case 5://row5
                    drawmapTemplate(row, col);
                    out.print("5");

                case 6://row6
                    drawmapTemplate(row, col);
                    out.print("6");

                case 7://row7
                    drawmapTemplate(row, col);
                    out.print("7");

            }
        }
        private void contoler () {
            while (true) {
                out.println("Gdzie chcesz się ruszyć?\n\n" + "           1⇧" + "\n         2⇦   3⇨" + "\n           4⇩");
                String choice = Main.getRead().nextLine();
                move(choice);
            }
        }

    public Map() {
    }

    public Map(String choose) {
        switch (choose) {
            case "map":
                map();
                break;
                case "drop":
                    dropEvents();
                    break;
                    case "spawn"://row3
                         roomStates[0][0] = state[2];
                        break;
                        case "controller":
                        contoler();
                            break;
        }

    }
   private static void mapTemplate(int row)
    {

        drawmapTemplate(row,0);
        drawmapTemplate(row,1);
        drawmapTemplate(row,2);
        drawmapTemplate(row,3);
        drawmapTemplate(row,4);
    }

    public static void map () {
        int row=0;
      while (row!=7)
      {
          mapTemplate(row);
          row++;
      }



        }

        private void dropeventstemplate (String type,int rndTo)
        {
            Random r = new Random();
            int whenemy = 1, whtsure = 1, whnxfrl = 1, wh = 0;
            String tp = "";
            if (type.equals("enemy")) {
                tp= state[3];
                wh = whenemy;
            } else if (type.equals("tsure")) {
                tp= state[5];
                wh = whtsure;
            } else if (type.equals("nxflr")) {
                tp= state[4];
                wh = whnxfrl;
            }

            while (wh <= rndTo) {
                int rndRow = Math.abs(r.nextInt()) % 7;
                int rndCol = Math.abs(r.nextInt()) % 4;
                if (roomStates[rndRow][rndCol] != state[2]) {
                    roomStates[rndRow][rndCol] = tp;
                    wh++;
                }
                if (type.equals("enemy"))
                    whenemy++;
                else if (type.equals("tsure"))
                    whtsure++;
                else if (type.equals("nxflr"))
                    whnxfrl++;
            }
        }
        private void dropEvents () {
            dropeventstemplate("enemy", 4);
            dropeventstemplate("tsure", 2);
            dropeventstemplate("nxflr", 1);
        }
    }