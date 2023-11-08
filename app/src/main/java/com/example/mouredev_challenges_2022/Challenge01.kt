package com.example.mouredev_challenges_2022

/*
 * Reto #1
 * ¿ES UN ANAGRAMA?
 * Fecha publicación enunciado: 03/01/22
 * Fecha publicación resolución: 10/01/22
 * Dificultad: MEDIA
 *
 * Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
 * Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
 * NO hace falta comprobar que ambas palabras existan.
 * Dos palabras exactamente iguales no son anagrama.
 *
 * Información adicional:
 * - Usa el canal de nuestro discord (https://mouredev.com/discord) "🔁reto-semanal" para preguntas, dudas o prestar ayuda a la acomunidad.
 * - Puedes hacer un Fork del repo y una Pull Request al repo original para que veamos tu solución aportada.
 * - Revisaré el ejercicio en directo desde Twitch el lunes siguiente al de su publicación.
 * - Subiré una posible solución al ejercicio el lunes siguiente al de su publicación.
 *
 */

fun main() {
    print(checkAnagrama("duee", "eedu"))
}

fun checkAnagrama(word1: String, word2: String): Boolean {

    fun countLetter(word: String): Map<Char, Int> {
        val wordToUpper = word.uppercase()
        val wordUpperToArray = wordToUpper.toCharArray()
        val wordWithoutDuplies = wordToUpper.toSet()
        val wordMap: MutableMap<Char, Int> = mutableMapOf()

        for (i in wordUpperToArray) {
            wordMap[i] = 0
        }
        for (i in wordUpperToArray) {
            if (wordWithoutDuplies.contains(i)) {
                var num = wordMap[i]
                num = num!! + 1
                wordMap[i] = num
            }
        }
        return wordMap
    }

    return if (word1.length != word2.length) {
        false
    } else {
        val word1Map = countLetter(word1)
        val word2Map = countLetter(word2)
        word1Map == word2Map
    }

}