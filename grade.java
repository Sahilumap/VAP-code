import java.util.Scanner ;
public class grade {
    public static void main( String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.println("enter your 1 sub mark:");
        int S1 =sc.nextInt();
         
        System.out.println("enter your 2 sub mark:");
        int S2 = sc.nextInt();
         
        System.out.println("enter your 3 sub mark:");
        int S3 = sc.nextInt();
         
        System.out.println("enter your 4 sub mark:");
        int S4 = sc.nextInt();
         
        System.out.println("enter your 5 sub mark:");
        int S5 = sc.nextInt();
        
        double total = S1 + S2 + S3 + S4 + S5 ;
        
        double perc = (total/500) *100 ;

        if (perc > 90 ){
            System.out.println("O");
        } else if( 80<perc && perc>90){
             System.out.println("A");
        }else if( 70<perc && perc>80){
             System.out.println("B");
             }else if(perc<70){
             System.out.println("F");
             }
             sc.close();

             

        
        


         

    }
}
