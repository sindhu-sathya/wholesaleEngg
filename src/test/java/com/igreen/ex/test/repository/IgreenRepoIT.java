/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.test.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.igreen.ex.model.AccountDetails;
import com.igreen.ex.model.AccountTransactionDetails;
import com.igreen.ex.repository.AccountDetailsRepository;
import com.igreen.ex.repository.AccountTransactionsRepository;
/**
 * 
 * Repository testCases run directly as Spring Service Test.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IgreenRepoIT {

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	AccountTransactionsRepository accountTransactionsRepository;

	@Test
	public void testBillerIdRefRepository() {
		List<AccountDetails> accDetails = new ArrayList<AccountDetails>();
		accDetails = accountDetailsRepository.findByUserId(1L);
		System.out.println("accDetails empty?" + accDetails.isEmpty());
	}

	@Test
	public void testBillerIdsBasedService() {
		List<AccountTransactionDetails> accountTransactionDetails = new ArrayList<AccountTransactionDetails>();
		accountTransactionDetails = accountTransactionsRepository.findByAccountNumber(1232223212L);
		System.out.println("accountTransactionDetails empty?" + accountTransactionDetails.isEmpty());
	}
}
