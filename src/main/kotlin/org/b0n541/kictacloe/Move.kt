package org.b0n541.kictacloe

class Move(val player: Player, val field: Coordinate) {
    companion object {
        fun from(move: String): Move {
            val moveParts = move.split(":")
            return Move(Player.valueOf(moveParts[0]), Coordinate(moveParts[1].toInt(), moveParts[2].toInt()))
        }
    }
}

enum class Player {
    X,
    O
}

data class Coordinate(val x: Int, val y: Int)