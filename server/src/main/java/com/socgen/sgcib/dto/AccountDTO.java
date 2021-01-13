package com.socgen.sgcib.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class AccountDTO {
	
    @Getter
    @Setter
	private Double balance;
	
    @Getter
    @Setter
	private Double operationAmount;
	
    @Getter
    @Setter
	private Date operationDate;

}
