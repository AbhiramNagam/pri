package exp12;

import java.util.Scanner;

class EnterCorrectAge extends Exception{
    public EnterCorrectAge(String s) {
        super(s);
    }
}
class check{
    public static void isEligible(int age)  {
        if(age>=18){
            System.out.println("Eligible to vote.");
        }
        else {
            throw new ArithmeticException("Not Eligible to Vote.");
        }
    }
    static void validateage (int age) throws EnterCorrectAge{
    }
}

public class Main {
    public static void main(String[] args){
        check ch= new check();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age : ");
        int age=sc.nextInt();
        try{
            ch.validateage(age);
        }
        catch (Exception EnterCorrectAge ){
            System.out.println("your age is not sufficient.");
        }
        ch.isEligible(age);
    }
}
