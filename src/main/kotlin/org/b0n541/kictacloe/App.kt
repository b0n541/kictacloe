package org.b0n541.kictacloe

fun main(args: Array<String>) {

    println("Welcome to Kic Tac Loe\n")

    val gameState = GameState(3)

    println(gameState)

    val gameState2 = gameState + Move.from("X:0:0")

    println(gameState2)
}
