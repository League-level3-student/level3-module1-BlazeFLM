package _03_RemovingStuffFromArrayLists;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListRemove {

    class Stuff {
        public String type;
    }
    
    class Worm extends Stuff {
        public Worm() {
            type = "worm";
        }
    }
    
    class Dirt extends Stuff {
        public Dirt() {
            type = "dirt";
        }
    }

    // 1. Write a method that removes the dirt in the yard and returns the
    //    ArrayList
    public static ArrayList<Stuff> cleanOutTheYard( ArrayList<Stuff> yard ) {
    	Iterator<Stuff> i = yard.iterator();
    	while(i.hasNext()) {
    		Stuff item = i.next();
    		if(item instanceof Dirt) {
    			i.remove();
    		}
    	}
    	return yard;
    }
    
    // 2. Write a method that removes the hash tag ('#') characters from the
    //    ArrayList and returns it
    public static ArrayList<Character> removeHashTags(ArrayList<Character> list) {
    	Iterator<Character> i = list.iterator();
    	while(i.hasNext()) {
    		Character item = i.next();
    		if(item.equals('#')) {
    			i.remove();
    		}
    	}
        return list;
    }
}
