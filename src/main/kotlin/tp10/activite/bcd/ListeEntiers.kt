package tp10.activite.bcd

/**
 * Classe représentant des Listes d'entiers (tableaux dynamiques d'entiers)
 */
// Quelles sont les 2 méthodes qui ont été rajoutées à la classe ListeEntiers ?
// isEmpty() et contenuAsString()
// Sont-elles testées dans une des classes de test ? Justifie ta réponse.
//
// isEmpty() est testée dans toutes les méthodes de tests pour vérifier
// qu'une liste vide retourne bien true quand on invoque isEmpty(), et
// vérifier qu'une liste non vide retourne bien false quand on invoque isEmpty().
//
// contenuAsString() est explicitement testée dans les méthodes
// `test la représentation en chaine de caractère liste non vide`()
// `test la représentation en chaine de caractère liste vide`()
// de la classe ListeEntiersTests
//
// Quelle est la complexité de chacune de ces méthodes ?
// isEmpty() -> O(1)
// contenuAsString() -> O(n)
class ListeEntiers(tabEntiers: Array<Int>) {

    private val capaciteInitiale = 100
    private var capaciteReelle = capaciteInitiale
    private var tableauEntiers = Array<Int?>(capaciteReelle) { null }

    var taille = 0
        private set // tricky : seul l'accès en modification est privé !

    init {
        this.ajoute(tabEntiers)
    }


    /**
     * Retourne l'élément de la liste à l'indice spécifié.
     *
     * @param i l'indice de l'élément dans la liste
     */
    operator fun get(i: Int): Int {
        require(i in indices()) { "Indice invalide." }
        return tableauEntiers[i]!!
    }

    /**
     * Ajoute à la liste un nouvel entier.
     *
     * @param element l'entier à ajouter à la liste
     */
    fun ajoute(element: Int) {
        this.assureCapacite()
        this.tableauEntiers[taille] = element
        this.taille++
    }

    /**
     * Ajoute à la liste les entiers contenus dans le tableau.
     *
     * @param elements le tableau contenant les entiers à ajouter à la liste.
     *
     */
    fun ajoute(elements: Array<Int>) {
        this.assureCapacite(elements.size)
        for (element in elements) {
            this.ajoute(element)
        }
    }

    /**
     * Fournit le IntRange des indices valides
     *
     * @return le IntRange des indices valides
     */
    fun indices(): IntRange {
        return IntRange(0, taille - 1)
    }

    /**
     * Indique si la liste est vide
     *
     * @return true si la liste est vide, false sinon
     */
    fun isEmpty(): Boolean {
        return taille == 0
    }

    /**
     * @return le contenu textuel de la liste
     */
    fun contenuAsString(): String {
        var res = "["
        for (i in indices()) {
            res += this[i]
            if (i < taille-1) {
                res += ", "
            }
        }
        res += "]"
        return res
    }

    /**
     * Cherche un élément donné dans la liste courante.
     * Recherche linéaire : complexité en O(n)
     *
     * @param element l'élément recherché
     *
     * @return le premier indice de l'élément dans la liste ou -1
     * si l'élément n'est pas dans la liste.
     */
    fun chercheAvecApprocheLineaire(element: Int): Int {
        for (i in this.indices()) {
            if (this[i] == element) {
                return i
            }
        }
        return -1
    }

    /**
     * Cherche un élément donné dans la liste courante supposée triée.
     * Recherche dichotomique : complexité en O(log n)
     *
     * Si la liste n'est pas triée, le résultat est aléatoire
     *
     * @param element l'élément recherché
     *
     * @return un indice de l'élément dans la liste ou -1
     * si l'élément n'est pas dans la liste.
     */
    fun chercheAvecApprocheDichotomique(element: Int): Int {
        var gauche = 0
        var droite = taille - 1
        while (gauche <= droite) {
            val i = (droite + gauche) / 2
            if (this[i] == element) {
                return i
            } else if (this[i] < element) {
                gauche = i + 1
            } else {
                droite = i - 1
            }
        }
        return -1
    }

    /**
     * Calcule et retourne le nombre occurrences de l'élément donné
     * dans la liste.
     * Recherche linéaire : complexité en O(n)
     *
     * @param element l'élément dont on cherche le nombre occurrences
     * @return le nombre d'occurrences de l'élément donné
     */
    fun nombreOccurences(element: Int): Int {
        var nombreOccurences = 0
        for (i in this.indices()) {
            if (this[i] == element) {
                nombreOccurences++
            }
        }
        return nombreOccurences
    }

    /**
     * Supprime l'élément à l'indice donné
     * <ul>
     *     <li> Complexité meilleur cas : O(1) (on supprime le dernier élement => on décrémente la taille)
     *     <li> Complexité pire cas : O(n) (on supprime le premier élément => décalage de tous les éléments à droite)
     * </ul>
     *
     * @param indice l'indice de l'élément à supprimer
     *
     * @throws IllegalArgumentException si l'indice n'est pas valide
     */
    fun supprimeA(indice: Int) {
        require(indice in indices()) { "Indice invalide." }
        for(i in indice until taille-1) {
            this.tableauEntiers[i] = this.tableauEntiers[i +1]
        }
        this.taille--
    }

    /**
     * Vide la liste de tous ses éléments.
     * Complexité : O(1) ! Yippeeehh
     */
    fun vide() {
        this.taille = 0
    }

    private fun assureCapacite() {
        if (this.taille == this.capaciteReelle) {
            this.augmenteCapacite()
        }
    }

    private fun assureCapacite(nbElementsAAjouter: Int) {
        val tailleFinale = this.taille + nbElementsAAjouter
        if (tailleFinale > this.capaciteReelle) {
            this.augmenteCapacite(tailleFinale)
        }
    }


    private fun augmenteCapacite(tailleAugmentation: Int = this.capaciteInitiale) {
        this.capaciteReelle += tailleAugmentation
        val nouveauTableauElements = Array<Int?>(this.capaciteReelle) { null }
        for (i in 0 until this.taille) {
            nouveauTableauElements[i] = this.tableauEntiers[i]
        }
        this.tableauEntiers = nouveauTableauElements
    }

}
