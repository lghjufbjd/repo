import java.util.Random;
import java.util.Scanner;

public class Battle {
    public static Scanner read = new Scanner(System.in); //obiekt do odebrania danych od użytkownika
    public static ANSIcolors color =new ANSIcolors();

    public Battle(Character player, Enemy enemy) {

        System.out.println(color.RED()+"You encounter " + Enemy.enemy + ": " + enemy.getDescription() + "\n"+color.RESET());
        System.out.println("Battle with " + Enemy.enemy + " starts: ");
        System.out.print(player.getStatus());
        System.out.print(enemy.getStatus());
        while (player.isAlive() && enemy.isAlive()) {
            System.out.print("\nAttack (a) or use potion (h)? ");
            String action = read.nextLine();
            if (action.equals("h")) {
                player.heal();
            } else {
                enemy.defend(player);
            }
            if (enemy.isAlive()) {
                player.defend(enemy);
            }
        }

    }

}