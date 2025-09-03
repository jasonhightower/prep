package com.hightower.prep.core;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class LinkedNode<T> {

    public LinkedNode<T> next;

    public final T value;

    public LinkedNode(T value) {
        this.value = value;
    }

    public Optional<LinkedNode<T>> find(T value) {
        if (value.equals(this.value)) {
            return Optional.of(this);
        }
        if (this.next == null) {
            return Optional.empty();
        }
        return this.next.find(value);
    }

    public long length() {
        if (this.next == null) {
            return 1;
        }
        return 1 + this.next.length();
    }

    @Override
    public boolean equals(final Object o) {
        return (o instanceof LinkedNode<?> n) &&
                Objects.equals(this.next, n.next) &&
                Objects.equals(this.value, n.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, value);
    }

    @Override
    public String toString() {
        return stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
    }

    public Stream<T> stream() {
        return StreamSupport.stream(new LinkedListSpliterator<>(this), false);
    }

    public static <T> LinkedNode<T> of(T ... values) {
        if (values == null || values.length == 0) {
            return null;
        }
        LinkedNode<T> head = new LinkedNode<>(values[0]);
        LinkedNode<T> cur = head;
        for (int i = 1; i < values.length; i++) {
            cur.next = new LinkedNode<>(values[i]);
            cur = cur.next;
        }
        return head;
    }

    protected static class LinkedListSpliterator<T> implements Spliterator<T> {

        private LinkedNode<T> cur;

        public LinkedListSpliterator(LinkedNode<T> head) {
            this.cur = head;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            if (this.cur == null) {
                return false;
            }
            action.accept(this.cur.value);
            this.cur = this.cur.next;
            return true;
        }

        @Override
        public Spliterator<T> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return this.cur.length();
        }

        @Override
        public int characteristics() {
            return ORDERED | IMMUTABLE;
        }
    }

}
