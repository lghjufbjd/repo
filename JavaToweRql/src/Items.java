public class Items {
    private static String name;
    private static String ratity;
    private static String HP;
    private static String strength;

    public Items() {
    }

    public Items(String name, String rarity, String str, String HP) {
        this.name = name;
        this.ratity = rarity;
        this.HP = HP;
        this.strength = str;
    }

    public static String getName() {
        return name;
    }

    public static String getRatity() {
        return ratity;
    }

    public static void setName(String name) {
        Items.name = name;
    }

    public static void setRatity(String ratity) {
        Items.ratity = ratity;
    }

    public static void setHP(String HP) {
        Items.HP = HP;
    }

    public static void setStrength(String strength) {
        Items.strength = strength;
    }

    public static String getHP() {
        return HP;
    }

    public static String getStrength() {
        return strength;
    }

    public String toString() {
        return "Nazwa: " + name + "\nstatystyki:" + "\n* rarity:" + ratity + "\n* HP:" + HP + "\n* strength:" + strength;
    }
}