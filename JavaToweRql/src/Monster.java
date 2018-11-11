 class Monster extends Enemy {
    public Monster(String name, int hp, int str) {

        this.name = name;
        this.setHealth(hp);
        this.setMaxHP(hp);
        this.setStrength(str);

    }


    public Monster(String name, int hp, int str, boolean isBoss) {
        if (isBoss) {
            this.setHealth(hp);
            this.setMaxHP(hp);
            this.setStrength(str);
        }
    }
}