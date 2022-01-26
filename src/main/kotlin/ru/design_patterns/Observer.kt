package ru.design_patterns

/**
 * название: паттерн Observer
 *
 * применение: используется когда нам нужно подписаться на изменения какого-либо объекта
 *
 * описание: объект сообщает о своих изменениях наблюдателям, которые подписались ранее на его изменения
 */

/**
 * интерфейс нашего наблюдателя
 */
fun interface Observer {
    fun update(item: List<String>)
}

/**
 * интерфейс объекта, изменения которого мы будем слушать
 */
interface Observable {
    fun observe(observer: Observer)
    fun cancel(observer: Observer)
    fun notifyObservers()
}

/**
 * содержит некоторые данные, при изменении которых мы будем оповещать наблюдателей
 */
class PonyList : Observable {
    private val ponies = mutableListOf<String>()
    private val observers = mutableListOf<Observer>()

    fun add(pony: String) {
        ponies.add(pony)
        // оповещаем наших наблюдателей о том, что данные изменились
        notifyObservers()
    }

    override fun observe(observer: Observer) {
        observers.add(observer)
    }

    override fun cancel(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { observer -> observer.update(ponies) }
    }

}