package com.valtech.poc.mutualfundportfolio.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.valtech.poc.mutualfundportfolio.entities.Transaction;
import com.valtech.poc.mutualfundportfolio.repositories.TransactionRepository;
import com.valtech.poc.mutualfundportfolio.services.EmailService;

import ch.qos.logback.classic.Logger;

class TransactionServiceImplTest {

	@Mock
	private TransactionRepository transactionRepository;

	@Mock
	private EmailService emailService;

	@InjectMocks
	private TransactionServiceImpl transactionService;

	@Mock
	private Logger logger;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCreateTransaction() throws Exception {
		Transaction transaction = new Transaction();
		transaction.setId(1);
		transaction.setNetAssetValue(new BigDecimal(100));
		transaction.setNavUnits(new BigDecimal(10));

		when(transactionRepository.save(transaction)).thenReturn(transaction);
		Transaction createdTransaction = transactionService.createTransaction(transaction);

		assertNotNull(createdTransaction);
		assertEquals(transaction.getId(), createdTransaction.getId());
		assertEquals(transaction.getNetAssetValue(), createdTransaction.getNetAssetValue());
		assertEquals(transaction.getNavUnits(), createdTransaction.getNavUnits());

		verify(emailService, times(1)).sendUserTransactionMail(transaction);
	}

	@Test
	void testShowUserTransactions() {
		int userId = 1;
		List<Transaction> mockTransactions = new ArrayList<>();
		when(transactionRepository.findTrasactionsByUserId(userId)).thenReturn(mockTransactions);

		List<Transaction> userTransactions = transactionService.showUserTransactions(userId);

		assertNotNull(userTransactions);
		assertEquals(mockTransactions, userTransactions);
	}

	@Test
	void testGetTotalAmountByMutualFundType() {
		int userId = 1;
		List<Object[]> mockResult = new ArrayList<>();
		when(transactionRepository.getTotalAmountByMutualFund(userId)).thenReturn(mockResult);

		List<Object[]> result = transactionService.getTotalAmountByMutualFund(userId);

		assertNotNull(result);
		assertEquals(mockResult, result);
	}

}
