package nt.study.tree.binary;

import nt.study.entity.BinaryTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;


public class 遍历二叉树{
    /**
     * 先序遍历，先访问根节点，再先序遍历左子树，然后先序遍历右子树
     * @param root
     * @param <K>
     */
    public <K> String preorderTraversal(BinaryTree<K> root){
        if(!Objects.isNull(root)){
            return root.getValue() + this.preorderTraversal(root.getLeft()) + this.preorderTraversal(root.getRight());
        }
        return "";
    }

    /**
     * 中序遍历，先中序遍历左子树，再访问根节点，然后中序遍历右子树
     * @param root
     * @param <K>
     */
    public <K> String inorderTraversal(BinaryTree<K> root){
        if(!Objects.isNull(root)){
            return this.inorderTraversal(root.getLeft()) + root.getValue() +  this.inorderTraversal(root.getRight());
        }
        return "";
    }

    /**
     * 后序遍历，先后序遍历左子树，再后序遍历右子树，然后访问根节点
     * @param root
     * @param <K>
     */
    public <K> String postorderTraversal(BinaryTree<K> root){
        if(!Objects.isNull(root)){
            return this.postorderTraversal(root.getLeft()) + this.postorderTraversal(root.getRight()) + root.getValue();
        }
        return "";
    }

    /**
     * 层次遍历
     */
    public <K>void hierarchicalTraversal(BinaryTree<K> root){
        if(Objects.isNull(root)){
            return;
        }
        Queue<BinaryTree<K>> binaryTreeQueue = new LinkedList<>();
        binaryTreeQueue.offer(root);
        while(binaryTreeQueue.size() > 0){
            BinaryTree<K> binaryTree = binaryTreeQueue.poll();
            System.out.println(binaryTree.getValue());
            BinaryTree<K> left = binaryTree.getLeft();
            BinaryTree<K> right = binaryTree.getRight();
            if(!Objects.isNull(left)){
                binaryTreeQueue.add(left);
            }
            if(!Objects.isNull(right)){
                binaryTreeQueue.add(right);
            }

        }
    }
}
