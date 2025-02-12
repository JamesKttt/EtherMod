package com.kttt.ethermod.datagen;

import com.kttt.ethermod.block.ModBlocks;
import com.kttt.ethermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.ICE_ETHER_BLOCK)
                .add(ModBlocks.RAW_ICE_ETHER_BLOCK)
                .add(ModBlocks.ICE_ETHER_ORE)
                .add(ModBlocks.FIRE_ETHER_BLOCK)
                .add(ModBlocks.RAW_FIRE_ETHER_BLOCK)
                .add(ModBlocks.FIRE_ETHER_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ICE_ETHER_BLOCK)
                .add(ModBlocks.RAW_ICE_ETHER_BLOCK)
                .add(ModBlocks.ICE_ETHER_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.FIRE_ETHER_BLOCK)
                .add(ModBlocks.RAW_FIRE_ETHER_BLOCK)
                .add(ModBlocks.FIRE_ETHER_ORE);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.ICE_ETHER_FENCE);
        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.ICE_ETHER_WALL);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.ICE_ETHER_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.BUTTONS)
                .add(ModBlocks.ICE_ETHER_BUTTON);

        //getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
        //        .add(ModBlocks.ICE_ETHER_FENCE);
    }
}
