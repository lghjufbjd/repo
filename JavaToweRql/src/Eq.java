import java.util.ArrayList;
public class Eq {
    public static ArrayList<String> eq = new ArrayList();
String output;


    public String toString() {
        for(int i=0;i<eq.size();i++){
            output= output+""+eq.get(i)+"";
        }
        return output;
    }

    Items basicItem=new Items("Test",1,1,1);
    Items basicSword=new Items("Sword",1,2,0);
    public void addItem(String item){
        eq.add(item); }
}
