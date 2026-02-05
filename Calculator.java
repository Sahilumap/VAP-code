import java.util.Scanner;
 public class Calculator{
    public static void main (String[] args){
         Scanner reader =new Scanner(System.in);

         System.out.println("enter first num:");
         double num1=reader.nextDouble();
         
         System.out.println("enter the operator(+,-,*,/");
         char operator = reader.next().charAt(0);

          System.out.println("enter second num:");
           double num2=reader.nextDouble();
           
           
           double result=0;

           switch (operator) {
            case '+':
                result = num1 + num2;
                break;

            case '-':
                result = num1 - num2;
                break;
                
            case '*':
                result = num1 * num2;
                break;
                
                case '/':
                result = num1 / num2;
                break; 
           }

              
            System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
            reader.close();
           }



    }
        



        
        
        