import java.util.Scanner;

public class InputFiveDigitAndFindTheSumOfEachDigit
{

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter whole number to get the Sum of that number : ");
        int num = scanner.nextInt();
        int sum = 0;

        while (num > 0)
        {
            sum = sum + num % 10;
            num = num / 10;
        }
        System.out.println("Sum of the given number is : " +sum );
    }

}
