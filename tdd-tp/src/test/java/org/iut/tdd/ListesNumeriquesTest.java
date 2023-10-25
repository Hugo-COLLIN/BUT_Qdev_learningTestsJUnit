package org.iut.tdd;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ListesNumeriquesTest {

    List<Integer> l1, l2, lRes;
    ListesNumeriques listesNumeriques;

    @BeforeEach
    void setUp() {
        listesNumeriques = new ListesNumeriques();

        l1 = new ArrayList<>();
        l2 = new ArrayList<>();
        lRes = new ArrayList<>();
    }

    @Test
    void testAjouteOk() {
        l1.add(1);
        l1.add(2);
        l2.add(3);
        l2.add(3);

        lRes.add(4);
        lRes.add(5);
        assertEquals(lRes, listesNumeriques.ajoute(l1, l2));
    }

    @Test
    void testAjouteThrowsException() {
        l1.add(0, 1);
        l1.add(0, 2);
        l2.add(0, 3);
        l2.add(0, 10);
        l2.add(0, 3);

        assertThatThrownBy(() -> listesNumeriques.ajoute(l1, l2))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testAjouteNull() {
        l1.add(0, 1);
        l1.add(0, 2);

        assertNull(listesNumeriques.ajoute(l1, null));
        assertNull(listesNumeriques.ajoute(null, l1));
    }

    @Test
    void testAjouteEmpty() {
        l1.add(0, 1);
        l1.add(0, 2);

        assertEquals(l1, listesNumeriques.ajoute(l1, new ArrayList<>()));
        assertEquals(l1, listesNumeriques.ajoute(new ArrayList<>(), l1));
    }


    @Test
    void testAreInLegalRangeThrowsException() {
        l1.add(0, 10);
        l1.add(0, 3);

        assertThatThrownBy(() -> listesNumeriques.areInLegalRange(l1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testAreInLegalRangeOk() {
        l1.add(0, 1);
        l1.add(0, 2);
        l2.add(0, 3);
        l2.add(0, 3);

        assertDoesNotThrow(() -> listesNumeriques.areInLegalRange(l1));
        assertDoesNotThrow(() -> listesNumeriques.areInLegalRange(l2));
    }

//    @Test



}