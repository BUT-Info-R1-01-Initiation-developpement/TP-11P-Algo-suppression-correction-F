package tp10.activite.bcd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ListeEntiersRechercheTest {

    // ==== Recherche linéaire

    @Test
    fun `test recherche lineaire element dans le tableau`() {
        // when
        val liste = ListeEntiers(arrayOf(12, -56, -200, 2500))
        // then
        assertEquals(0, liste.chercheAvecApprocheLineaire(12))
        assertEquals(2, liste.chercheAvecApprocheLineaire(-200))
        assertEquals(3, liste.chercheAvecApprocheLineaire(2500))
    }

    @Test
    fun `test recherche lineaire element qui n'est pas dans le tableau`() {
        // when
        val liste = ListeEntiers(arrayOf(12, -56, -200, 2500))
        // then
        assertEquals(-1, liste.chercheAvecApprocheLineaire(60))
    }

    @Test
    @Disabled
    fun `test recherche lineaire element qui n'est pas dans un très grand tableau`() {
        // when
        val liste = ListeEntiers(Array(100_000_000) { it })
        // then
        val initTime = System.currentTimeMillis()
        assertEquals(-1, liste.chercheAvecApprocheLineaire(100_000_000))
        val endTime = System.currentTimeMillis()
        val duree = endTime - initTime
        println("Duree recherche lineaire sur grand tableau : $duree")
        assertTrue(duree > 100)
    }

    // ==== Recherche sur tableau trié

    @Test
    fun `test recherche dichotomique element dans le tableau`() {
        // when
        val liste = ListeEntiers(arrayOf(-200, -56, 12, 2500))
        // then
        assertEquals(0, liste.chercheAvecApprocheDichotomique(-200))
        assertEquals(2, liste.chercheAvecApprocheDichotomique(12))
        assertEquals(3, liste.chercheAvecApprocheDichotomique(2500))
    }

    @Test
    fun `test recherche dichotomique element qui n'est pas dans le tableau`() {
        // when
        val liste = ListeEntiers(arrayOf(-200, -56, 12, 2500))
        // then
        assertEquals(-1, liste.chercheAvecApprocheDichotomique(60))
    }

    @Test
    @Disabled
    fun `test recherche dichotomique element qui n'est pas dans un très grand tableau`() {
        // when
        val liste = ListeEntiers(Array(100_000_000) { it })
        // then
        val initTime = System.currentTimeMillis()
        assertEquals(-1, liste.chercheAvecApprocheDichotomique(100_000_000))
        val endTime = System.currentTimeMillis()
        val duree = endTime - initTime
        println("Duree recherche dichotomique sur grand tableau : $duree")
        assertTrue(duree < 10)
    }

    // === Comptage nombre occurences
    @Test
    fun `test comptage du nombre d'occurrences d'un élément non présent`() {
        // when
        val liste = ListeEntiers(arrayOf(12, -56, -200, 2500))
        // then
        assertEquals(0, liste.nombreOccurences(60))
    }

    @Test
    fun `test comptage du nombre d'occurrences d'un élément présent 1 fois`() {
        // when
        val liste = ListeEntiers(arrayOf(12, -56, -200, 2500))
        // then
        assertEquals(1, liste.nombreOccurences(-56))
    }

    @Test
    fun `test comptage du nombre d'occurrences d'un élément présent 3 fois`() {
        // when
        val liste = ListeEntiers(arrayOf(12, -56, -200, 2500, -56, 254, -18, -1000, -56, 999))
        // then
        assertEquals(3, liste.nombreOccurences(-56))
    }
}