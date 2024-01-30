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
    * [Abstract Factory](/src/main/kotlin/design_patterns/Abstract%20Factory.kt)
    * [Adapter](/src/main/kotlin/design_patterns/Adapter.kt)
    * [Bridge](/src/main/kotlin/design_patterns/Bridge.kt)
    * [Builder](/src/main/kotlin/design_patterns/Builder.kt)
    * [Chain Of Responsibilities](/src/main/kotlin/design_patterns/Сhain%20Of%20Responsibilities.kt)
    * [Command](/src/main/kotlin/design_patterns/Command.kt)
    * [Composite](/src/main/kotlin/design_patterns/Composite.kt)
    * [Decorator](/src/main/kotlin/design_patterns/Decorator.kt)
    * [Facade](/src/main/kotlin/design_patterns/Facade.kt)
    * [Factory Method](/src/main/kotlin/design_patterns/Factory%20Method.kt)
    * [Flyweight](/src/main/kotlin/design_patterns/Flyweight.kt)
    * [Interpreter](/src/main/kotlin/design_patterns/Interpreter.kt)
    * [Iterator](/src/main/kotlin/design_patterns/Iterator.kt)
    * [Mediator](/src/main/kotlin/design_patterns/Mediator.kt)
    * [Memento](/src/main/kotlin/design_patterns/Memento.kt)
    * [Observer](/src/main/kotlin/design_patterns/Observer.kt)
    * [Prototype](/src/main/kotlin/design_patterns/Prototype.kt)
    * [Proxy](/src/main/kotlin/design_patterns/Proxy.kt)
    * [Singleton](/src/main/kotlin/design_patterns/Singleton.kt)
    * [State](/src/main/kotlin/design_patterns/State.kt)
    * [Strategy](/src/main/kotlin/design_patterns/Strategy.kt)
    * [Template Method](/src/main/kotlin/design_patterns/Template%20Method.kt)
    * [Visitor](/src/main/kotlin/design_patterns/Visitor.kt)

2. пакет <code>ru.structures</code> - структуры данных
    * [Бинарное дерево](/src/main/kotlin/structures/BinaryTree.kt)
    * [Стэк](/src/main/kotlin/structures/Stack.kt)
    * [Очередь](/src/main/kotlin/structures/Queue.kt)
    * [Неориентированный граф](/src/main/kotlin/structures/Graph.kt)
    * [Ориентированный граф с весами](/src/main/kotlin/structures/GraphWithWeights.kt)
    * [Матрица](/src/main/kotlin/structures/Matrix.kt)
    * [Динамический массив](/src/main/kotlin/structures/MyArrayList.kt)
    * [Односвязный список](/src/main/kotlin/structures/SingleLinkedList.kt)
    * [Двусвязный список](/src/main/kotlin/structures/DoubleLinkedList.kt)
    * [Min-куча](/src/main/kotlin/structures/MinHeap.kt)
    * [Max-куча](/src/main/kotlin/structures/MaxHeap.kt)

3. пакет <code>ru.sorting</code> - алгоритмы сортировки
    * [Пузырьковая сортировка](/src/main/kotlin/sorting/BubbleSort.kt)
    * [Сортировка вставками](/src/main/kotlin/sorting/InsertionSort.kt)
    * [Сортировака слиянием](/src/main/kotlin/sorting/MergeSort.kt)
    * [Быстрая сортировка](/src/main/kotlin/sorting/QuickSort.kt)
    * [Сортировка выбором](/src/main/kotlin/sorting/SelectionSort.kt)
    * [Поразрядная сортировка](/src/main/kotlin/sorting/RadixSort.kt)
    * [Tim sort](/src/main/kotlin/sorting/TimSort.kt)
    * [Сортировка подсчётом](/src/main/kotlin/sorting/CountingSort.kt)

4. пакет <code>ru.search</code> - алгоритмы поиска
    * [Бинарный поиск](/src/main/kotlin/search/BinarySearch.kt)
    * [Линейный поиск](/src/main/kotlin/search/LinearSearch.kt)

5. пакет <code>ru.other</code> - другие алгоритмы
    * [Конечный автомат](/src/main/kotlin/other/BinaryDigitsCounter.kt)
    * [Алгоритм Эвклида](/src/main/kotlin/other/EuclidAlgorithm.kt)
    * [Факториал](/src/main/kotlin/other/Factorial.kt)
    * [Факториал из Google Guava библиотеки](/src/main/kotlin/other/FactorialAdvanced.kt)
    * [Факториал BigInteger'ов с кэшем](/src/main/kotlin/other/FactorialBigWithCache.kt)
    * [Факториал с кэшем](/src/main/kotlin/other/FactorialWithCache.kt)
    * [FizzBuzz](/src/main/kotlin/other/FizzBuzz.kt)
    * [Алгоритм Кнута Морриса Пратта для поиска подстроки](/src/main/kotlin/other/KnuthMorrisPrattAlgorithm.kt)
    * [Расстояние Левенштейна](/src/main/kotlin/other/LevenshteinLengthAlgorithm.kt)
    * [Поиск максимума](/src/main/kotlin/other/MaxAlgorithm.kt)
    * [Поиск минимума](/src/main/kotlin/other/MinAlgorithm.kt)
    * [Палиндром](/src/main/kotlin/other/PalindromeAlgorithm.kt)
    * [Проверка скобок на корректность](/src/main/kotlin/other/ParenthesisCheckAlgorithm.kt)
    * [Алгоритм переворота массива](/src/main/kotlin/other/ReverseArrayAlgorithm.kt)
    * [Решето Эратосфена](/src/main/kotlin/other/SieveOfEratosthenesAlgorithm.kt)
    * [Квадратный корень из числа](/src/main/kotlin/other/Sqrt.kt)
    * [Сравнение строк с помощью хэша](/src/main/kotlin/other/StringEqualsHashAlgorithm.kt)
    * [Алгоритм обмена двух переменных](/src/main/kotlin/other/SwapAlgorithm.kt)

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
