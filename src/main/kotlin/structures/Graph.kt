package structures

import java.util.LinkedList


/**
 * структура данных: граф
 *
 * описание: граф состоит из вершин, соединенных между собой ребрами
 */

class Graph<T> {
    private val data = mutableMapOf<Vertex<T>, MutableList<Vertex<T>>>()

    /**
     * добавляет новую вершину
     *
     * @value - значение новой вершины
     */
    fun addVertex(value: T) = data.putIfAbsent(Vertex(value), mutableListOf())

    /**
     * удаляет вершину из графа
     *
     * @value - значение вершины
     */
    fun removeVertex(value: T) {
        val removingVertex = Vertex(value)
        data.values.forEach { list ->
            list.remove(removingVertex)
        }
        data.remove(removingVertex)
    }

    /**
     * добавляет ребро между двумя вершинами
     *
     * @value1 - значение 1-ой вершины
     * @value2 - значение 2-ой вершины
     */
    fun addEdge(value1: T, value2: T) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.add(vertex2)
        data[vertex2]?.add(vertex1)
    }

    /**
     * удаляет ребро между двумя вершинами
     *
     * @value1 - значение 1-ой вершины
     * @value2 - значение 2-ой вершины
     */
    fun removeEdge(value1: T, value2: T) {
        val vertex1 = Vertex(value1)
        val vertex2 = Vertex(value2)
        data[vertex1]?.remove(vertex2)
        data[vertex2]?.remove(vertex1)
    }

    /**
     * возвращает связанные вершины с данной вершиной
     *
     * @value - значение вершины
     */
    fun connectedVertexes(value: T) = data[Vertex(value)] ?: listOf()

    /**
     * обход графа в глубину
     *
     * @return возвращает все вершины графа
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
     * обход графа в ширину
     *
     * @return возвращает все вершины графа
     */
    fun breadthFirstTraversal() : List<Vertex<T>> {
        val visited = LinkedHashSet<Vertex<T>>()
        val queue = LinkedList<Vertex<T>>()
        queue.add(data.keys.first())
        visited.add(data.keys.first())
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