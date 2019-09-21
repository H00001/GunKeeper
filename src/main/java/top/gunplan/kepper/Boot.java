package top.gunplan.kepper;

/**
 * Boot
 *
 * @author frank albert
 * @version 0.0.0.1
 * @date 2019-09-21 21:54
 */
public final class Boot {
    public static void main(String[] args) {
        try {
            new GunKeeperServer().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
