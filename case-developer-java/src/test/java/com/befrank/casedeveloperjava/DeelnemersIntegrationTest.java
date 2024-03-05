package com.befrank.casedeveloperjava;

import com.befrank.casedeveloperjava.domain.Deelnemer;
import com.befrank.casedeveloperjava.domain.DeelnemersRepository;
import com.befrank.casedeveloperjava.testdata.Deelnemers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeelnemersIntegrationTest {

    private static final String URI = "/api/deelnemers";

    @Autowired
    private DeelnemersRepository deelnemersRepository;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        deelnemersRepository.clear();
        // voeg twee deelnemers toe
        deelnemersRepository.add(Deelnemers.John);
        deelnemersRepository.add(Deelnemers.Jane);
    }

    @AfterEach
    void teardown() {
        deelnemersRepository.clear();
    }

    @Test
    void findAllDeelnemers() throws Exception {
        mockMvc.perform(get(URI))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void findDeelnemer_invalidId() throws Exception {
        mockMvc.perform(get(URI + "/incorrectID"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void findDeelnemer_notFound() throws Exception {
        mockMvc.perform(get(URI + "/" + UUID.randomUUID()))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void findDeelnemer() throws Exception {
        final String contentAsString = mockMvc
                .perform(get(URI + "/" + Deelnemers.Jane.getDeelnemerID().id()))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        final var deelnemer = objectMapper.readValue(contentAsString, Deelnemer.class);
        assertEquals(Deelnemers.Jane, deelnemer);
    }
}
