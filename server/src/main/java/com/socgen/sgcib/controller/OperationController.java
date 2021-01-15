package com.socgen.sgcib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.sgcib.dto.AccountDTO;
import com.socgen.sgcib.dto.OperationDTO;
import com.socgen.sgcib.exception.WithdrawalException;
import com.socgen.sgcib.service.AccountService;
import com.socgen.sgcib.util.mapper.SelmaMapper;

@CrossOrigin
@RestController
@RequestMapping("/operation")
public class OperationController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	SelmaMapper mapper;

	@GetMapping("/")
	public List<AccountDTO> getAllOperations() {
		return mapper.asAccountDTO(accountService.getAll());
	}

	@PostMapping("/deposit")
	@ResponseBody
	public ResponseEntity depositAmount(@RequestBody OperationDTO operation) {
		
		accountService.depositAmount(operation.getAmount());
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/withdrawal")
	@ResponseBody
	public ResponseEntity withdrawalAmount(@RequestBody OperationDTO operation) throws WithdrawalException {
		accountService.withdrawalAmount(operation.getAmount());
		return new ResponseEntity(HttpStatus.OK);
	}

}
