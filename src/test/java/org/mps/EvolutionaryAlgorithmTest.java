package org.mps;

import org.mps.crossover.CrossoverOperator;
import org.mps.crossover.OnePointCrossover;
import org.mps.mutation.MutationOperator;
import org.mps.mutation.SwapMutation;
import org.mps.selection.SelectionOperator;
import org.mps.selection.TournamentSelection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

public class EvolutionaryAlgorithmTest {

    @Nested
    @DisplayName("Tests constructor EvolutionaryAlgorithm")
    class TestCnstructorEvolutionaryAlgorithm {
        @Test
        @DisplayName("Test constructor EvolutionaryAlgorithm con argumentos nulos lanza excepción")
        public void  EvolutionaryALgorithm_ArgumentosNulos_LanzaExcepcion() {
            SelectionOperator selOp = null;
            MutationOperator mutOp = null;
            CrossoverOperator crossOp = null;
            
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
            });
        }
    
        @Test
        @DisplayName("Test constructor EvolutionaryAlgorithm con solo CrossoverOperator no nulo lanza excepción")
        public void  EvolutionaryALgorithm_CrossoverOperatorNotNull_LanzaExcepcion() {
            SelectionOperator selOp = null;
            MutationOperator mutOp = null;
            CrossoverOperator crossOp = new OnePointCrossover();
            
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
            });
        }
    
        @Test
        @DisplayName("Test constructor EvolutionaryAlgorithm con solo MutationOperator no nulo lanza excepción")
        public void  EvolutionaryALgorithm_MutationOperatorNotNull_LanzaExcepcion() {
            SelectionOperator selOp = null;
            MutationOperator mutOp = new SwapMutation();
            CrossoverOperator crossOp = null;
            
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
            });
        }
    
        @Test
        @DisplayName("Test constructor EvolutionaryAlgorithm con solo SelectionOperator nulo lanza excepción")
        public void  EvolutionaryAlgorithm_SelectionOperatorNull_LanzaExcepcion(){
            SelectionOperator selOp = null;
            MutationOperator mutOp = new SwapMutation();
            CrossoverOperator crossOp = new OnePointCrossover();
            
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
            });
        }
    
        @Test
        @DisplayName("Test constructor EvolutionaryAlgorithm con solo SelectionOperator no nulo lanza excepción")
        public void EvolutionaryAlgorithm_SelectionOperatorNotNull_LanzaExcepcion() throws EvolutionaryAlgorithmException {
            SelectionOperator selOp = new TournamentSelection(3);
            MutationOperator mutOp = null;
            CrossoverOperator crossOp = null;
            
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
            });
        }
    
        @Test
        @DisplayName("Test constructor EvolutionaryAlgorithm con solo MutationOperator nulo lanza excepción")
        public void EvolutionaryALgorithm_MutationOperatorNull_LanzaExcepcion() throws EvolutionaryAlgorithmException {
            SelectionOperator selOp = new TournamentSelection(3);
            MutationOperator mutOp = null;
            CrossoverOperator crossOp = new OnePointCrossover();
            
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
            });
        }
    
        @Test
        @DisplayName("Test constructor EvolutionaryAlgorithm con solo CrossoverOperator nulo lanza excepción")
        public void EvolutionaryALgorithm_CrossoverOperatorNull_LanzaExcepcion() throws EvolutionaryAlgorithmException {
            SelectionOperator selOp = new TournamentSelection(3);
            MutationOperator mutOp = new SwapMutation();
            CrossoverOperator crossOp = null;
            
            assertThrows(EvolutionaryAlgorithmException.class, () -> {
                new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
            });
        }
        
        @Test
        @DisplayName("Test constructor EvolutionaryAlgorithm con argumentos válidos no lanza excepción")
        public void EvolutionaryAlgorithm_ArgumentosValidos_NoLanzaExcepcion() throws EvolutionaryAlgorithmException {
            SelectionOperator selOp = new TournamentSelection(3);
            MutationOperator mutOp = new SwapMutation();
            CrossoverOperator crossOp = new OnePointCrossover();
            
            EvolutionaryAlgorithm evAl = new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
    
            assertNotNull(evAl);
        }
    }

    @Nested
    @DisplayName("Tests método optimize")
    class TestsOptimize {
        @Nested
        @DisplayName("Tests inicialización del array population")
        class TestsInicializacionArrayPopulation {
            @Test
            @DisplayName("Test optimize con array population nulo lanza excepción")
            public void optimize_PoblacionNull_LanzaExcepcion() throws EvolutionaryAlgorithmException {
                int[][] population = null;
                SelectionOperator selOp = new TournamentSelection(3);
                MutationOperator mutOp = new SwapMutation();
                CrossoverOperator crossOp = new OnePointCrossover();
                
                EvolutionaryAlgorithm evAl = new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
    
                assertThrows(EvolutionaryAlgorithmException.class,()-> {
                    evAl.optimize(population);
                });
            }
    
            @Test
            @DisplayName("Test optimize con población no vacía y genes nulos lanza excepción")
            public void optimize_PoblacionVaciaGenesNull_LanzaExcepcion() throws EvolutionaryAlgorithmException {
                int[][] population = new int[2][];
    
                SelectionOperator selOp = new TournamentSelection(3);
                MutationOperator mutOp = new SwapMutation();
                CrossoverOperator crossOp = new OnePointCrossover();
                
                EvolutionaryAlgorithm evAl = new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
    
                assertThrows(EvolutionaryAlgorithmException.class,()-> {
                    evAl.optimize(population);
                });
            }
    
            @Test
            @DisplayName("Test optimize con población no vacía y genes vacíos lanza excepción")
            public void optimize_PoblacionNoVaciaGenesVacíos_LanzaExcepcion() throws EvolutionaryAlgorithmException {
                int[][] population = new int[2][0];
    
                SelectionOperator selOp = new TournamentSelection(3);
                MutationOperator mutOp = new SwapMutation();
                CrossoverOperator crossOp = new OnePointCrossover();
                
                EvolutionaryAlgorithm evAl = new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
    
                assertThrows(EvolutionaryAlgorithmException.class,()-> {
                    evAl.optimize(population);
                });
            }
        }

        @Nested
        @DisplayName("Tests optimize con distintos tamanyos de población")
        class TestsOptimizeTamanyoPoblacion {
            @Test
            @DisplayName("Test optimize con individuos pares no lanza excepción")
            public void optimize_PolacionPar_NoLanzaExcepcion() throws EvolutionaryAlgorithmException {
                int[][] population = new int[2][3];
    
                SelectionOperator selOp = new TournamentSelection(3);
                MutationOperator mutOp = new SwapMutation();
                CrossoverOperator crossOp = new OnePointCrossover();
                
                EvolutionaryAlgorithm evAl = new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
    
                int[][] result = evAl.optimize(population);
    
                assertNotNull(result);
            }
    
            @Test
            @DisplayName("Test optimize con individuos impares lanza excepción")
            public void opitimize_IndividuosImpares_LanzaExcepcion() throws EvolutionaryAlgorithmException {
                int[][] population = new int[3][3];
    
                SelectionOperator selOp = new TournamentSelection(3);
                MutationOperator mutOp = new SwapMutation();
                CrossoverOperator crossOp = new OnePointCrossover();
                
                EvolutionaryAlgorithm evAl = new EvolutionaryAlgorithm(selOp, mutOp, crossOp);
    
                assertThrows(EvolutionaryAlgorithmException.class,()-> {
                    evAl.optimize(population);
                });
            }
        }

    }
}
