package structures

import java.util.LinkedList
import kotlin.collections.LinkedHashSet

/**
 *
 * Graph is a non-linear data structure consisting of vertices and edges. 
 * 
 * The vertices are sometimes also referred to as nodes and the edges are lines or arcs that connect any two nodes in the graph.
 * 
 * More formally a Graph is composed of a set of vertices V and a set of edges E. The graph is denoted by G(E, V). 
 *
 * Undirected graph is a type of graph where the edges have no specified direction assigned to the them.
 *
 */

class Graph<T> {

    private val data = linkedMapOf<Vertex<T>, MutableList<Vertex<T>>>()

    // Complexity: O(1)
    fun addVertex(value: T) {
        data.putIfAbsent(Vertex(value), mutableListOf())
    }

    // Complexity: O(n)
    fun removeVertex(value: T) {
        val removingVertex = Vertex(value)
        data.values.forEach { list ->
            list.remove(removingVertex)
        }
        data.remove(removingVertex)
    }

    // Complexity: O(1)
    fun addEdge(value1: T, value2: T) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.add(vertex2)
        data[vertex2]?.add(vertex1)
    }

    // Complexity: O(1)
    fun removeEdge(value1: T, value2: T) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.remove(vertex2)
        data[vertex2]?.remove(vertex1)
    }

    // returns the associated vertices with the given vertex value
    fun connectedVertexes(value: T) = data[Vertex(value)]?.map { it.value } ?: emptyList()

    /**
     *
     * Traversal of the graph in depth,
     *
     * returns all vertices of the graph
     *
     */
    fun depthFirstTraversal() : List<T> {
        val firstVertex = data.keys.firstOrNull() ?: return emptyList()

        val visited = LinkedHashSet<T>()
        val queue = LinkedList<Vertex<T>>()
        queue.push(firstVertex)
        while (queue.isNotEmpty()) {
            val vertex = queue.pollFirst()
            if (!visited.contains(vertex.value)) {
                visited.add(vertex.value)
                queue.addAll(data[vertex] ?: emptyList())
            }
        }
        return visited.toList()
    }

    /**
     *
     * Traversal of the graph in breadth,
     *
     * returns all vertices of the graph
     *
     */
    fun breadthFirstTraversal() : List<T> {
        val firstVertex = data.keys.firstOrNull() ?: return emptyList()

        val visited = LinkedHashSet<T>()
        val queue = LinkedList<Vertex<T>>()
        queue.add(firstVertex)
        visited.add(firstVertex.value)
        while (queue.isNotEmpty()) {
            val vertex = queue.pollFirst()
            data[vertex]?.forEach { connectedVertex ->
                if (!visited.contains(connectedVertex.value)) {
                    visited.add(connectedVertex.value)
                    queue.add(connectedVertex)
                }
            }
        }
        return visited.toList()
    }

    private data class Vertex<T>(val value: T)

}
