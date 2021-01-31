# FUNCTIONAL PROGRAMMING AND LAMBDAS

## Higher-Order Functions and Lambdas
Kotlin functions are first-class, which means that they can be stored in variables and data structures, passed as arguments to and returned from other higher-order functions.
A programming language is said to have first-class functions if it treats functions as first-class citizens. This means the language supports passing functions as arguments to other functions, returning them as the values from other functions, and assigning them to variables or storing them in data structures.
You can operate with functions in any way that is possible for other non-function values.

### Higher-Order Functions
A higher-order function is a function that takes functions as parameters, or returns a function.
A good example is the functional programming idiom fold for collections.

### Function types
Kotlin uses a family of function types like (Int) -> String for declarations that deal with functions: 
val onClick: () -> Unit = ....

These types have a special notation that corresponds to the signatures of the functions, 
i.e. their parameters and return values
(A, B) -> C
functions taking two arguments of types A and B and returning a value of type C. 
The parameter types list may be empty, as in () -> A. 
The Unit return type cannot be omitted.

```kotlin
    val stringPlus: (String, String) -> String = String::plus
    val intPlus: Int.(Int) -> Int = Int::plus

    println(stringPlus.invoke("<-", "->"))
    println(stringPlus("Hello, ", "world!"))

    println(intPlus.invoke(1, 1))
    println(intPlus(1, 2))
    println(2.intPlus(3)) // extension-like call
```