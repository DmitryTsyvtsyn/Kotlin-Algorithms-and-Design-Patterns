package structures

import org.junit.Test
import org.junit.Assert.assertEquals

class GraphWithWeightsTest {

    @Test
    fun `test add and remove vertexes`() {
        val graph = GraphWithWeights<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20, 1)
        graph.addEdge(10, 30, 2)
        graph.addEdge(20, 30, 3)

        assertEquals(listOf(
            "vertex -> 20, cost -> 1",
            "vertex -> 30, cost -> 2"
        ), graph.connectedVertexesWithWeights(10))

        graph.removeVertex(10)

        assertEquals(listOf<String>(), graph.connectedVertexesWithWeights(10))

        assertEquals(listOf("vertex -> 30, cost -> 3"), graph.connectedVertexesWithWeights(20))

        graph.removeVertex(20)

        assertEquals(listOf<String>(), graph.connectedVertexesWithWeights(10))
    }

    @Test
    fun `test remove edges`() {
        val graph = GraphWithWeights<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20, 1)
        graph.addEdge(10, 30, 2)
        graph.addEdge(20, 30, 3)

        assertEquals(listOf(
            "vertex -> 20, cost -> 1",
            "vertex -> 30, cost -> 2"
        ), graph.connectedVertexesWithWeights(10))

        graph.removeEdge(10, 20)

        assertEquals(listOf("vertex -> 30, cost -> 2"), graph.connectedVertexesWithWeights(10))

        graph.removeEdge(10, 30)

        assertEquals(listOf<String>(), graph.connectedVertexesWithWeights(10))
        assertEquals(listOf("vertex -> 30, cost -> 3"), graph.connectedVertexesWithWeights(20))

        graph.removeEdge(20, 30)

        assertEquals(listOf<String>(), graph.connectedVertexesWithWeights(10))
    }

    @Test
    fun test_dijkstraAlgorithm() {
        val graph = GraphWithWeights<Int>()

        graph.addVertex(1)
        graph.addVertex(2)
        graph.addVertex(3)
        graph.addVertex(4)
        graph.addVertex(5)

        graph.addEdge(1, 2, 10)
        graph.addEdge(1, 5, 100)
        graph.addEdge(2, 3, 20)
        graph.addEdge(2, 4, 5)
        graph.addEdge(3, 4, 15)
        graph.addEdge(4, 5, 5)

        assertEquals(linkedMapOf(
            1 to 0,
            2 to 10,
            3 to 30,
            4 to 15,
            5 to 20
        ), graph.dijkstraAlgorithm())

        graph.removeVertex(4)

        assertEquals(linkedMapOf(
            1 to 0,
            2 to 10,
            3 to 30,
            5 to 100
        ), graph.dijkstraAlgorithm())

        graph.removeVertex(5)

        assertEquals(linkedMapOf(
            1 to 0,
            2 to 10,
            3 to 30
        ), graph.dijkstraAlgorithm())

        graph.removeVertex(1)
        graph.removeVertex(2)
        graph.removeVertex(3)

        assertEquals(mapOf<Int, Int>(), graph.dijkstraAlgorithm())
    }

}