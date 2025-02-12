package com.kttt.ethermod.item.custom;

import com.kttt.ethermod.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class Prospecter extends Item{
    public Prospecter(Settings settings) {
        super(settings.fireproof());
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.ethermod.prospector.shift_tooltip"));
        } else {
            tooltip.add(Text.translatable("item.ethermod.prospector.tooltip"));
        }
    }

    @Override

    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();
        if(world.isClient()) {
            boolean foundBlock = false;
            if(!Screen.hasShiftDown()) {
                //模糊搜索
                player.sendMessage(Text.of("Pos:" + pos.getX() + "," + pos.getY() + "Mode:5*5."));
                for(int i = 0; i <= pos.getY() + 64; i++) {
                    for(int j = 0; j < 5; j++) {
                        for(int k = 0; k < 5; k++) {
                            BlockPos pos1 = pos.down(i).north(j).east(k);
                            BlockState blockState = world.getBlockState(pos1);
                            String name = blockState.getBlock().getName().getString();

                            if(isRightBlock(blockState)) {
                                player.sendMessage(Text.of("Found" + name + "."));
                                foundBlock = true;
                                break;
                            }
                        }
                    }
                }
                if(!foundBlock) {
                    player.sendMessage(Text.of("Not found."));
                }
            }
            else {
                //精准搜索
                player.sendMessage(Text.of("Pos:" + pos.getX() + "," + pos.getY() + "Mode:1*1."));
                for(int i = 0; i <= pos.getY() + 64; i++) {
                    BlockPos pos1 = pos.down(i);
                    BlockState blockState = world.getBlockState(pos1);
                    String name = blockState.getBlock().getName().getString();

                    if(isRightBlock(blockState)) {
                        player.sendMessage(Text.of("Found" + name + "."));
                        //world.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1.0f, 1.0f);
                        foundBlock = true;
                        break;
                    }
                }
                if(!foundBlock) {
                    player.sendMessage(Text.of("Not found."));
                }
            }
            context.getStack().damage(1, player, EquipmentSlot.MAINHAND);
            return ActionResult.SUCCESS;
        }
        return super.useOnBlock(context);
    }

    private boolean isRightBlock(BlockState blockState) {
        if(blockState.isOf(Blocks.DIAMOND_ORE) ||
           blockState.isOf(Blocks.DEEPSLATE_DIAMOND_ORE) ||
           //blockState.isOf(Blocks.IRON_ORE)    ||
           //blockState.isOf(Blocks.DEEPSLATE_IRON_ORE)    ||
           blockState.isOf(Blocks.DEEPSLATE_COAL_ORE)    ||
           blockState.isOf(Blocks.EMERALD_ORE) ||
           blockState.isOf(Blocks.DEEPSLATE_EMERALD_ORE) ||
           blockState.isOf(Blocks.ANCIENT_DEBRIS) ||
           blockState.isOf(ModBlocks.ICE_ETHER_ORE) || blockState.isOf(ModBlocks.FIRE_ETHER_ORE)
        ) {
            return true;
        }
        else {
            return false;
        }
    }
}
