package top.gunplan.kepper.meta;

/**
 * GunKeeperNodeManagerImpl
 *
 * @author frank albert
 * @version 0.0.0.1
 * @date 2019-09-22 20:56
 */
public class GunKeeperNodeManagerImpl {
    private volatile GunKeeperNode root;

    public synchronized GunKeeperNode createROOT() {
        root = new GunKeeperNodeImpl();
        return root;
    }

    @Override
    public synchronized String toString() {
        return toString(root);
    }

    private String toString(GunKeeperNode root) {
        StringBuilder builder = new StringBuilder();
        builder.append(root.name() + " type:" + root.type());
        if (root.next().size() != 0) {
            builder.append("[");
            for (var k : root.next()) {
                builder.append(toString(k)).append(",");
            }
            return builder.substring(0, builder.length() - 1) + "]";
        }
        return builder.toString();
    }
}
