package com.hotstrip.data.structure.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OnePointerNodeTest {
    public static void main(String[] args) {
        OnePointerNode node = new OnePointerNode();
        node.setData(1);

        log.info("node data: [{}]", node.getData());
    }
}