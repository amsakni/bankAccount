package com.socgen.sgcib.controller;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.socgen.sgcib.dto.OperationDTO;
import com.socgen.sgcib.exception.WithdrawalException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class OperationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@Order(4)
	public void getHistoryTest_OK() throws Exception {
		this.mockMvc.perform(get("/operation/")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	@Order(1)
	public void depositTest_OK() throws Exception {
		OperationDTO operation = new OperationDTO();
		operation.setAmount(new Double(50));
		this.mockMvc
				.perform(post("/operation/deposit").content(asJsonString(operation))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@Order(2)
	public void withdrawalTest_OK() throws Exception {
		OperationDTO operation = new OperationDTO();
		operation.setAmount(new Double(30));
		this.mockMvc
				.perform(post("/operation/withdrawal").content(asJsonString(operation))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@Order(3)
	public void withdrawalTest_KO() throws Exception {
		OperationDTO operation = new OperationDTO();
		operation.setAmount(new Double(30));
		try {
			this.mockMvc
					.perform(post("/operation/withdrawal").content(asJsonString(operation))
							.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isInternalServerError())
					.andExpect(result -> assertTrue(result.getResolvedException() instanceof WithdrawalException));
		} catch (Exception e) {
			
		}
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
