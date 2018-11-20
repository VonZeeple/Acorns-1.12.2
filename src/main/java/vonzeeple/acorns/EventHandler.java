package vonzeeple.acorns;

import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

import static net.minecraft.block.BlockSapling.TYPE;


@Mod.EventBusSubscriber
public class EventHandler {

    private static Random rand = new Random();

    @SubscribeEvent
    public static void onSaplingDroped(BlockEvent.HarvestDropsEvent event) {
        if (event.getState() == Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK)) {
            for (int i = 0; i < event.getDrops().size(); i++) {
                ItemStack item=event.getDrops().get(i);
                if (item.getItem() == Items.APPLE) {
                    if (Configuration.disableApples) {
                        event.getDrops().remove(i);
                    }
                }
                if(item.getItem()== Item.getItemFromBlock(Blocks.SAPLING)){
                    if(item.getMetadata()== Blocks.SAPLING.getMetaFromState(Blocks.SAPLING.getDefaultState().withProperty(TYPE,BlockPlanks.EnumType.OAK))){
                        if(Configuration.disableOakSaplings){event.getDrops().remove(i);}
                    }
                }
            }
            if (rand.nextInt(100) < Configuration.AcornDropChance) {
                event.getDrops().add(new ItemStack(Content.itemAcorns, 1));

            }

        }
    }

    //From Quark by Vazkii
    @SubscribeEvent
    public static void onEntityTick(LivingEvent.LivingUpdateEvent event) {
        if (!Configuration.acornsTemptPigs) {
            return;
        }
        if (event.getEntity() instanceof EntityPig) {
            EntityPig pig = (EntityPig) event.getEntity();
            pig.tasks.addTask(4, new EntityAITempt(pig, 1, Content.itemAcorns, false));
        }
    }

    @SubscribeEvent
    public static void breed(PlayerInteractEvent.EntityInteract event) {
        if (!Configuration.acornsBreedPigs) {
            return;
        }
        if (event.getHand() == EnumHand.MAIN_HAND)
            if (event.getItemStack().getItem() == Content.itemAcorns && event.getTarget() instanceof EntityPig) {
                EntityPig pig = (EntityPig) event.getTarget();
                ItemStack itemstack = event.getItemStack();
                EntityPlayer player = event.getEntityPlayer();
                if (!itemstack.isEmpty()) {
                    if (pig.getGrowingAge() == 0 && !pig.isInLove()) {
                        if (!player.capabilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }
                        pig.setInLove(player);

                    }
                    if (pig.isChild()) {
                        if (!player.capabilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }
                        pig.ageUp((int) ((float) (-pig.getGrowingAge() / 20) * 0.1F), true);

                    }
                }
            }
    }
}



