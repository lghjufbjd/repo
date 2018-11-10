public class Items {
    private static String name;
    private static int ratity;
    private int HP;
    private int strength;
    public static String getName() {
        return name;
    }
    public Items() {
    }
    public Items(String name, int rarity, int str, int hp) {
        this.name =name;
    this.ratity=  rarity;
     this.HP=str;
        this.strength=str;
    }
    @Override
    public String toString() {
        return "Nazwa: "+name +" statystyki: \n"+ " rarity: "+ratity+" HP= " + HP + ", strength= " + strength;
    }
}