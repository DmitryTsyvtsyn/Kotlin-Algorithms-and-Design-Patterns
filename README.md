![Алгоритмы на Kotlin](/assets/algo_logo.png)

# Kotlin Algorithms and Design Patterns

This repository lists the most common algorithms, data structures, and design patterns written in the Kotlin programming language.

All code is divided into separate packages:

1. <code>sorting</code> - sorting algorithms
2. <code>search</code> - search algorithms
3. <code>structures</code> - data structure (lists, arrays, stack, queue, binary trees, e.t.c)
4. <code>design-patterns</code> - design patterns
5. <code>other</code> - other algorithms (Levenshtein distance, Knut Morris Pratt algorithm, e.t.c)

For each code file, tests are made, which are located in the <code>test/kotlin</code> directory

Also, whenever possible, I add *javadoc* for each class, method, and file

Content:

1. package <code>design_patterns</code> - design patterns
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

2. package <code>structures</code> - data structure
    * [Binary tree](/src/main/kotlin/structures/BinaryTree.kt)
    * [Stack](/src/main/kotlin/structures/Stack.kt)
    * [Queue](/src/main/kotlin/structures/Queue.kt)
    * [Undirected Graph](/src/main/kotlin/structures/Graph.kt)
    * [Directed Graph with weights](/src/main/kotlin/structures/GraphWithWeights.kt)
    * [Matrix](/src/main/kotlin/structures/Matrix.kt)
    * [ArrayList](/src/main/kotlin/structures/MyArrayList.kt)
    * [Linked list](/src/main/kotlin/structures/LinkedList.kt)
    * [Min-heap](/src/main/kotlin/structures/MinHeap.kt)
    * [Max-heap](/src/main/kotlin/structures/MaxHeap.kt)

3. package <code>sorting</code> - sorting algorithms
    * [Bubble sort](/src/main/kotlin/sorting/BubbleSort.kt)
    * [Bubble sort (improved)](/src/main/kotlin/sorting/BubbleSortImproved.kt)
    * [Insertion sort](/src/main/kotlin/sorting/InsertionSort.kt)
    * [Merge sort](/src/main/kotlin/sorting/MergeSort.kt)
    * [Quick sort](/src/main/kotlin/sorting/QuickSort.kt)
    * [Selection sort](/src/main/kotlin/sorting/SelectionSort.kt)
    * [Radix sort](/src/main/kotlin/sorting/RadixSort.kt)
    * [Tim sort](/src/main/kotlin/sorting/TimSort.kt)
    * [Count sort](/src/main/kotlin/sorting/CountSort.kt)

4. package <code>search</code> - search algorithms
    * [Binary search](/src/main/kotlin/search/BinarySearch.kt)
    * [Binary search (recursive)](/src/main/kotlin/search/BinarySearchRecursive.kt)
    * [Linear search](/src/main/kotlin/search/LinearSearch.kt)

5. package <code>other</code> - other algorithms
    * [Factorial](/src/main/kotlin/other/Factorial.kt)
    * [Knut Morris Pratt's Algorithm for finding a substring](/src/main/kotlin/other/KnuthMorrisPratt.kt)
    * [Levenshtein distance](/src/main/kotlin/other/LevensteinLength.kt)
    * [Palindrome](/src/main/kotlin/other/Palindrome.kt)
    * [Euclid's algorithm](/src/main/kotlin/other/Euclid.kt)
    * [FizzBuzz](/src/main/kotlin/other/FizzBuzz.kt)
    * [Reverse Array](/src/main/kotlin/other/ReverseArray.kt)
    * [Sieve of Eratosthenes](/src/main/kotlin/other/SieveOfEratosthenes.kt)
    * [Finding the minimum](/src/main/kotlin/other/Min.kt)
    * [Finding the maximum](/src/main/kotlin/other/Max.kt)
    * [The square root of a number](/src/main/kotlin/other/Sqrt.kt)
    * [Finite state machine](/src/main/kotlin/other/BinaryDigitsCounter.kt)
    * [ParenthesisCheck](/src/main/kotlin/other/ParenthesisCheck.kt)
    * [StringEqualsHash](/src/main/kotlin/other/StringEqualsHash.kt)

## Your wishes and ideas

If you are interested in my repository or you have ideas on how to improve it or add something, then let me know in telegram:

<a href="https://t.me/rwcwuwr"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Telegram_logo.svg/1024px-Telegram_logo.svg.png" width=160 /></a>

## License

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
