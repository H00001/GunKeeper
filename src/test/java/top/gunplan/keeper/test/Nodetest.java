package top.gunplan.keeper.test;

import org.junit.jupiter.api.Test;
import top.gunplan.kepper.meta.GunKeeperNodeManagerImpl;
import top.gunplan.kepper.meta.NodeState;

public class Nodetest {

    @Test
    void nodetest() {
        GunKeeperNodeManagerImpl mm = new GunKeeperNodeManagerImpl();
        mm.createROOT()
                .createNode("hello", NodeState.PERMANENT)
                .createTempNodeReturnThis("dddpp")
                .createTempNodeReturnThis("djd")
                .createListOfTempOrderNodeReturnThis("order-list", 20)
                .createTempNodeReturnThis("Dddd");
        System.out.println(mm.toString());

    }
}
