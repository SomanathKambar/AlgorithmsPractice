package LeetCode

import java.util.Stack

fun main(){
    val input = "([{})]"
    val balancedBracket = BalancedBracket()
    println(balancedBracket.isBalanced(input))
}
class BalancedBracket {

    fun isBalanced(input: String) : Boolean{

       val stack: Stack<Char> = Stack()
        for(ch in input.toCharArray()) {
            if(ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch)
            } else  {
                if (stack.peek() == getOpeningBraceForChar(ch)) {
                    stack.pop()
                } else {
                    print("char = $ch")
                    println("!=  ${stack.peek()}")
                   return false
                }
            }
        }
        return stack.isEmpty()
    }

    private fun getOpeningBraceForChar(char: Char): Char {
        return when(char) {
            '}' -> '{'
            ']' -> '['
            ')'  -> '('
            else -> throw IllegalArgumentException("not a bracket")
        }
    }

}