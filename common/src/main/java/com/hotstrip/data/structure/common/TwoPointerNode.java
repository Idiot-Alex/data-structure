package com.hotstrip.data.structure.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hotstrip
 * two pointer node, it's has one data, two pointer pointing to different node
 */
@Data
@NoArgsConstructor
public class TwoPointerNode<T> implements Node {
    private T data;
    private Node prev;
    private Node next;
}
