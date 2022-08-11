package nt.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BinaryTree<K> {
    private K value;
    private BinaryTree<K> left;
    private BinaryTree<K> right;
}
