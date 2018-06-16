package org.apache.ignite.testframework;

import org.apache.ignite.internal.IgniteEx;
import org.apache.ignite.testframework.junits.common.GridCommonAbstractTest;

public class CustomTestNode extends GridCommonAbstractTest {



    public void testBase()throws Exception{

        IgniteEx srv1 = startGrid(0);
        startGrid(1);
        startGrid(2);

        assertEquals(3, srv1.cluster().nodes().size());
        for (int i = 0; i < 3; i++) {
            stopGrid(i);

        }


    }
}
