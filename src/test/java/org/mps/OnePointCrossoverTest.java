/*
 * AUTORES:
 * - Eduardo Garcí­a Rivas
 * - Marí­a Victoria Huesca Peláez
 */

package org.mps;

import org.mps.crossover.OnePointCrossover;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class OnePointCrossoverTest {
    @Nested
    @DisplayName("Tests método crossover")
    class TestsCrossover {
        @Test
        @DisplayName("Test con parent1 nulo")
        void crossover_Parent1NullParent2Null_LanzaExccepcion() {
            OnePointCrossover onePointCrossover = new OnePointCrossover();
            int[] parent1 = null;
            int[] parent2 = { 1, 2, 3, 4, 5 };
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                onePointCrossover.crossover(parent1, parent2);
            });
        }

        @Test
        @DisplayName("Test con parent2 nulo")
        void crossover_Parent1NullParent2NotNull_LanzaExccepcion() {
            OnePointCrossover onePointCrossover = new OnePointCrossover();
            int[] parent1 = {1, 2, 3, 4, 5};
            int[] parent2 = null;
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                onePointCrossover.crossover(parent1, parent2);
            });
        }

        @Test
        @DisplayName("Test con parent1 vacio")
        void crossover_Parent1EmptyParent2Null_LanzaExccepcion() {
            OnePointCrossover onePointCrossover = new OnePointCrossover();
            int[] parent1 = {};
            int[] parent2 = {1, 2, 3, 4, 5};
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                onePointCrossover.crossover(parent1, parent2);
            });
        }

        @Test
        @DisplayName("Test con arrays de distinto tamaño")
        void crossover_Parent1SizeNotEqualParent2Size_LanzaExccepcion() {
            OnePointCrossover onePointCrossover = new OnePointCrossover();
            int[] parent1 = {1, 2, 3, 4, 5};
            int[] parent2 = {1, 2, 3, 4};
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                onePointCrossover.crossover(parent1, parent2);
            });
        }

        @Test
        @DisplayName("Test con argumentos correctos devuelve un array no nulo")
        void crossover_ArgumentosCorrectos_DevuelveArrayNoNulo() throws EvolutionaryAlgorithmException {
            OnePointCrossover onePointCrossover = new OnePointCrossover();
            int[] parent1 = {1, 2, 3, 4, 5};
            int[] parent2 = {5, 4, 3, 2, 1};
            int[][] offspring = onePointCrossover.crossover(parent1, parent2);
            assertNotNull(offspring);
        }

    }
}
