import java.util.ArrayList;

public class students {
    

    
            private int id ;
            private String name;
            private int DOB ;
            private double marks;

            public students (int id, String name, int DOB, double marks){
                this.id = id;
                this.name = name;
                this.DOB = DOB;
                this.marks = marks;
            }
            public int getId(){ return id; }
            public String getName(){ return name; }
            public int getDOB(){ return DOB; }
            public double getMarks(){ return marks; }

            public void display(){
                System.out.printf("%d|%-15s|%d|%.2f\n", id, name, DOB, marks);
            } 
            public static void main(String[] args) {
                ArrayList<students> studentList = new ArrayList<>();
                studentList.add(new students(1, "sahil", 2006, 99.5));
                studentList.add(new students(2, "rohan", 2007, 40.0));
                studentList.add(new students(3, "vedant", 2007, 80.0));
            
            
    
                System.out.println("ID | Name        | DOB | Marks");
                System.out.println("-----------------------------------");
                for (students s : studentList) {
                    s.display();
                }
                System.out.println("\nsearching for id 2:");
                for (students s : studentList) {
                    if (s.getId() == 2) {
                        s.display();
                        
                    }
                }
       

        }
    }


