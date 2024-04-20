package org.mps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.crossover.OnePointCrossover;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public class OnePointCrossoverTest {
    @Test
    @DisplayName("Test que prueba que lanza error cuando parent1 es nulo")
    public void crossover_Parent1EsNull_ReturnException() {
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        int[] parent1 = null;
        int[] parent2 = {1, 2, 3, 4};

        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            onePointCrossover.crossover(parent1, parent2);
        });
    }

    @Test
    @DisplayName("Test que prueba que lanza error cuando parent1 es vacio")
    public void crossover_Parent1EsVacio_ReturnException() {
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        int[] parent1 = {};
        int[] parent2 = {1, 2, 3, 4};

        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            onePointCrossover.crossover(parent1, parent2);
        });
    }

    @Test
    @DisplayName("Test que prueba que lanza error cuando parent2 es nulo")
    public void crossover_Parent2EsNull_ReturnException() {
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        int[] parent1 = {1, 2, 3, 4};
        int[] parent2 = null;

        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            onePointCrossover.crossover(parent1, parent2);
        });
    }

    @Test
    @DisplayName("Test que prueba que lanza error cuando parent1.length no es igual a parent2.length")
    public void crossover_TamParent1DistintoDeTamParent2_ReturnException() {
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        int[] parent1 = {1, 2, 3, 4};
        int[] parent2 = {2, 3, 4, 5, 6};

        assertThrows(EvolutionaryAlgorithmException.class, () -> {
            onePointCrossover.crossover(parent1, parent2);
        });
    }
}
