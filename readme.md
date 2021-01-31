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

## Lambda Expressions and Anonymous Functions
Lambda expressions and anonymous functions are 'function literals', i.e. functions that are not declared, 
but passed immediately as an expression. 

```kotlin
    max(strings, { a, b -> a.length < b.length })
```

Function max is a higher-order function, it takes a function value as the second argument. 
This second argument is an expression that is itself a function

### Lambda expression syntax
The full syntactic form of lambda expressions is as follows:
```kotlin
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
```
If we leave all the optional annotations out, what's left looks like this:
```kotlin
    val sum = { x: Int, y: Int -> x + y }
```

### Passing trailing lambdas
In Kotlin, there is a convention: if the last parameter of a function is a function, then a lambda expression passed as the corresponding argument can be placed outside the parentheses:
```kotlin
    val product = items.fold(1) { acc, e -> acc * e }
```
Such syntax is also known as **trailing lambda**.

If the lambda is the only argument to that call, the parentheses can be omitted entirely:
```kotlin
    run { println("...") }
```

### it: implicit name of a single parameter
It's very common that a lambda expression has only one parameter.

If the compiler can figure the signature out itself, it is allowed not to declare the only parameter and omit ->. 
The parameter will be implicitly declared under the name it:
```kotlin
    ints.filter { it > 0 } // this literal is of type '(it: Int) -> Boolean'
```

### Returning a value from a lambda expression
We can explicitly return a value from the lambda using the qualified return syntax. 
Otherwise, the value of the last expression is implicitly returned.

Therefore, the two following snippets are equivalent:
```kotlin
    ints.filter {
        val shouldFilter = it > 0
        shouldFilter
    }
    
    ints.filter {
        val shouldFilter = it > 0
        return@filter shouldFilter
    }
```

### Underscore for unused variables (since 1.1)
If the lambda parameter is unused, you can place an underscore instead of its name:
```kotlin
    map.forEach { _, value -> println("$value!") }
```

### Destructuring in Lambdas (since 1.1)
You can use the destructuring declarations syntax for lambda parameters. 
If a lambda has a parameter of the Pair type (or Map.Entry, or any other type that has 
the appropriate componentN functions), you can introduce several new parameters 
instead of one by putting them in parentheses:
```kotlin
    map.mapValues { entry -> "${entry.value}!" }
    map.mapValues { (key, value) -> "$value!" }
```

### Anonymous functions
An anonymous function looks very much like a regular function declaration, except that its name is omitted. 
Its body can be either an expression (as shown above) or a block:
```kotlin
    fun(x: Int, y: Int): Int = x + y

    fun(x: Int, y: Int): Int {
        return x + y
    }
```

### Closures
The variables captured in the closure can be modified in the lambda:
```kotlin
    var sum = 0
    ints.filter { it > 0 }.forEach {
        sum += it
    }
    print(sum)
```