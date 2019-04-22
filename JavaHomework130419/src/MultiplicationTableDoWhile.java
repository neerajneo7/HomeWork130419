import java.util.Scanner;

public class MultiplicationTableDoWhile
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter whole number to get the Multiplication Table : ");
        int num = sc.nextInt();
        int i=1;
        System.out.println("Multiplication Table for "+num);
        System.out.println("----------------------------");
        do {

            System.out.println(num + " x " + i + " = " + (num*i));
            i++;

        }while( i<=10);



    }


}
