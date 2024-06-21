package Camel24;

/**
 * A caravan of camels implemented as a singly linked list with entries of 'Camel'.
 * There are no 'null' entries in the list.
 */
//
// TODO: define further classes and methods for the implementation of the singly linked list,
//  if needed. Do NOT use the Java-Collection framework in your implementation.
//
class Node {
  private Camel value;
  private Node next;

  public Node(Camel value, Node next) {
    this.value = value;
    this.next = next;
  }

  public Camel getValue() {
    return value;
  }

  public void setValue(Camel value) {
    this.value = value;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}


public class Caravan {

  private Node _head;

  /**
   * Initializes this caravan as an empty list.
   */
  public Caravan() {
    this._head = null;
  }

  /**
   * Adds 'camel' as the last camel to the end of this caravan.
   *
   * @param camel the camel to be added to the end of this caravan, camel != null.
   */
  public void addLast(Camel camel) {

    if (_head == null) {
      _head = new Node(camel, null);
      return;
    }

    Node current = _head;
    while (current.getNext() != null) {
      current = current.getNext();
    }

    current.setNext(new Node(camel, null));
  }

  /**
   * Inserts a new camel into this caravan. Seen from the head of the caravan, the camel is
   * inserted just before the first camel in the caravan that has the same strength as the
   * specified 'searchStrength'. If no such camel is found, the new camel is added as the head
   * of the caravan.
   *
   * @param searchStrength the strength of the camel to be found in the caravan.
   * @param camel          the camel to be inserted into the caravan, camel != null.
   */
  public void insertBefore(int searchStrength, Camel camel) {

    if (_head == null) {
      _head = new Node(camel, null);
    }

    Node current = _head;
    while (current != null && current.getNext() != null) {
      if (current.getNext().getValue().getStrength() == searchStrength) {
        Node temp = current.getNext();
        current.setNext(new Node(camel, temp));
        return;
      }
      current = current.getNext();
    }

    Node tempNext = _head.getNext();
    _head = new Node(camel, tempNext);
  }

  /**
   * Removes 'number' camels from the front of the caravan (the first 'number'
   * camels seen from the head of the caravan) and returns them as a new caravan in which they
   * have the same order as they had in 'this' (see examples in 'TreeSetPoint23.PraxisTest1.java'). If this
   * caravan is empty (this.size() == 0) or number == 0 then the result is a new empty caravan.
   * Precondition:
   *
   * @param number the number of camels to be removed from the front of this caravan,
   *               number >= 0 && number <= this.size().
   * @return the detached caravan.
   */
  public Caravan detachFront(int number) {

    if (_head == null || number == 0) {
      return new Caravan();
    }

    Caravan newCaravan = new Caravan();
    newCaravan._head = this._head;

    Node current = _head;
    while (--number >  0) {
      current = current.getNext();
    }

    _head = current.getNext();
    current.setNext(null);

    return newCaravan;

  }

  /**
   * Returns the number of camels in the caravan.
   *
   * @return the number of camels in the caravan.
   */
  public int size() {
    int size = 0;

    if (_head == null) {
      return size;
    }

    Node current = _head;
    size++;

    while (current.getNext() != null) {
      size++;
      current = current.getNext();
    }

    return size;
  }

  /**
   * Returns a string representation of this caravan with all its camels in brackets
   * in corresponding order with head of the caravan on the left,
   * followed by the pace of the caravan, which corresponds to the pace of
   * the slowest camel in the caravan.
   * Example: [(10-2=8), (5-2=3), (7-3=4), (10-3=7)] pace = 3
   * Returns "[]" if the caravan is empty.
   *
   * @return the string representation of this caravan.
   */
  public String toString() {

    if (_head == null) {
      return "[]";
    }

    StringBuilder sb = new StringBuilder("[");

    Node current = _head;
    int slowest = _head.getValue().getMaxPace();

    while (current != null) {
      sb.append(current.getValue().toString());

      if (current.getNext() != null) {
        sb.append(", ");
      }

      int maxPace = current.getValue().getMaxPace();
      if (maxPace < slowest) {
        slowest = maxPace;
      }
      current = current.getNext();
    }

    sb.append("] ");
    sb.append("pace = ");
    sb.append(slowest);

    return sb.toString();
  }
}

// TODO: define further classes, if needed (either here or in a separate file).
