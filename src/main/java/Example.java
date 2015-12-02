import java.util.ArrayList;
import java.util.List;

/**
 * Created by me on 30.11.2015.
 */
public class Example {

    public class Stuff{
        int key;
        String string;

        void setKey(int key){
            this.key = key;
        }
        int getKey(){
            return this.key;
        }
        String getString(){
            return this.string;
        }
    }


    private ArrayList<Stuff> arrayList;

    void put(int key, Stuff stuff){
        stuff.setKey(key);
        arrayList.add(stuff);
    }

    String get(int key){
        for(Stuff f : arrayList){
            if(f.getKey()==key){
                return f.getString();
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
