/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.igreen.ex.exception.IgreenServiceException;
import com.igreen.ex.model.AccountDetails;
import com.igreen.ex.model.AccountTransactionDetails;
import com.igreen.ex.service.IgreenService;
import com.igreen.ex.utils.JsonUtils;
/**
 * 
 * Controller file
 *
 */
@RestController
public class IgreenController {
	private final static Logger LOGGER = LoggerFactory.getLogger(IgreenController.class);

	@Autowired
	private IgreenService igreenService;

	@RequestMapping(value = "/api/account/fetchAccountList/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public List<AccountDetails> findAccountList(@PathVariable Long userId) throws Exception {
		LOGGER.info("Inside Controller: findAccountList");
		if (userId == null) {
			LOGGER.error("userId is null");
			throw new IgreenServiceException("Please check the input data. UserId is required");
		}
		List<AccountDetails> accountDetails= igreenService.findAccountList(userId);
		LOGGER.info(JsonUtils.prettyPrint(accountDetails));
		return accountDetails;
	}

	@RequestMapping(value = "/api/account/fetchTransactionList/{accountNumber}", method = RequestMethod.GET)
	@ResponseBody
	public List<AccountTransactionDetails> findTransactionList(@PathVariable Long accountNumber) throws Exception {
		LOGGER.info("Inside Controller: findTransactionList");
		if (accountNumber == null) {
			LOGGER.error("accountNumber is null");
			throw new IgreenServiceException("Please check the input data. accountNumber is required");
		}
		List<AccountTransactionDetails> accountTransactionDetails = igreenService.findTransactionList(accountNumber);
		LOGGER.info(JsonUtils.prettyPrint(accountTransactionDetails));
		return accountTransactionDetails;
	}

}
