package structures

import java.util.LinkedList
import kotlin.collections.LinkedHashSet

/**
 *
 * data structure: undirected graph without weights
 *
 * description: made up of vertices connected by edges
 *
 */

class Graph<T> {

    private val data = mutableMapOf<Vertex<T>, MutableList<Vertex<T>>>()

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
            list.remove(removingVertex)
        }
        data.remove(removingVertex)
    }

    /**
     * adds an edge between two vertices, that have values [value1], [value2]
     */
    fun addEdge(value1: T, value2: T) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.add(vertex2)
        data[vertex2]?.add(vertex1)
    }

    /**
     * removes an edge between two vertices, that have values [value1], [value2]
     */
    fun removeEdge(value1: T, value2: T) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.remove(vertex2)
        data[vertex2]?.remove(vertex1)
    }

    /**
     * returns the associated vertices with the given vertex value [value]
     */
    fun connectedVertexes(value: T) = data[Vertex(value)] ?: listOf()

    /**
     * traversal of the graph in depth, returns all vertices of the graph
     */
    fun depthFirstTraversal() : List<Vertex<T>> {
        val visited = LinkedHashSet<Vertex<T>>()
        val queue = LinkedList<Vertex<T>>()
        val firstVertex = data.keys.firstOrNull() ?: return emptyList()
        queue.push(firstVertex)
        while (queue.isNotEmpty()) {
            val vertex = queue.poll()
            if (!visited.contains(vertex)) {
                visited.add(vertex)
                queue.addAll(data[vertex] ?: listOf())
            }
        }
        return visited.toList()
    }

    /**
     * traversal of the graph in breadth, returns all vertices of the graph
     */
    fun breadthFirstTraversal() : List<Vertex<T>> {
        val visited = LinkedHashSet<Vertex<T>>()
        val queue = LinkedList<Vertex<T>>()
        val firstVertex = data.keys.firstOrNull() ?: return emptyList()
        queue.add(firstVertex)
        visited.add(firstVertex)
        while (queue.isNotEmpty()) {
            val vertex = queue.poll()
            data[vertex]?.forEach { v ->
                if (!visited.contains(v)) {
                    visited.add(v)
                    queue.add(v)
                }
            }
        }
        return visited.toList()
    }

}

/**
 * graph vertex model
 */
data class Vertex<T>(val value: T)
