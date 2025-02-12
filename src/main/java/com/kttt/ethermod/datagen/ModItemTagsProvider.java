package com.kttt.ethermod.datagen;

import com.kttt.ethermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //附魔附加
        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.FIRE_ETHER_SWORD);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.FIRE_ETHER_AXE)
                .add(ModItems.FIRE_ETHER_SHOVEL)
                .add(ModItems.FIRE_ETHER_HOE)
                .add(ModItems.FIRE_ETHER_PICKAXE);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.ICE_ETHER_HELMET)
                .add(ModItems.ICE_ETHER_CHESTPLATE)
                .add(ModItems.ICE_ETHER_LEGGINGS)
                .add(ModItems.ICE_ETHER_BOOTS);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ICE_ETHER_HELMET)
                .add(ModItems.ICE_ETHER_CHESTPLATE)
                .add(ModItems.ICE_ETHER_LEGGINGS)
                .add(ModItems.ICE_ETHER_BOOTS);
    }
}
