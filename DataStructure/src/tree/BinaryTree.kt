package tree

import java.util.*

class BinaryNode(var value: String) {
      var leftChild: BinaryNode? = null
      var rightChild: BinaryNode? = null
}


fun main() {
    val b1 = BinaryNode("N1")
    val b2 = BinaryNode("N2")
    val b3 = BinaryNode("N3")
    val b4 = BinaryNode("N4")
    val b5 = BinaryNode("N5")
    val b6 = BinaryNode("N6")
    val b7 = BinaryNode("N7")
    val b8 = BinaryNode("N8")
    val b9 = BinaryNode("N9")
    b1.leftChild = b2
    b1.rightChild = b3

    b2.leftChild = b4
    b2.rightChild = b5

    b3.leftChild = b6
    b3.rightChild = b7

    b4.leftChild = b8
    b4.rightChild = b9
    val binaryTreeLL = BinaryTreeLL()
    binaryTreeLL.root = b1
    print("PreOrder:")
    binaryTreeLL.preOrder(binaryTreeLL.root)
    println()
    print("InOrder:")
    binaryTreeLL.inOrder(binaryTreeLL.root)
    println()
    print("PostOrder:")
    binaryTreeLL.postOrder(binaryTreeLL.root)
    println()
    print("LevelOrder:")
    binaryTreeLL.levelOrder()
    println()

    binaryTreeLL.search("N0")

    binaryTreeLL.insert("N10")
    binaryTreeLL.insert("N11")
    binaryTreeLL.levelOrder()

    binaryTreeLL.deleteDeepestNode()
    println()
    binaryTreeLL.levelOrder()
    println()
    print("Deepest node = ${binaryTreeLL.getDeepestNode()?.value}")
    println()

    binaryTreeLL.levelOrder()
    println()
    binaryTreeLL.deleteNode("N3")
    println()
    binaryTreeLL.levelOrder()

    println()
    binaryTreeLL.deleteNode("N3")
    println()
    binaryTreeLL.deleteTree()
    println()
    binaryTreeLL.levelOrder()

}
class BinaryTreeLL() {
     var root :BinaryNode? = null

    /**
     * PreOrder traversal Root->Left->Right
     */
    fun preOrder(binaryNode: BinaryNode?) {
        if(binaryNode == null) return
        print(binaryNode.value+ " ")
        preOrder(binaryNode.leftChild)
        preOrder(binaryNode.rightChild)
    }

    /**
     * InOrder traversal Left -> Root -> Right
     */
    fun inOrder(binaryNode: BinaryNode?) {
        if(binaryNode == null) return
        inOrder(binaryNode.leftChild)
        print(binaryNode.value + " ")
        inOrder(binaryNode.rightChild)
    }

    /**
     * PostOrder traversal Left-> Right -> Root
     */
    fun postOrder(binaryNode: BinaryNode?) {
        if(binaryNode == null) return
        postOrder(binaryNode.leftChild)
        postOrder(binaryNode.rightChild)
        print(binaryNode.value + " ")
    }

    /**
     * LevelOrder traversal Root->Left->Right
     */
    fun levelOrder() {
        if(root ==null) {
            println("BinaryTree is Empty")
            return
        }
    val queue :  Queue<BinaryNode> = LinkedList<BinaryNode>()
        queue.add(root)
        while(queue.isNotEmpty()) {
            val presentNode = queue.poll()
            print(presentNode.value + " ")
            if(presentNode.leftChild != null) {
                queue.add(presentNode.leftChild)
            }
            if(presentNode.rightChild != null) {
                queue.add(presentNode.rightChild)
            }
        }
    }

    //Search method
    fun search(value: String) {
        if(root == null) return
        val queue  = LinkedList<BinaryNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            if(currentNode!!.value == value) {
                System.out.println("The Value $value found in Tree")
                return
            } else {
                if(currentNode.leftChild != null) {
                    queue.add(currentNode.leftChild)
                }
                if(currentNode.rightChild != null) {
                    queue.add(currentNode.rightChild)
                }
            }
        }
        println("The Value $value is not Found in Tree")
    }


    fun insert(value: String) {
        val node = BinaryNode(value)
        if(root == null) {
            root = node
            println("SuccessFully Inserted a newNode at Root ")
            return
        }
        val queue = LinkedList<BinaryNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val currentNode = queue.poll()
            if(currentNode!!.leftChild == null) {
                currentNode.leftChild = node
                println("SuccessFully Inserted a newNode as LeftChild ")
                return
            } else if(currentNode.rightChild == null) {
                currentNode.rightChild = node
                println("SuccessFully Inserted a newNode as RightChild ")
                return
            } else {
                queue.add(currentNode.leftChild)
                queue.add(currentNode.rightChild)
            }
        }
    }

    /**
     * Deletes a Deepest Node
     */

    fun deleteDeepestNode() {
        if(root == null) {
            return
        }
        val queue = LinkedList<BinaryNode>()
        queue.add(root!!)
        var previousNode : BinaryNode?
        var currentNode : BinaryNode? = null
        while(queue.isNotEmpty()) {
            previousNode = currentNode
             currentNode = queue.poll()
            if(currentNode.leftChild == null) {
                previousNode!!.rightChild = null
                return
            } else if(currentNode.rightChild == null) {
                currentNode!!.leftChild = null
                return
            } else {
                queue.add(currentNode.leftChild!!)
            if(currentNode.rightChild != null) {
                queue.add(currentNode.rightChild!!)
            }
            }
        }
    }

    /**
     * Returns a Deepest Node
     */
    fun getDeepestNode(): BinaryNode? {
        if(root == null) return root
        var deepestNode: BinaryNode? = null
        val queue = LinkedList<BinaryNode>()
        queue.add(root!!)
        while (queue.isNotEmpty()) {
            deepestNode = queue.poll()
            if(deepestNode!!.leftChild != null) {
                queue.add(deepestNode.leftChild!!)
            }
            if(deepestNode.rightChild != null) {
                queue.add(deepestNode.rightChild!!)
            }
        }
        return deepestNode
    }

    /**
     * Deletes a Given Node O(n)
     */
    fun deleteNode(value: String) {
        if(root == null) {
            println("Tree is Empty")
            return
        }
        val queue = LinkedList<BinaryNode>()
        queue.add(root!!)
        while (queue.isNotEmpty()) { // -> O(n)
            val currentNode = queue.poll()
            if(currentNode.value == value) {
                val deepestNode = getDeepestNode() // --> O(n)
               currentNode.value =  deepestNode!!.value
                deleteDeepestNode() // --> O(n)
                println("Deleted value $value SuccessFully")
                return
            } else {
               if(currentNode.leftChild != null) queue.add(currentNode.leftChild!!)
               if(currentNode.rightChild != null) queue.add(currentNode.rightChild!!)
            }
        }

        println("The Value $value not found in tree")

    }

    /**
     * Deletes entire tree
     */
    fun deleteTree() {
        root = null
        println("Binary Tree has been deleted SuccessFully")
    }
}