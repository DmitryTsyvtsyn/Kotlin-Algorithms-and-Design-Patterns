package structures

/**
 *
 * data structure: directed graph with weights
 *
 * description: made up of vertices connected by edges that have direction and weight
 *
 */

class GraphWithWeights<T> {

    private val data = linkedMapOf<Vertex<T>, MutableList<VertexConnection<T>>>()

    /**
     * adds a new vertex with a value [value]
     */
    fun addVertex(value: T) = data.putIfAbsent(Vertex(value), mutableListOf())

    /**
     * removes a vertex by value [value] from a graph
     */
    fun removeVertex(value: T) {
        val removingVertex = Vertex(value)
        data.values.forEach { list ->
            list.removeIf { it.vertex == removingVertex }
        }
        data.remove(removingVertex)
    }

    /**
     * adds an edge between two vertices, that have values [value1], [value2]
     */
    fun addEdge(value1: T, value2: T, cost: Int) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.add(VertexConnection(vertex2, cost))
    }

    /**
     * removes an edge between two vertices, that have values [value1], [value2]
     */
    fun removeEdge(value1: T, value2: T) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.removeIf { it.vertex == vertex2 }
    }

    /**
     * returns the associated vertices and their weights with the given vertex value [value]
     */
    fun connectedVertexesWithWeights(value: T) = data[Vertex(value)] ?: listOf()

    /**
     * implementation of Dijkstra's algorithm, returns pairs of a vertex and the minimum weight needed to get to that vertex (the starting vertex is the first added)
     */
    fun dijkstraAlgorithm(): Map<Vertex<T>, Int> {
        val unvisitedVertexes = linkedMapOf<Vertex<T>, Int>()
        data.keys.forEach { vertex ->
            unvisitedVertexes[vertex] = Int.MAX_VALUE
        }

        val visitedVertexes = linkedMapOf<Vertex<T>, Int>()
        var minimumCost = 0

        var currentVertex = unvisitedVertexes.keys.firstOrNull() ?: return visitedVertexes
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
            visitedVertexes[currentVertex] = minimumCost
            unvisitedVertexes.remove(currentVertex)
            val nextUnvisitedEntry = unvisitedVertexes.entries
                .filter { it.value != Int.MAX_VALUE }
                .minByOrNull { it.value } ?: return visitedVertexes
            currentVertex = nextUnvisitedEntry.key
            minimumCost = nextUnvisitedEntry.value
        }
        return visitedVertexes
    }

}

/**
 * helper class for defining graph weights
 */
data class VertexConnection<T>(val vertex: Vertex<T>, val cost: Int)