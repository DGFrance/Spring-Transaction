package com.Javabootcamp.springtransaction.jdbc.examples;

public interface FundManager {
	void transfer(int accountNbr1, int accountNbr2, int amount) throws Exception;
	int getBalance(int accountNbr);
	void verifyAccount(int accountNbr);
}
