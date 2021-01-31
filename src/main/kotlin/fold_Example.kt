fun main(args: Array<String>) {
    val items = listOf(1, 2, 3, 4, 5)

    // SUM all the elements
    val sum = items.fold(0,    // fold, first argument is the initial item, an Int
        { acc: Int, i: Int ->        // fold, second argument is a function
                    acc + i
                                                    // When a lambda has parameters, they go first, followed by '->'
                                                    // First parameter: accumulator
                                                    // Second parameter: current element
                                                    // after -> body of the function
        })
    println("The sum of all elements is $sum")

    // CONCAT all the elements
    val concat = items.fold("Elements: ", { acc, i -> acc + " " + i })    // the first argument of fold determines
                                                                                //  the type of the result
    println("$concat")
}


