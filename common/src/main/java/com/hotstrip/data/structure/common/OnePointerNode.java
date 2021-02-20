package com.hotstrip.data.structure.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Hotstrip
 * this is a one pointer node, it's mean that only one data and only one pointer
 * the pointer well pointing to next node
 */
@Data
@NoArgsConstructor
public class OnePointerNode<T> implements Node {
    private T data;
    private Node next;
}
