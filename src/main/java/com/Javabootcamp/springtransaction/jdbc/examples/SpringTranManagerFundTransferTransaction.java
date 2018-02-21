package com.Javabootcamp.springtransaction.jdbc.examples;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class SpringTranManagerFundTransferTransaction extends FundManagerDao implements FundManager {
	private PlatformTransactionManager transactionManager;

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	public void transfer(int accountNbr1, int accountNbr2, int amount) throws Exception {
		TransactionDefinition transactions = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(transactions);
		try {
			doTransfer(accountNbr1, accountNbr2, amount);
			transactionManager.commit(status);
		} catch (Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
	}
}
