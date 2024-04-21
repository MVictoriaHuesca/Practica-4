package org.mps;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mps.selection.TournamentSelection;

public class TournamentSelectionTest {
    @Nested
    @DisplayName("Tests constructor TournamentSelection")
    class TestsConstructorTournamnetSelection {
        @Test
        @DisplayName("Test constructor TournamentSelection con tamaño de torneo cero lanza excepción")
        public void tournamentSelection_TamanyoCero_LanzaExcepcion() {
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new TournamentSelection(0);
            });
        }

        @Test
        @DisplayName("Test constructor TournamentSelection con tamaño mayor que 0 crea el objeto correctamente") 
        public void tournamentSelection_TamanyoMayorQueCero_CreaObjetoCorrectamente() {
            TournamentSelection tournamentSelection = new TournamentSelection(3);
            assertNotNull(tournamentSelection);
        }
    }

    
}
