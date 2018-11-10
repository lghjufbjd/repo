public class Monster extends Enemy {
    private static String name;

    public Monster(String name, int hp, int str) {

        this.name = name;
        this.setHealth(hp);
        this.setMaxHP(hp);
        this.setStrength(str);

    }

    public Monster(String name, int hp, int str, boolean isBoss) {
        if (isBoss == true) {
            name = "d";
            this.setHealth(hp);
            this.setMaxHP(hp);
            this.setStrength(str);
        }

    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Monster.name = name;
    }

}