package p455w0rd.ae2wtlib.api;

import baubles.api.cap.IBaublesItemHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import org.apache.commons.lang3.tuple.Pair;
import p455w0rd.ae2wtlib.api.container.ContainerWT;

import java.util.Set;

/**
 * @author p455w0rd
 *
 */
public abstract class WTBaublesAccess {

	public abstract Pair<Integer, ItemStack> getFirstWTBauble(EntityPlayer player);

	public abstract Set<Pair<Integer, ItemStack>> getAllWTBaubles(EntityPlayer player);

	public abstract void updateWTBauble(EntityPlayer player, ItemStack wirelessTerm, int slot);

	public abstract ItemStack getWTBySlot(EntityPlayer player, int slot, Class<? extends ICustomWirelessTerminalItem> type);

	public abstract IBaublesItemHandler getBaubles(EntityPlayer player);

	public abstract void setBaublesItemStack(EntityPlayer player, int slot, ItemStack stack);

	public abstract void addBaubleSlots(ContainerWT container, EntityPlayer player);

	public abstract boolean isBaubleItem(ItemStack stack);

	public abstract boolean isAEBaubleSlot(Slot slot);

	public abstract boolean isBaubleSlot(Slot slot);

	public abstract void sync(EntityPlayer player, ItemStack stack, int slot);

	public abstract Set<Pair<Integer, ItemStack>> getAllWTBaublesByType(EntityPlayer player, Class<? extends ICustomWirelessTerminalItem> type);

	public abstract Pair<Integer, ItemStack> getFirstWTBaubleByType(EntityPlayer player, Class<? extends ICustomWirelessTerminalItem> type);

}
