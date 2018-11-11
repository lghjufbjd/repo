import java.util.Random;

import static java.lang.System.out;

public class Map {
    public static ANSIcolors color = new ANSIcolors();
    private static int lastmoveRow = 0, lastmoveCol = 0;
    //0          1        2         3        4        5            / private static String[] state = new String[]{"|____|","█████", "|_ME_|"+color.RESET(),color.RED()+ "|_!!_|"+color.RESET(), color.PURPLE()+"|_BS_|"+color.RESET(), color.YELLOW()+"|_¿¿_|"+color.RESET()};
    private static String[] state = new String[]{"|____|", "█████", "|_" + color.BLUE() + "ME" + color.RESET() + "_|", "|_" + color.RED() + "!!" + color.RESET() + "_|", "|_" + color.PURPLE() + "BS" + color.RESET() + "_|", "|_" + color.YELLOW() + "¿¿" + color.RESET() + "_|"};

    private static String[][] roomStates = new String[][]{
            {state[0], state[0], state[0], state[0]},
            {state[3], state[0], state[0], state[0]},
            {state[0], state[0], state[0], state[0]},
            {state[0], state[0], state[0], state[0]},
            {state[0], state[0], state[0], state[0]},
            {state[0], state[0], state[0], state[0]},
            {state[0], state[0], state[0], state[0]}
    };

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
            case "spawn":
                roomStates[0][0] = state[2];
                break;
            case "controller":
                contoller();
                break;
        }
    }

    private static void drawmap(int row, int col) {
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
        }
    }

    public static void map() {
        int row = 0;
        while (row != 7) {
            for (int col = 0; col <= 4; col++) {
                {
                    drawmap(row, col);
                }
            }
            row++;
        }
    }

    private void moveto(int row, int col) {
        Main.cls();
        roomStates[row][col] = state[2];
    }

    private void checkEvent() {
        if (roomStates[lastmoveRow][lastmoveCol].equals(state[3])) {
            Random r = new Random();
            Enemy.enemy = Enemy.chooseEnemy((Math.abs(r.nextInt()) % 2) + 1);
            Enemy.enemy.setHealth(Enemy.enemy.getMaxHP());
            moveto(lastmoveRow, lastmoveCol);
            map();
            new Battle(Character.player, Enemy.enemy);
        } else if (roomStates[lastmoveRow][lastmoveCol].equals(state[4]) ) {
            Random r = new Random();
            Enemy.enemy = Enemy.chooseEnemy(3);
            Enemy.enemy.setHealth(Enemy.enemy.getMaxHP());
            moveto(lastmoveRow, lastmoveCol);
            map();
             new Battle(Character.player, Enemy.enemy);

        } else if (roomStates[lastmoveRow][lastmoveCol].equals(state[5]) ) {
            Random r = new Random();
            Eq eq = new Eq();
            eq.addItem("sword");
            moveto(lastmoveRow, lastmoveCol);
            map();
        }
    }

    private void moveTemplate(String direction) {
        int row = lastmoveRow, col = lastmoveCol;
        switch (direction) {
            case "up":
                row = lastmoveRow - 1;
                break;
            case "down":
                row = lastmoveRow + 1;
                break;
            case "right":
                col = lastmoveCol + 1;
                break;
            case "left":
                col = lastmoveCol - 1;
                break;
        }
        roomStates[lastmoveRow][lastmoveCol] = state[0];
        lastmoveRow = row;
        lastmoveCol = col;
        checkEvent();
        moveto(lastmoveRow, lastmoveCol);
        map();
    }

    private void move(String move) {
        String wallErr = color.RED() + "you came to the wall\n" + color.RESET();
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


    private void contoller() {
        while (true) {
            out.println("\n" + "Where do you want to do?\n5.Show eq\n6.Show stats\n\n" + "           1⇧" + "\n         2⇦   3⇨" + "\n           4⇩");
            String choice = Main.getRead().nextLine();
            if (choice.equals("5")){
                Eq eq=new Eq();
                System.out.println(eq.toString());
            }else if (choice.equals("6")){System.out.println(Character.player.getStats());}
            move(choice);
        }
    }

    private void dropeventstemplate(String type, int rndTo) {
        Random r = new Random();
        int whenemy = 1, whtsure = 1, whnxfrl = 1, wh = 0;
        String tp = "";
        switch (type) {
            case "enemy":
                tp = state[3];
                wh = whenemy;
                break;
            case "tsure":
                tp = state[5];
                wh = whtsure;
                break;
            case "nxflr":
                tp = state[4];
                wh = whnxfrl;
                break;
        }
        while (wh <= rndTo) {
            int rndRow = Math.abs(r.nextInt()) % 7;
            int rndCol = Math.abs(r.nextInt()) % 4;
            if (!roomStates[rndRow][rndCol].equals(state[2])) {
                roomStates[rndRow][rndCol] = tp;
                wh++;
            }
            switch (type) {
                case "enemy":
                    whenemy++;
                    break;
                case "tsure":
                    whtsure++;
                    break;
                case "nxflr":
                    whnxfrl++;
                    break;
            }
        }
    }

    private void dropEvents() {
        dropeventstemplate("enemy", 4);
        dropeventstemplate("tsure", 2);
        dropeventstemplate("nxflr", 1);
    }
}
