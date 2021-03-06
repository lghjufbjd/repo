import java.util.Random;

public class Character extends Entity {

    public static Character player;
    Battle battle = new Battle();
    private String name;
    private int EXP; // experience points
    private int gold; // player money
    private double critChance; // critical chance
    private int strength; // attack damage
    private int defense; // reduce taken damage
    private int dexterity; // accuracy only for bow and spells
    private int intelligence; // spell damage
    private int evasion; // dodge attacks
    private int lvl = 1; // lvl
    private int exp = 100; // exp
    // armor parts
    private String helmet;
    private String chest;
    private String boots;

    public static Character chooseClass(String readclass) {
        String char_type = readclass;
        switch (char_type) {
            case "1":
                return new Warior();
            case "2":
                return new Ranger();
            default:
                System.out.println("Error that play doesnt exist!");
        }
        return null;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    @Override
    public String toString() {
        return name;
    }



    public int getEXP() {
        return EXP;
    }
    public String getStats() {
                return player.toString()+": {" +
                "EXP=" + EXP +
                ", level='" + lvl +
                ", gold=" + gold +
                ", critChance=" + critChance +
                ", strength=" + strength +
                ", defense=" + defense +
                ", dexterity=" + dexterity +
                ", intelligence=" + intelligence +
                ", evasion=" + evasion +
                ", helmet='" + helmet + '\'' +
                ", chest='" + chest + '\'' +
                ", boots='" + boots + '\'' +
                '}';
    }

    public void setEXP(int exp) {
        this.EXP = exp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(int crit) {
        this.critChance = crit;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int str) {
        this.strength = str;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int def) {
        this.defense = def;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dex) {
        this.dexterity = dex;
    }

    public int getIntelligence() {
        return intelligence;
    }


    public void setIntelligence(int inte) {
        this.intelligence = inte;
    }

    public boolean isAlive() {
        int hp = Character.player.getHealth();
        return hp > 0;
    }

    public String getStatus() {
        //   System.out.println("Defence: "+getDefense()+" Critchance: "+getCritChance()+" Dex:"+getDexterity()+" Evasion: "+getEvasion()+" Exp: "+getEXP()+" Gold: "+getGold()+" Intelligence:"+getIntelligence()+" Strenght: "+getStrength()+" HP:"+getHealth()+"/"+getMaxHP());
        // System.out.println();

        //   System.out.println(" vs: ");
        String starus = " HP:" + getHealth() + "/" + getMaxHP();
        return starus;
    }

    public int getEvasion() {
        return evasion;
    }

    public void setEvasion(int eva) {
    }

    public void checkLevel(int playerExp, int playerLevel, Character a) {

        int[] levelArray = {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1200, 1400, 1600, 1800, 2000, 2200,
                2400, 2600, 2800, 3000, 3500, 4000, 4500, 5000, 5500, 6000, 6500, 7000, 7500, 8000}; // 30

        if (playerExp >= levelArray[playerLevel]) {
            // level up player
            if (playerExp >= levelArray[playerLevel + 1]) {
                a.setEXP(levelArray[playerLevel]);
            } else {
                System.out.println(Map.color.YELLOW() + "Level up!" + Map.color.RESET());
                a.setLevel(playerLevel + 1);
            }
        }
        this.lvl = playerLevel;
        this.exp = playerExp;

    }

    public void heal() {
        int hp = getHealth();
        hp = hp + 10;
        player.setHealth(hp);
    }

    public int attack() {
        Random rand = new Random();
        return rand.nextInt(Character.player.getDamage() * Character.player.getStrength() + 1) / 2;
    }

    public void defend(Enemy enemy) {
        int attackStrength = enemy.attack();
        int hp = (player.getHealth() > attackStrength) ? player.getHealth() - attackStrength : 0;
        Character.player.setHealth(hp);
        System.out.printf("  " + getName() + " is hit for %d HP of damage (%s)\n", attackStrength, getStatus());
        if (hp == 0) {
            System.out.println("  " + getName() + " has been defeated");
        }
    }

}
