package org.b0n541.kictacloe

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class GameStateTest {
    @Test
    fun newGame() {
        assertThat(GameState(3).moves).hasSize(0)
    }

    @Test
    fun newGamePlusFirstMove() {

        assertThat(GameState(3, listOf(Move.from("X:0:0"))).moves).hasSize(1)

        val gameState = GameState(3) + Move.from("X:0:0")
        assertThat(gameState.moves).hasSize(1)
    }

    @Test
    fun newGamePlusMultipleMoves() {
        val gameState = GameState(3) +
                Move.from("X:0:0") +
                Move.from("O:1:1") +
                Move.from("X:2:2")

        assertThat(gameState.moves).hasSize(3)
    }

    @Test
    fun newGamePlusInvalidMove() {
        assertThrows(IllegalStateException::class.java) { GameState(3) + Move.from("X:3:0") }
        assertThrows(IllegalStateException::class.java) { GameState(3) + Move.from("O:0:3") }
        assertThrows(IllegalStateException::class.java) { GameState(3) + Move.from("Z:0:0") }
    }

    @Test
    fun newGameToString() {
        assertThat(GameState(3).toString()).isEqualTo(
                """
                    
                     | | 
                    -+-+-
                     | | 
                    -+-+-
                     | |  -> DRAW
                """.trimIndent())
    }

    @Test
    fun newGamePlusMultipleMovesToString() {
        val gameState = GameState(3) +
                Move.from("X:0:0") +
                Move.from("O:1:1") +
                Move.from("X:2:2")

        assertThat(gameState.toString()).isEqualTo(
                """
                    
                    X| | 
                    -+-+-
                     |O| 
                    -+-+-
                     | |X -> DRAW
                """.trimIndent())
    }
}