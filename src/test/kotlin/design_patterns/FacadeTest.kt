package design_patterns

import org.junit.Test
import org.junit.Assert.assertEquals

internal class FacadeTest {

    @Test
    fun test() {
        val goodsRepository = GoodsRepository(
            GoodsDatabase(),
            GoodsNetworkService(),
            CategoryDatabase(),
            CategoryNetworkService()
        )

        val actual = goodsRepository.goodsAndCategories()

        assertEquals(
            GoodsResult(
                goods = listOf(GoodsEntity(
                    id = 1,
                    name = "Head First Design Patterns: Building Extensible and Maintainable Object-Oriented Software 2nd Edition",
                    description = "You know you don't want to reinvent the wheel, so you look to Design Patterns: the lessons learned by those who've faced the same software design problems.",
                    price = 41.94
                )),
                categories = listOf(CategoryEntity(
                    id = 1,
                    name = "Books"
                ))
            ),
            actual
        )
    }

}