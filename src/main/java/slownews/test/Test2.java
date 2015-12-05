package slownews.test;

import java.util.ArrayList;

/**
 * Created by Dmytro.Palets on 30.11.2015.
 */
public class Test2 {

    ArrayList myList = new ArrayList<>();


    public static void main(String[] args) {



    }

    public void put (Object key, Object value) {

        myList.add(key);
        myList.add(value);

    }


    public Object getValue (Object key) {

        for (int i = 0; i < myList.size(); i+=2) {
            if (myList.get(i) == key) {
                return myList.get(i+1);
            }
        }

        return null;

    }
}
