package edu.gorilas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ExamenTest {

        @Test
        public void testEcuacionSegundoGrado() {

                ArrayList<Double> expectedSol1 = new ArrayList<>();
                expectedSol1.add(-1.0);

                ArrayList<Double> actualSol1 = Ecuacion.ecuacionSegundoGrado(1, 2, 1);
                assertEquals(expectedSol1.size(), actualSol1.size());
                assertEquals(expectedSol1.get(0), actualSol1.get(0));

                ArrayList<Double> expectedSol2 = new ArrayList<>();
                expectedSol2.add(0.0);

                ArrayList<Double> actualSol2 = Ecuacion.ecuacionSegundoGrado(1, 0, 0);
                assertEquals(expectedSol2.size(), actualSol2.size());
                assertEquals(expectedSol2.get(0), actualSol2.get(0));

                ArrayList<Double> expectedSol3 = new ArrayList<>();
                expectedSol3.add(3.0);
                expectedSol3.add(0.5);

                ArrayList<Double> actualSol3 = Ecuacion.ecuacionSegundoGrado(2, -7, 3);
                assertEquals(expectedSol3.size(), actualSol3.size());
                assertEquals(expectedSol3.get(0), actualSol3.get(0));
                assertEquals(expectedSol3.get(1), actualSol3.get(1));



        }


}

