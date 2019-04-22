import java.util.Scanner;

public class FibonacciSeriesOfNTerms
{
    public static void main(String[] args)
    {
// In the below program, first (t1) and second (t2) terms are initialized to first two terms of the Fibonacci series 0 and 1 respectively.
// Then, for loop iterates to n (number of terms) displaying the sum of previous two terms stored in variable t1.



        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for n : ");
        int n = sc.nextInt();
        int t1 = 0, t2 = 1;
        System.out.print("First " + n + " terms: ");

        for (int i = 1; i <= n; ++i)
        {
            System.out.print(t1 + " + ");

            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }
    }
}
