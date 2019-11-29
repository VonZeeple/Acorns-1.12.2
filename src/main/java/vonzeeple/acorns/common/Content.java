package vonzeeple.acorns.common;


import net.minecraft.block.SoundType;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import vonzeeple.acorns.Acorns;
import vonzeeple.acorns.common.blocks.BlockAcorn;
import vonzeeple.acorns.common.items.ItemAcorns;


public class Content {
    @ObjectHolder(Acorns.MODID+":"+"acorns")
    public static final ItemAcorns itemAcorns = null;

    @ObjectHolder(Acorns.MODID+":"+"block_acorn")
    public static final BlockAcorn blockAcorns = null;

    public static SoundType blockAcornSound=new SoundType(0.2F, 2.0F, SoundEvents.ENTITY_ITEM_PICKUP, SoundEvents.BLOCK_WOOD_STEP, SoundEvents.ENTITY_ITEM_PICKUP, SoundEvents.ENTITY_ITEM_PICKUP, SoundEvents.BLOCK_WOOD_FALL);
}
