package com.valtech.poc.mutualfundportfolio.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.poc.mutualfundportfolio.entities.MutualFund;
import com.valtech.poc.mutualfundportfolio.entities.MutualFundScheme;
import com.valtech.poc.mutualfundportfolio.repositories.MutualFundRepository;
import com.valtech.poc.mutualfundportfolio.repositories.MutualFundSchemeRepository;
import com.valtech.poc.mutualfundportfolio.services.MutualFundService;

@SpringBootTest
class MutualFundServiceImplTest {
	@Mock
	private MutualFundRepository mutualFundRepository;

	@Mock
	private MutualFundSchemeRepository schemeRepository;

	@InjectMocks
	private MutualFundServiceImpl mutualFundServiceImpl;

	@Autowired
	private MutualFundService mutualFundService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getAllMutualFundTypes() {
		List<MutualFund> mutualFunds = new ArrayList<>();
		mutualFunds.add(new MutualFund("Equity", "Equity type mutual fund"));
		mutualFunds.add(new MutualFund("Debt", "Debt type mutual fund"));
		mutualFunds.add(new MutualFund("Hybrid", "Hybrid type mutual fund"));

		when(mutualFundRepository.findAll()).thenReturn(mutualFunds);

		List<MutualFund> result = mutualFundService.getAllMutualFundTypes();

		assertEquals(mutualFunds.size(), result.size());
		assertTrue(mutualFunds.stream().anyMatch(mf -> mf.getType().equals("Equity")));
		assertTrue(mutualFunds.stream().anyMatch(mf -> mf.getType().equals("Debt")));
	}

	@Test
	void updateMutualFund() {
		MutualFund mutualFund = new MutualFund();
		mutualFund.setType("Equity");
		mutualFund.setDescription("Equity Mutual Fund");
		MutualFund createdMutualFund = mutualFundService.createMutualFund(mutualFund);

		createdMutualFund.setDescription("Updated Equity Mutual Fund");
		MutualFund updatedMutualFund = mutualFundService.updateMutualFund(createdMutualFund);

		assertEquals("Updated Equity Mutual Fund", updatedMutualFund.getDescription());
	}

	@Test
	void updateMutualFundScheme() {
		MutualFund mutualFund = new MutualFund();
		mutualFund.setType("Debt");
		mutualFund.setDescription("Debt Mutual Fund");
		mutualFundService.createMutualFund(mutualFund);

		MutualFundScheme scheme = new MutualFundScheme();
		scheme.setSchemeName("Debt Scheme");
		scheme.setDescription("Long-term debt investment");
		scheme.setNetAssetValue(new BigDecimal(200));
		scheme.setMutualFund(mutualFund);
		MutualFundScheme createdScheme = mutualFundService.createMutualFundScheme(scheme);

		createdScheme.setDescription("Updated Debt Scheme");
		MutualFundScheme updatedScheme = mutualFundService.updateMutualFundScheme(createdScheme);

		assertEquals("Updated Debt Scheme", updatedScheme.getDescription());
	}

	@Test
	void getAllMutualFundSchemes() {
		List<MutualFundScheme> mutualFundSchemes = mutualFundService.getAllMutualFundSchemes();
		assertNotNull(mutualFundSchemes);
		assertTrue(mutualFundSchemes.size() > 0);
	}

	@Test
	void testGetAllMutualFundTypes() {
		List<MutualFund> mutualFunds = new ArrayList<>();
		mutualFunds.add(new MutualFund("Equity", "Equity type mutual fund"));
		mutualFunds.add(new MutualFund("Debt", "Debt type mutual fund"));
		mutualFunds.add(new MutualFund("Hybrid", "Hybrid type mutual fund"));

		when(mutualFundRepository.findAll()).thenReturn(mutualFunds);

		List<MutualFund> result = mutualFundService.getAllMutualFundTypes();

		System.out.println("Expected size: " + mutualFunds.size());
		System.out.println("Actual size: " + result.size());
		System.out.println("Expected data: " + mutualFunds);
		System.out.println("Actual data: " + result);

		assertEquals(mutualFunds.size(), result.size());
		assertEquals(mutualFunds.get(0).getType(), result.get(0).getType());
		assertEquals(mutualFunds.get(1).getType(), result.get(1).getType());
		assertEquals(mutualFunds.get(2).getType(), result.get(2).getType());
	}

	@Test
	void getAllSchemesByNonExistentMutualFundType() {
		int nonExistentMutualFundId = 9999;

		List<MutualFundScheme> schemes = mutualFundService.getAllSchemesByMutualFundType(nonExistentMutualFundId);
		assertNotNull(schemes);
		assertTrue(schemes.isEmpty(), "List of schemes should be empty for non-existent MutualFund");
	}

	@Test
	void createAndUpdateMutualFundScheme() {
		MutualFund mutualFund = new MutualFund();
		mutualFund.setType("Balanced");
		mutualFund.setDescription("Balanced Mutual Fund");
		mutualFundService.createMutualFund(mutualFund);

		MutualFundScheme scheme = new MutualFundScheme();
		scheme.setSchemeName("Balanced Scheme");
		scheme.setDescription("Balanced Investment Scheme");
		scheme.setNetAssetValue(new BigDecimal(120.0));
		scheme.setMutualFund(mutualFund);

		MutualFundScheme createdScheme = mutualFundService.createMutualFundScheme(scheme);
		assertNotNull(createdScheme.getId());

		createdScheme.setDescription("Updated Balanced Investment Scheme");
		MutualFundScheme updatedScheme = mutualFundService.updateMutualFundScheme(createdScheme);
		assertEquals("Updated Balanced Investment Scheme", updatedScheme.getDescription());
	}

	@Test
	void testCreateMutualFund() {
		MutualFund mutualFund = new MutualFund("Equity", "Test description");
		when(mutualFundRepository.save(mutualFund)).thenReturn(mutualFund);

		MutualFund createdMutualFund = mutualFundService.createMutualFund(mutualFund);

		assertEquals(mutualFund.getType(), createdMutualFund.getType());
		assertEquals(mutualFund.getDescription(), createdMutualFund.getDescription());
	}

	@Test
	void testUpdateMutualFund() {
		MutualFund existingMutualFund = new MutualFund(1, "Equity", "Test description");
		when(mutualFundRepository.save(existingMutualFund)).thenReturn(existingMutualFund);

		MutualFund updatedMutualFund = mutualFundService.updateMutualFund(existingMutualFund);

		assertEquals(existingMutualFund.getId(), updatedMutualFund.getId());
		assertEquals(existingMutualFund.getType(), updatedMutualFund.getType());
		assertEquals(existingMutualFund.getDescription(), updatedMutualFund.getDescription());
	}
}