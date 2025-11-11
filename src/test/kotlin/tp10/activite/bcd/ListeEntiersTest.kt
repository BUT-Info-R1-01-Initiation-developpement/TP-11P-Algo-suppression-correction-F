package tp10.activite.bcd

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ListeEntiersTest {
    @Test
    fun `test la création d'une liste vide`() {
        // when
        val liste = ListeEntiers(emptyArray<Int>())
        // then
        assertEquals(0, liste.taille)
        assertTrue(liste.isEmpty())
    }

    @Test
    fun `test la création d'une liste avec un tableau dont la taille est inférieure à 100`() {
        // given
        val tab = arrayOf(12, -5, 18, -56)
        // when
        val liste = ListeEntiers(tab)
        assertFalse(liste.isEmpty())
        // then
        assertEquals(4, liste.taille)
        for (i in liste.indices()) {
            assertEquals(tab[i], liste.get(i))
        }
    }

    @Test
    fun `test la création d'une liste avec un tableau dont la taille est supérieure à 100`() {
        // given
        val tab = Array(150) { it } // créer le tableau [0, 1, 2, ..., 148, 149]
        // when
        val liste = ListeEntiers(tab)
        // then
        assertEquals(150, liste.taille)
        for (i in liste.indices()) {
            assertEquals(tab[i], liste.get(i))
        }
    }

    @Test
    fun `test la création d'une liste avec un tableau dont la taille est supérieure à 1000`() {
        // given
        val tab = Array(1500) { it } // créer le tableau [0, 1, 2, ..., 1498, 1499]
        // when
        val liste = ListeEntiers(tab)
        // then
        assertEquals(1500, liste.taille)
        for (i in liste.indices()) {
            assertEquals(tab[i], liste.get(i))
        }
    }

    @Test
    fun `test ajout d'un élément à un tableau de taille inférieure à 100`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -5, -40, 1253))
        assertEquals(4, liste.taille)
        // when
        liste.ajoute(-584)
        // then
        assertEquals(5, liste.taille)
        assertEquals(-584, liste.get(liste.taille-1))
    }

    @Test
    fun `test ajout d'un élément à un tableau de taille supérieure à 100`() {
        // given
        val liste = ListeEntiers(Array(150) { it })
        assertEquals(150, liste.taille)
        // when
        liste.ajoute(-584)
        // then
        assertEquals(151, liste.taille)
        assertEquals(-584, liste.get(liste.taille-1))
    }

    @Test
    fun `test ajout d'un élément à un tableau de taille supérieure à 1000`() {
        // given
        val liste = ListeEntiers(Array(1500) { it })
        assertEquals(1500, liste.taille)
        // when
        liste.ajoute(-584)
        // then
        assertEquals(1501, liste.taille)
        assertEquals(-584, liste.get(liste.taille-1))
    }

    @Test
    fun `test ajout d'éléments à un tableau de taille inférieure à 100`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -5, -40, 1253))
        assertEquals(4, liste.taille)
        // when
        liste.ajoute(Array(20) { it })
        // then
        assertEquals(24, liste.taille)
        assertEquals(19, liste.get(liste.taille-1))
    }

    @Test
    fun `test ajout de plus de 100 éléments à un tableau de taille inférieure à 100`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -5, -40, 1253))
        assertEquals(4, liste.taille)
        // when
        liste.ajoute(Array(150) { it })
        // then
        assertEquals(154, liste.taille)
        assertEquals(149, liste.get(liste.taille-1))
    }

    @Test
    fun `test ajout de plus de 1000 éléments à un tableau de taille inférieure à 100`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -5, -40, 1253))
        assertEquals(4, liste.taille)
        // when
        liste.ajoute(Array(1500) { it })
        // then
        assertEquals(1504, liste.taille)
        assertEquals(1499, liste.get(liste.taille-1))
    }

    @Test
    fun `test tentative d'accès invalide`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -5, -40, 1253))
        // then
        assertThrows<IllegalArgumentException> {
            liste.get(liste.taille)
        }
        assertThrows<IllegalArgumentException> {
            liste.get(-1)
        }
    }

    @Test
    fun `test creation grand tableau`() {
        // when
        val initTime = System.currentTimeMillis()
        ListeEntiers(Array(1_000_000) { it })
        val endTime = System.currentTimeMillis()
        val duree = endTime - initTime
        println("Duree creation d'un grand tableau : $duree")
        assertTrue(duree > 30)
    }

    @Test
    fun `test la représentation en chaine de caractère liste non vide`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -5, -40, 1253))
        // then
        println(liste.contenuAsString())
        assertEquals("[12, -5, -40, 1253]", liste.contenuAsString())
    }

    @Test
    fun `test la représentation en chaine de caractère liste vide`() {
        // given
        val liste = ListeEntiers(emptyArray())
        // then
        println(liste.contenuAsString())
        assertEquals("[]", liste.contenuAsString())
    }

}