package TreeSetPoint23;// Please modify this file at each line containing TODO.

// A set of 2D-points (objects of type 'TreeSetPoint23.Point') implemented as a binary search tree.
// There are no duplicate entries in the set (no two elements e1 and e2 for which
// e1.isEqualTo(e2) is 'true'). To find an element, the search tree uses the city block distance
// between the element and a reference point as key. See the method 'distanceTo'
// in 'TreeSetPoint23.Point' that defines 'city block distance' through program code. The reference point is
// specified upon construction of the 'TreeSetPoint23.TreeSetPoint' object. It is not specified where to find
// elements with the same city block distance in the tree (but some some decision can lead to
// a simpler implementation than another one). The reference point itself need not be an
// element of the set (unless explicitly added as an element).

class Node {
  private Point value;
  private Node left;
  private Node right;

  public Node(Point value) {
    this.value = value;
  }

  public Point getValue() {
    return value;
  }

  public void setValue(Point value) {
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

public class TreeSetPoint {

  private Point _ref;
  private Node _root;


  // Initializes this set as an empty set. 'reference' is the reference point according
  // to the description of this class ('TreeSetPoint23.TreeSetPoint').
  // Precondition: reference != null.
  public TreeSetPoint(Point reference) {
    this._ref = reference;
    this._root = null;
  }

  // Adds the specified TreeSetPoint23.Point object to the set. The method does nothing if the set
  // already contained an element 'e' for which e.isEqualTo(point) == true.
  // Precondition: point != null.
  public void add(Point point) {
    if (_root == null) {
      _root = new Node(point);
      return;
    }
    addRecursive(_root, point);
  }

  private void addRecursive(Node node, Point point) {
    if (node.getValue().distanceTo(_ref) > point.distanceTo(_ref)) {
      if (node.getLeft() == null) {
        node.setLeft(new Node(point));
      } else {
        addRecursive(node.getLeft(), point);
      }
    } else if (node.getValue().distanceTo(_ref) < point.distanceTo(_ref)) {
      if (node.getRight() == null) {
        node.setRight(new Node(point));
      } else {
        addRecursive(node.getRight(), point);
      }
    } else if (!point.isEqualTo(node.getValue())) {
      this.add(point);
    }
  }

  // Adds all elements of the specified set to this set. 'set' is not changed by the method.
  // Precondition: set != null.
  public void addAll(TreeSetPoint set) {
    addAllRecursive(set._root);
  }

  private void addAllRecursive(Node current) {
    if (current != null) {
      addAllRecursive(current.getLeft());
      this.add(current.getValue());
      addAllRecursive(current.getRight());
    }
  }


  // Returns the number of points in this set having a city block distance to the set's reference
  // point less or equal to the specified 'distance' (given as parameter). The method exploits
  // the structure of the binary search tree and traverses only relevant parts of the tree.
  // Precondition: distance >= 0.
  public int countWithinRange(int distance) {
    if (_root == null) {
      return 0;
    }
    int[] counter = {0};
    countWithinRangeRecursive(_root, counter, distance);
    return counter[0];
  }

  private void countWithinRangeRecursive(Node current, int[] counter, int distance) {
    if (current == null) {
      return;
    }

    if (current.getValue().distanceTo(_ref) <= distance) {
      counter[0]++;
    }

    if (current.getLeft() != null && current.getLeft().getValue().distanceTo(_ref) <= distance) {
      countWithinRangeRecursive(current.getLeft(), counter, distance);
    }

    if (current.getRight() != null && current.getRight().getValue().distanceTo(_ref) <= distance) {
      countWithinRangeRecursive(current.getRight(), counter, distance);
    }
  }

  // Returns a string representation of 'this' with all points in brackets ordered ascending
  // according to their city block distance to the set's reference point, followed by the
  // reference point and its distance to the closest and most distant element.
  // (The order of two elements with the same distance is not specified.)
  // The format is as in the following example with a list of four points and the reference
  // point [0,1]:
  // "[[1,1], [1,2], [-1,2], [2,3]] ref [0,1] min 1 max 4"
  // If the set is empty the format is as follows (in this example the reference point is [0,1]):
  // "[] ref [0,1]"
  // See further examples in 'TreeSetPoint23.PraxisTest1.java'.
  public String toString() {
    if (_root == null) {
      return "[] ref " + _ref.toString();
    }

    int[] minmax = {Integer.MAX_VALUE, Integer.MIN_VALUE};

    StringBuilder sb = new StringBuilder("[");
    toStringRecursive(_root, sb, minmax);
    sb.deleteCharAt(sb.lastIndexOf(","));
    sb.deleteCharAt(sb.lastIndexOf(" "));
    sb.append("] ref ");
    sb.append(_ref.toString());
    sb.append(" min ");
    sb.append(minmax[0] == Integer.MAX_VALUE ? "0" : minmax[0]);
    sb.append(" max ");
    sb.append(minmax[1] == Integer.MIN_VALUE ? "0" : minmax[1]);

    return sb.toString();
  }

  private void toStringRecursive(Node current, StringBuilder sb, int[] minmax) {
    if (current != null) {
      toStringRecursive(current.getLeft(), sb, minmax);
      sb.append(current.getValue().toString());
      sb.append(", ");

      int distance = current.getValue().distanceTo(_ref);
      minmax[0] = Math.min(minmax[0], distance);
      minmax[1] = Math.max(minmax[1], distance);

      toStringRecursive(current.getRight(), sb, minmax);
    }
  }
}

