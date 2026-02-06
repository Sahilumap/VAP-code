
import java.util.ArrayList;;
public class arraylistdemo {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("amit");
        name.add("priya");
        name.add("rahul");
        
        //adding my friends names in arraylist
        System.out.println("after adding 3 names:" + name);
        System.out.println("size :" + name.size());
        
        //adding rohan name at index 1
        name.add(1, "rohan");
        System.out.println("after adding rohan at index 1:" + name);
        
        //removing the name of priya from arraylist
        name.remove("priya");
        System.out.println("after removing priya:" + name);

        //getting the element at index 0 
        System.out.println("element at index 0:" + name.get(0));

        //setting name at index 0 to ankit
        name.set(0, "ankit");
        System.out.println("after setting index 0 to ankit:" + name);

        //removing the element at index 2
        name.remove(2);
        System.out.println("after removing element at index 2:" + name);

        // final arraylist after all the operations
        System.out.println("final ArrayList:" + name);
        name.clear();
        

    
    }
}