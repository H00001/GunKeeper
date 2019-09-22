package top.gunplan.kepper.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * GunKeeperNodeImpl
 *
 * @author frank albert
 * @version 0.0.0.1
 * @date 2019-09-22 20:47
 */
public class GunKeeperNodeImpl implements GunKeeperNode {

    private final NodeState state;
    private final String name;
    private byte[] data;
    private List<GunKeeperNode> next = new ArrayList<>();

    public GunKeeperNodeImpl() {
        this("/", NodeState.TEST);
    }

    public GunKeeperNodeImpl(String name, NodeState state) {
        this.name = name;
        this.state = state;
    }

    @Override
    public List<GunKeeperNode> next() {
        return next;
    }

    @Override
    public NodeState type() {
        return state;
    }

    @Override
    public String name() {
        return name;
    }


    @Override
    public synchronized GunKeeperNode createNode(String name, NodeState state) {
        final GunKeeperNode node = new GunKeeperNodeImpl(name, state);
        this.next.add(node);
        return node;
    }


    @Override
    public synchronized GunKeeperNode createTempNodeReturnThis(String name) {
        createNode(name, NodeState.TEMP);
        return this;
    }

    @Override
    public GunKeeperNode createListOfTempOrderNodeReturnThis(String name, int len) {
        for (int i = 0; i < len; i++) {
            createNode(name + "-0" + i, NodeState.TEMP);
        }
        return this;
    }


}
