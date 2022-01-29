![Алгоритмы на Kotlin](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/assets/algo_ru.png)

# Kotlin Algorithms and Design Patterns

<a href="https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/README_english.md"><img src="https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/assets/english.png" /></a>

В этом репозитории приведены наиболее распространенные алгоритмы, структуры данных и паттерны проектирования, написанные на языке программирования Kotlin.

Весь код разбит по отдельным пакетам:

1. <code>ru.sorting</code> - алгоритмы сортировки
2. <code>ru.search</code> - алгоритмы поиска
3. <code>ru.structures</code> - структуры данных (списки, массивы, стэк, очередь, бинарное дерево и др.)
4. <code>design-patterns</code> - паттерны проектирования
5. <code>ru.other</code> - другие алгоритмы (расстояние Левенштейна, алгоритм Кнута Морриса Пратта и т.д.)

Для каждого файла с кодом сделаны тесты, которые находятся в директории <code>test/kotlin</code>

Также по возможности я добавляю *javadoc* для каждого класса, метода и файла

Структура:

1. пакет <code>ru.design_patterns</code> - паттерны проектирования
    * [Builder](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Builder.kt)
    * [Decorator](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Decorator.kt)
    * [Facade](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Facade.kt)
    * [Factory](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Factory.kt)
    * [Fluent Interface](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Fluent%20Interface%20Pattern.kt)
    * [Monostate](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Monostate.kt)
    * [Singleton](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Singleton.kt)
    * [Strategy](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Strategy.kt)
    * [Observer](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Observer.kt)
    * [Dependency Injection](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Dependency%20%20Injection.kt)
    * [Adapter](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/design_patterns/Adapter.kt)

2. пакет <code>ru.structures</code> - структуры данных
    * [Бинарное дерево](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/structures/BinaryTree.kt)
    * [Стэк](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/structures/Stack.kt)
    * [Очередь](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/structures/Queue.kt)
    * [Граф](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/structures/Graph.kt)
    * [Динамический массив](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/structures/DynamicArray.kt)
    * [Связанный список](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/structures/LinkedList.kt)
    * [Min-куча](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/structures/MinHeap.kt)
    * [Max-куча](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/structures/MaxHeap.kt)

3. пакет <code>ru.sorting</code> - алгоритмы сортировки
    * [Пузырьковая сортировка](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/sorting/BubbleSort.kt)
    * [Пузырьковая сортировка (улучшенная)](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/sorting/BubbleSortImproved.kt)
    * [Сортировка вставками](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/sorting/InsertionSort.kt)
    * [Сортировака слиянием](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/sorting/MergeSort.kt)
    * [Быстрая сортировка](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/sorting/QuickSort.kt)
    * [Сортировка выбором](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/sorting/SelectionSort.kt)
    * [Поразрядная сортировка](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/sorting/RadixSort.kt)

4. пакет <code>ru.search</code> - алгоритмы поиска
    * [Бинарный поиск](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/search/BinarySearch.kt)
    * [Бинарный поиск (рекурсивный)](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/search/BinarySearchRecursive.kt)
    * [Линейный поиск](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/search/LinearSearch.kt)

5. пакет <code>ru.other</code> - другие алгоритмы
    * [Факториал числа](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/Factorial.kt)
    * [Алгоритм Кнута Морриса Пратта для поиска подстроки](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/KnuthMorrisPratt.kt)
    * [Расстояние Левенштейна](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/LevensteinLength.kt)
    * [Палиндром](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/Palindrome.kt)
    * [Алгоритм Эвклида](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/Euclid.kt)
    * [FizzBuzz](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/FizzBuzz.kt)
    * [Алгоритм переворота массива](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/ReverseArray.kt)
    * [Решето Эратосфена](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/SieveOfEratosthenes.kt)
    * [Поиск минимума](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/Max.kt)
    * [Поиск максимума](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/Min.kt)
    * [Квадратный корень из числа](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/ru/other/Sqrt.kt)

## Ваши пожелания и идеи

Если вы заинтересовались моим репозиторием или у вас появились идеи как его улучшить или что-то добавить, то сообщите мне об этом в телеграме:

<a href="https://t.me/good_twilly"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Telegram_logo.svg/1024px-Telegram_logo.svg.png" width=160 /></a>
