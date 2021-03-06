package mods.elysium.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import mods.elysium.DefaultProps;
import mods.elysium.Elysium;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockShells extends ElysiumFlowerBlock
{ 
	@SideOnly(Side.CLIENT)
	private Icon iconConch;
	
    public BlockShells(int par1)
    {
        super(par1);
        float f = 0.5F;
        float f1 = 0.015625F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 23;
    }
    /**
     * Adds all intersecting collision boxes to a list. (Be sure to only add boxes to the list if they intersect the
     * mask.) Parameters: World, X, Y, Z, mask, list, colliding entity
     */
    public void addCollisionBoxesToList(World par1World, int par2, int par3, int par4, AxisAlignedBB par5AxisAlignedBB, List par6List, Entity entity)
    {
        if (entity == null || !(entity instanceof EntityBoat))
        {
            super.addCollisionBoxesToList(par1World, par2, par3, par4, par5AxisAlignedBB, par6List, entity);
        }
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return AxisAlignedBB.getAABBPool().getAABB((double)par2 + this.minX, (double)par3 + this.minY, (double)par4 + this.minZ, (double)par2 + this.maxX, (double)par3 + this.maxY, (double)par4 + this.maxZ);
    }

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    @Override
	public boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Elysium.LeucosandBlock.blockID;
    }

    /**
     * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
     */
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIcon(int id, int meta)
    {
    	Icon icon = null;
    	if(meta == 0)
    		return this.iconConch;
    	else
    		return this.blockIcon;
    }
    
    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int damage)
    {
        return damage;
    }

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int id, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(id, 1, 0));        
        list.add(new ItemStack(id, 1, 1));
    }
    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister IconRegister)
    {
    	this.iconConch = IconRegister.registerIcon(DefaultProps.modId + ":conch");
    	this.blockIcon = IconRegister.registerIcon(DefaultProps.modId + ":shell");
    }
}
