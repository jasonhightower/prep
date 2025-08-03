package com.hightower.prep.trees;

import com.hightower.prep.trees.binary.TreeNode;

import java.util.ArrayList;
import java.util.List;

public final class TreeHelper {


    public static List<TreeNode<Integer>> createTreeNodes(int num) {
        List<TreeNode<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            nodes.add(new TreeNode<>(i+1));
        }
        return nodes;
    }

    public static <T> List<TreeNode<T>> createTreeNodes(T[] values) {
        List<TreeNode<T>> nodes = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            nodes.add(new TreeNode<>(values[i]));
        }
        return nodes;
    }

    public static <T> TreeNode<T> createRight(TreeNode<T> root, T value) {
        TreeNode<T> newNode = new TreeNode<>(value);
        root.setRight(newNode);
        return newNode;
    }

    public static <T> TreeNode<T> createLeft(TreeNode<T> root, T value) {
        TreeNode<T> newNode = new TreeNode<>(value);
        root.setLeft(newNode);
        return newNode;
    }

    private TreeHelper() {};

}
