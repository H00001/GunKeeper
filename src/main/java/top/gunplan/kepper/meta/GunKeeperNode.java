package top.gunplan.kepper.meta;

import java.util.List;

/**
 * GunKeeperNode
 *
 * @author frank albert
 * @version 0.0.0.1
 * @date 2019-09-22 20:46
 */
public interface GunKeeperNode {
    List<GunKeeperNode> next();

    NodeState type();

    String name();

    GunKeeperNode createNode(String name, NodeState state);

    GunKeeperNode createTempNodeReturnThis(String name);

    GunKeeperNode createListOfTempOrderNodeReturnThis(String name, int len);
}
