package tree


fun main() {
    val root = TreeNode("Drinks")
    val child1 = TreeNode("Hot")
    val child2 = TreeNode("Cold")
    root.addChild(child1)
    root.addChild(child2)

    val child11 = TreeNode("Tea")
    val child12 = TreeNode("Coffee")
    child1.addChild(child11)
    child1.addChild(child12)
    val child21 = TreeNode("Wine")
    val child22 = TreeNode("Beer")
    child2.addChild(child21)
    child2.addChild(child22)
    println(root.print(0))
}
class TreeNode(val data: String) {
    private val children : MutableList<TreeNode> = mutableListOf()

    fun addChild(childNode: TreeNode) {
        children.add(childNode)
    }

    fun print(level: Int): String {
        var ret = "  ".repeat(level) + data + "\n"
        for (node in this.children) {
            ret += node.print(level + 1)
        }
        return ret
    }

}