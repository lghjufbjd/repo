import static java.lang.System.out;

public class Menu {
    public static ANSIcolors color = new ANSIcolors();

    private static String name = "";

    public Menu() {
    }

    public Menu(String choose) {
        if (choose.equals("main")) menustartup();
    }

    public static String getName() {
        return name;
    }

    public static void menustartup() {
        out.println("┌─────────" + color.PURPLE() + "Menu" + color.RESET() + "─────────┐");
        out.println("│ 1.Start Game         │");
        out.println("│ 2.Exit               │");
        out.println("│                      │");
        out.println("│                      │");
        out.println("│                      │");
        out.println("└─────────" + color.PURPLE() + "Menu" + color.RESET() + "─────────┘");
        String startup = Main.getRead().nextLine();
        switch (startup) {
            case "1":
                Main.cls();
                out.println(color.PURPLE() + "How you want to be called?" + color.RESET());
                name = Main.getRead().nextLine();
                Character.player.setName(name);
                Main.cls();
                out.println("┌─────────" + color.PURPLE() + "Menu" + color.RESET() + "─────────┐");
                out.println("│ 1.Warior             │");
                out.println("│ 2.Ranger             │");
                out.println("│ 3.LOCKED             │");
                out.println("│ 4.LOCKED             │");
                out.println("│    " + color.CYAN() + "»Choose class«" + color.RESET() + "    " + color.RESET() + "│");
                out.println("└─────────" + color.PURPLE() + "Menu" + color.RESET() + "─────────┘");
                String readclass = Main.getRead().nextLine();
                Character.player = Character.chooseClass(readclass);
                Enemy.enemy = Enemy.chooseEnemy(1);
                Main.cls();
                Map map = new Map();
                map.map(); //spawn
                new Map("controler");
                break;
        }

    }
}







