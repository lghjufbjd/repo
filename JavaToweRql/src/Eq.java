import java.util.ArrayList;

public class Eq {
    public static ArrayList<Items> eq = new ArrayList();
    String output = "";
    Items basicItem = new Items("Test", "1", "1", "1");
    Items basicSword = new Items("Sword", "1", "2", "1");

    public String toString() {
        for (int i = 0; i < eq.size(); i++) {
            output = output + "" + eq.get(i) + "";
        }
        return output;
    }

    public void addItem(String item) {
        switch (item){
            case "Sword":   eq.add(basicSword);break;
            case "Test":   eq.add(basicItem);break;
        }

    }
}
