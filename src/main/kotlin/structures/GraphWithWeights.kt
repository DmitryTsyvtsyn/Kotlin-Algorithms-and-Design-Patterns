package structures


/**
 *
 * Graph is a non-linear data structure consisting of vertices and edges.
 *
 * The vertices are sometimes also referred to as nodes and the edges are lines or arcs that connect any two nodes in the graph.
 *
 * More formally a Graph is composed of a set of vertices V and a set of edges E. The graph is denoted by G(E, V).
 *
 * Directed graph with weights is a type of graph where the edges have specified direction and weights assigned to the them.
 *
 */

class GraphWithWeights<T> {

    private val data = linkedMapOf<Vertex<T>, MutableList<VertexConnection<T>>>()

    // Complexity: O(1)
    fun addVertex(value: T) {
        data.putIfAbsent(Vertex(value), mutableListOf())
    }

    // Complexity: O(n)
    fun removeVertex(value: T) {
        val removingVertex = Vertex(value)
        data.values.forEach { connections ->
            connections.removeIf { it.vertex == removingVertex }
        }
        data.remove(removingVertex)
    }

    // Complexity: O(1)
    fun addEdge(value1: T, value2: T, cost: Int) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.add(VertexConnection(vertex2, cost))
    }

    // Complexity: O(n)
    fun removeEdge(value1: T, value2: T) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.removeIf { it.vertex == vertex2 }
    }

    // returns the associated vertices and their weights with the given vertex value
    fun connectedVertexesWithWeights(value: T) = data[Vertex(value)]?.map { it.toString() }  ?: emptyList()

    /**
     *
     * Dijkstra's algorithm,
     *
     * returns pairs of a vertex and the minimum weight needed to get to that vertex,
     *
     * the starting vertex is the first added
     *
     */
    fun dijkstraAlgorithm(): Map<T, Int> {
        if (data.isEmpty()) return emptyMap()

        val unvisitedVertexes = linkedMapOf<Vertex<T>, Int>()
        data.keys.forEach { vertex ->
            unvisitedVertexes[vertex] = Int.MAX_VALUE
        }

        val visitedVertexes = linkedMapOf<T, Int>()
        var minimumCost = 0

        var currentVertex = unvisitedVertexes.keys.first()
        while(unvisitedVertexes.isNotEmpty()) {
            val neighbourVertexConnections = data[currentVertex] ?: emptyList()
            for (neighbourVertexConnection in neighbourVertexConnections) {
                val neighbourVertex = neighbourVertexConnection.vertex
                if (!unvisitedVertexes.contains(neighbourVertex)) continue

                val newCost = minimumCost + neighbourVertexConnection.cost
                val neighbourVertexCost = unvisitedVertexes[neighbourVertex] ?: Int.MAX_VALUE
                if (neighbourVertexCost > newCost) {
                    unvisitedVertexes[neighbourVertex] = newCost
                }
            }
            visitedVertexes[currentVertex.value] = minimumCost
            unvisitedVertexes.remove(currentVertex)
            val nextUnvisitedEntry = unvisitedVertexes.entries
                .filter { it.value != Int.MAX_VALUE }
                .minByOrNull { it.value } ?: return visitedVertexes
            currentVertex = nextUnvisitedEntry.key
            minimumCost = nextUnvisitedEntry.value
        }
        return visitedVertexes
    }

    private data class Vertex<T>(val value: T)

    // helper class for defining graph weights
    private data class VertexConnection<T>(val vertex: Vertex<T>, val cost: Int) {
        override fun toString(): String = "vertex -> ${vertex.value}, cost -> $cost"
    }

}