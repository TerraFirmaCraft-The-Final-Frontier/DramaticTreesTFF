package org.labellum.mc.dynamictreestfc.blocks;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.init.Blocks;

import net.dries007.tfc.api.types.Tree;

// The only purpose of this block is to avoid calling getBlockHardness on a BlockLogTFC with a
// DynamicTrees branch blockstate, which doesn't have the needed properties to compute it.
// This block just holds the textures, really.
public class BlockLogDTTFC extends BlockLog
{
    private static final Map<Tree, BlockLogDTTFC> MAP = new HashMap<>();
    public final Tree tree;

    public static BlockLogDTTFC get(Tree tree)
    {
        return MAP.get(tree);
    }

    public BlockLogDTTFC(Tree tree)
    {
        super();
        if (MAP.put(tree, this) != null)
        {
            throw new IllegalStateException("There can only be one.");
        }
        else
        {
            this.tree = tree;
            setSoundType(SoundType.WOOD);
            setHardness(5.0F).setResistance(5.0F);
            setHarvestLevel("axe", 0);
            setCreativeTab(null);
            Blocks.FIRE.setFireInfo(this, 5, 5);
        }
    }
}
