package systems.nanobreaker.collections.tree;

import systems.nanobreaker.iterator.Iterable;
import systems.nanobreaker.iterator.Iterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public record Tree<T>(Node<T> root) implements Iterable<Node<T>> {

    @Override
    public Iterator<Node<T>> createIterator() {
        return new Itr(root);
    }

    private class Itr implements Iterator<Node<T>> {

        final Node<T> node;
        final ArrayList<Node<T>> cache = new ArrayList<>();
        int cursor = 0;

        public Itr(Node<T> node) {
            this.node = node;
            init(node);
        }

        private void init(Node<T> node) {
            for (Node<T> u : node.nodes()) {
                cache.add(u);
                init(u);
            }
        }

        @Override
        public Node<T> next() {
            if (!hasNext()) throw new NoSuchElementException();

            Node<T> next = cache.get(cursor);
            cursor++;

            return next;
        }

        @Override
        public boolean hasNext() {
            return cursor < cache.size();
        }
    }
}

