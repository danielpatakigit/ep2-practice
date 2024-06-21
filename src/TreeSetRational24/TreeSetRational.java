package TreeSetRational24;

/**
 * A set of rational numbers implemented as a binary search tree. There are no
 * duplicate entries in this set (no two elements e1 and e2 for which e1.compareTo(e2) == 0). The
 * elements are sorted according to their value (the ordering is given by the method 'compareTo'
 * of class 'Rational').
 */

class Node {
  private Rational value;

  private Node left;
  private Node right;

  public Node(Rational value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  public Rational getValue() {
    return value;
  }

  public void setValue(Rational value) {
    this.value = value;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}

public class TreeSetRational {
  Node _root;

  /**
   * Initialises 'this' as an empty set.
   */
  public TreeSetRational() {
    this._root = null;
  }

  /**
   * Adds the specified rational number to the set.
   * Returns 'true' if the set did not already contain the specified element
   * and 'false' otherwise.
   *
   * @param r the rational number to add to this set, r != null.
   */
  public boolean add(Rational r) {
    return addRecursive(_root, r);
  }

  private boolean addRecursive(Node current, Rational value) {
    if (current == null) {
      _root = new Node(value);
      return true;
    }

    if (value.compareTo(current.getValue()) < 0) {
      if (current.getLeft() == null) {
        current.setLeft(new Node(value));
        return true;
      } else {
        return addRecursive(current.getLeft(), value);
      }
    } else if (value.compareTo(current.getValue()) > 0) {
      if (current.getRight() == null) {
        current.setRight(new Node(value));
        return true;
      } else {
        return addRecursive(current.getRight(), value);
      }
    } else {
      return false;
    }
  }

  /**
   * Returns a new 'TreeSetRational' object that is the union of this set and the 'other' set.
   * 'this' and 'other' are not changed by this method.
   *
   * @param other the second operand != null.
   */
  public TreeSetRational union(TreeSetRational other) {

    TreeSetRational newSet = new TreeSetRational();

    addToNewSetRecursive(newSet, this._root);
    addToNewSetRecursive(newSet, other._root);

    return newSet;
  }

  private void addToNewSetRecursive(TreeSetRational set, Node node) {
    if (node != null) {
      addToNewSetRecursive(set, node.getLeft());
      set.add(node.getValue());
      addToNewSetRecursive(set, node.getRight());
    }
  }


  /**
   * Returns the number of rational numbers in the set that are within the range defined by
   * the lowest and highest rational number (inclusive). The method exploits the structure of
   * the binary search tree and traverses only relevant parts of the tree.
   *
   * @param highest the upper bound of the range.
   * @param lowest  the lower bound of the range.
   *                The following preconditions hold for 'highest' and 'lowest':
   *                lowest != null && highest != null && lowest.compareTo(highest) <= 0.
   * @return number of rational numbers in the set that are within the specified range.
   */
  public int countWithinRange(Rational lowest, Rational highest) {
    int[] counter = new int[1];

    countWithinRangeRecursive(_root, counter, lowest, highest);

    return counter[0];
  }

  private void countWithinRangeRecursive(Node node, int[] counter, Rational lowest, Rational highest) {
    if (node == null) {
      return;
    }

    // If left child may contain values within the range, traverse left subtree
    if (node.getLeft() != null && node.getValue().compareTo(lowest) >= 0) {
      countWithinRangeRecursive(node.getLeft(), counter, lowest, highest);
    }

    // If node data is within the range, increment the counter
    if (node.getValue().compareTo(lowest) >= 0 && node.getValue().compareTo(highest) <= 0) {
      counter[0]++;
    }

    // If right child may contain values within the range, traverse right subtree
    if (node.getRight() != null && node.getValue().compareTo(highest) <= 0) {
      countWithinRangeRecursive(node.getRight(), counter, lowest, highest);
    }
  }

  /**
   * Removes the lowest rational number from this set. Returns the rational number that was
   * removed from this set or 'null' if this set is empty.
   * (The corresponding node is removed by replacing it with the subtree of the node that
   * contains entries greater than the minimum.)
   *
   * @return the lowest rational number from this set or 'null' if this set is empty.
   */
  public Rational removeMinimum() {
    if (_root == null) {
      return null;
    }

    Node parent = null;
    Node current = _root;

    while (current.getLeft() != null) {
      parent = current;
      current = current.getLeft();
    }

    Rational minValue = current.getValue();

    if (parent == null) {
      _root = current.getRight();
    } else {
      parent.setLeft(current.getRight());
    }

    return minValue;
  }

  /**
   * Returns a string representation of 'this' with all rational objects
   * ordered ascending. The format of the string uses
   * brackets and is as in the following example with a set of four elements:
   * "[-3/4, -2/3, -1/3, 1/2]"
   * Returns "[]" if this set is empty.
   *
   * @return the string representation of 'this'.
   */
  public String toString() {
    if (_root == null) {
      return "[]";
    }

    StringBuilder sb = new StringBuilder("[");
    toStringRecursive(_root, sb);

    sb.deleteCharAt(sb.lastIndexOf(","));
    sb.deleteCharAt(sb.lastIndexOf(" "));

    sb.append("]");
    return sb.toString();
  }

  private void toStringRecursive(Node node, StringBuilder sb) {
    if (node != null) {
      toStringRecursive(node.getLeft(), sb);
      sb.append(node.getValue().toString());
      sb.append(", ");
      toStringRecursive(node.getRight(), sb);
    }
  }
}

