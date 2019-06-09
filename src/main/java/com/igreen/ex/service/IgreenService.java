/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.igreen.ex.exception.DataNotFoundException;
import com.igreen.ex.model.AccountDetails;
import com.igreen.ex.model.AccountTransactionDetails;
import com.igreen.ex.repository.AccountDetailsRepository;
import com.igreen.ex.repository.AccountTransactionsRepository;
/**
 * 
 * Service and ServiceIMPL file combined
 *
 */
@Service
public class IgreenService {

	final static Logger LOGGER = LoggerFactory.getLogger(IgreenService.class);
	final static private String NODATA = "No Data found";
	private AccountDetailsRepository accountDetailsRepository;

	private AccountTransactionsRepository accountTransactionsRepository;

	public IgreenService(final AccountDetailsRepository accountDetailsRepository,
			final AccountTransactionsRepository accountTransactionsRepository) {
		this.accountDetailsRepository = accountDetailsRepository;
		this.accountTransactionsRepository = accountTransactionsRepository;
	}

	public List<AccountDetails> findAccountList(final Long userId) {
		LOGGER.info("Inside Service: findAccountList");
		final List<AccountDetails> accountDetails = accountDetailsRepository.findByUserId(userId);
		if (CollectionUtils.isEmpty(accountDetails)) {
			LOGGER.error(NODATA);
			final String errorMessage = "No Account numbers are assosiated for given userId: " + userId;
			throw new DataNotFoundException(errorMessage);
		}

		return accountDetails;
	}

	public List<AccountTransactionDetails> findTransactionList(Long accountNumber) {
		LOGGER.info("Inside Service: findTransactionList");
		final List<AccountTransactionDetails> accountTrasactionDetails = accountTransactionsRepository
				.findByAccountNumber(accountNumber);
		if (CollectionUtils.isEmpty(accountTrasactionDetails)) {
			LOGGER.error(NODATA);
			final String errorMessage = "No trasactions are found for given accountNumber: " + accountNumber;
			throw new DataNotFoundException(errorMessage);
		}

		return accountTrasactionDetails;
	}

}
