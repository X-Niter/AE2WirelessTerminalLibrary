package p455w0rd.ae2wtlib.api;

import net.minecraft.item.ItemStack;

import java.util.List;
import java.util.Map;

/**
 * @author p455w0rd
 *
 */
public abstract class WTRegistry {

	public abstract List<ICustomWirelessTerminalItem> getRegisteredTerminals();

	public abstract List<ICustomWirelessTerminalItem> getRegisteredTerminals(boolean excludeWUT);

	public abstract int getNumRegisteredTerminals(boolean excludeWUT);

	public abstract <T extends ICustomWirelessTerminalItem, C extends T> void registerWirelessTerminal(T wirelessTerminal, C creativeTerminal);

	public abstract ICustomWirelessTerminalItem getCreativeVersion(ICustomWirelessTerminalItem nonCreativeTerminal);

	public abstract ItemStack convertToCreative(ItemStack wirelessTerminal);

	public abstract Map<ICustomWirelessTerminalItem, ICustomWirelessTerminalItem> getNonCreativeToCreativeMap();

	public abstract ItemStack getStackForHandler(Class<? extends ICustomWirelessTerminalItem> clazz, boolean creative, boolean fullyPower);

}
