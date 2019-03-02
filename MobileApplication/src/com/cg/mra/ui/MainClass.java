package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.MobileNumberNotFoundException;
import com.cg.mra.exception.MobileNumerNotValidException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		AccountService service=new AccountServiceImpl();


		while(true) {
			System.out.println("1.Account Balance Enquiry");
			System.out.println("2. Recharge Account");
			System.out.println("3.Exit");

			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter your mobile number");
				String mobileNo=sc.next();
				Account acc;
				try {
					acc = service.getAccountDetails(mobileNo);
					System.out.println("Account Balance: "+acc.getAccountBalance());
				}
				catch(MobileNumerNotValidException ae) {
					System.out.println(ae.getMessage());
				}
				catch (MobileNumberNotFoundException e) {
				  System.out.println(e.getMessage());
				}
				break;

			case 2:
				System.out.println("Enter your mobile number");
				String mobileNo1=sc.next();
				System.out.println("Enter the amount");
				double rechargeAmount=sc.nextDouble();
				double balance1=service.rechargeAccount(mobileNo1,rechargeAmount);
				System.out.println("Recharge Done: "+balance1);
				break;

			case 3:
				System.out.println("Exit");
				System.exit(0);

			}
		}
	}
}