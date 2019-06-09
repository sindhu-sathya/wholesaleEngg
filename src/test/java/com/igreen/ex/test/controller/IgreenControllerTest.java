/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.test.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.igreen.ex.controller.IgreenController;
import com.igreen.ex.model.AccountDetails;
import com.igreen.ex.model.AccountTransactionDetails;
import com.igreen.ex.service.IgreenService;

/**
 * 
 * Controller file TestCases.
 *
 */
@Category(IgreenControllerTest.class)
@RunWith(MockitoJUnitRunner.class)
public class IgreenControllerTest {
	private MockMvc mockMvc;

	@InjectMocks
	IgreenController igreenControllerMock = new IgreenController();

	@Mock
	IgreenService igreenServiceMock;
	private static final Long MOCK_USER_ID = 1l;
	private static final Long MOCK_ACC_NUM = 595309209l;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(igreenControllerMock).build();
	}

	@Test
	public void testGetAccDetailsException() throws Exception {
		when(igreenServiceMock.findAccountList(0L)).thenReturn(getMockAccountDetails());
		this.mockMvc.perform(get("/api/account/fetchAccountList/0")).andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void testGetAccountDetails() throws Exception {
		when(igreenServiceMock.findAccountList(MOCK_USER_ID)).thenReturn(getMockAccountDetails());
		this.mockMvc.perform(get("/api/account/fetchAccountList/1")).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.accountName", is("SGSavings726"))).andExpect(jsonPath("$.currency", is("SGD")));
	}

	@Test
	public void testGetAccTransactionDetailsException() throws Exception {
		when(igreenServiceMock.findTransactionList(0L)).thenReturn(getMockTrasactionDetails());
		this.mockMvc.perform(get("/api/account/fetchTransactionList/0")).andDo(print()).andExpect(status().isOk());

	}

	@Test
	public void testGetAccountTransactionDetails() throws Exception {
		when(igreenServiceMock.findTransactionList(MOCK_ACC_NUM)).thenReturn(getMockTrasactionDetails());
		this.mockMvc.perform(get("/api/account/fetchTransactionList/595309209")).andDo(print())
				.andExpect(status().isOk()).andExpect(jsonPath("$.accountName", is("Savings Account")))
				.andExpect(jsonPath("$.currency", is("SGD")));
	}

	private List<AccountDetails> getMockAccountDetails() {
		List<AccountDetails> accountDetailsList = new ArrayList<AccountDetails>();
		AccountDetails accountDetails = new AccountDetails();
		accountDetails.setAccountNumber(MOCK_ACC_NUM);
		accountDetails.setBalanceDate(new Date());
		accountDetails.setUserId(1L);
		accountDetails.setAccountName("SGSavings726");
		accountDetails.setBalance(new BigDecimal(84327.51));
		accountDetails.setCurrency("SGD");

		accountDetailsList.add(accountDetails);
		return accountDetailsList;
	}

	private List<AccountTransactionDetails> getMockTrasactionDetails() {
		List<AccountTransactionDetails> accountTransactionDetailList = new ArrayList<AccountTransactionDetails>();
		AccountTransactionDetails accountTransactionDetails = new AccountTransactionDetails();
		accountTransactionDetails.setTrasactionId(1234l);
		accountTransactionDetails.setAccountNumber(MOCK_ACC_NUM);
		accountTransactionDetails.setAccountname("Savings Account");
		accountTransactionDetails.setCurrency("SGD");
		accountTransactionDetails.setValueDate(new Date());
		accountTransactionDetails.setDebitCredit("DEBIT");
		accountTransactionDetails.setDebitAmount(new BigDecimal(84327.51));

		accountTransactionDetailList.add(accountTransactionDetails);
		return accountTransactionDetailList;
	}
}