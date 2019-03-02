package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.MobileNumberNotFoundException;
import com.cg.mra.exception.MobileNumerNotValidException;

public class AccountServiceImpl implements AccountService{
	AccountDao dao=new AccountDaoImpl();
	@Override
	public Account getAccountDetails(String mobileNo) throws MobileNumberNotFoundException, MobileNumerNotValidException {
		Account detail=dao.getAccountDetails(mobileNo);
		if(mobileNo.length()<10)
			throw new MobileNumerNotValidException("Mobile number entered is not valid");
		if (detail==null)
			throw new MobileNumberNotFoundException("Mobile number does not exist");
		return detail;
	
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) {
	return dao.rechargeAccount(mobileNo,rechargeAmount);
	}
}

