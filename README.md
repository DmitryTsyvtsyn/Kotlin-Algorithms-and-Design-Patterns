# Kotlin Algorithms and Design Patterns

В этом репозитории приведены наиболее распространенные алгоритмы, структуры данных и паттерны проектирования, написанные на языке программирования Kotlin.

Весь код разбит по отдельным пакетам:

1. <code>sorting</code> - алгоритмы сортировки
2. <code>search</code> - алгоритмы поиска
3. <code>structures</code> - структуры данных (списки, массивы, стэк, очередь, бинарное дерево и др.)
4. <code>design-patterns</code> - паттерны проектирования
5. <code>other</code> - другие алгоритмы (расстояние Левенштейна, алгоритм Кнута Морриса Пратта и т.д.)

Для каждого файла с кодом сделаны тесты, которые находятся в директории <code>test/kotlin</code>

Также по возможности я добавляю *javadoc* для каждого класса, метода и файла

Структура:

1. пакет <code>design_patterns</code> - паттерны проектирования
    * [Builder](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Builder.kt)
    * [Decorator](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Decorator.kt)
    * [Facade](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Facade.kt)
    * [Factory](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Factory.kt)
    * [Fluent Interface](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Fluent%20Interface%20Pattern.kt)
    * [Monostate](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Monostate.kt)
    * [Singleton](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Singleton.kt)
    * [Strategy](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Strategy.kt)
    * [Observer](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Observer.kt)
    * [Dependency Injection](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Dependency%20%20Injection.kt)
    * [Adapter](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Adapter.kt)

2. пакет <code>structures</code> - структуры данных
    * [Бинарное дерево](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/structures/BinaryTree.kt)
    * [Стэк](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/structures/Stack.kt)

3. пакет <code>sorting</code> - алгоритмы сортировки
    * [пузырьковая сортировка](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/BubbleSort.kt)
    * [пузырьковая сортировка (улучшенная)](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/BubbleSortImproved.kt)
    * [сортировка вставками](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/InsertionSort.kt)
    * [сортировака слиянием](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/MergeSort.kt)
    * [быстрая сортировка](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/QuickSort.kt)
    * [сортировка выбором](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/SelectionSort.kt)
    * [поразрядная сортировка](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/RadixSort.kt)

4. пакет <code>search</code> - алгоритмы поиска
    * [бинарный поиск](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/search/BinarySearch.kt)
    * [бинарный поиск (рекурсивный)](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/search/BinarySearchRecursive.kt)
    * [линейный поиск](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/search/LinearSearch.kt)

5. пакет <code>other</code> - другие алгоритмы
    * [факториал числа](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Factorial.kt)
    * [алгоритм Кнута Морриса Пратта для поиска подстроки](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/KnuthMorrisPratt.kt)
    * [расстояние Левенштейна](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/LevensteinLength.kt)
    * [палиндром](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Palindrome.kt)
    * [поиск минимума](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Max.kt)
    * [поиск максимума](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Min.kt)
    * [квадратный корень из числа](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Sqrt.kt)
