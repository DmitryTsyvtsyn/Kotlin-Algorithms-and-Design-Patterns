package design_patterns

/**
 *
 * Facade is a structural design pattern that simplifies the interface to a group of interfaces
 *
 * with a more complex implementation
 *
 */

data class GoodsEntity(
    private val id: Long,
    private val name: String,
    private val description: String,
    private val price: Double
)

class GoodsDatabase {
    private val cachedGoods = mutableListOf<GoodsEntity>()

    fun save(goods: List<GoodsEntity>) {
        cachedGoods.addAll(goods)
    }

    fun read() = cachedGoods
}

class GoodsNetworkService {

    fun fetch() = listOf(
        GoodsEntity(
            id = 1,
            name = "Head First Design Patterns: Building Extensible and Maintainable Object-Oriented Software 2nd Edition",
            description = "You know you don't want to reinvent the wheel, so you look to Design Patterns: the lessons learned by those who've faced the same software design problems.",
            price = 41.94
        )
    )

}

data class CategoryEntity(
    private val id: Long,
    private val name: String
)

class CategoryDatabase {
    private val cachedCategories = mutableListOf<CategoryEntity>()

    fun save(goods: List<CategoryEntity>) {
        cachedCategories.addAll(goods)
    }

    fun read() = cachedCategories
}

class CategoryNetworkService {

    fun fetch() = listOf(
        CategoryEntity(
            id = 1,
            name = "Books"
        )
    )

}

data class GoodsResult(
    val goods: List<GoodsEntity>,
    val categories: List<CategoryEntity>
)

// we have a group of interfaces (databases and network services)
class GoodsRepository(
    private val goodsDatabase: GoodsDatabase,
    private val goodsNetworkService: GoodsNetworkService,
    private val categoryDatabase: CategoryDatabase,
    private val categoryNetworkService: CategoryNetworkService
) {

    // we need a simpler interface
    fun goodsAndCategories() : GoodsResult {
        val goods = goodsDatabase.read().toMutableList()
        if (goods.isEmpty()) {
            val networkGoods = goodsNetworkService.fetch()
            goodsDatabase.save(networkGoods)
            goods.addAll(networkGoods)
        }

        val categories = categoryDatabase.read().toMutableList()
        if (categories.isEmpty()) {
            val networkCategories = categoryNetworkService.fetch()
            categoryDatabase.save(networkCategories)
            categories.addAll(networkCategories)
        }

        return GoodsResult(
            goods = goods,
            categories = categories
        )
    }

}