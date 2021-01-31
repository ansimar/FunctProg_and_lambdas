// Function types examples

fun main(args: Array<String>) {
    val result = applyFunction(5, 10, sum)
    println("The result is $result")

    val listStr = listOf("Uno", "Dos", "Tres")
    val size = applyFunctionToList(listStr, getSizeOfListOfStrings)
    println("The size is $size")


}

// Function that apply to two arguments another function
// a, first argument
// b, second argument
// x, function to be applied that returns an Int
fun applyFunction(a: Int, b: Int, x: (Int, Int) -> Int): Int{
    return x(a, b) // or x.invoke(a, b)
}
// Function type example 1. Function that adds two numbers
val sum: (a: Int, b: Int) -> Int = { a, b -> a + b }

fun applyFunctionToList(a: List<String>, x: (List<String>) -> Int): Int{
    return x.invoke(a) // or x(a)
}
// Function type example 2. Function that returns the size of a list of Strings
val getSizeOfListOfStrings: (a: List<String>) -> Int = List<String>::size