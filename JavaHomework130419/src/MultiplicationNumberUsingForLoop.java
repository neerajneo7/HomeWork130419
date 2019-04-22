import java.util.Scanner;

public class MultiplicationNumberUsingForLoop
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner((System.in));
        System.out.println("Enter a number to get the Multiplication Table : ");
        int num = sc.nextInt();

        System.out.println("Multiplication table for "+num);
        System.out.println("----------------------------");
        for (int i=1; i<=10; i++)
        {
            System.out.println(num + " x " + (i)+ " = " + (num*(i)));
        }
    }

}
