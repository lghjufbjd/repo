import java.util.Random;

public class Enemy extends Entity {
    public static Enemy enemy;
    private int HP;
    private int MaxHP;
    private int strength;

    public static Enemy chooseEnemy(int enemy) {
        Monster rat = new Monster("rat", 20, 1);
        Monster zombie = new Monster("zombie", 40, 1);
        Monster dragon = new Monster("Dragon", 100, 2,true);

        String s = String.valueOf(enemy);
        String char_type = s;
        switch (char_type) {
            case "1": {
                Monster.setName("rat");
                return rat;
            }
            case "2": {
                Monster.setName("Zombie");
                return zombie;
            }
            case "3":
            { Monster.setName("Dragon");
                return dragon;
            }
            default:
                System.out.println("Error that play doesnt exist!");
        }
        return null;
    }
    String name="example name";
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

    ;

    @Override
    public String toString() {
        return name;
    }

    public boolean isAlive() {
        int hp = Enemy.enemy.getHealth();
        if (hp > 0) {
            return true;
        } else {
            return false;
        }

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
        System.out.printf("  %s hit %s for %d hp (%s)\n", player.getName(), enemy, attackStrength,
                getStatus());
        if (hp == 0) {
            player.setGold(player.getGold() + 10);
            System.out.println("  " + Character.player.getName() + " defeat " + enemy
                    + " and get 10 pices of gold\n You have already" + player.getGold());


        }

    }
}
