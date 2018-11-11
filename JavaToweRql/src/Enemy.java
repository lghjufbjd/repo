import java.util.Random;

public class Enemy extends Entity {
    public static Enemy enemy;

    public String name = "example name";
    Battle battle = new Battle();
    private int HP;
    private int MaxHP;
    private int strength;
    public static Monster rat = new Monster("rat", 20, 1);
    public static Monster zombie = new Monster("zombie", 40, 1);
    public static Monster dragon = new Monster("Dragon", 100, 2, true);
    public static Enemy chooseEnemy(int enemy) {


        String s = String.valueOf(enemy);
        String char_type = s;
        switch (char_type) {
            case "1": {

                return rat;
            }
            case "2": {
                return zombie;
            }
            case "3": {
                return dragon;
            }
            default:
                System.out.println("Error wrong enemy");
        }
        return null;
    }

    public String getName() {
        if (enemy == rat)
            return "rat";
        else if (enemy == zombie)
            return "zombie";
        else if (enemy == dragon)
            return "dragon";
        return null;
    }

    public int getHealth() {
        return HP;
    }

    public void setHealth(int hp) {
        this.HP = hp;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    public void setMaxHP(int maxhp) {
        this.MaxHP = maxhp;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int str) {
        this.strength = str;
    }


    public boolean isAlive() {
        int hp = Enemy.enemy.getHealth();
        return hp > 0;

    }

    String getDescription() {
        return "";
    }

    public String getStatus() {
        //System.out.println("Strenght:"+getStrength()+" HP:"+getHealth()+"/"+getMaxHP());
        String status = " HP:" + getHealth() + "/" + getMaxHP();
        return status;
    }

    public int attack() {
        Random rand = new Random();
        return rand.nextInt(Enemy.enemy.getStrength() + 1);
    }

    public void defend(Character player) {
        int attackStrength = player.attack();
        int hp = (getHealth() > attackStrength) ? getHealth() - attackStrength : 0;
        Enemy.enemy.setHealth(hp);
        System.out.printf("  %s hit %s for %d hp (%s)\n", player.getName(), enemy.getName(), attackStrength, getStatus());
        if (hp == 0) {
            player.setGold(player.getGold() + 10);
            System.out.println("  " + Character.player.getName() + " defeat " + enemy.getName() + " and get 10 pices of gold\n You have already: " + player.getGold());
            if (Enemy.enemy.getName().equals("dragon")) {
                player.setEXP(player.getEXP() + 100);
            } else {
                player.setEXP(player.getEXP() + 50);
            }
            player.checkLevel(Character.player.getEXP(), Character.player.getLevel(), Character.player);
            System.out.println("click any key to continue");
            Main.getRead().nextLine();

        }

    }
}
