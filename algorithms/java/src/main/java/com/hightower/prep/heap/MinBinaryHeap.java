package com.hightower.prep.heap;

import java.lang.reflect.Array;
import java.util.Random;

public class MinBinaryHeap<T extends Comparable<T>> {

    private T[] values;
    private int size;
    private Class<T> componentType;

    public MinBinaryHeap(final Class<T> componentType) {
        this(componentType, 9);
    }

    public MinBinaryHeap(final Class<T> componentType, int capacity) {
        this.values = (T[])Array.newInstance(componentType, capacity);
        this.size = 0;
        this.componentType = componentType;
    }

    public void add(T element) {
        if (this.size == values.length) {
            int depth = (int)(Math.log(this.size)/Math.log(2));
            int length = (int)Math.pow(2, depth + 1) + 1;
            T[] newVals = (T[]) Array.newInstance(this.componentType, length);
            for (int i = 0; i < this.size; i++) {
                newVals[i] = this.values[i];
            }
            this.values = newVals;
        }
        this.values[this.size] = element;
        this.size++;
        if (this.size > 1) {
            this.shiftUp(this.size - 1);
        }
    }

    public T get() {
        if (this.size == 0) {
            return null;
        }
        T max = this.values[0];
        int i = this.size - 1;

        T val = this.values[i];
        this.values[i] = null;
        this.values[0] = val;
        if (i != 0) {
            this.shiftDown(0, val);
        }
        this.size--;
        return max;
    }

    public int size() {
        return this.size;
    }

    public boolean remove(T val) {
        return remove(0, val);
    }
    private boolean remove(int index, T val) {
        if (index >= this.size) {
            return false;
        }
        if (this.values[index] == val) {
            this.shiftDown(index, val);
            return true;
        } else if (isLessThan(this.values[index], val)) {
            int leftIndex = this.leftChildOf(index);
            int rightIndex = this.rightChildOf(index);
            return remove(leftIndex, val) ||
                    remove(rightIndex, val);
        }
        return false;
    }

    public boolean has(T val) {
        return has(0, val);
    }

    private boolean has(int index, T val) {
        if (index >= this.size) {
            return false;
        }
        if (this.values[index] == val) {
            return true;
        } else if (isLessThan(this.values[index], val)) {
            int leftIndex = this.leftChildOf(index);
            int rightIndex = this.rightChildOf(index);
            return has(leftIndex, val) || has(rightIndex, val);
        } else {
            return false;
        }
    }


    private void shiftDown(int index, T val) {
        int leftIndex = this.leftChildOf(index);
        int rightIndex = this.rightChildOf(index);
        T left = null;
        T right = null;
        if (leftIndex < this.size) {
            left = this.values[leftIndex];
        }
        if (rightIndex < this.size) {
            right = this.values[rightIndex];
        }
        if (right == null && left == null) {
            this.values[index] = val;
            return;
        }
        if (right == null) {
            if (this.isLessThan(left, val)) {
                this.values[leftIndex] = val;
                this.values[index] = left;
            }
        } else if (isLessThan(right, left)) {
            if (this.isLessThan(right, val)) {
                this.values[rightIndex] = val;
                this.values[index] = right;
                this.shiftDown(rightIndex, val);
            }
        } else {
            if (this.isLessThan(left, val)) {
                this.values[leftIndex] = val;
                this.values[index] = left;
                this.shiftDown(leftIndex, val);
            }
        }
    }

    private void shiftUp(int index) {
        if (index != 0) {
            int pIndex = this.parentOf(index);
            T parent = this.values[pIndex];
            T val = this.values[index];
            if (this.isLessThan(val, parent)) {
                this.values[pIndex] = val;
                this.values[index] = parent;
                shiftUp(pIndex);
            }
        }
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private int leftChildOf(int index) {
        return (2 * index) + 1;
    }

    private int rightChildOf(int index) {
        return (2 * index) + 2;
    }

    private boolean isLessThan(T s, T t) {
        return s.compareTo(t) < 0;
    }

    public static void main(String[] args) {
        MinBinaryHeap<Integer> heap = new MinBinaryHeap<>(Integer.class);
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int rand = r.nextInt(100);
            System.out.printf("Adding %d%n", rand);
            heap.add(rand);
        }

        int min = heap.get();
        System.out.printf("Getting %d%n", min);
        int num = 2;
        for (int i = 0; i < num; i++) {
            int val = heap.get();
            if (val < min) {
                throw new RuntimeException("Min was greater than val");
            }
            System.out.printf("Getting %d%n", val);
        }
        while (heap.size() > 0) {
            int val = heap.get();
            System.out.printf("Getting %d%n", val);
            if (val < min) {
                throw new RuntimeException("Min was greater than val");
            }
            min = val;
        }
    }

}
