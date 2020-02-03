package org.b0n541.kictacloe

data class GameState(val boardSize: Int, val moves: List<Move> = emptyList()) {

    val gameResult: GameResult
        get() {
            println("Computing game result...")
            return GameResult.DRAW
        }

    operator fun plus(move: Move): GameState {
        check(move.field.x < boardSize) { "x value must be between 0 and ${boardSize - 1}" }
        check(move.field.y < boardSize) { "y value must be between 0 and ${boardSize - 1}" }
        return GameState(boardSize, moves + move)
    }

    override fun toString() = format(getBoardStateFromMoves())

    private fun getBoardStateFromMoves(): Array<Array<String>> {
        val result = Array(boardSize) { Array(boardSize) { " " } }
        moves.forEach { result[it.field.x][it.field.y] = it.player.toString() }
        return result
    }

    private fun format(board: Array<Array<String>>): String {
        var result = "\n"
        for (i in 0..board.lastIndex) {
            for (j in 0..board.get(i).lastIndex) {
                result += board[i][j]
                if (j < 2) {
                    result += "|"
                }
            }
            if (i < 2) {
                result += "\n-+-+-\n"
            } else {
                result += " -> ${gameResult}"
            }
        }
        return result
    }
}

enum class GameResult {
    DRAW,
    X_WIN,
    O_WIN
}