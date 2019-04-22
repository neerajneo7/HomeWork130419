import javax.swing.*;

public class CheckTheNumberIfArmstrongOrNot
{

    public static void main(String[] args)
    {   //Jframe is used to input your number in the frame
        JFrame frame = new JFrame("Title");
        int num = Integer.parseInt(JOptionPane.showInputDialog(frame, "Please enter your number : "));
        //System.out.println("Your Chosen Number : " + num);

        int inputArmstrongNumber = num; //Input number to check armstrong
        int tempNumber , digit, digitCubeSum = 0;

        tempNumber = inputArmstrongNumber;
        while (tempNumber != 0)
        {

            // On each iteration, remainder is powered by the tempNumber of digits n

            System.out.println("Current Number is "+tempNumber);
            digit =tempNumber % 10;
            System.out.println("Current Digit is "+digit);
            //sum of cubes of each digits is equal to the tempNumber itself
            digitCubeSum = digitCubeSum + digit*digit*digit;
            System.out.println("Current digitCubeSum is "+digitCubeSum);
            tempNumber /= 10;

        }

        //check giventempNumber and digitCubeSum is equal to or not
        if(digitCubeSum == inputArmstrongNumber) {
            System.out.println(inputArmstrongNumber + " is an Armstrong Number");
        }else
        {
            System.out.println(inputArmstrongNumber + " is not an Armstrong Number");

        }

    }


}
