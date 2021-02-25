package com.hotstrip.data.structure.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TreeNode<T> implements Node {
    private T data;
    private TreeNode left;
    private TreeNode right;
}
