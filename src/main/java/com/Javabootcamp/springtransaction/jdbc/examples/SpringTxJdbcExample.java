package com.Javabootcamp.springtransaction.jdbc.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class SpringTxJdbcExample {
    public static void main(String[] args) {
            Scanner amounts = new Scanner(System.in);
            System.out.println("how much money do you want to Transfer : ");
            String n = amounts.next();
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            FundManager fundManager = (FundManager) context.getBean("fundTransferTranTemplate");
            try {
                int amount = Integer.parseInt(n);
                printAccountDetails(fundManager);
                fundManager.transfer(1, 2, amount);
                System.out.println("Fund transfered");
                printAccountDetails(fundManager);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            amounts.close();
        }

	private static void printAccountDetails(FundManager fundManager) {
		System.out.println("Account 1 has " + fundManager.getBalance(1) + ", account 2 has " + fundManager.getBalance(2));
	}
}
