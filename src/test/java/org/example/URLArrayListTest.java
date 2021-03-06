package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class URLArrayListTest {

    @Test
    public void probarLista (){

        org.example.List lista = new URLArrayList ();

        lista.add (0, 10);
        lista.add (0, 9);
        lista.add (0, 8);
        lista.add (0, 7);
        lista.add (0, 6);
        lista.add (0, 5);

        assertEquals (5, lista.get (0));
        assertEquals (8, lista.get (3));

        lista.add (0, 40);
        lista.set (0, 4);

        assertEquals (4, lista.get (0));
        assertEquals (8, lista.get (4));

        assertTrue (! lista.isEmpty ());
        assertEquals (7, lista.size ());


    }


}
