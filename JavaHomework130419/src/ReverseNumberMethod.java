import java.util.Scanner;

public class ReverseNumberMethod
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter at least 2 digit number : ");
        int num = sc.nextInt();
        int reversedNumber = 0;
        int temp = 0;

        while(num != 0) {
            temp = num % 10;
            reversedNumber = reversedNumber * 10 + temp;
            num /= 10;
        }

        System.out.println("Reversed Number is : " + reversedNumber);
    }
}

