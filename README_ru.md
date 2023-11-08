![Алгоритмы на Kotlin](/assets/algo_ru.png)

# Kotlin Algorithms and Design Patterns

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
    * [Builder](/src/main/kotlin/design_patterns/Builder.kt)
    * [Visitor](/src/main/kotlin/design_patterns/Visitor.kt)
    * [Command](/src/main/kotlin/design_patterns/Command.kt)
    * [Decorator](/src/main/kotlin/design_patterns/Decorator.kt)
    * [Facade](/src/main/kotlin/design_patterns/Facade.kt)
    * [Abstract Factory](/src/main/kotlin/design_patterns/Abstract%20Factory.kt)
    * [Factory Method](/src/main/kotlin/design_patterns/Factory%20Method.kt)
    * [Fluent Interface](/src/main/kotlin/design_patterns/Fluent%20Interface%20Pattern.kt)
    * [Monostate](/src/main/kotlin/design_patterns/Monostate.kt)
    * [Singleton](/src/main/kotlin/design_patterns/Singleton.kt)
    * [Strategy](/src/main/kotlin/design_patterns/Strategy.kt)
    * [Observer](/src/main/kotlin/design_patterns/Observer.kt)
    * [Dependency Injection](/src/main/kotlin/design_patterns/Dependency%20Injection.kt)
    * [Adapter](/src/main/kotlin/design_patterns/Adapter.kt)
    * [Memento](/src/main/kotlin/design_patterns/Memento.kt)
    * [Chain Of Responsibilities](/src/main/kotlin/design_patterns/Сhain%20Of%20Responsibilities.kt)

2. пакет <code>ru.structures</code> - структуры данных
    * [Бинарное дерево](/src/main/kotlin/structures/BinaryTree.kt)
    * [Стэк](/src/main/kotlin/structures/Stack.kt)
    * [Очередь](/src/main/kotlin/structures/Queue.kt)
    * [Неориентированный граф](/src/main/kotlin/structures/Graph.kt)
    * [Ориентированный граф с весами](/src/main/kotlin/structures/GraphWithWeights.kt)
    * [Матрица](/src/main/kotlin/structures/Matrix.kt)
    * [Динамический массив](/src/main/kotlin/structures/MyArrayList.kt)
    * [Связанный список](/src/main/kotlin/structures/LinkedList.kt)
    * [Min-куча](/src/main/kotlin/structures/MinHeap.kt)
    * [Max-куча](/src/main/kotlin/structures/MaxHeap.kt)

3. пакет <code>ru.sorting</code> - алгоритмы сортировки
    * [Пузырьковая сортировка](/src/main/kotlin/sorting/BubbleSort.kt)
    * [Пузырьковая сортировка (улучшенная)](/src/main/kotlin/sorting/BubbleSortImproved.kt)
    * [Сортировка вставками](/src/main/kotlin/sorting/InsertionSort.kt)
    * [Сортировака слиянием](/src/main/kotlin/sorting/MergeSort.kt)
    * [Быстрая сортировка](/src/main/kotlin/sorting/QuickSort.kt)
    * [Сортировка выбором](/src/main/kotlin/sorting/SelectionSort.kt)
    * [Поразрядная сортировка](/src/main/kotlin/sorting/RadixSort.kt)
    * [Tim sort](/src/main/kotlin/sorting/TimSort.kt)
    * [Сортировка подсчётом](/src/main/kotlin/sorting/CountSort.kt)

4. пакет <code>ru.search</code> - алгоритмы поиска
    * [Бинарный поиск](/src/main/kotlin/search/BinarySearch.kt)
    * [Бинарный поиск (рекурсивный)](/src/main/kotlin/search/BinarySearchRecursive.kt)
    * [Линейный поиск](/src/main/kotlin/search/LinearSearch.kt)

5. пакет <code>ru.other</code> - другие алгоритмы
    * [Факториал числа](/src/main/kotlin/other/Factorial.kt)
    * [Алгоритм Кнута Морриса Пратта для поиска подстроки](/src/main/kotlin/other/KnuthMorrisPratt.kt)
    * [Расстояние Левенштейна](/src/main/kotlin/other/LevensteinLength.kt)
    * [Палиндром](/src/main/kotlin/other/Palindrome.kt)
    * [Алгоритм Эвклида](/src/main/kotlin/other/Euclid.kt)
    * [FizzBuzz](/src/main/kotlin/other/FizzBuzz.kt)
    * [Алгоритм переворота массива](/src/main/kotlin/other/ReverseArray.kt)
    * [Решето Эратосфена](/src/main/kotlin/other/SieveOfEratosthenes.kt)
    * [Поиск минимума](/src/main/kotlin/other/Min.kt)
    * [Поиск максимума](/src/main/kotlin/other/Max.kt)
    * [Квадратный корень из числа](/src/main/kotlin/other/Sqrt.kt)
    * [Конечный автомат](/src/main/kotlin/other/BinaryDigitsCounter.kt)
    * [Проверка скобок на корректность](/src/main/kotlin/other/ParenthesisCheck.kt)
    * [Сравнение строк с помощью хэша](/src/main/kotlin/other/StringEqualsHash.kt)

## Ваши пожелания и идеи

Если вы заинтересовались моим репозиторием или у вас появились идеи как его улучшить или что-то добавить, напишите: [Telegram](https://t.me/rwcwuwr), [Gmail](mailto:dmitry.kind.2@gmail.com)


## Лицензия

      MIT License

      Copyright (c) 2023 Dmitry Tsyvtsyn

      Permission is hereby granted, free of charge, to any person obtaining a copy
      of this software and associated documentation files (the "Software"), to deal
      in the Software without restriction, including without limitation the rights
      to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
      copies of the Software, and to permit persons to whom the Software is
      furnished to do so, subject to the following conditions:

      The above copyright notice and this permission notice shall be included in all
      copies or substantial portions of the Software.

      THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
      IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
      FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
      AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
      LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
      OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
      SOFTWARE.
