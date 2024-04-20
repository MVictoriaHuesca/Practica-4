package org.mps;

import org.junit.jupiter.api.Test;
import org.mps.crossover.OnePointCrossover;
import org.mps.mutation.SwapMutation;
import org.mps.selection.TournamentSelection;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public class EvolutionaryAlgorithmTest {

    @Nested
    @DisplayName("Clase para los tests del constructor")
    public class ConstructorTest {
        @Test
        @DisplayName("Test que prueba que lanza excepcion cuando todo es nulo")
        public void EvolutionaryAlgorithm_TodoEsNull_ReturnException() throws EvolutionaryAlgorithmException{
            TournamentSelection selectionOperator = null;
            SwapMutation mutationOperator = null;
            OnePointCrossover crossoverOperator = null;
    
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);
            });
        }

        @Test
        @DisplayName("Test que prueba que lanza excepcion cuando solo selectionOperator no es nulo")
        public void EvolutionaryAlgorithm_SelectionOperatorNoEsNull_ReturnException() throws EvolutionaryAlgorithmException{
            TournamentSelection selectionOperator = new TournamentSelection(3);
            SwapMutation mutationOperator = null;
            OnePointCrossover crossoverOperator = null;
    
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);
            });
        }

        @Test
        @DisplayName("Test que prueba que lanza excepcion cuando solo mutationOperator no es nulo")
        public void EvolutionaryAlgorithm_MutationOperatorNoEsNull_ReturnException() throws EvolutionaryAlgorithmException{
            TournamentSelection selectionOperator = null;
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = null;
    
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);
            });
        }

        @Test
        @DisplayName("Test que prueba que lanza excepcion cuando solo crossoverOperator no es nulo")
        public void EvolutionaryAlgorithm_CrossoverOperatorNoEsNull_ReturnException() throws EvolutionaryAlgorithmException{
            TournamentSelection selectionOperator = null;
            SwapMutation mutationOperator = null;
            OnePointCrossover crossoverOperator = new OnePointCrossover();
    
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);
            });
        }

        @Test
        @DisplayName("Test que prueba que lanza excepcion cuando solo selectionOperator es nulo")
        public void EvolutionaryAlgorithm_SoloSelectionOperatorEsNull_ReturnNoException() throws EvolutionaryAlgorithmException{
            TournamentSelection selectionOperator = null;
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = new OnePointCrossover();
    
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);
            });
        }

        @Test
        @DisplayName("Test que prueba que lanza excepcion cuando solo mutationOperator es nulo")
        public void EvolutionaryAlgorithm_SoloMutationOperatorEsNull_ReturnNoException() throws EvolutionaryAlgorithmException{
            TournamentSelection selectionOperator = new TournamentSelection(3);
            SwapMutation mutationOperator = null;
            OnePointCrossover crossoverOperator = new OnePointCrossover();
    
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);
            });
        }

        @Test
        @DisplayName("Test que prueba que lanza excepcion cuando solo crossoverOperator es nulo")
        public void EvolutionaryAlgorithm_SoloCrossoverOperatorEsNull_ReturnNoException() throws EvolutionaryAlgorithmException{
            TournamentSelection selectionOperator = new TournamentSelection(3);
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = null;
    
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);
            });
        }

        @Test
        @DisplayName("Test que prueba que no lanza excepcion cuando todo es distinto de nulo")
        public void EvolutionaryAlgorithm_NadaEsNull() throws EvolutionaryAlgorithmException{
            TournamentSelection selectionOperator = new TournamentSelection(3);
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = new OnePointCrossover();
    
            EvolutionaryAlgorithm ev = new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);

            assertNotNull(ev);
        }
    }

    @Nested
    @DisplayName("Clase para los tests del metodo optimize")
    public class OptimizeTest {
        @Test
        @DisplayName("Test que prueba que lanza error cuando population es null")
        public void optimize_PopulationEsNull_ReturnException() throws EvolutionaryAlgorithmException{
            TournamentSelection selectionOperator = new TournamentSelection(3);
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = new OnePointCrossover();
            EvolutionaryAlgorithm ev = new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);

            int[][] population = null;
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                ev.optimize(population);
            });
        }

        @Test
        @DisplayName("Test que prueba que lanza error cuando population esta vacio")
        public void optimize_PopulationEstaVacio_ReturnException() throws EvolutionaryAlgorithmException{
            TournamentSelection selectionOperator = new TournamentSelection(3);
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = new OnePointCrossover();
            EvolutionaryAlgorithm ev = new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);

            int[][] population = new int[0][0];
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                ev.optimize(population);
            });
        }

        @Test
        @DisplayName("Test que prueba que lanza error cuando population[0] es null")
        public void optimize_Population0EsNull_ReturnException() throws EvolutionaryAlgorithmException {
            TournamentSelection selectionOperator = new TournamentSelection(3);
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = new OnePointCrossover();
            EvolutionaryAlgorithm ev = new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);

            int[][] population = new int[2][2];
            population[0] = null;
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                ev.optimize(population);
            });
        }

        @Test
        @DisplayName("Test que prueba que lanza error cuando population[0] esta vacio")
        public void optimize_Population0EstaVacio_ReturnException() throws EvolutionaryAlgorithmException {
            TournamentSelection selectionOperator = new TournamentSelection(3);
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = new OnePointCrossover();
            EvolutionaryAlgorithm ev = new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);

            int[][] population = new int[2][0];
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                ev.optimize(population);
            });
        }

        @Test
        @DisplayName("Test que prueba que no lanza error cuando toda la condicion es true")
        public void optimize_TodoEsCorrecto() throws EvolutionaryAlgorithmException {
            TournamentSelection selectionOperator = new TournamentSelection(2);
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = new OnePointCrossover();
            EvolutionaryAlgorithm ev = new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);

            int[][] population = new int[2][2];
            population[0] = new int[]{1, 2};
            population[1] = new int[]{3, 4};
            
            assertDoesNotThrow(() -> {
                ev.optimize(population);
            });
        }

        @Test
        @DisplayName("Test que prueba que lanza error cuando population es impar")
        public void optimize_PopulationEsImpar_ReturnException() throws EvolutionaryAlgorithmException {
            TournamentSelection selectionOperator = new TournamentSelection(2);
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = new OnePointCrossover();
            EvolutionaryAlgorithm ev = new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);

            int[][] population = new int[3][2];
            
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                ev.optimize(population);
            });
        }

        /*@Test
        @DisplayName("Test que prueba que entra en el if de better")
        public void optimize_BetterEsTrue() throws EvolutionaryAlgorithmException {
            TournamentSelection selectionOperator = new TournamentSelection(2);
            SwapMutation mutationOperator = new SwapMutation();
            OnePointCrossover crossoverOperator = new OnePointCrossover();
            EvolutionaryAlgorithm ev = new EvolutionaryAlgorithm(selectionOperator, mutationOperator, crossoverOperator);

            int[][] population = new int[2][2];
            population[0] = new int[]{1, 2};
            population[1] = new int[]{3, 4};
            
            assertDoesNotThrow(() -> {
                ev.optimize(population);
            });
        }*/
    }
    
}
