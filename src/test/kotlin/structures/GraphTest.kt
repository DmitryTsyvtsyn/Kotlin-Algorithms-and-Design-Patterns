package structures

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class GraphTest {

    @Test
    fun test_add_and_remove_vertexes() {
        val graph = Graph<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20)
        graph.addEdge(10, 30)
        graph.addEdge(20, 30)

        graph.removeVertex(10)

        assertEquals(listOf(Vertex(20), Vertex(30)), graph.breadthFirstTraversal())
    }

    @Test
    fun test_remove_edges() {
        val graph = Graph<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20)
        graph.addEdge(10, 30)
        graph.addEdge(20, 30)

        assertEquals(listOf(Vertex(20), Vertex(30)), graph.connectedVertexes(10))

        graph.removeEdge(10, 20)

        assertEquals(listOf(Vertex(30)), graph.connectedVertexes(10))

        graph.removeEdge(10, 30)

        assertEquals(emptyList<Vertex<Int>>(), graph.connectedVertexes(10))
        assertEquals(listOf(Vertex(30)), graph.connectedVertexes(20))
    }

    @Test
    fun test_empty() {
        val graph = Graph<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20)
        graph.addEdge(10, 30)
        graph.addEdge(20, 30)

        graph.removeVertex(10)
        graph.removeVertex(20)
        graph.removeVertex(30)

        val expected: List<Vertex<Int>> = listOf()
        assertEquals(expected, graph.breadthFirstTraversal())
    }

    @Test
    fun test_depth_first_traversal_if_graph_is_not_empty() {
        val graph = Graph<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)

        graph.addEdge(10, 20)
        graph.addEdge(20, 30)
        graph.addEdge(30, 10)

        assertEquals(listOf(Vertex(10), Vertex(20), Vertex(30)), graph.depthFirstTraversal())
    }

    @Test
    fun test_depth_first_traversal_if_graph_is_empty() {
        val graph = Graph<Int>()

        assertEquals(emptyList<Vertex<Int>>(), graph.depthFirstTraversal())
    }

    @Test
    fun test_breadth_first_traversal_if_graph_is_not_empty() {
        val graph = Graph<Int>()

        graph.addVertex(10)
        graph.addVertex(20)
        graph.addVertex(30)
        graph.addVertex(40)

        graph.addEdge(10, 20)
        graph.addEdge(20, 30)
        graph.addEdge(20, 40)

        assertEquals(listOf(Vertex(10), Vertex(20), Vertex(30), Vertex(40)), graph.breadthFirstTraversal())
    }

    @Test
    fun test_breadth_first_traversal_if_graph_is_empty() {
        val graph = Graph<Int>()

        assertEquals(emptyList<Vertex<Int>>(), graph.breadthFirstTraversal())
    }

}