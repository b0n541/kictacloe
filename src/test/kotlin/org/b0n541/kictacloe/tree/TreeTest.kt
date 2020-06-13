package org.b0n541.kictacloe.tree

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test


class TreeTest {
    @Test
    fun emptyTree() {

        val tree =
            Tree(TreeNode(NodeStatistics()))

        assertThat(tree.rootNode.value.wins).isEqualTo(0)
        assertThat(tree.rootNode.value.playOuts).isEqualTo(0)

        assertThatThrownBy { tree.rootNode.value.getWinRate() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("No playouts done.")
    }

    @Test
    fun emptyTreeSelect() {

        val tree =
            Tree(TreeNode(NodeStatistics()))
        val selectedNode = tree.select()

        assertThat(tree.rootNode).isEqualTo(selectedNode)

        selectedNode.children
    }
}