package com.befrank.casedeveloperjava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.befrank.casedeveloperjava.service.BeleggingsService;
import com.befrank.casedeveloperjava.service.DefaultPensioenServiceImpl;
import com.befrank.casedeveloperjava.service.MockBeleggingsServiceImpl;
import com.befrank.casedeveloperjava.service.PensioenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CaseDeveloperJavaApplicationTests {

	@Autowired
	private BeleggingsService beleggingsService;

	@Autowired
	private PensioenService pensioenService;

	@Test
	void contextLoadsWithExpectedImplementations() {
		assertEquals(MockBeleggingsServiceImpl.class, this.beleggingsService.getClass());
		assertEquals(DefaultPensioenServiceImpl.class, this.pensioenService.getClass());
	}
}
