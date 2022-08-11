package nt.study.tree.binary;

import nt.study.entity.BinaryTree;

import java.util.Objects;
import java.util.Stack;

/**
 * 构造二叉树
 */
public class BinaryTreeBuilder {
    // 通过括号表示字符串构造二叉树
    public static BinaryTree<Character> builder(String str){
        BinaryTree<Character> root = null, binaryTree = null;
        // 栈
        Stack<BinaryTree<Character>> characterStack = new Stack<>();
        Character ch ;
        int k = 0, length = str.length(), j = 0;
        while(j  < length){
            switch(str.charAt(j)){
                case '(':
                    k = 1;
                    characterStack.push(binaryTree);
                    break;
                case ')':
                    characterStack.pop();
                    break;
                case ',':
                    k = 2;
                    break;
                default:
                    ch = str.charAt(j);
                    binaryTree = new BinaryTree<>();
                    binaryTree.setValue(ch);
                    if(Objects.isNull(root)){
                        root = binaryTree;
                    }else{
                        switch(k){
                            case 1:
                                characterStack.peek().setLeft(binaryTree);
                                break;
                            case 2:
                                characterStack.peek().setRight(binaryTree);
                                break;
                        }
                    }
            }
            j++;
        }
        return root;
    }


    /**
     * 通过先序遍历和中序遍历构造二叉树
     * @param preorderTraversalStr 先序遍历字符串
     * @param preorderIndex 先序遍历字符串的根节点位置
     * @param inorderTraversal 中序遍历字符串
     * @param inorderIndex 中序遍历字符串的开始位置
     * @param n 二叉树的节点个数
     * @return
     */
    public static BinaryTree<Character> builder(String preorderTraversalStr, int preorderIndex,  String inorderTraversal, int inorderIndex, int n){
        if(Objects.isNull(preorderTraversalStr) || Objects.isNull(inorderTraversal) || n <= 0){
            return null;
        }
        char ch = preorderTraversalStr.charAt(preorderIndex);
        BinaryTree<Character> binaryTree = new BinaryTree<>();
        binaryTree.setValue(ch);
        int p, k;
        for (p = inorderIndex; p < inorderIndex + n; p++) {
            if(inorderTraversal.charAt(p) == ch){
                break;
            }
        }
        // k为左子树的节点个数
        k = p - inorderIndex;
        BinaryTree<Character> leftTree = builder(preorderTraversalStr, preorderIndex + 1, inorderTraversal, inorderIndex, k);
        BinaryTree<Character> rightTree = builder(preorderTraversalStr, preorderIndex + k + 1, inorderTraversal, p + 1, n - k - 1);
        binaryTree.setLeft(leftTree);
        binaryTree.setRight(rightTree);
        return binaryTree;
    }
}
