package com.hotstrip.data.structure.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class OnePointerNodeTest {

    @Test
    public void test1() {
        OnePointerNode node = new OnePointerNode();
        node.setData(1);

        log.info("node data: [{}]", node.getData());
        Assert.assertEquals(1, node.getData());
    }
}