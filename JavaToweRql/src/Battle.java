import java.util.Scanner;

public class Battle {
    private static Scanner read = new Scanner(System.in);
    private static ANSIcolors color = new ANSIcolors();

    public Battle() {
    }

    public Battle(Character player, Enemy enemy) {

        System.out.println(color.RED() + "You encounter " + enemy.getName() + ": " + enemy.getDescription() + "\n" + color.RESET());
        System.out.println("Battle with " + enemy.getName() + " starts: ");
        System.out.print(player.getStatus() + " vs");
        System.out.println(enemy.getStatus());
        while (player.isAlive() && enemy.isAlive()) {
            hpBar(1);
            hpBar(2);
            System.out.println();
            System.out.print("\nAttack (a) or use potion (h)? ");
            String action = read.nextLine();
            if (action.equals("h")) {
                if (Eq.eq.contains(Eq.potion)) {
                    if (Character.player.getHealth() < Character.player.getMaxHP() - 20) {
                        player.heal();
                        Eq.eq.remove(Eq.potion);
                    } else System.out.println("you have enough HP points");
                } else System.out.println("u dont have any potions!");

            } else {
                enemy.defend(player);
            }
            if (enemy.isAlive()) {
                player.defend(enemy);

            }
        }


    }

    public void hpBar(int choose) {
        if (choose == 1) {
            double hpproc = (double) Character.player.getHealth() / Character.player.getMaxHP() * 100;
            int i = 0;
            while (i < hpproc / 10) {
                System.out.print(Map.color.RED() + "HP" + Map.color.RESET() + " [");
                for (int j = 0; j < i; j++) {
                    System.out.print("#");
                }
                for (int j = 0; j < 9 - i; j++) {
                    System.out.print(" ");
                }
                System.out.print("] " + Character.player.getHealth());
                if (i < hpproc / 10) {
                    System.out.print("\r");
                }
                i++;

            }
            System.out.println();

        } else if (choose == 2) {
            double hpproc = (double) Enemy.enemy.getHealth() / Enemy.enemy.getMaxHP() * 100;
            int i = 0;
            while (i < hpproc / 10) {
                System.out.print(Map.color.RED() + "HP" + Map.color.RESET() + " [");
                for (int j = 0; j < i; j++) {
                    System.out.print("#");
                }
                for (int j = 0; j < 9 - i; j++) {
                    System.out.print(" ");
                }
                System.out.print("] " + Enemy.enemy.getHealth());
                if (i < hpproc / 10) {
                    System.out.print("\r");
                }
                i++;
            }

        }
    }

}