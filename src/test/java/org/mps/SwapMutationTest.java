package org.mps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.mutation.SwapMutation;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public class SwapMutationTest {
    @Test
    @DisplayName("Test que prueba que lanza error cuando individual es nulo")
    public void mutate_IndividualEsNull_ReturnException() {
        SwapMutation swapMutation = new SwapMutation();
        int[] individual = null;

        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            swapMutation.mutate(individual);
        });
    }

    @Test
    @DisplayName("Test que prueba que lanza error cuando individual es vacio")
    public void mutate_IndividualEsVacio_ReturnException() {
        SwapMutation swapMutation = new SwapMutation();
        int[] individual = {};

        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            swapMutation.mutate(individual);
        });
    }
}
