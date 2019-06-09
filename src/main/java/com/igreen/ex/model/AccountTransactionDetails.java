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
 * The persistent class for the AccountTrasactions database table.
 * 
 */
@Entity
@Table(name = "AccountTrasactions")
public class AccountTransactionDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "trasactionid")
	private Long trasactionId;
	
	@Column(name = "accountnumber")
	private Long accountNumber;

	@Column(name = "accountName")
	private String accountname;

	@Temporal(TemporalType.DATE)
	@Column(name = "valuedate")
	private Date valueDate;

	@Column(name = "currency")
	private String currency;

	@Column(name = "debit_credit")
	private String debitCredit;

	@Column(name = "creditamount")
	private BigDecimal creditAmount;

	@Column(name = "debitamount")
	private BigDecimal debitAmount;

	@Column(name = "trasactionnarrative")
	private String trasactionNarrative;

	public AccountTransactionDetails() {
	}

	public Long getTrasactionId() {
		return trasactionId;
	}

	public void setTrasactionId(Long trasactionId) {
		this.trasactionId = trasactionId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountname() {
		return accountname;
	}

	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDebitCredit() {
		return debitCredit;
	}

	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public BigDecimal getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(BigDecimal debitAmount) {
		this.debitAmount = debitAmount;
	}

	public String getTrasactionNarrative() {
		return trasactionNarrative;
	}

	public void setTrasactionNarrative(String trasactionNarrative) {
		this.trasactionNarrative = trasactionNarrative;
	}

}