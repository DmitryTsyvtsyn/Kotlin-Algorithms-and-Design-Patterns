package design_patterns

/**
 *
 * Observer is is a behavioral design pattern that defines a one-to-many relationship between objects
 *
 * such that when the state of one object changes all dependent objects are automatically notified and updated
 *
 */

fun interface PonyObserver {
    fun update(item: List<String>)
}

interface PonyObservable {
    fun addObserver(observer: PonyObserver)
    fun removeObserver(observer: PonyObserver)
    fun notifyObservers()
}

// PonyList contains some data and when it changes we will notify observers
class PonyList : PonyObservable {

    private val ponies = mutableListOf<String>()

    private val observers = mutableSetOf<PonyObserver>()

    fun add(pony: String) {
        ponies.add(pony)
        // notify observers that the data has changed
        notifyObservers()
    }

    override fun addObserver(observer: PonyObserver) {
        observers.add(observer)
    }

    override fun removeObserver(observer: PonyObserver) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { observer -> observer.update(ponies) }
    }

}