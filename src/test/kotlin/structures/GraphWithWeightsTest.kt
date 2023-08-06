package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions

class GraphWithWeightsTest {

    @Test
    fun test_add_and_remove_vertexes() {
        val graph = GraphWithWeights<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20, 1)
        graph.addEdge(10, 30, 2)
        graph.addEdge(20, 30, 3)

        val expected = listOf(
            VertexConnection(Vertex(20), 1),
            VertexConnection(Vertex(30), 2)
        )
        Assertions.assertEquals(expected, graph.connectedVertexesWithWeights(10))

        graph.removeVertex(10)

        Assertions.assertEquals(emptyList<VertexConnection<Int>>(), graph.connectedVertexesWithWeights(10))
    }

    @Test
    fun test_remove_edges() {
        val graph = GraphWithWeights<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20, 1)
        graph.addEdge(10, 30, 2)
        graph.addEdge(20, 30, 3)

        val expected1 = listOf(
            VertexConnection(Vertex(20), 1),
            VertexConnection(Vertex(30), 2)
        )
        Assertions.assertEquals(expected1, graph.connectedVertexesWithWeights(10))

        graph.removeEdge(10, 20)

        val expected2 = listOf(VertexConnection(Vertex(30), 2))
        Assertions.assertEquals(expected2, graph.connectedVertexesWithWeights(10))

        graph.removeEdge(10, 30)

        Assertions.assertEquals(emptyList<VertexConnection<Int>>(), graph.connectedVertexesWithWeights(10))
        Assertions.assertEquals(listOf(VertexConnection(Vertex(30), 3)), graph.connectedVertexesWithWeights(20))
    }

    @Test
    fun test_dijkstraAlgorithm() {
        val graph = GraphWithWeights<Int>()

        graph.addVertex(3)
        graph.addVertex(1)
        graph.addVertex(5)
        graph.addVertex(4)
        graph.addVertex(2)
        graph.addVertex(6)
        graph.addVertex(0)

        graph.addEdge(3, 1, 12)
        graph.addEdge(3, 5, 6)
        graph.addEdge(3, 4, 3)
        graph.addEdge(1, 0, 5)
        graph.addEdge(5, 2, 4)
        graph.addEdge(4, 2, 8)
        graph.addEdge(4, 6, 7)
        graph.addEdge(2, 0, 8)

        val expected = linkedMapOf(
            Vertex(3) to 0,
            Vertex(4) to 3,
            Vertex(5) to 6,
            Vertex(2) to 10,
            Vertex(6) to 10,
            Vertex(1) to 12,
            Vertex(0) to 17,
        )
        Assertions.assertEquals(expected, graph.dijkstraAlgorithm())
    }

}