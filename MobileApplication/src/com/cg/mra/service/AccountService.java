package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.MobileNumberNotFoundException;
import com.cg.mra.exception.MobileNumerNotValidException;

public interface AccountService {
	Account getAccountDetails(String mobileNo)  
			throws MobileNumberNotFoundException, MobileNumerNotValidException ;
	double rechargeAccount(String mobileNo,double rechargeAmount);

}
