ALTER TABLE `dbKBank`.`tableAccount` 
ADD INDEX `fk_tableAccount_1_idx` (`customerID` ASC);
ALTER TABLE `dbKBank`.`tableAccount` 
ADD CONSTRAINT `fk_tableAccount_1`
  FOREIGN KEY (`customerID`)
  REFERENCES `dbKBank`.`tableCustomer` (`customerID`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;