package com.kttt.ethermod.datagen;

import com.kttt.ethermod.block.ModBlocks;
import com.kttt.ethermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ICE_ETHER_BLOCK);
        addDrop(ModBlocks.RAW_ICE_ETHER_BLOCK);
        addDrop(ModBlocks.FIRE_ETHER_BLOCK);
        addDrop(ModBlocks.RAW_FIRE_ETHER_BLOCK);
        //addDrop(ModBlocks.ICE_ETHER_ORE, copperOreLikeDrops(ModBlocks.ICE_ETHER_ORE, ModItems.RAW_ICE_ETHER));
        addDrop(ModBlocks.ICE_ETHER_ORE, ModItems.RAW_ICE_ETHER);
        addDrop(ModBlocks.FIRE_ETHER_ORE, ModItems.RAW_FIRE_ETHER);

        addDrop(ModBlocks.ICE_ETHER_STAIRS);
        addDrop(ModBlocks.ICE_ETHER_FENCE);
        addDrop(ModBlocks.ICE_ETHER_FENCE_GATE);
        addDrop(ModBlocks.ICE_ETHER_BUTTON);
        addDrop(ModBlocks.ICE_ETHER_PRESSURE_PLATE);
        addDrop(ModBlocks.ICE_ETHER_WALL);
        addDrop(ModBlocks.ICE_ETHER_TRAPDOOR);

        addDrop(ModBlocks.ICE_ETHER_DOOR, doorDrops(ModBlocks.ICE_ETHER_DOOR));
        addDrop(ModBlocks.ICE_ETHER_SLAB, slabDrops(ModBlocks.ICE_ETHER_SLAB));
    }
    public LootTable.Builder copperOreLikeDrops(Block drop, Item dropItem) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(dropItem)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }
}
