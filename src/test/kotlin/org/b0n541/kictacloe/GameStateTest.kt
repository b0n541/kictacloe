package org.b0n541.kictacloe

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test


class GameStateTest {
    @Test
    fun newGameState() {
        assertThat(GameState(3).moves).hasSize(0)
    }

    @Test
    fun newGameStatePlusFirstMove() {

        assertThat(GameState(3, listOf(Move.from("X,0,0"))).moves).hasSize(1)

        val gameState = GameState(3) + Move.from("X,0,0")
        assertThat(gameState.moves).hasSize(1)
    }

    @Test
    fun newGameStatePlusMultipleMoves() {
        val gameState = GameState(3) +
                Move.from("X,0,0") +
                Move.from("O,1,1") +
                Move.from("X,2,2")

        assertThat(gameState.moves).hasSize(3)
    }
}