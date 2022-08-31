package structures

import java.util.LinkedList

/**
 * data structure: graph
 *
 * description: a graph is made up of vertices connected by edges
 *
 */

class Graph<T> {

    private val data = mutableMapOf<Vertex<T>, MutableList<Vertex<T>>>()

    /**
     * adds a new vertex
     *
     * @param value - the value of the new vertex
     */
    fun addVertex(value: T) = data.putIfAbsent(Vertex(value), mutableListOf())

    /**
     * removes a vertex from a graph
     *
     * @param value - vertex value
     */
    fun removeVertex(value: T) {
        val removingVertex = Vertex(value)
        data.values.forEach { list ->
            list.remove(removingVertex)
        }
        data.remove(removingVertex)
    }

    /**
     * adds an edge between two vertices
     *
     * @param value1 - first vertex value
     * @param value2 - second vertex value
     */
    fun addEdge(value1: T, value2: T) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.add(vertex2)
        data[vertex2]?.add(vertex1)
    }

    /**
     * removes an edge between two vertices
     *
     * @param value1 - first vertex value
     * @param value2 - second vertex value
     */
    fun removeEdge(value1: T, value2: T) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.remove(vertex2)
        data[vertex2]?.remove(vertex1)
    }

    /**
     * returns the associated vertices with the given vertex
     *
     * @param value - vertex value
     */
    fun connectedVertexes(value: T) = data[Vertex(value)] ?: listOf()

    /**
     * traversal of the graph in depth
     *
     * @return returns all vertices of the graph
     */
    fun depthFirstTraversal() : List<Vertex<T>> {
        val visited = LinkedHashSet<Vertex<T>>()
        val queue = LinkedList<Vertex<T>>()
        queue.push(data.keys.first())
        while (queue.isNotEmpty()) {
            val vertex = queue.pop()
            if (!visited.contains(vertex)) {
                visited.add(vertex)
                queue.addAll(data[vertex] ?: listOf())
            }
        }
        return visited.toList()
    }

    /**
     * traversal of the graph in breadth
     *
     * @return returns all vertices of the graph
     */
    fun breadthFirstTraversal() : List<Vertex<T>> {
        val visited = LinkedHashSet<Vertex<T>>()
        val queue = LinkedList<Vertex<T>>()
        val firstVertex = data.keys.firstOrNull() ?: return listOf()
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

data class Vertex<T>(val value: T)