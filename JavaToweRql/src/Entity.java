public class Entity {
    private int MaxHP;
    private int HP;
    private int MaxMP;
    private int MP;
    private int Level;
    private int Damage;

    //     this.setMaxMP(100);
    //     this.setMP(100);
    //    this.setLevel(1);
    //    this.setDamage(10); //

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

    public int getMP() {
        return MP;
    }

    public void setMP(int mp) {
        this.MP = mp;
    }

    public int getMaxMP() {
        return MaxMP;
    }

    public void setMaxMP(int maxmp) {
        this.MaxMP = maxmp;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        this.Level = level;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        this.Damage = damage;
    }

}