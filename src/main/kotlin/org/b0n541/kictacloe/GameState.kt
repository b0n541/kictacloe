package org.b0n541.kictacloe

data class GameState(val boardSize: Int, val moves: List<Move> = emptyList()) {

    operator fun plus(move: Move): GameState = GameState(boardSize, moves + move)

    override fun toString(): String {
        val board = getBoard()
        var result = ""
        for (i in 0..board.lastIndex) {
            for (j in 0..board.get(i).lastIndex) {
                result += "${board[i][j]}"
                if (j < 2) result += "|"
            }
            result += "\n"
            if (i < 2) result += "-+-+-\n"
        }

        return result
    }

    private fun getBoard(): Array<Array<String>> {
        val result = Array(boardSize) { Array(boardSize) { " " } }
        moves.forEach { result[it.field.x][it.field.y] = it.player.toString() }
        return result
    }
}