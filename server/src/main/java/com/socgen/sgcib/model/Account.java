package com.socgen.sgcib.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name="Account")
@Table(
   name="account"
)
@Access(AccessType.FIELD)
public class Account implements Serializable{
	
	private  static  final  long serialVersionUID =  1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    private Long id;
	
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
