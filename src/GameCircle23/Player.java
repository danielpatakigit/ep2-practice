package GameCircle23;

// This class represents a Player in a counting game. Every player has a name
// and a unique number.
//
public class Player {
  private static int playerCount = 0;

  private String name;
  private int number;

  // Use unique consecutive numbers for instances.
  // The first instance has number 1.

  // A constructor with the 'name' of the player.
  // Precondition: name != null (needs not be checked).
  public Player(String name) {
    this.name = name;
    playerCount++;
    this.number = playerCount;
  }

  // Returns the number of players that have been instantiated so far.
  public static int numberOfPlayers() {
    return playerCount;
  }

  // Returns a representation of this player with his name and his number in
  // parentheses, e.g.: Michael(5)
  public String toString() {
    return name + "(" + number + ")";
  }

}

