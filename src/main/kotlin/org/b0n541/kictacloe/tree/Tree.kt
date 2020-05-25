package org.b0n541.kictacloe.tree

data class TreeNode<T>(val value: T, val children: List<TreeNode<T>> = emptyList())

class Tree<T>(rootNode: TreeNode<T>) {
    val rootNode: TreeNode<T> = rootNode

    fun select(): TreeNode<T> {
        var node = rootNode

        while (node.children.isNotEmpty()) {
            node = node.children[0]
        }

        return node
    }
}

data class NodeStatistics(val wins: Long = 0, val playOuts: Long = 0) {
    fun getWinRate(): Double {
        check(playOuts > 0) { "No playouts done." }
        return wins.toDouble() / playOuts.toDouble()
    }
}