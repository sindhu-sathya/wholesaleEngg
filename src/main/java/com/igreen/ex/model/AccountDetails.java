/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the Account database table.
 * 
 */
@Entity
@Table(name = "Account")
public class AccountDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "accountnumber")
	private Long accountNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "balancedate")
	private Date balanceDate;

	@Column(name = "userid")
	private Long userId;

	@Column(name = "accountname")
	private String accountName;

	@Column(name = "balance")
	private BigDecimal balance;

	@Column(name = "currency")
	private String currency;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public AccountDetails() {
	}

	@Override
	public String toString() {
		return "AccountDetails [userId=" + userId + ", accountNumber=" + accountNumber + "," + ", balanceDate="
				+ balanceDate + "," + ", accountName=" + accountName + ","
				+ " balance=" + balance + ", currency=" + currency + "]";
	}

}