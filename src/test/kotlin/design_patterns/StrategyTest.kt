package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

internal class StrategyTest {

    @Test
    fun test() {
        val exchange = RubleExchangeRate()
        assertEquals(1.0, exchange.exchange(70.0), 0.0)

        exchange.changeStrategy(ExchangeStrategy.Tenge())
        assertEquals(60.0, exchange.exchange(10.0), 0.0)
    }

}