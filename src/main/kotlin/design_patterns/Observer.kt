package design_patterns

/**
 *
 * pattern: Observer
 *
 * using: used when we need to subscribe to changes of some object
 *
 * description: the object communicates its changes to observers
 * who previously subscribed to its changes
 *
 */

fun interface Observer {
    fun update(item: List<String>)
}

/**
 * the interface of the object whose changes we will listen to
 */
interface Observable {
    fun observe(observer: Observer)
    fun cancel(observer: Observer)
    fun notifyObservers()
}

/**
 * contains some data, when it changes we will notify observers
 */
class PonyList : Observable {

    private val ponies = mutableListOf<String>()

    private val observers = mutableSetOf<Observer>()

    fun add(pony: String) {
        ponies.add(pony)
        // notify our observers that the data has changed
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