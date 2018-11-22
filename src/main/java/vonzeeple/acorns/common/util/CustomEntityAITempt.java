package vonzeeple.acorns.common.util;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.item.Item;

public class CustomEntityAITempt extends EntityAITempt {

    private Item temptingItem;
    public CustomEntityAITempt(EntityCreature temptedEntityIn, double speedIn, Item temptItemIn, boolean scaredByPlayerMovementIn) {
        super(temptedEntityIn, speedIn, temptItemIn, scaredByPlayerMovementIn);
        this.temptingItem=temptItemIn;
    }

    public Item getTemptingItem(){
        return this.temptingItem;
    }
}
