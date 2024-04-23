/*
 * AUTORES:
 * - Eduardo Garcí­a Rivas
 * - Marí­a Victoria Huesca Peláez
 */

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
        @DisplayName("Test constructor TournamentSelection con tamañoo de torneo cero lanza excepción")
        public void tournamentSelection_TamanyoCero_LanzaExcepcion() {
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new TournamentSelection(0);
            });
        }

        @Test
        @DisplayName("Test constructor TournamentSelection con tamaño mayor que 0 crea el objeto correctamente") 
        public void tournamentSelection_TamanyoMayorQueCero_CreaObjetoCorrectamente() throws EvolutionaryAlgorithmException {
            TournamentSelection tournamentSelection = new TournamentSelection(3);
            assertNotNull(tournamentSelection);
        }
    }

    @Nested
    @DisplayName("Tests método select")
    class TestsMetodoSelect {
        @Test
        @DisplayName("Test select con población nula lanza excepción")
        public void select_PoblacionNula_LanzaExcepcion() {
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                TournamentSelection tournamentSelection = new TournamentSelection(3);
                int[] population = null;
                tournamentSelection.select(population);
            });
        }

        @Test
        @DisplayName("Test select con población vacía lanza excepción")
        public void select_PoblacionVacia_LanzaExcepcion() {
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                TournamentSelection tournamentSelection = new TournamentSelection(3);
                int[] population = new int[0];
                tournamentSelection.select(population);
            });
        }

        @Test
        @DisplayName("Test método select con población correcta y tamaño de torneo correcto devuelve un array no nulo")
        public void select_ArgmentosCorrectos_DevuelveArrayNoNulo() throws EvolutionaryAlgorithmException {
            TournamentSelection tournamentSelection = new TournamentSelection(5);
            int[] population = { 1, 2, 3, 4, 5 };
            int[] selected = tournamentSelection.select(population);
            assertNotNull(selected);
        }

        @Test
        @DisplayName("Test método select con tamaño de torneo mayor que population.length devuelve excepción")
        public void select_TamanyoTorneoMayorTamanyoPoblacion_LanzaExcepcion() throws EvolutionaryAlgorithmException {
            TournamentSelection tournamentSelection = new TournamentSelection(6);
            int[] population = { 1, 2, 3, 4, 5 };
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                tournamentSelection.select(population);
            });
        }

        @Test
        @DisplayName("Test método select con tamaño de torneo menor a population.length devuelve excepción")
        public void select_TamanyoTorneoIgualTamanyoPoblacion_NoLanzaExcepcion() throws EvolutionaryAlgorithmException {
            TournamentSelection tournamentSelection = new TournamentSelection(5);
            int[] population = { 1, 2, 3, 4, 5 };
            tournamentSelection.select(population);
        }
    }

    
}
