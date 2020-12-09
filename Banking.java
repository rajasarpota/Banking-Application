/**
Raj Asarpota 
CS 3300-22729
Final Project: Banking app
 */

import java.util.*;

public class Banking 
{
    //recursive function
    static int factorial(int num) {
        if (num != 0)  
            return num * factorial(num-1);
        else
            return 1;
    }

    public static void main(String args[]) 
    {
        Menu obj = new Menu("Raj Asarpota", "123456");
        obj.showMenu();
        
        int number = 5;
        int result = factorial(number);
        System.out.println("Check out this cool recursive factorial function while you're at it -> " + number + " factorial = " + result);
    }
}

class BankAccount
{
    int balance;
    int previousTransaction;
    String name;
    String ID;
    
    //try-catch function
    void deposit(int amount)
    {
        try{
            if(amount < 0){
                throw new IllegalArgumentException("invalid number");
            }
      
            balance = balance + amount;
            previousTransaction = amount;
        }
       catch(IllegalArgumentException numfEx){
                System.out.println("Type a positive number");     
        }
    }
    
    //try-catch function
    void withdraw(int amount)
    {
         try{
            if(amount < 0){
                throw new IllegalArgumentException("invalid number");
            }
            balance = balance - amount;
            previousTransaction = -amount;
        }
        catch(IllegalArgumentException numfEx){
            System.out.println("Type a positive number");     
        }
    }
    
    void getPreviousTransaction()
    {
        if(previousTransaction > 0)
        {
            System.out.println("Deposited: $" + previousTransaction);
        }
        else if(previousTransaction < 0)
        {
            System.out.println("Withdrawn: $" + Math.abs(previousTransaction));
        }
        else
        {
            System.out.println("No transaction has occured");
        }
    } 
}



class Menu extends BankAccount
{
    Menu(String cname, String cid)
    {
        name = cname;
        ID = cid;
    }
    
    void showMenu()
    {
        char option;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome " + name);
        System.out.println("Your ID is " + ID);
        System.out.println("\n");
        System.out.println("A: Check Balance");
        System.out.println("B: Deposit");
        System.out.println("C: Withdraw");
        System.out.println("D: Previous transaction");
        System.out.println("E: Exit");
        
        //do-while loop
        do
        {
            System.out.println("===================================");
            System.out.println("Enter an option");
            System.out.println("-----------------------------------");
            option = scanner.next().charAt(0);
            System.out.println('\n');
            
            switch(option)
            {
                case 'A':
                    System.out.println("-----------------------------------");
                    System.out.println("Balance = $" + balance);
                    System.out.println("-----------------------------------");
                    System.out.println("\n");
                    break;
                    
                case 'B':
                    System.out.println("-----------------------------------");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("-----------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                    
                case 'C':
                    System.out.println("-----------------------------------");
                    System.out.println("Enter an amount to withdraw:");
                    System.out.println("-----------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                    
                case 'D':
                    System.out.println("-----------------------------------");
                    getPreviousTransaction();
                    System.out.println("-----------------------------------");
                    System.out.println("\n");
                    break;
                    
                case 'E':
                    System.out.println("*******************************");
                    break;
                    
                default:
                    System.out.println("Invalid option. Try again");
                    break;
            }
            
        }while(option != 'E');
        System.out.println("Thanks for banking with us!");
        
    }
}

