package nt.study.find.impl;

import nt.study.find.Find;
import nt.study.find.entity.BinarySearchTreeNode;

public class BinarySearchTree implements Find {

    @Override
    public int find(int[] arr, int i) {
        BinarySearchTreeNode<Integer, Integer> integerIntegerBinarySearchTreeNode = this.<Integer, Integer>buildBinarySearchTree(arr);
        Integer value = integerIntegerBinarySearchTreeNode.get(i);
        System.out.println(value);
        return value;
    }

    private BinarySearchTreeNode<Integer, Integer> buildBinarySearchTree(int[] arr) {
        return null;
    }

}
