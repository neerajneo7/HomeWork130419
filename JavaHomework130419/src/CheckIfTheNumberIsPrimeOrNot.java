
import java.util.Scanner;

public class CheckIfTheNumberIsPrimeOrNot
{

    public static void main(String[] args)
{

    //If number is divisible from 2 to one less than that number,
    // then the number is not prime number otherwise it will be a prime number.
    int num, i, count=0;
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter a Number : ");
    num = scan.nextInt();

    for(i=2; i<num; i++)
    {
        if(num%i == 0)
        {
            count++;
            break;
        }
    }
    if(count == 0)
    {
        System.out.print("This is a Prime Number");
    }
    else
    {
        System.out.print("This is not a Prime Number");
    }
    }
}
