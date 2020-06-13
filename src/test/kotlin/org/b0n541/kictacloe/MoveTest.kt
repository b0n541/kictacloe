package org.b0n541.kictacloe

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MoveTest {
    @Test
    fun parseFromString() {
        assertThat(
            Move.from("X:0:0") == Move(
                Player.X,
                Coordinate(0, 0)
            )
        )
    }
}