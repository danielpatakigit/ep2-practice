package GameCircle23;
// This class represents players sitting in a circle in a counting game.
// Objects of type 'Player' are stored in a ring list (all nodes have a successor node != null).
// The first player starts counting "1", the second counts "2", etc., until the player, who reaches the
// specified dropout number. This player is removed from the game and the player next to his position
// starts counting again with "1" in the next round.
//
// Example (4 Players, dropout number is 3):
//
// Round 1:
// Player1      Player2     Player3     Player4
// "1"
//              "2"
//                          "3!"
// -> Player3 removed
//
// Round 2:
// Player1      Player2     Player4
//                          "1"
// "2"                      ⤶
//              "3!"
// -> Player2 removed
//
// Round 3:
// Player1      Player4
//              "1"
// "2"          ⤶
//              "3!"
// -> Player4 removed
// Player1 wins!


class Node {
  private Player player;
  private Node next;

  public Node(Player player) {
    this.player = player;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}


public class GameCircle {
  private Node head;
  private int size;
  private Node startingNode;


  // Initializes this GameCircle with the players created according to
  // 'playerNames'. The player playerNames[i] gets the number i+1.
  // playerNames[0] is the player who will start counting.
  // Preconditions: 'playerNames' is not null and has no 'null'-entries (need not be checked).
  public GameCircle(String[] playerNames) {
    this.size = playerNames.length;
    this.head = new Node(new Player(playerNames[0]));

    head.setNext(head);
    Node insertedNode = head;
    Node newNode = null;
    for (int i = 1; i < playerNames.length; i++) {
      newNode = new Node(new Player(playerNames[i]));
      insertedNode.setNext(newNode);
      insertedNode = newNode;
    }
    startingNode = head;
    assert newNode != null;
    newNode.setNext(head);
  }


  // This method simulates one round of the counting game with
  // dropout number 'dropOutCount'. It returns the player who is removed
  // in this round. Returns 'null' if there is no player in the game circle.
  // Note that the starting position for counting depends on the previous round!
  // Precondition: dropOutCount > 0 (needs not be checked).
  public Player play(int dropOutCount) {
    if (isEmpty()) {
      return null;
    }
    if (size == 1) {
      Node tempNode = head;
      head = null;
      startingNode = null;
      size--;
      return tempNode.getPlayer();
    }

//    int positionsToMove = dropOutCount % size;
    Node current = startingNode;
    while (dropOutCount > 1) {
      current = current.getNext();
      dropOutCount--;
    }

    Node toRemove = current.getNext();
    Node next = current.getNext().getNext();

    if (size <= 2) {
      head = next;
      head.setNext(head);
      startingNode = head;
    } else {
      current.setNext(next);
      startingNode = next;
    }

    size--;
    toRemove.setNext(null);
    return toRemove.getPlayer();
  }

  // Returns 'true' if there is no player in the game circle.
  public boolean isEmpty() {
    return size == 0;
  }

  // Returns a representation of this game circle with all its (remaining) players in
  // brackets in order of their insertion (player with smallest number is left).
  // The player that starts counting in the next round is marked by '*'.
  // Returns "[]" if the circle is empty.
  public String toString() {
    StringBuilder sb = new StringBuilder("[ ");
    if (isEmpty()) {
      return "";
    }
    if (size == 1) {
      return "[ *" + head.getPlayer().toString() + "* ]";
    }


    if (startingNode.getNext() == head) {
      sb.append("*");
      sb.append(head.getPlayer().toString());
      sb.append("*");
    } else {
      sb.append(head.getPlayer().toString());
    }
    sb.append(" ");


    Node current = head.getNext();

    while (current != head) {
      if (startingNode.getNext() == current) {
        sb.append("*");
        sb.append(current.getPlayer().toString());
        sb.append("*");
      } else {
        sb.append(current.getPlayer().toString());
      }
      sb.append(" ");
      current = current.getNext();
    }

    sb.append("]");
    return sb.toString();
  }

}

