package com.valtech.poc.mutualfundportfolio.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.poc.mutualfundportfolio.entities.Transaction;
import com.valtech.poc.mutualfundportfolio.repositories.TransactionRepository;
import com.valtech.poc.mutualfundportfolio.services.EmailService;
import com.valtech.poc.mutualfundportfolio.services.TransactionService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TransactionServiceImpl implements TransactionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

	private TransactionRepository transactionRepository;
	LocalDateTime dateTime = LocalDateTime.now();
	private EmailService emailService;

	@Autowired
	public TransactionServiceImpl(TransactionRepository trasactionRepository, EmailService emailService) {
		this.transactionRepository = trasactionRepository;
		this.emailService = emailService;
	}

	@Override
	public Transaction createTransaction(Transaction transaction) throws Exception {

		LOGGER.info("Creating Transaction with Net Asset Value: {}, Nav Units: {}", transaction.getNetAssetValue(),
				transaction.getNavUnits());
		emailService.sendUserTransactionMail(transaction);

		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> showUserTransactions(int userId) {
		LOGGER.info("Fetching transactions for user with userId: {}", userId);

		return transactionRepository.findTrasactionsByUserId(userId);
	}

	@Override
	public List<Object[]> getTotalAmountByMutualFund(int userId) {
		LOGGER.info("Fetching piechart Data");

		return transactionRepository.getTotalAmountByMutualFund(userId);
	}

	@Override
	public Page<Transaction> listAllInvestments(int pageNumber,int userId) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 3);
		
		return transactionRepository.findInvestTransactionsByUserId(userId,pageable);
	}

	@Override
	public Page<Transaction> listAllRedeems(int pageNumber,int userId) {
		Pageable pageable = PageRequest.of(pageNumber - 1, 3);

		return transactionRepository.findRedeemTransactionsByUserId(userId,pageable);
	}
}