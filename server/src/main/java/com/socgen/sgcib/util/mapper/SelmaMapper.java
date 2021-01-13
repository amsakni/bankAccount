package com.socgen.sgcib.util.mapper;

import java.util.List;

import com.socgen.sgcib.dto.AccountDTO;
import com.socgen.sgcib.model.Account;

import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreFields = "id")
public interface SelmaMapper {

	List<AccountDTO> asAccountDTO(List<Account> in);

	Account asAccount(AccountDTO in, Account out);

}