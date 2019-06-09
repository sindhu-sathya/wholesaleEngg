/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.igreen.ex.exception.DataNotFoundException;
import com.igreen.ex.model.AccountDetails;
import com.igreen.ex.model.AccountTransactionDetails;
import com.igreen.ex.repository.AccountDetailsRepository;
import com.igreen.ex.repository.AccountTransactionsRepository;
import com.igreen.ex.service.IgreenService;

/**
 * 
 * Service file TestCases.
 *
 */
@Category(IgreenServiceTest.class)
@RunWith(MockitoJUnitRunner.class)
public class IgreenServiceTest {

	@Mock
	AccountDetailsRepository accountDetailsRepository;

	@Mock
	AccountTransactionsRepository accountTransactionsRepository;

	@InjectMocks
	IgreenService igreenService = new IgreenService(accountDetailsRepository, accountTransactionsRepository);

	private static final Long MOCK_ACC_ID = 1232223212L;
	private static final Long MOCK_USER_ID = 1l;

	private static final Long MOCK_TEST_ID_ZERO = 0L;

	@Test
	public void testFindTransactionList() {
		when(igreenService.findTransactionList(MOCK_ACC_ID)).thenReturn(new ArrayList<AccountTransactionDetails>());
		List<AccountTransactionDetails> accountTrasactionDetails = igreenService.findTransactionList(MOCK_ACC_ID);
		assertNotNull(accountTrasactionDetails);
		if (!CollectionUtils.isEmpty(accountTrasactionDetails)) {
			assertEquals(accountTrasactionDetails.get(0).getAccountNumber(), MOCK_ACC_ID);
		}

	}

	@Test(expected = DataNotFoundException.class)
	public void testFindTransactionListException() {
		when(igreenService.findTransactionList(MOCK_TEST_ID_ZERO)).thenReturn(null);
		List<AccountTransactionDetails> accountTrasactionDetails = igreenService.findTransactionList(0L);
		assertNull(accountTrasactionDetails);
	}

	@Test
	public void testFindAccountList() {
		when(igreenService.findAccountList(MOCK_USER_ID)).thenReturn(new ArrayList<AccountDetails>());
		List<AccountDetails> accountDetails = igreenService.findAccountList(MOCK_USER_ID);
		assertNotNull(accountDetails);
		if (!CollectionUtils.isEmpty(accountDetails)) {
			assertEquals(accountDetails.get(0).getUserId(), MOCK_USER_ID);
		}

	}

	@Test(expected = DataNotFoundException.class)
	public void testFindAccountListException() {
		when(igreenService.findAccountList(MOCK_TEST_ID_ZERO)).thenReturn(null);
		List<AccountDetails> accountDetails = igreenService.findAccountList(0L);
		assertNull(accountDetails);
	}
}