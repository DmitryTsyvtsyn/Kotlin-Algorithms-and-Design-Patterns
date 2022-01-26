![Алгоритмы на Kotlin](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/assets/algo_english.png)

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
    * [Builder](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Builder.kt)
    * [Decorator](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Decorator.kt)
    * [Facade](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Facade.kt)
    * [Factory](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Factory.kt)
    * [Fluent Interface](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Fluent%20Interface%20Pattern.kt)
    * [Monostate](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Monostate.kt)
    * [Singleton](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Singleton.kt)
    * [Strategy](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Strategy.kt)
    * [Observer](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Observer.kt)
    * [Dependency Injection](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Dependency%20%20Injection.kt)
    * [Adapter](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/design_patterns/Adapter.kt)

2. package <code>structures</code> - data structure
    * [Binary tree](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/structures/BinaryTree.kt)
    * [Stack](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/structures/Stack.kt)
    * [Queue](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/structures/Queue.kt)
    * [Graph](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/structures/Graph.kt)
    * [Dynamic array](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/structures/DynamicArray.kt)
    * [Linked list](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/structures/LinkedList.kt)
    * [Min-heap](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/structures/MinHeap.kt)
    * [Max-heap](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/structures/MaxHeap.kt)

3. package <code>sorting</code> - sorting algorithms
    * [Bubble sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/sorting/BubbleSort.kt)
    * [Bubble sort (improved)](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/sorting/BubbleSortImproved.kt)
    * [Insertion sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/sorting/InsertionSort.kt)
    * [Merge sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/sorting/MergeSort.kt)
    * [Quick sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/sorting/QuickSort.kt)
    * [Selection sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/sorting/SelectionSort.kt)
    * [Radix sort](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/sorting/RadixSort.kt)

4. package <code>search</code> - search algorithms
    * [Binary search](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/search/BinarySearch.kt)
    * [Binary search (recursive)](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/search/BinarySearchRecursive.kt)
    * [Linear search](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/search/LinearSearch.kt)

5. package <code>other</code> - other algorithms
    * [Factorial](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/Factorial.kt)
    * [Knut Morris Pratt's Algorithm for finding a substring](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/KnuthMorrisPratt.kt)
    * [Levenshtein distance](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/LevensteinLength.kt)
    * [Palindrome](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/Palindrome.kt)
    * [Euclid's algorithm](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/Euclid.kt)
    * [FizzBuzz](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/FizzBuzz.kt)
    * [Reverse Array](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/ReverseArray.kt)
    * [Sieve of Eratosthenes](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/SieveOfEratosthenes.kt)
    * [Finding the minimum](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/Max.kt)
    * [Finding the maximum](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/Min.kt)
    * [The square root of a number](https://github.com/KiberneticWorm/Kotlin-Algorithms-and-Design-Patterns/blob/master/src/main/kotlin/en/other/Sqrt.kt)

## Your wishes and ideas

If you are interested in my repository or you have ideas on how to improve it or add something, then let me know in telegram:

<a href="https://t.me/good_twilly"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Telegram_logo.svg/1024px-Telegram_logo.svg.png" width=160 /></a>
