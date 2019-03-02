package com.cg.mra.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.mra.beans.Account;

public class AccountDaoImpl implements AccountDao{
Map<String,Account>accountEntry;

public AccountDaoImpl() {
	accountEntry=new HashMap<>();
	accountEntry.put("9010210131", new Account("Prepaid","Vaishali",200));
	accountEntry.put("9823920123", new Account("Prepaid","Megha",453));
	accountEntry.put("9932012345", new Account("Prepaid","Vikas",200));
	accountEntry.put("9010200132", new Account("Prepaid","Anju",200));
	accountEntry.put("9010200133", new Account("Prepaid","Tushar",200));
	}

	@Override
	public Account getAccountDetails(String mobileNo) {
	Account acc=accountEntry.get(mobileNo);
	return acc;
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) {
	Account acc=accountEntry.get(mobileNo);
	double balance=acc.getAccountBalance();
	double balance1=rechargeAmount+balance;
	acc.setAccountBalance(balance1);
	accountEntry.put(mobileNo, acc);
	return balance1;
	}

}
