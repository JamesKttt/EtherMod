package com.kttt.ethermod.datagen;

import com.kttt.ethermod.block.ModBlocks;
import com.kttt.ethermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.ICE_ETHER, "Ice Ether");
        translationBuilder.add(ModItems.RAW_ICE_ETHER, "Raw Ice Ether");
        translationBuilder.add(ModItems.FIRE_ETHER, "Fire Ether");
        translationBuilder.add(ModItems.RAW_FIRE_ETHER, "Raw Fire Ether");

        translationBuilder.add(ModBlocks.ICE_ETHER_BLOCK, "Ice Ether Block");
        translationBuilder.add(ModBlocks.ICE_ETHER_ORE, "Ice Ether Ore");
        translationBuilder.add(ModBlocks.RAW_ICE_ETHER_BLOCK, "Raw Ice Ether Block");
        translationBuilder.add(ModBlocks.FIRE_ETHER_BLOCK, "Fire Ether Block");
        translationBuilder.add(ModBlocks.FIRE_ETHER_ORE, "Fire Ether Ore");
        translationBuilder.add(ModBlocks.RAW_FIRE_ETHER_BLOCK, "Raw Fire Ether Block");

        translationBuilder.add(ModItems.PROSPECTOR, "Prospector");

        translationBuilder.add("item.ethermod.prospector.shift_tooltip", "A tool used to find ores.Precise search mode.");
        translationBuilder.add("item.ethermod.prospector.tooltip", "A tool used to find ores.Fuzzy search mode.");

        translationBuilder.add(ModBlocks.ICE_ETHER_BUTTON, "Ice Ether Button");
        translationBuilder.add(ModBlocks.ICE_ETHER_WALL, "Ice Ether Wall");
        translationBuilder.add(ModBlocks.ICE_ETHER_DOOR, "Ice Ether Door");
        translationBuilder.add(ModBlocks.ICE_ETHER_FENCE, "Ice Ether Fence");
        translationBuilder.add(ModBlocks.ICE_ETHER_STAIRS, "Ice Ether Stairs");
        translationBuilder.add(ModBlocks.ICE_ETHER_SLAB, "Ice Ether Slab");
        translationBuilder.add(ModBlocks.ICE_ETHER_TRAPDOOR, "Ice Ether TrabDoor");
        translationBuilder.add(ModBlocks.ICE_ETHER_PRESSURE_PLATE, "Ice Ether Pressure Plate");
        translationBuilder.add(ModBlocks.ICE_ETHER_FENCE_GATE, "Ice Ether Fence Gate");

        translationBuilder.add(ModItems.FIRE_ETHER_SWORD, "Fire Ether Sword");
        translationBuilder.add(ModItems.FIRE_ETHER_SHOVEL, "Fire Ether Shovel");
        translationBuilder.add(ModItems.FIRE_ETHER_PICKAXE, "Fire Ether Pickaxe");
        translationBuilder.add(ModItems.FIRE_ETHER_AXE, "Fire Ether Axe");
        translationBuilder.add(ModItems.FIRE_ETHER_HOE, "Fire Ether Hoe");

        translationBuilder.add(ModItems.ICE_ETHER_HELMET, "Ice Ether Helmet");
        translationBuilder.add(ModItems.ICE_ETHER_CHESTPLATE, "Ice Ether Chestplate");
        translationBuilder.add(ModItems.ICE_ETHER_LEGGINGS, "Ice Ether Leggings");
        translationBuilder.add(ModItems.ICE_ETHER_BOOTS, "Ice Ether Boots");

        translationBuilder.add(ModItems.ICE_ETHER_HORSE_ARMOR, "Ice Ether Horse Armor");
    }
}