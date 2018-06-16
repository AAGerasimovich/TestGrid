package org.apache.ignite.testframework;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;

import org.apache.ignite.configuration.*;

import org.apache.ignite.internal.IgniteEx;
import org.apache.ignite.testframework.junits.common.GridCommonAbstractTest;


public class CustomTestPersistenceNode extends GridCommonAbstractTest {




    public void testPersistence() throws  Exception{


        IgniteEx  srv1 = (IgniteEx)startGrids(3);

        assertEquals(3, srv1.cluster().nodes().size());
        stopAllGrids();
        cleanPersistenceDir();

    }

    protected IgniteConfiguration getConfiguration(String gridName) throws Exception {
        IgniteConfiguration cfg = super.getConfiguration(gridName);

        DataStorageConfiguration memCfg = new DataStorageConfiguration()
                .setDefaultDataRegionConfiguration(
                        new DataRegionConfiguration().setMaxSize(50 * 1024 * 1024).setPersistenceEnabled(true))
                .setWalMode(WALMode.LOG_ONLY)
                .setPageSize(1024);


        cfg.setDataStorageConfiguration(memCfg);
        return cfg;
    }
}
