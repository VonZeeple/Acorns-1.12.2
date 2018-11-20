package vonzeeple.acorns;

import com.sun.istack.internal.NotNull;
import net.minecraft.block.SoundType;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vonzeeple.acorns.common.blocks.BlockAcorn;
import vonzeeple.acorns.common.items.ItemAcorns;

import java.util.Random;


public class Content {
    @GameRegistry.ObjectHolder(Acorns.MODID+":"+"acorns")//format modid:name
    public static final ItemAcorns itemAcorns = null;

    @GameRegistry.ObjectHolder(Acorns.MODID+":"+"block_acorn")//format modid:name
    public static final BlockAcorn blockAcorns = null;

    public static SoundType blockAcornSound=new SoundType(0.2F, 2.0F, SoundEvents.ENTITY_ITEM_PICKUP, SoundEvents.BLOCK_WOOD_STEP, SoundEvents.ENTITY_ITEM_PICKUP, SoundEvents.ENTITY_ITEM_PICKUP, SoundEvents.BLOCK_WOOD_FALL);
}
