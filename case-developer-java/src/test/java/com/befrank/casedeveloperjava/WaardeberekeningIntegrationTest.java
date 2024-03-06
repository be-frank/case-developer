package com.befrank.casedeveloperjava;

import com.befrank.casedeveloperjava.domain.DeelnemersRepository;
import com.befrank.casedeveloperjava.testdata.Deelnemers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.befrank.casedeveloperjava.testdata.Deelnemers.John;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WaardeberekeningIntegrationTest {

    private static final String URI = "/api/waardeberekening";

    @Autowired
    private DeelnemersRepository deelnemersRepository;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        deelnemersRepository.clear();
        // voeg een deelnemer van 60 jaar oud toe
        deelnemersRepository.add(John);
    }

    @AfterEach
    void teardown() {
        deelnemersRepository.clear();
    }

    @Test
    void berekenPensioenpot() throws Exception {
        //Voorbeeld 1
        //Gegeven:
        //
        //Een deelnemer van 60 jaar oud
        //En een huidige waarde van 100.000, -
        //En een full-time salaris van 60.000, -
        //En een part-time percentage van 80%
        //En een franchise van 15.599, -
        //En een beschikbare premie percentage van 5%
        //En een rendement van 3% per jaar

        //Wanneer een gewenste pensioenleeftijd van 61 jaar wordt ingevuld

        //Dan levert dit een verwachte waarde op pensioendatum van 104.802,68 euro

        final String deelnemerID = John.getDeelnemerID().id().toString();
        final String ingangsdatum = John.getGeboortedatum().plusYears(1).toString();
        mockMvc.perform(get(URI)
                .param("deelnemerID", deelnemerID)
                .param("ingangsdatum", ingangsdatum))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deelnemerID").value(deelnemerID))
                .andExpect(jsonPath("$.ingangsdatum").value(ingangsdatum))
                .andExpect(jsonPath("$.waarde").value("104802.68"));
    }
}
