package top.gunplan.kepper;

import org.junit.jupiter.api.Assertions;
import top.gunplan.netty.*;
import top.gunplan.netty.example.*;
import top.gunplan.netty.impl.GunBootServerFactory;
import top.gunplan.netty.impl.GunNettyDefaultObserve;
import top.gunplan.netty.impl.GunNettyStdFirstFilter;
import top.gunplan.netty.impl.property.GunGetPropertyFromBaseFile;
import top.gunplan.netty.observe.DefaultGunNettyChildrenPipelineChangedObserve;

/**
 * GunKeeperServer
 *
 * @author frank albert
 * @version 0.0.0.1
 * @date 2019-09-21 21:54
 */
public class GunKeeperServer implements GunBootServerBase {
    @Override
    public int sync() throws Exception {
        //set property strategy
        GunNettySystemService.PROPERTY_MANAGER.setStrategy(new GunGetPropertyFromBaseFile());
        //get a server instance
        GunBootServer server = GunBootServerFactory.newInstance();
        server
                //set sum of thread
                .setExecutors(10, 10)
                //use steal work model (ForkJoinPool)
                .useStealMode(true)
                .registerObserve(new GunNettyDefaultObserve())
                .onHasChannel(pipeline -> pipeline
                        .setMetaInfoChangeObserver(new DefaultGunNettyChildrenPipelineChangedObserve())
                        .addDataFilter(new GunNettyStdFirstFilter().setObserve(null))
                        .addDataFilter(new GunNettyCharsetInboundChecker())
                        .addConnFilter(new GunNettyStdFirstFilter())
                        .addDataFilter(new GunNettyExampleStopFilter())
                        .setHandle((GunNettyChildrenHandle) new GunNettyStringHandle())
                        .setHandle((GunNettyParentHandle) new GunNettyStringHandle())
                        .addNettyTimer(new GunTimerExample()));
        server.timeManager().addGlobalTimers(new GlobalTimer());
        server.setSyncType(false);
        Assertions.assertEquals(server.sync(), GunBootServer.GunNettyWorkState.ASYNC.state |
                GunBootServer.GunNettyWorkState.RUNNING.state);
        //running doTime
        Thread.sleep(100);
        System.out.println(GunBootServer.GunNettyWorkState.getState(server.stop()));
        System.out.println("sync hello gunkeeper");
        return 0;
    }

    @Override
    public int stop() throws InterruptedException {
        return 0;
    }
}
