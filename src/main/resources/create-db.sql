--drop command is coded so that any user can start fresh.
DROP TABLE Account IF EXISTS;

CREATE TABLE Account (
  accountnumber  INTEGER NOT NULL PRIMARY KEY,
  userid  INTEGER NOT NULL,
  accountname VARCHAR(30),
  accounttype  VARCHAR(50),
  balancedate DATE,
  currency VARCHAR(5),
  balance decimal(10,2)
  );

CREATE TABLE AccountTrasactions (
  trasactionid INTEGER NOT NULL AUTO_INCREMENT,
  accountnumber         INTEGER,
  accountname VARCHAR(30),
  valuedate DATE,
  currency VARCHAR(30),
  creditamount decimal(10,2),
  debitamount decimal(10,2),
  debit_credit  VARCHAR(10),
  trasactionnarrative VARCHAR(30)
);

