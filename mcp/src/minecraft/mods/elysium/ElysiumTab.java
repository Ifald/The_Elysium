package mods.elysium;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class ElysiumTab extends CreativeTabs
{
	public ElysiumTab(int par1, String par2Str)
	{
		super(par1, par2Str);
	}
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return Elysium.paleStone.blockID;
	}

	public String getTranslatedTabLabel()
	{
		return "The Elysium";
	}
}
