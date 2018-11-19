package vonzeeple.acorns.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemAcorns extends Item {
    public ItemAcorns(){
        super();
        setUnlocalizedName("acorns");
        setRegistryName("acorns:acorns");
        setCreativeTab(CreativeTabs.FOOD);
    }
}
