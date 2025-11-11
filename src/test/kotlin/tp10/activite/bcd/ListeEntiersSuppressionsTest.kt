package tp10.activite.bcd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ListeEntiersSuppressionsTest {

 /*

    // === Tests sur méthode vide()
    @Test
    fun `test vidage d'une liste vide`() {
        // given :
        val liste = ListeEntiers(emptyArray())
        assertEquals(0, liste.taille)
        assertTrue(liste.isEmpty())
        // when :
        liste.vide()
        // then :
        assertTrue(liste.isEmpty())
        assertEquals(0, liste.taille)
    }

    @Test
    fun `test vidage d'une liste non vide`() {
        // given :
        val liste = ListeEntiers(arrayOf(12, -56, 18, 35))
        assertEquals(4, liste.taille)
        assertFalse(liste.isEmpty())
        // when :
        liste.vide()
        // then :
        assertTrue(liste.isEmpty())
        assertEquals(0, liste.taille)
    }

    @Test
    fun `test vidage d'une liste grande`() {
        // given :
        val liste = ListeEntiers(Array<Int>(1_000) {it})
        assertEquals(1000, liste.taille)
        assertFalse(liste.isEmpty())
        // when :
        liste.vide()
        // then :
        assertTrue(liste.isEmpty())
        assertEquals(0, liste.taille)
    }

    // === Tests sur méthode supprimeA()

    @Test
    fun `test suppression d'un élément a un indice valide au milieu`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -56, 18, 35))
        // when
        liste.supprimeA(1)
        // then
        assertEquals(3, liste.taille)
        println(liste.contenuAsString())
        assertEquals("[12, 18, 35]", liste.contenuAsString())
    }

    @Test
    fun `test suppression d'un élément a un indice valide avant dernier`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -56, 18, 35))
        // when
        liste.supprimeA(2)
        // then
        assertEquals(3, liste.taille)
        println(liste.contenuAsString())
        assertEquals("[12, -56, 35]", liste.contenuAsString())
    }

    @Test
    fun `test suppression d'un élément a un indice valide au début`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -56, 18, 35))
        // when
        liste.supprimeA(0)
        // then
        assertEquals(3, liste.taille)
        println(liste.contenuAsString())
        assertEquals("[-56, 18, 35]", liste.contenuAsString())
    }

    @Test
    fun `test suppression d'un élément a un indice valide à la fin`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -56, 18, 35))
        // when
        liste.supprimeA(3)
        // then
        assertEquals(3, liste.taille)
        println(liste.contenuAsString())
        assertEquals("[12, -56, 18]", liste.contenuAsString())
    }

    @Test
    fun `test suppression d'un élément a un indice sur liste vide`() {
        // given
        val liste = ListeEntiers(emptyArray())
        // then
        assertThrows<IllegalArgumentException> {
            liste.supprimeA(0)
        }
    }

    @Test
    fun `test suppression d'un élément a un indice invalide sur liste`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -56, 18, 35))
        // then
        assertThrows<IllegalArgumentException> {
            liste.supprimeA(5)
        }
    }

    // === Tests sur méthode supprime()

    @Test
    fun `test suppression d'un élément apparaissant au milieu du tableau`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -56, 18, 35))
        // when
        liste.supprime(-56)
        // then
        assertEquals(3, liste.taille)
        println(liste.contenuAsString())
        assertEquals("[12, 18, 35]", liste.contenuAsString())
    }

    @Test
    fun `test suppression d'un élément apparaissant au début`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -56, 18, 35))
        // when
        liste.supprime(12)
        // then
        assertEquals(3, liste.taille)
        println(liste.contenuAsString())
        assertEquals("[-56, 18, 35]", liste.contenuAsString())
    }

    @Test
    fun `test suppression d'un élément apparaissant à la fin`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -56, 18, 35))
        // when
        liste.supprime(35)
        // then
        assertEquals(3, liste.taille)
        println(liste.contenuAsString())
        assertEquals("[12, -56, 18]", liste.contenuAsString())
    }

    @Test
    fun `test suppression d'un élément sur liste vide`() {
        // given
        val liste = ListeEntiers(emptyArray())
        // when
        liste.supprime(35)
        // then
        assertTrue(liste.isEmpty())
    }

    @Test
    fun `test suppression d'un élément qui n'est pas dans la liste`() {
        // given
        val liste = ListeEntiers(arrayOf(12, -56, 18, 35))
        // when
        liste.supprime(500)
        // then
        assertEquals(4, liste.taille)
        println(liste.contenuAsString())
        assertEquals("[12, -56, 18, 35]", liste.contenuAsString())
    }

 */
}