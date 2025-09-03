package com.hightower.prep.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LinkedNodeWRandom<T> extends LinkedNode<T> {

    public LinkedNode<T> random;

    public LinkedNodeWRandom(T val) {
        super(val);
    }

    @Override
    public boolean equals(final Object o) {
        return (o instanceof LinkedNodeWRandom<?> n) &&
                Objects.equals(this.next, n.next) &&
                Objects.equals(this.value, n.value) &&
                ((this.random == null && n.random == null) || Objects.equals(this.random.value, n.random.value));
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, random, value);
    }

    public static <T> LinkedNodeWRandom<T> of(T v1, Integer r1,
                                              T v2, Integer r2,
                                              T v3, Integer r3) {
        List<LinkedNodeWRandom<T>> nodes = new ArrayList<>();
        nodes.add(new LinkedNodeWRandom<>(v1));
        nodes.add(new LinkedNodeWRandom<>(v2));
        nodes.add(new LinkedNodeWRandom<>(v3));
        nodes.get(0).next = nodes.get(1);
        nodes.get(1).next = nodes.get(2);

        if (r1 != null) {
            nodes.get(0).random = nodes.get(r1);
        }
        if (r2 != null) {
            nodes.get(1).random = nodes.get(r2);
        }
        if (r3 != null) {
            nodes.get(2).random = nodes.get(r2);
        }
        return nodes.get(0);
    }

    public static <T> LinkedNodeWRandom<T> of(T v1, Integer r1,
                                              T v2, Integer r2,
                                              T v3, Integer r3,
                                              T v4, Integer r4) {

        List<LinkedNodeWRandom<T>> nodes = new ArrayList<>();
        nodes.add(new LinkedNodeWRandom<>(v1));
        nodes.add(new LinkedNodeWRandom<>(v2));
        nodes.add(new LinkedNodeWRandom<>(v3));
        nodes.add(new LinkedNodeWRandom<>(v4));
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }

        if (r1 != null) {
            nodes.get(0).random = nodes.get(r1);
        }
        if (r2 != null) {
            nodes.get(1).random = nodes.get(r2);
        }
        if (r3 != null) {
            nodes.get(2).random = nodes.get(r2);
        }
        if (r4 != null) {
            nodes.get(3).random = nodes.get(r3);
        }
        return nodes.get(0);
    }

}
