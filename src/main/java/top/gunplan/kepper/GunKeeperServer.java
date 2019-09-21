package top.gunplan.kepper;

import top.gunplan.netty.GunBootServerBase;

/**
 * GunKeeperServer
 *
 * @author frank albert
 * @version 0.0.0.1
 * @date 2019-09-21 21:54
 */
public class GunKeeperServer implements GunBootServerBase {
    public int sync() throws Exception {
        System.out.println("sync hello gunkeeper");
        return 0;
    }

    public int stop() throws InterruptedException {
        return 0;
    }
}
