SELECT a.accountNumber, a.currentBalance, c.firstName, c.lastName FROM tableAccount AS a
INNER JOIN tableCustomer AS c
ON a.customerID = c.customerID
WHERE customerID = tableCustomer.customerID;