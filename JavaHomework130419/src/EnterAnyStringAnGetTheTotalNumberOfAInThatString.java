import java.util.Scanner;

public class EnterAnyStringAnGetTheTotalNumberOfAInThatString
{

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        System.out.println (" Please Enter Any String " );
        String sn = scanner.next ();
        int count = 0;

        for (int i = 0; i<sn.length ();i++)
        {
        if (sn.charAt (i)=='a')
        {
            count++;
        }
        }
        System.out.println ("Number of 'a' in string"+ "'"+"is ="+count );
    }



}

