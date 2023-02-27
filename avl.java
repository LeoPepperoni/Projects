import java.util.*;

class Node
{
  int data;
  int leftHeight = -1;
  int rightHeight = -1;

  int maxHeight = -1;

  Node left = null;
  Node right = null;

  Node(int data)
  {
    this.data = data;
  }
}

class avlTree {
  Node root;
  boolean rotation = false;

  avlTree(int data) {
    this.root = new Node(data);
  }

  // Add nodes to the tree
  public void add(Node head, int[] array, int index, int lastNode) {
  
    }

  public void checkBalance (Node head)
  {
    if (head == null)
    {
      return;
    }
    //System.out.println("checking balance of " + head.data);

    if (head.left == null && head.right == null)
    {
      head.maxHeight = 0;
      return;
    }
    if (head.left == null && head.right != null)
    {
      head.maxHeight = head.right.maxHeight + 1;
      
      if (1 + head.right.maxHeight > 1)
      {
        this.rotation = true;
        return;
      }
    }
    if (head.left != null && head.right == null)
    {
      head.maxHeight = head.left.maxHeight + 1;
      //System.out.println("head left is " + head.leftHeight);
      if (1 + head.left.maxHeight > 1) {
        this.rotation = true;
        return;
      }
    }
    if (head.left != null && head.right != null)
    {
      head.maxHeight = 1 + Math.max(head.left.maxHeight, head.right.maxHeight);

      if (Math.abs(head.left.maxHeight - head.right.maxHeight) > 1) {
        this.rotation = true;
        return;
      }
    }
    checkBalance(head.left);
    checkBalance(head.right);
  }
}

  public class avl {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      int numCases = input.nextInt();

      for (int i = 1; i <= numCases; i++) {
        int numInserts = input.nextInt();
        int[] values = new int[numInserts];
        int headData = input.nextInt();

        avlTree myTree = new avlTree(headData);

        for (int j = 1; j < numInserts; j++) {
          values[j] = input.nextInt();
        }

        myTree.add(myTree.root, values, 1, numInserts - 1);
        myTree.checkBalance(myTree.root);

        if (myTree.rotation == false) {
          System.out.println("Tree #" + i + ": KEEP");
        } else {
          System.out.println("Tree #" + i + ": REMOVE");
        }
      }
    }
  }
