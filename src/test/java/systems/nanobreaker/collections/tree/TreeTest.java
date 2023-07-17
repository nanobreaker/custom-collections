package systems.nanobreaker.collections.tree;

import org.junit.jupiter.api.Test;
import systems.nanobreaker.iterator.Iterator;

class TreeTest {

    @Test
    void shouldReturnAllNodes() {
        Node<String> childSix = new Node<>("childSix", new Node[]{});
        Node<String> childFive = new Node<>("childFive", new Node[]{});
        Node<String> childFour = new Node<>("childFour", new Node[]{childFive, childSix});
        Node<String> childThree = new Node<>("childThree", new Node[]{});
        Node<String> childTwo = new Node<>("childTwo", new Node[]{childThree});
        Node<String> childOne = new Node<>("childOne", new Node[]{childTwo});

        Tree<String> tree = new Tree<>(new Node<>("root", new Node[]{childOne, childFour}));

        Iterator<Node<String>> iterator = tree.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().value());
        }
    }
}