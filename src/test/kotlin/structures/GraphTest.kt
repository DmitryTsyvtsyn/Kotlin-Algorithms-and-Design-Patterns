package structures

import org.junit.Test
import org.junit.Assert.assertEquals

internal class GraphTest {

    @Test
    fun `test add and remove vertexes`() {
        val graph = Graph<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20)
        graph.addEdge(10, 30)
        graph.addEdge(20, 30)

        assertEquals(listOf(20, 30), graph.connectedVertexes(10))
        assertEquals(listOf(10, 30), graph.connectedVertexes(20))

        graph.removeVertex(10)

        assertEquals(listOf(20), graph.connectedVertexes(30))
        assertEquals(listOf(30), graph.connectedVertexes(20))

        graph.removeVertex(20)

        assertEquals(listOf<Int>(), graph.connectedVertexes(30))
    }

    @Test
    fun `test remove edges`() {
        val graph = Graph<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20)
        graph.addEdge(10, 30)
        graph.addEdge(20, 30)

        assertEquals(listOf(20, 30), graph.connectedVertexes(10))

        graph.removeEdge(10, 20)

        assertEquals(listOf(30), graph.connectedVertexes(10))

        graph.removeEdge(10, 30)

        assertEquals(listOf<Int>(), graph.connectedVertexes(10))
        assertEquals(listOf(30), graph.connectedVertexes(20))

        graph.removeEdge(20, 30)

        assertEquals(listOf<Int>(), graph.connectedVertexes(20))
    }

    @Test
    fun `test depthFirstTraversal`() {
        val graph = Graph<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20)
        graph.addEdge(20, 30)
        graph.addEdge(30, 10)

        assertEquals(listOf(10, 20, 30), graph.depthFirstTraversal())

        graph.removeVertex(10)

        assertEquals(listOf(20, 30), graph.depthFirstTraversal())

        graph.removeVertex(30)

        assertEquals(listOf(20), graph.depthFirstTraversal())

        graph.removeVertex(20)

        assertEquals(listOf<Int>(), graph.depthFirstTraversal())
    }

    @Test
    fun `test breadthFirstTraversal`() {
        val graph = Graph<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)
        graph.addVertex(40)

        graph.addEdge(10, 20)
        graph.addEdge(20, 30)
        graph.addEdge(20, 40)

        assertEquals(listOf(10, 20, 30, 40), graph.breadthFirstTraversal())

        graph.removeVertex(10)

        assertEquals(listOf(20, 30, 40), graph.breadthFirstTraversal())

        graph.removeVertex(40)

        assertEquals(listOf(20, 30), graph.breadthFirstTraversal())

        graph.removeVertex(20)
        graph.removeVertex(30)

        assertEquals(listOf<Int>(), graph.breadthFirstTraversal())
    }

}