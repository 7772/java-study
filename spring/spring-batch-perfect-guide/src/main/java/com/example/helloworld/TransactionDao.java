package com.example.helloworld;

import java.util.List;

public interface TransactionDao {

	List<Transaction> getTransactionsByAccountNumber(String accountNumber);
}
