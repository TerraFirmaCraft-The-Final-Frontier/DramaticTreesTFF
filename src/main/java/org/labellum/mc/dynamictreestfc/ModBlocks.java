package org.labellum.mc.dynamictreestfc;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

import com.ferreusveritas.dynamictrees.ModConstants;
import com.ferreusveritas.dynamictrees.api.TreeRegistry;
import com.ferreusveritas.dynamictrees.api.cells.ICellKit;
import com.ferreusveritas.dynamictrees.blocks.LeavesPaging;
import com.ferreusveritas.dynamictrees.blocks.LeavesProperties;
import net.dries007.tfc.objects.blocks.BlocksTFC;
import net.dries007.tfc.objects.blocks.wood.BlockLeavesTFC;
import org.labellum.mc.dynamictreestfc.blocks.BlockRootyDirtTFC;

import static org.labellum.mc.dynamictreestfc.DynamicTreesTFC.MOD_ID;

public class ModBlocks
{
    public static LeavesProperties[] tfcLeavesProperties;
    public static Map<String, LeavesProperties> leafMap;
    public static Map<String, ICellKit> kitMap;
    public static BlockRootyDirtTFC blockRootyDirt;

    public static void preInit()
    {
        blockRootyDirt = new BlockRootyDirtTFC();

        kitMap = new HashMap<>();
        fillMaps(kitMap);
    }

    public static void register(IForgeRegistry<Block> registry)
    {
        //For this mod it is vital that these are never reordered.  If a leaves properties is removed from the
        //mod then there should be a LeavesProperties.NULLPROPERTIES used as a placeholder.
        tfcLeavesProperties = new LeavesProperties[BlocksTFC.getAllLeafBlocks().size()];
        leafMap = new HashMap<>();
        int i = 0; // DT wants an array of leafprops for some reason
        for (BlockLeavesTFC leaf : BlocksTFC.getAllLeafBlocks())
        {
            LeavesProperties prop = new LeavesProperties(leaf.getDefaultState(), kitMap.get(leaf.tree.toString()));
            leafMap.put(leaf.tree.toString(), prop);
            tfcLeavesProperties[i++] = prop;
        }

        for (LeavesProperties lp : tfcLeavesProperties)
        {
            LeavesPaging.getNextLeavesBlock(MOD_ID, lp);
        }
        registry.register(blockRootyDirt);
    }

    private static void fillMaps(Map<String, ICellKit> kitMap)
    {
        kitMap.put("acacia", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "acacia")));
        kitMap.put("ash", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("aspen", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("blackwood", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "darkoak")));
        kitMap.put("chestnut", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("douglas_fir", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "conifer")));
        kitMap.put("hickory", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("kapok", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("maple", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("oak", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("flowering_oak", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("dark_oak", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("palm", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "palm")));
        kitMap.put("pine", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "conifer")));
        kitMap.put("rosewood", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("sequoia", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "conifer")));
        kitMap.put("spruce", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "conifer")));
        kitMap.put("norway_spruce", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "conifer")));
        kitMap.put("japanese_spruce", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "conifer")));
        kitMap.put("sycamore", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("birch", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("silver_birch", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("white_cedar", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("white_elm", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("willow", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("weeping_willow", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("hevea_benthamiana", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("hevea_braziliensis", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("hevea_camargoana", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("hevea_camporium", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("hevea_guianensis", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("hevea_microphylla", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("hevea_nitida", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("hevea_pauciflora", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("hevea_rigidifolia", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("hevea_spruceana", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("sapodilla", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
        kitMap.put("castilla", TreeRegistry.findCellKit(new ResourceLocation(ModConstants.MODID, "deciduous")));
    }
}
