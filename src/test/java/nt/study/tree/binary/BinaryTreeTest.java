package nt.study.tree.binary;

import nt.study.entity.BinaryTree;
import org.junit.Test;

/**
 * 二叉树相关测试类
 */
public class BinaryTreeTest {
    @Test
    public void test(){
        // 构造二叉树
        BinaryTree<Character> binaryTree = BinaryTreeBuilder.builder("A(B(D(,G)),C(E,F))");
        System.out.println(binaryTree);
        遍历二叉树 遍历二叉树 = new 遍历二叉树();
        // 二叉树先序遍历
        System.out.println("二叉树先序遍历");
        String preorderStr = 遍历二叉树.preorderTraversal(binaryTree);
        System.out.println(preorderStr);
        // 二叉树中序遍历
        System.out.println("二叉树中序遍历");
        String inorderStr = 遍历二叉树.inorderTraversal(binaryTree);
        System.out.println(inorderStr);
        // 二叉树后序遍历
        System.out.println("二叉树后序遍历");
        String postorderStr = 遍历二叉树.postorderTraversal(binaryTree);
        System.out.println(postorderStr);

        // 层次遍历
        System.out.println("二叉树层次遍历");
        遍历二叉树.hierarchicalTraversal(binaryTree);

        // 先序遍历和中序遍历构造二叉树
        BinaryTree<Character> builder = BinaryTreeBuilder.builder(preorderStr, 0, inorderStr, 0, preorderStr.length());
        System.out.println(builder);
    }

}