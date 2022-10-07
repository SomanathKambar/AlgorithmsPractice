package LeetCode;

public class Utils {
    /* Data Structure                 purpose
    Linear DataStructures
    * 1.Array                   to store similar/Primitive type of data ex:int[] , String[], char[] etc
    *                            *IndexBased Access *Fixed length
    * 2.Stack                   LIFO -> last in first out , no Random access
    *   i.Deque
    *   ii. ArrayDeque
    *   iii.Stack
    *   iv. LinkedList
    * 3.Queue                    FIFO ->First in first out
    *      i.Simple Queue       insertion takes place at the rear and removal occurs at the front. It strictly follows the FIFO (First in First out) rule.
    *      ii.Deque, ArrayDeque Double ended Queue you can insert/remove elements from both head & tail
    *      iiI.CircularQueue    the last element points to the first element making a circular link.
    *      iv. PriorityQueue    A priority queue is a special type of queue in which each element is associated with a priority and is served according to its priority.
    *                           If elements with the same priority occur, they are served according to their order in the queue.
    * 4.List                    to store Generic/non-Primitive type of data  ex: ArrayList, LinkedList
    *                           * Random Access * Dynamic Size.
      non-Linear DataStructures
    * 5.Set                     to Store Distinct elements of a specific Type EX; HashSet, LinkedHashSet, TreeSet
    * 6.Map                     to store key value pair ex: HashMap, LinkedHasMap, Treemap, ArrayMap(only Android)
    * 7.Tree                    Trees are a collection of nodes (vertices), and they are linked with edges (pointers), representing the hierarchical connections between the nodes.
    *                               A node contains data of any type, but all the nodes must be of the same data type. Trees are similar to graphs, but a cycle cannot exist in a tree.
    *    i.N-ary trees.
        ii.Balanced trees.
       iii.Binary trees.
        iv.Binary Search Trees.
         v.AVL Trees.
        vi.Red-Black Trees.
       vii.2-3 Trees.
      viii.2-3-4 Trees.

    * 8.Graph                       In graph data structure, each node is called vertex and each vertex is connected to other vertices through edges.
            i.Spanning Tree and Minimum Spanning Tree
           ii.Strongly Connected Components
          iii.Adjacency Matrix
           iv.Adjacency List
    * 9.Heap
    * 10. HashTable
     */

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static long getTimeDiff(long start){
        return System.currentTimeMillis() - start;
    }
}
