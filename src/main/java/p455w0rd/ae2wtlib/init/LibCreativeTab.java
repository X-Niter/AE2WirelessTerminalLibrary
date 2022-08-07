package p455w0rd.ae2wtlib.init;

import java.util.List;
import java.util.Objects;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import p455w0rd.ae2wtlib.api.ICustomWirelessTerminalItem;
import p455w0rd.ae2wtlib.api.WTApi;
import p455w0rd.ae2wtlib.items.ItemWUT;

/**
 * @author p455w0rd
 *
 */
public class LibCreativeTab {
	@MethodsReturnNonnullByDefault
	public static CreativeTabs CREATIVE_TAB = new CreativeTabs(WTApi.MODID) {

		@Override
		public ItemStack createIcon() {
			final List<ICustomWirelessTerminalItem> termList = WTApi.instance().getWirelessTerminalRegistry().getRegisteredTerminals(true);
			//ensure we have more than one terminal, and account for WUT
			final int numTerminalsRegistered = WTApi.instance().getWirelessTerminalRegistry().getNumRegisteredTerminals(true);
			if (numTerminalsRegistered <= 1) {
				return new ItemStack(WTApi.instance().getWirelessTerminalRegistry().getStackForHandler(termList.get(0).getClass(), false, true).getItem());
			}

			return new ItemStack(ItemWUT.getFullyStockedWut(true).getItem());
		}
	};

}