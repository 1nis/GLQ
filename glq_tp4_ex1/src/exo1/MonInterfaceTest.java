package exo1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.never;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.isA;
import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.AdditionalMatchers.or;
import static org.mockito.Mockito.any;

class MonInterfaceTest {

    private MonInterface mock, autreMock;

    @BeforeEach
    void setUp() throws Exception {
        mock = mock(MonInterface.class);
        autreMock = mock(MonInterface.class);

        doThrow(new IllegalArgumentException()).when(mock).methode1();
        doNothing().when(autreMock).methode1();

        when(mock.methode2()).thenReturn(1,2,3,4);

        when(mock.methode3(3)).thenReturn(3);
        when(mock.methode3(7)).thenReturn(10);
        when(mock.methode3(15)).thenThrow(new NullPointerException());

        when(mock.methode4(or(eq(1),eq(2)), anyInt())).thenReturn(100);
        when(mock.methode4(or(eq(1),eq(2)), any(String.class))).thenReturn(200);
        when(mock.methode4(or(eq(1),eq(2)), isA(List.class))).thenReturn(300);
        when(mock.methode4(or(eq(1),eq(2)), isA(HashSet.class))).thenReturn(400);
        when(mock.methode5(eq(1), eq("oui"), anyIterable())).thenReturn(500);
        // voir https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/ArgumentMatchers.html

        List<String> liste = Arrays.asList("oui","non","bof");
        Iterator<String> it = liste.iterator();
        when(mock.iterator()).thenReturn(it);
    }

    @Test
    void testMethode1a() {
        assertThrows(IllegalArgumentException.class,
                () ->  mock.methode1());
    }

    @Test
    void testMethode1b() throws Exception {
        autreMock.methode1();
    }

    @Test
    void testMethode2() throws Exception {
        assertEquals(1,mock.methode2());
        assertEquals(2,mock.methode2());
        assertEquals(3,mock.methode2());
        assertEquals(4,mock.methode2());
        verify(mock,times(4)).methode2();
        assertEquals(4,mock.methode2());
        assertEquals(4,mock.methode2());
        assertEquals(4,mock.methode2());
        verify(mock,times(7)).methode2();
    }

    @Test
    void testMethode3a() throws Exception {
        assertEquals(0,mock.methode3(1));
        assertEquals(3,mock.methode3(3));
        assertEquals(10,mock.methode3(7));
        verify(mock,atLeast(1)).methode3(3);
        verify(mock,atLeast(3)).methode3(anyInt());
        verify(mock,never()).methode3(0);
    }

    @Test
    void testMethode3b() {
        assertThrows( NullPointerException.class,
                () -> mock.methode3(15));
    }

    @Test
    void testMethode4() throws Exception {
        assertEquals(0, mock.methode4(1, null));

        assertEquals(100,mock.methode4(1,-15));
        assertEquals(0,mock.methode4(0,-15));

        assertEquals(200,mock.methode4(1,"un"));
        assertEquals(200,mock.methode4(2,"deux"));
        assertEquals(0,mock.methode4(3,"trois"));


        assertEquals(300,mock.methode4(1, new ArrayList<Integer>()));
        assertEquals(300,mock.methode4(2, new LinkedList<String>()));
        assertEquals(0,mock.methode4(3, new LinkedList<String>()));

        assertEquals(400,mock.methode4(1, new java.util.HashSet<Integer>()));
        assertEquals(0,mock.methode4(4, new java.util.HashSet<Integer>()));

        assertEquals(500,mock.methode5(1, "oui", new java.util.HashSet<Integer>()));
        assertEquals(0,mock.methode5(1, "oui", new java.awt.Point()));
    }


    @Test
    void testIterator() throws Exception {
        assertIterableEquals(Arrays.asList("oui","non","bof"), mock);
    }

    @Test
    void testSpy() throws Exception {
        List<String> liste = new LinkedList<String>();
        List<String> spy = spy(liste);
        //when(spy.get(0)).thenReturn("ok"); // incorrect : IndexOutOfBoundsException
        doReturn("ok").when(spy).get(0);
        assertEquals("ok", spy.get(0));
        spy.add("a");
        spy.add("b");
        assertEquals("[a, b]", spy.toString());
        assertEquals("ok", spy.get(0));
        assertEquals("b", spy.get(1));
        assertEquals("[]", liste.toString());
        assertThrows( IndexOutOfBoundsException.class, () -> liste.get(0));
    }
}









