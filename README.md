![Алгоритмы на Kotlin](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/assets/algo_logo.png)

# Kotlin Algorithms and Design Patterns

<a href="https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/README_ru.md" target="_blank"><img src="https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/assets/russian_version.png" width="300px" /></a>

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
    * [Builder](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Builder.kt)
    * [Visitor](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/design_patterns/Visitor.kt)
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

2. package <code>structures</code> - data structure
    * [Binary tree](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/structures/BinaryTree.kt)
    * [Stack](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/structures/Stack.kt)
    * [Queue](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/structures/Queue.kt)
    * [Graph](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/structures/Graph.kt)
    * [Dynamic array](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/structures/DynamicArray.kt)
    * [Linked list](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/structures/LinkedList.kt)
    * [Min-heap](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/structures/MinHeap.kt)
    * [Max-heap](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/structures/MaxHeap.kt)

3. package <code>sorting</code> - sorting algorithms
    * [Bubble sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/BubbleSort.kt)
    * [Bubble sort (improved)](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/BubbleSortImproved.kt)
    * [Insertion sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/InsertionSort.kt)
    * [Merge sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/MergeSort.kt)
    * [Quick sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/QuickSort.kt)
    * [Selection sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/SelectionSort.kt)
    * [Radix sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/sorting/RadixSort.kt)

4. package <code>search</code> - search algorithms
    * [Binary search](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/search/BinarySearch.kt)
    * [Binary search (recursive)](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/search/BinarySearchRecursive.kt)
    * [Linear search](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/search/LinearSearch.kt)

5. package <code>other</code> - other algorithms
    * [Factorial](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Factorial.kt)
    * [Knut Morris Pratt's Algorithm for finding a substring](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/KnuthMorrisPratt.kt)
    * [Levenshtein distance](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/LevensteinLength.kt)
    * [Palindrome](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Palindrome.kt)
    * [Euclid's algorithm](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Euclid.kt)
    * [FizzBuzz](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/FizzBuzz.kt)
    * [Reverse Array](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/ReverseArray.kt)
    * [Sieve of Eratosthenes](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/SieveOfEratosthenes.kt)
    * [Finding the minimum](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Max.kt)
    * [Finding the maximum](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Min.kt)
    * [The square root of a number](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/other/Sqrt.kt)

## Your wishes and ideas

If you are interested in my repository or you have ideas on how to improve it or add something, then let me know in telegram:

<a href="https://t.me/good_twilly"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Telegram_logo.svg/1024px-Telegram_logo.svg.png" width=160 /></a>
