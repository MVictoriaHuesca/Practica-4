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
import org.mps.mutation.SwapMutation;

public class SwapMutationTest {
    @Nested
    @DisplayName("Tests método mutate")
    class TestsMutate {
        @Test
        @DisplayName("Test con individuo nulo")
        void mutate_IndividuoNull_LanzaExccepcion() {
            SwapMutation swapMutation = new SwapMutation();
            int[] individual = null;
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                swapMutation.mutate(individual);
            });
        }

        @Test
        @DisplayName("Test con individuo vacío")
        void mutate_IndividuoEmpty_LanzaExccepcion() {
            SwapMutation swapMutation = new SwapMutation();
            int[] individual = {};
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                swapMutation.mutate(individual);
            });
        }

        @Test
        @DisplayName("Test con individuo correcto devuelve un array no nulo")
        void mutate_IndividuoCorrecto_DevueveArrayNoNulo() throws EvolutionaryAlgorithmException {
            SwapMutation swapMutation = new SwapMutation();
            int[] individual = {1, 2, 3, 4, 5};
            int[] mutated = swapMutation.mutate(individual);
            assertNotNull(mutated);
        }
    }
    
}
