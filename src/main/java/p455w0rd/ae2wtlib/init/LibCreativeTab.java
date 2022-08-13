package p455w0rd.ae2wtlib.init;

import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import p455w0rd.ae2wtlib.api.WTApi;

/**
 * @author p455w0rd
 *
 */
public class LibCreativeTab {
	@MethodsReturnNonnullByDefault
	public static CreativeTabs CREATIVE_TAB = new CreativeTabs(WTApi.MODID) {

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack createIcon() {
			return new ItemStack(LibItems.ULTIMATE_TERMINAL);
		}
	};

}