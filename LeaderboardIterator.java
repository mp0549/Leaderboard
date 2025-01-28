// Title:    P09_Leaderboard
// Course:   CS 300 Fall 2024
//
// Author:   Maanan Purothi
// Email:    purothi@wisc.edu
// Lecturer: Hobbes LeGault

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Uses an array to store the list from the leaderboard in ascending order.
 */
public class LeaderboardIterator implements Iterator<Player> {
    private Player[] list;
    private int currentIndex;
    private int size;

    /**
     * Initializes the array for storing elements of the given BST in ascending order.
     * @param root the root of the BST
     * @param treeSize the number of nodes in the BST
     */
    public LeaderboardIterator(BSTNode<Player> root, int treeSize) {
        list = new Player[treeSize];
        currentIndex = 0;
        size = 0;
        addToArray(root);
        currentIndex = 0; // Reset currentIndex for iteration
    }

    /**
     * Performs an in-order traversal of the BST and stores elements in the array.
     * @param node the current node being traversed
     */
    private void addToArray(BSTNode<Player> node) {
        if (node == null) {
            return;
        }
        addToArray(node.getLeft());
        list[size++] = node.getData();
        addToArray(node.getRight());
    }

    /**
     * Checks if there are more elements to iterate over.
     * @return true if there are unvisited elements in the array, otherwise false
     */
    @Override
    public boolean hasNext() {
        return currentIndex < size;
    }

    /**
     * Returns the next element in the in-order sequence.
     * @return player at the current index of the array
     */
    @Override
    public Player next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iterator");
        }
        return list[currentIndex++];
    }
}
