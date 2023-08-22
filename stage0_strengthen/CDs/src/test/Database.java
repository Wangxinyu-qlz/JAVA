package test;
import java.util.ArrayList;

public class Database {
//  泛型类：Items:类型 ListItem:
    private ArrayList<Items> ListItem = new ArrayList<Items>();

    public void add(Items items){
        ListItem.add(items);
    }

    public void list(){
        for ( Items item : ListItem ){
            item.print();
        }
    }

    public static void main(String[] args){
        Database cd = new Database();
        cd.add(new CDC("爱", "小虎队", 1, 1, "经典"));
        cd.list();
    }
}
