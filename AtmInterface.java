/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atminterface;

import java.util.Scanner;
class BankAccount{
    String name;
    String userName;
    String password;
    String accountNo;
    float balance =100000f;
    int transaction =0;
    String transactionHistory="";
    
//    BankAccount(String name,String userName,String password,String accountNo){
//        this.name=name;
//        this.userName=userName;
//        this.password=password;
//        this.accountNo=accountNo;
//    }

public void register(){
Scanner sc =new Scanner(System.in);
System.out.print("\nEnter your Name-");
this.name=sc.nextLine();
System.out.print("\nEnter your UserName-");
this.userName=sc.nextLine();
System.out.print("\nEnter your Password-");
this.password= sc.nextLine();
System.out.print("\nEnter your Account Number-");
this.accountNo=sc.nextLine();
System.out.println("\nRegistration completed..Kindly login");
}
public boolean login(){
    boolean isLogin=false;
    Scanner sc =new Scanner(System.in);
    while(!isLogin){
        System.out.print("\nEnter your UserName-");
        String Username =sc.nextLine();
        if(Username.equals(userName)){
            while(!isLogin){
                System.out.print("\nEnter youe Password-");
                String Password=sc.nextLine();
                if(Password.equals(password)){
                    System.out.print("\nLogin successful!");
                    isLogin=true;
                }
                else{
                    System.out.println("\nIncorrect Password");
                }
            }
        }
        else{
            System.out.println("Username not Found");
        }
    }
    return isLogin;
}
public void withdraw(){
    System.out.print("\nEnter amount to withdraw-");
    Scanner sc =new Scanner(System.in);
    float amount =sc.nextFloat();
    try{
        if(balance >= amount){
            transaction++;
            balance -= amount;
            System.out.println("\nWithdraw Successfully");
            
            String str =amount+"Rs Withdraw\n";
            transactionHistory=transactionHistory.concat(str);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
    catch(Exception e){
        
    }
}
public void deposit(){
    System.out.print("\nEnter amount to deposit -");
    Scanner sc =new Scanner(System.in);
    float amount =sc.nextFloat();
    
    try{
        if(amount <= 100000f){
            transaction++;
            balance += amount;
            System.out.println("\nSuccessfully Deposited");
            String str =amount+ "Rs deposited\n";
            transactionHistory=transactionHistory.concat(str);
        }
        else {
            System.out.println("\nSorry....Limit is 100000.00");
        }
    }
    catch(Exception e){
        
    }
}
public void transfer(){
    Scanner sc = new Scanner(System.in);
    System.out.print("\nEnter Receipent's Name-");
    String receipent =sc.nextLine();
    System.out.print("\nEnter amount to transfer -");
    float amount =sc.nextFloat();
    
    try{
        if(balance>=amount){
            if(amount<=50000f){
                transaction++;
                balance -=amount;
                System.out.println("\nSuccessfully Transfered to" +receipent);
                String str =amount+ "Rs transfered to"+receipent +"\n";
                transactionHistory=transactionHistory.concat(str);
                
                   
            }
            else{
                System.out.println("\nSorry...Limit is 50000.00");
            }
        }
        else{
            System.out.println("\nInsufficient Balance");
        }
    }
    catch(Exception e){
        
    }
}

public void checkBalance(){
    System.out.println("\n"+balance+"Rs");
}

public void transHistory(){
    if(transaction==0){
        System.out.println("\nEmpty");
    }
    else{
        System.out.println("\n"+transactionHistory);
    }
}
}

public class AtmInterface {

public static int takeIntegerInput(int limit){
    int input =0;
    boolean flag =false;
    while(!flag) {
        try {
            Scanner sc =new Scanner(System.in);
            input =sc.nextInt();
            flag =true;
            if(flag && input >limit || input <1){
                System.out.println("Choose the number between 1 to " +limit);
                flag = false;
            }
        }catch(Exception e){
            System.out.println("Enter only integer value");
            flag =false;
        }
    };
    return input;
}
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Welcome To Pnb Atm System");
        System.out.println("1.Register \n 2.Exit");
        System.out.println("Enter your Choice-");
        int choice =takeIntegerInput(2);
        
        if(choice ==1){
            BankAccount b=new BankAccount();
            b.register();
            
            while(true){
                System.out.println("\n1.Login \n2.Exit");
                System.out.println("Enter your choice-");
                int ch =takeIntegerInput(2);
                if(ch==1){
                    if(b.login()){
                        System.out.println("\n\nWelcome Back"+b.name +"********\n");
                        boolean isFinished =false;
                        while(!isFinished){
                            System.out.println("\n1.Withdraw\n2.Deposit\n3.Transfer\n4.Check Balance\n5.Transaction History\n6.Exit");
                            System.out.println("\nEnter your choice-");
                            int c=takeIntegerInput(6);
                            switch(c){
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4 :
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished=true;
                                    break;
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }                                      
            
        }
        else{
            System.exit(0);
        }
        
        
        
        
        
        
    }
    
}
