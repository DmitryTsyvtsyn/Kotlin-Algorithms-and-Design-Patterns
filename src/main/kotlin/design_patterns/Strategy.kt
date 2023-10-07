package design_patterns

/**
 *
 * pattern: Strategy
 *
 * using: used when we need to change the behavior of an object
 *
 */

interface ExchangeStrategy {
    fun into(price: Double) : Double

    class Dollar : ExchangeStrategy {
        override fun into(price: Double): Double {
            return price / 70
        }
    }

    class Tenge : ExchangeStrategy {
        override fun into(price: Double): Double {
            return price * 6
        }
    }
}

class RubleExchangeRate {
    private var strategy : ExchangeStrategy = ExchangeStrategy.Dollar()

    fun changeStrategy(strategy: ExchangeStrategy) {
        this.strategy = strategy
    }

    fun exchange(priceInRuble: Double) = strategy.into(priceInRuble)
}

