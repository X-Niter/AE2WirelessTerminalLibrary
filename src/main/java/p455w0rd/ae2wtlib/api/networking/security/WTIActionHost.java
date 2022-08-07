package p455w0rd.ae2wtlib.api.networking.security;

import appeng.api.networking.IGridNode;
import appeng.api.networking.security.IActionHost;

public interface WTIActionHost extends IActionHost {

	/**
	 * Used to for calculating security rules, you must supply a node from your
	 * IGridHost for the security test, this should be the primary node for the
	 * machine, unless the action is preformed by a non-primary node.
	 *
	 * @return the gridnode that actions from this IGridHost are preformed
	 * by.
	 */
	@Override
	IGridNode getActionableNode();

	IGridNode getActionableNode(boolean ignoreRange);
}
