// Title:    P09_Leaderboard
// Course:   CS 300 Fall 2024
//
// Author:   Maanan Purothi
// Email:    purothi@wisc.edu
// Lecturer: Hobbes LeGault

import java.util.NoSuchElementException;
public class LeaderboardTester {
  
  
  /////////////////////////////////////////// COMPARE TO ///////////////////////////////////////////

  /**
   * Tests Player Class' compareTo method using 3 private helper tester methods.
   * @return true if all 3 helpers pass
   */
  public static boolean testPlayerCompareTo() {
    boolean test1 = testCompareToDiffScore();
    boolean test2 = testCompareToSameScoreDiffName();
    boolean test3 = testCompareToEqual();
    if (!test1) System.out.print("diffScore FAIL ");
    if (!test2) System.out.print("diffName FAIL ");
    if (!test3) System.out.print("equals FAIL ");
    return test1 && test2 && test3;
  }
  /**
   * @return true if compareTo returns a negative when a player with a lower score is compared with one with a higher score 
   */
  private static boolean testCompareToDiffScore() {
    try {
      
    
    Player p1 = new Player("a");
    Player p2 = new Player("a");
    
    p1.setScore(2);
    p2.setScore(5);
    
    
    return p1.compareTo(p2) < 0;
    } catch(Exception e) {
      return false;
    }
  }
  
  /**
   * @return true if compareTo returns a negative when a player with an alphabetically lower name is compared with an alphabetically higher name
   */
  private static boolean testCompareToSameScoreDiffName() {
    try {
      Player p1 = new Player("a");
      Player p2 = new Player("b");
      
      p1.setScore(5);
      p2.setScore(5);
      
      
      return p1.compareTo(p2) < 0;
  } catch(Exception e) {
    return false;
  }
  }
  /**
   * @return true if compareTo returns a 0 when two equal players are compared 
   */
  private static boolean testCompareToEqual() {
    try {
        Player p1 = new Player("a");
        Player p2 = new Player("a");
        
        p1.setScore(5);
        p2.setScore(5);
        
        
        return p1.compareTo(p2) == 0;
    } catch(Exception e) {
      return false;
    }
  }
  
  ///////////////////////////////////////// LOOKUP: NAME /////////////////////////////////////////
  
  public static boolean testNameLookup() {
    boolean test1 = testLookupRoot();
    boolean test2 = testLookupLeft();
    boolean test3 = testLookupRight();
    boolean test4 = testLookupNotPresent();
    if (!test1) System.out.print("lookupRoot FAIL ");
    if (!test2) System.out.print("lookupLeft FAIL ");
    if (!test3) System.out.print("lookupRight FAIL ");
    if (!test4) System.out.print("lookupNotPresent FAIL");
    return test1 && test2 && test3 && test4;
  }
  
  // HINT: for these testers, add one Player at the root and then build the rest of the tree manually
  // using the reference returned by getRoot(), so that you are not relying on the correctness of
  // the addPlayer() method.
  
  private static boolean testLookupRoot() {
    try {
      Leaderboard lb = new Leaderboard();
      
      Player ans = new Player("d");
      
      lb.addPlayer(ans);
      
      lb.getRoot().setLeft(new BSTNode<>(new Player("b")));
      lb.getRoot().getLeft().setLeft(new BSTNode<>(new Player("a")));
      lb.getRoot().getLeft().setRight(new BSTNode<>(new Player("c")));
      
      lb.getRoot().setRight(new BSTNode<>(new Player("f")));
      lb.getRoot().getRight().setLeft(new BSTNode<>(new Player("e")));
      lb.getRoot().getRight().setRight(new BSTNode<>(new Player("g")));
      
      return lb.lookup("d").equals(ans);
      
    } catch(Exception e) {
      return false;
    }
    
  }
  
  private static boolean testLookupLeft() {
    try {
      Leaderboard lb = new Leaderboard();
      
      Player ans = new Player("a");
      
      lb.addPlayer(new Player("d"));
      
      lb.getRoot().setLeft(new BSTNode<>(new Player("b")));
      lb.getRoot().getLeft().setLeft(new BSTNode<>(ans));
      lb.getRoot().getLeft().setRight(new BSTNode<>(new Player("c")));
      
      lb.getRoot().setRight(new BSTNode<>(new Player("f")));
      lb.getRoot().getRight().setLeft(new BSTNode<>(new Player("e")));
      lb.getRoot().getRight().setRight(new BSTNode<>(new Player("g")));
      
      return lb.lookup("a").equals(ans);
    } catch(Exception e) {
      return false;
    }
  }
  
  private static boolean testLookupRight() {
    try {
      Leaderboard lb = new Leaderboard();
      
      Player ans = new Player("g");
      
      lb.addPlayer(new Player("d"));
      
      lb.getRoot().setLeft(new BSTNode<>(new Player("b")));
      lb.getRoot().getLeft().setLeft(new BSTNode<>(new Player("a")));
      lb.getRoot().getLeft().setRight(new BSTNode<>(new Player("c")));
      
      lb.getRoot().setRight(new BSTNode<>(new Player("f")));
      lb.getRoot().getRight().setLeft(new BSTNode<>(new Player("e")));
      lb.getRoot().getRight().setRight(new BSTNode<>(ans));
      
      return lb.lookup("g").equals(ans);
    } catch(Exception e) {
      return false;
    }
  }
  
  private static boolean testLookupNotPresent() {
    try {
      Leaderboard lb = new Leaderboard();
      
      lb.addPlayer(new Player("d"));
      
      lb.getRoot().setLeft(new BSTNode<>(new Player("b")));
      lb.getRoot().getLeft().setLeft(new BSTNode<>(new Player("a")));
      lb.getRoot().getLeft().setRight(new BSTNode<>(new Player("c")));
      
      lb.getRoot().setRight(new BSTNode<>(new Player("f")));
      lb.getRoot().getRight().setLeft(new BSTNode<>(new Player("e")));
      lb.getRoot().getRight().setRight(new BSTNode<>(new Player("g")));
      
      return lb.lookup("x") == null;
    } catch(Exception e) {
      return false;
    }
  }
  
  //////////////////////////////////////////// ADD ////////////////////////////////////////////
  
  public static boolean testAdd() {
    try {
    boolean test1 = testAddPlayerEmpty();
    boolean test2 = testAddPlayer();
    boolean test3 = testAddPlayerDuplicate();
    if (!test1) System.out.print("addEmpty FAIL ");
    if (!test2) System.out.print("addPlayer FAIL ");
    if (!test3) System.out.print("addDuplicate FAIL ");
    return test1 && test2 && test3;
    } catch(Exception e) {
      return false;
    }
  } 
  
  private static boolean testAddPlayerEmpty() {
    try {
      Leaderboard lb = new Leaderboard();
      
      Player p1 = new Player("a");
      lb.addPlayer(p1);
      
  //    System.out.println(lb.getRoot().getData());
      
      return lb.getRoot().getData().equals(p1) && lb.size() == 1;
    } catch(Exception e) {
      return false;
    }
  }
  
  /**
   * 
   * @return true if each time you add a player: 
               (1) the method returns true
               (2) the size and count have increased correctly
               (3) the output of prettyPrint() is the expected tree
   */
  private static boolean testAddPlayer() {
    try {
      Leaderboard lb = new Leaderboard();
      
      Player p1 = new Player("a");
      Player p2 = new Player("b");
      Player p3 = new Player("c");
      
      boolean b1 = lb.addPlayer(p1) && lb.size() == 1;
      boolean b2 = lb.addPlayer(p2) && lb.size() == 2;
      boolean b3 = lb.addPlayer(p3) && lb.size() == 3;
      
  //    System.out.println("\n" + lb.prettyPrint());
  //    System.out.println("" + b1 + b2 + b3 + lb.size());
      return b1 && b2 && b3;
    } catch(Exception e) {
      return false;
    }
  }
  
  private static boolean testAddPlayerDuplicate() {
    try {
    Leaderboard lb = new Leaderboard();
    
    Player p1 = new Player("a");
    Player p2 = new Player("b");
    Player p3 = new Player("c");
    
    boolean b1 = lb.addPlayer(p1) && lb.size() == 1;
    boolean b2 = lb.addPlayer(p2) && lb.size() == 2;
    boolean b3 = lb.addPlayer(p3) && lb.size() == 3;
    boolean b4 = lb.addPlayer(p1) || lb.size() == 4;
    

    lb.prettyPrint();
    return b1 && b2 && b3 && !b4;
    
    } catch (Exception e) {
      return false;
    }
  }
  
  //////////////////////////////////////////// REMOVE ////////////////////////////////////////////
  
  public static boolean testRemove() {
    boolean test1 = testRemoveLeaf();
    boolean test2 = testRemoveOneChild();
    boolean test3 = testRemoveTwoChildren();
    boolean test4 = testRemoveNotInTree();
    if (!test1) System.out.print("remove FAIL ");
    if (!test2) System.out.print("removeOneChild FAIL ");
    if (!test3) System.out.print("removeTwoChildren FAIL ");
    if (!test4) System.out.print("removeNotInTree FAIL ");
    return test1 && test2 && test3 && test4;
  }
  
  private static boolean testRemoveLeaf() {
      Leaderboard lb = new Leaderboard();
              
      Player p1 = new Player("a");
      Player p2 = new Player("b");
      Player p3 = new Player("c");
      Player p4 = new Player("d");
      Player p5 = new Player("e");
      Player p6 = new Player("f");
      Player p7 = new Player("g");
      try {
        lb.addPlayer(p4);
    //    System.out.println(lb.getRoot().getData());
        lb.addPlayer(p2);
    //    System.out.println(lb.getRoot().getLeft().getData());
        lb.addPlayer(p1);
    //    System.out.println(lb.getRoot().getLeft().getLeft().getData());
        lb.addPlayer(p3);
        lb.addPlayer(p6);
        lb.addPlayer(p5);
        lb.addPlayer(p7);
    } catch(Exception e) {
      return false;
    }
      
      try {
        boolean out = lb.removePlayer(new Player("a"));
        System.out.println(lb);
    //    System.out.println("returns: " + out + lb.size() + "==6");
        return out && lb.size() == 6;
      } catch (NoSuchElementException e) {
        return false;
    }
      
  }
  
  /**
   * 
   * @return true if correctly removes a player with ONE child
    // (1) the method returns true
    // (2) the size and count have decreased correctly
    // (3) the output of prettyPrint() is the tree that you expect (you may do this one visually)
   */
  private static boolean testRemoveOneChild() {
    Leaderboard lb = new Leaderboard();

    Player p1 = new Player("a");
    Player p2 = new Player("b");
    Player p3 = new Player("c");
    Player p4 = new Player("d");
    Player p5 = new Player("e");
    Player p6 = new Player("f");
    try {
      lb.addPlayer(p4);
      lb.addPlayer(p2);
      lb.addPlayer(p1);
      lb.addPlayer(p3);
      lb.addPlayer(p5);
      lb.addPlayer(p6);
    } catch(Exception e) {
      return false;
    }
    boolean out = lb.removePlayer(p5);
    System.out.println(lb);
    
    return out && lb.size() == 5;
  }
  
  /**
   * 
   * @return true if removePlayer() correctly removes a player with TWO children
    // (1) the method returns true
    // (2) the size and count have decreased correctly
    // (3) the output of prettyPrint() is the tree that you expect (you may do this one visually)
   */
  private static boolean testRemoveTwoChildren() {
    Leaderboard lb = new Leaderboard();
    
    Player p1 = new Player("a");
    Player p2 = new Player("b");
    Player p3 = new Player("c");
    Player p4 = new Player("d");
    Player p5 = new Player("e");
    Player p6 = new Player("f");
    Player p7 = new Player("g");
    
    try {
      lb.addPlayer(p4);
      lb.addPlayer(p2);
      lb.addPlayer(p1);
      lb.addPlayer(p3);
      lb.addPlayer(p6);
      lb.addPlayer(p5);
      lb.addPlayer(p7);
    } catch(Exception e) {
      return false;
    }
    try {
      boolean out = lb.removePlayer(p6);
      System.out.println(lb);
      return out && lb.size() == 6;
    } catch(NoSuchElementException e) {
      return false;
    }
  }
  
  private static boolean testRemoveNotInTree() {
    // TODO: verify that removing a player not in the tree returns false, does not modify the BST, 
    // and does not cause an exception
    Leaderboard lb = new Leaderboard();
  
    Player p1 = new Player("a");
    Player p2 = new Player("b");
    Player p3 = new Player("c");
    Player p4 = new Player("d");
    Player p5 = new Player("e");
    Player p6 = new Player("f");
    Player p7 = new Player("g");
    try {
      lb.addPlayer(p4);    
      lb.addPlayer(p1);
      lb.addPlayer(p2);
      lb.addPlayer(p3);
      lb.addPlayer(p5);
      lb.addPlayer(p6);
    } catch(Exception e) {
      return false;
    }
    try {
    boolean out = lb.removePlayer(p7);
    
    System.out.println(lb);
    
    return !out && lb.size() == 6;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
 
  //////////////////////////////////////////// GET NEXT ////////////////////////////////////////////
  
  public static boolean testGetNext() {
    boolean test1 = testGetNextAfterRoot();
    boolean test2 = testGetNextAfterLeftSubtree();
    boolean test3 = testGetNextAfterRightSubtree();
    if (!test1) System.out.print("afterRoot FAIL ");
    if (!test2) System.out.print("afterLeft FAIL ");
    if (!test3) System.out.print("afterRight FAIL ");
    return test1 && test2 && test3;
  }
  
  private static boolean testGetNextAfterRoot() {
    try {
      Leaderboard lb = new Leaderboard();
      
      Player p1 = new Player("a");
      Player p2 = new Player("b");
      Player p3 = new Player("c");
      Player p4 = new Player("d");
      Player p5 = new Player("e");
      Player p6 = new Player("f");
      Player p7 = new Player("g");
      
      lb.addPlayer(p4);    
      lb.addPlayer(p1);
      lb.addPlayer(p2);
      lb.addPlayer(p3);
      lb.addPlayer(p5);
      lb.addPlayer(p6);
      lb.addPlayer(p7);
      
      System.out.println(lb);
      
      // TODO: verify that next() returns the correct Player when passed the Player in the root node
      return lb.next(lb.getRoot().getData()).equals(p5);
    } catch(Exception e) {
      return false;
    }
  } 
  
  /**
   * verify that next() returns the correct Player when the correct value is in the left
    // subtree of the leaderboard
   * @return true if correct
   */
  private static boolean testGetNextAfterLeftSubtree() {
    try {
    
      Leaderboard lb = new Leaderboard();
      
      Player p1 = new Player("a");
      Player p2 = new Player("b");
      Player p3 = new Player("c");
      Player p31 = new Player("c");
      p31.setScore(1900);
      Player p4 = new Player("d");
      Player p5 = new Player("e");
      Player p6 = new Player("f");
      Player p7 = new Player("g");
      
      lb.addPlayer(p4);    
      lb.addPlayer(p1);
      lb.addPlayer(p2);
      lb.addPlayer(p3);
      lb.addPlayer(p31);
      lb.addPlayer(p5);
      lb.addPlayer(p6);
      lb.addPlayer(p7);
      
      System.out.println(lb);
      
      return lb.next(p2).equals(p3);
    } catch(Exception e) {
      return false;
    }
  }
  /**
   * // TODO: verify that next() returns the correct Player when the correct value is in the right
    // subtree of the leaderboard
   * @return
   */
  private static boolean testGetNextAfterRightSubtree() {
    try {
      
      Leaderboard lb = new Leaderboard();
      
      Player p1 = new Player("a");
      Player p2 = new Player("b");
      Player p3 = new Player("c");
      Player p4 = new Player("d");
      Player p5 = new Player("e");
      Player p6 = new Player("f");
      Player p7 = new Player("g");
      Player p71 = new Player("c");
      p71.setScore(1900);
      
      lb.addPlayer(p4);    
      lb.addPlayer(p1);
      lb.addPlayer(p2);
      lb.addPlayer(p3);
      lb.addPlayer(p5);
      lb.addPlayer(p6);
      lb.addPlayer(p7);
      lb.addPlayer(p71);
      
      return lb.next(p6).equals(p7);
    } catch(Exception e) {
      return false;
    }
  }
  
  //////////////////////////////////////////// MAIN ////////////////////////////////////////////
  
  public static void main(String[] args) {
    System.out.print("Player compareTo(): ");
    System.out.println(testPlayerCompareTo()?"PASS":"");
    
    System.out.print("Leaderboard lookup(): ");
    System.out.println(testNameLookup()?"PASS":"");
    
    System.out.print("Leaderboard add(): ");
    System.out.println(testAdd()?"PASS":"");

    System.out.print("Leaderboard remove(): ");
    System.out.println(testRemove()?"PASS":"");

    System.out.print("Leaderboard next(): ");
    System.out.println(testGetNext()?"PASS":"");
  }
  
}
