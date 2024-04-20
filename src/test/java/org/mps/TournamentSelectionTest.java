package org.mps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.selection.SelectionOperator;
import org.mps.selection.TournamentSelection;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public class TournamentSelectionTest {

    @Test
    @DisplayName("Test que lanza error cuando tournamentSize es 0")
    public void tournamentSelection_TournamentSizeEsCero_ReturnException() {
        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            new TournamentSelection(0);
        });
    }

    @Test
    @DisplayName("Test que lanza error cuando population es null")
    public void select_PopulationEsNull_ReturnException() throws EvolutionaryAlgorithmException {
        SelectionOperator tournamentSelection = new TournamentSelection(3);
        int[] population = null;

        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            tournamentSelection.select(population);
        });
    }

    @Test
    @DisplayName("Test que lanza error cuando population es vacio")
    public void select_PopulationEstaVacio_ReturnException() throws EvolutionaryAlgorithmException {
        SelectionOperator tournamentSelection = new TournamentSelection(3);
        int[] population = {};

        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            tournamentSelection.select(population);
        });
    }

    @Test
    @DisplayName("Test que prueba que no entra en el ultimo if de select")
    public void select_PopulationEsValido_ReturnException() throws EvolutionaryAlgorithmException {
        SelectionOperator tournamentSelection = new TournamentSelection(3);
        int[] population = {1, 2, 3, 4, 5};

        assertDoesNotThrow(() -> {
            tournamentSelection.select(population);
        });
    }
    
}