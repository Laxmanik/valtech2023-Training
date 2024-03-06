package com.valtech.poc.mutualfundportfolio.services;

import java.util.List;

import org.springframework.data.domain.Page;

import com.valtech.poc.mutualfundportfolio.entities.Transaction;

public interface TransactionService {

	Transaction createTransaction(Transaction transaction) throws Exception;

	List<Transaction> showUserTransactions(int userId);

	Page<Transaction> listAllInvestments(int pageNumber,int userId);

	Page<Transaction> listAllRedeems(int pageNumber,int userId);

	public List<Object[]> getTotalAmountByMutualFund(int userId);
}