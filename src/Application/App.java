package Application;

import entities.Account;
import exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class App {
        public static void main(String[] args)  {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);

                System.out.print("Enter account data: ");
                int number = sc.nextInt();

                System.out.print("Holder : ");
                sc.nextLine();
                String name = sc.nextLine();

                System.out.print("Initial balance: ");
                double balance = sc.nextDouble();
                sc.nextLine();
                System.out.print("Withdraw limit: ");
                double limit = sc.nextDouble();


                Account acc = new Account(number, name, limit, balance);
                System.out.print("\nEnter amount for withdraw: ");
                double amount = sc.nextDouble();
                try{
                    acc.withLimit(amount);
                    System.out.print(acc);
                }
                catch(BusinessException e){
                    System.out.println(e.getMessage());



                }catch (RuntimeException e){
                    System.out.println(e.getMessage());
                }




            sc.close();
        }
    }

