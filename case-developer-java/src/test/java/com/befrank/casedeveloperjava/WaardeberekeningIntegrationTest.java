package com.befrank.casedeveloperjava;

import com.befrank.casedeveloperjava.db.DeelnemersJpaRepository;
import com.befrank.casedeveloperjava.db.model.Deelnemer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WaardeberekeningIntegrationTest {

    private static final String URI = "/api/waardeberekening";

    @Autowired
    private DeelnemersJpaRepository deelnemersJpaRepository;
    @Autowired
    private MockMvc mockMvc;

    private Deelnemer john;

    /*
     * John is een deelnemer van 60 jaar oud met een full-time salaris van 60.000,- en een part-time percentage van 80%.
     * De franchise is 15.599,- en het beschikbare premie percentage is 5%.
     * Zie ook CaseBeFrankDeveloperJavaApplication.init().
     *
     * Huidige waarde is 100.000,-
     * Rendement is 3% per jaar.
     */
    @BeforeEach
    void setup() {
        john = deelnemersJpaRepository.findAll()
                .stream()
                .filter(deelnemer -> deelnemer.getNaam().equalsIgnoreCase("John"))
                .findFirst().orElseThrow();
    }

    @Test
    void berekenPensioenpot61jaar() throws Exception {
        // Wanneer een gewenste pensioenleeftijd van 61 jaar wordt ingevuld, dan levert dit een verwachte waarde op van 104.802,68 euro.
        final String deelnemerID = john.getId().toString();
        final String pensioenleeftijd = "61";
        mockMvc.perform(get(URI)
                .param("deelnemerID", deelnemerID)
                .param("pensioenleeftijd", pensioenleeftijd))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deelnemerID").value(deelnemerID))
                .andExpect(jsonPath("$.pensioenleeftijd").value(pensioenleeftijd))
                .andExpect(jsonPath("$.waarde").value("104802.68"));
    }

    // FIXME Parametrized tests
    @Test
    void berekenPensioenpot65jaar() throws Exception {
        // Wanneer een gewenste pensioenleeftijd van 65 jaar wordt ingevuld, dan levert dit een verwachte waarde op van 125.498,08 euro.
        final String deelnemerID = john.getId().toString();
        final String pensioenleeftijd = "65";
        mockMvc.perform(get(URI)
                .param("deelnemerID", deelnemerID)
                .param("pensioenleeftijd", pensioenleeftijd))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deelnemerID").value(deelnemerID))
                .andExpect(jsonPath("$.pensioenleeftijd").value(pensioenleeftijd))
                .andExpect(jsonPath("$.waarde").value("125498.08"));
    }
}
