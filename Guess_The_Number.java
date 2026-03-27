import java.util.Scanner;

public class Guess_The_Number 
{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) 
    {
        
        boolean is_try_again = true;
        while(is_try_again) 
        {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100");
            int num = (int)(Math.random() * 100)+1;
            System.out.println("Please select the difficulty level:\n1. Easy (10 chances)\n2. Medium (5 chances)\n3. Hard (3 chances)");
            int choice = sc.nextInt();
            while(choice<1 || choice>3)
            {
               System.out.print("Please choose a correct difficulty level: "); 
               choice = sc.nextInt(); 
            }
            switch (choice) 
            {
                case 1:
                    Mode(num,10);
                break;
                case 2:
                    Mode(num,5);
                break;
                case 3:
                    Mode(num,3);
                break;
            }
            System.out.print("Enter 1 to play again, 0 to exit: ");
            int try_again = sc.nextInt();
            while(try_again>1 || try_again<0)
            {
                System.out.print("Please enter 1 (play again) or 0 (exit): ");
                try_again = sc.nextInt();
            }
            is_try_again = (try_again==1);
        }
        System.out.println("Thanks for playing! See you soon");
        sc.close();      
    }
    public static void Mode(int num,int attempts)
    { 
        String difficulty;
        switch (attempts) 
        {
            case 3:
                difficulty = "Hard";
                break;
            case 5:
                difficulty = "Medium";
                break;
            default:
                difficulty= "Easy";
                break;
        }
        System.out.println("Great! You have selected the "+difficulty+" difficulty level\nYou have "+attempts+" chances to guess the correct number\nLet's start the game!");
        int count = 0;
        while (count<attempts) 
        {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            if(guess<=0 || guess>100)
            {
                System.out.println("Please choose the number between 1-100 only");
                continue;
            }
            count++;
            if(guess==num)
            {
                System.out.println("Congratulations! You guessed the correct number in "+count+" attempts.");
                return;
            }
            else
            {
                if(guess>num)
                    System.out.println("Incorrect! The number is less than "+guess+"\nremaining attempts: "+(attempts-count) );
                else
                    System.out.println("Incorrect! The number is greater than "+guess+"\nremaining attempts: "+(attempts-count));
            }
            
        }
        System.out.println("You have reached the attempt limit \nThe correct number was: "+num);
    }
}


    
