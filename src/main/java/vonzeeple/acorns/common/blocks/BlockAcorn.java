package vonzeeple.acorns.common.blocks;

import net.minecraft.block.*;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vonzeeple.acorns.Acorns;
import vonzeeple.acorns.Content;


import java.util.Random;

public class BlockAcorn extends BlockSapling {

    protected static final AxisAlignedBB ACORN_AABB = new AxisAlignedBB(0.4, 0.0, 0.4, 0.6, 0.1, 0.6);

    public BlockAcorn() {
        super();
        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)).withProperty(TYPE,BlockPlanks.EnumType.OAK));
        this.setUnlocalizedName("block_acorn");
        this.setRegistryName("acorns:block_acorn");
        //this.setSoundType(Content.blockAcornSound);
        this.setSoundType(Content.blockAcornSound);

    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Content.itemAcorns,1);
        //return getItem(world, pos, state);
    }
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){return Content.itemAcorns;}
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return ACORN_AABB;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {TYPE, STAGE});
    }
    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        return;
    }
    @Override
    public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if ((Integer) state.getValue(STAGE) == 0)
        {
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        }
        else
        {
            this.generateSapling(worldIn, pos, state);
        }
    }

    public void generateSapling(World worldIn, BlockPos pos, IBlockState state){
        IBlockState sapling = Blocks.SAPLING.getDefaultState().withProperty(TYPE,BlockPlanks.EnumType.OAK);
        worldIn.setBlockState(pos,sapling,4);
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        if (this == Content.blockAcorns)  return EnumPlantType.Plains;
        return net.minecraftforge.common.EnumPlantType.Plains;
    }
    public StateMapperBase getCustomStateMapper(){
        return new StateMapperBase()
        {
            @Override
            protected ModelResourceLocation getModelResourceLocation(IBlockState state)
            {
                return new ModelResourceLocation(Acorns.MODID.toLowerCase() + ":block_acorn", "normal");
            }
        };
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.SOLID;
    }
}
