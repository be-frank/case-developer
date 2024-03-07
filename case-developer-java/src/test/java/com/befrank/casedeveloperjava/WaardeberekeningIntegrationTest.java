package com.befrank.casedeveloperjava;

import com.befrank.casedeveloperjava.repository.DeelnemersJpaRepository;
import com.befrank.casedeveloperjava.repository.model.Deelnemer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @ParameterizedTest
    @CsvSource({"61,104802.68", "65,125498.08"})
    void berekenPensioenPotOpBasisVanGewenstePensioenleeftijd(
            final String gewenstePernsioenLeeftijd,
            final String verwachteWaarde) throws Exception {
        final String deelnemerID = john.getId().toString();

        mockMvc.perform(get(URI)
                        .param("deelnemerID", deelnemerID)
                        .param("pensioenleeftijd", gewenstePernsioenLeeftijd))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deelnemerID").value(deelnemerID))
                .andExpect(jsonPath("$.pensioenleeftijd").value(gewenstePernsioenLeeftijd))
                .andExpect(jsonPath("$.waarde").value(verwachteWaarde));
    }
}
