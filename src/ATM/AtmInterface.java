package ATM;


import java.util.*;
public class AtmInterface
{
	static void ATMUI(Scanner obj,int balance,int AccountNo) {
        do{   
            System.out.println("\n" + "Choose 1 for Deposit");
            System.out.println("Choose 2 for withdrawl");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for EXIT");
            System.out.println("\n" + "Choose the Operation" +"\n");
            int Operation = obj.nextInt();
            System.out.println();
                
            switch(Operation)
            {
              case 1: 
                 System.out.println("Enter Money to be deposited");
                 int DepositMoney= obj.nextInt();
                 if (DepositMoney >0 && DepositMoney !=0)
                 {
                   balance=Integer.parseInt(FindCustomerValues.select(AccountNo));
                   balance += DepositMoney;
                   InsertCustomerdetails.insert(balance,AccountNo);
                   System.out.println("Your Money has been successfully Deposited :" + balance); 
                   System.out.println("Your Account Balance is :" + balance);
                 }
                 else
                 {
                    System.out.println("Error occour please try again later");

                 }
              break;
              
              case 2: 
              System.out.println("Enter Money to Withdraw");
              int WithdrawMoney=obj.nextInt();
              balance=Integer.parseInt(FindCustomerValues.select(AccountNo));
              if(WithdrawMoney <= balance && WithdrawMoney >0  &&  WithdrawMoney !=0)
              {
                 balance -= WithdrawMoney;
                 UpdateCustomerbalance.Update(AccountNo, balance);
                 System.out.println("Ammount Withdraw Successfully" + "\n" + "Please Collect Your Cash...");
                 System.out.println("Your Account Balance is :" + balance);
              }   
              else 
              {
                 if(WithdrawMoney > balance)
                 {
                 System.out.println("Insufficient Balance");
                 }
                 if (WithdrawMoney <0  ||  WithdrawMoney ==0)
                 {
                    System.out.println("Invalid input");
                 }

              }
              break;

              case 3:
              balance=Integer.parseInt(FindCustomerValues.select(AccountNo));
              System.out.println("Balance :" + balance);
            
              break;

              case 4:
              System.out.println("Thank You for Using ATM");
               
              System.exit(0);
            }
        }
        while(true);	
	
	}
public static void main(String args[])
{
    Scanner obj=new Scanner(System.in);
    int balance=0;
    //System.out.println("your Balance is : " + balance);
    System.out.println("\n" + "======================");
    System.out.println("WELCOME TO ATM MACHINE");
    System.out.println("======================" + "\n");
    
    System.out.println("Enter your Account No.");
    int AccountNo=obj.nextInt();

    if(GetAccountDetails.getDetail(AccountNo)) {
    	AtmInterface.ATMUI(obj,balance,AccountNo);
    }else {
    	System.out.println("Invalid Account Number");
        System.out.println("Enter your Account No.");
        AccountNo=obj.nextInt();
    	AtmInterface.ATMUI(obj,balance,AccountNo);
    }

}
}
	