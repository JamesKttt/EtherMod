package com.kttt.ethermod.datagen;

import com.kttt.ethermod.block.ModBlockFamilies;
import com.kttt.ethermod.item.ModItems;
import com.kttt.ethermod.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ArmorItem;

public class ModModelsProvider extends FabricModelProvider{
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ICE_ETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_FIRE_ETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIRE_ETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.FIRE_ETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ICE_ETHER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ICE_ETHER_ORE);

        ModBlockFamilies.getFamilies()
                .filter(BlockFamily::shouldGenerateModels).forEach(
                        blockFamily -> blockStateModelGenerator.registerCubeAllModelTexturePool(blockFamily.getBaseBlock())
                                .family(blockFamily)); //替代ICE_ETHER_BLOCK以及其衍生的各种建筑材料注册语句
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ICE_ETHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ICE_ETHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.FIRE_ETHER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_FIRE_ETHER, Models.GENERATED);

        itemModelGenerator.register(ModItems.PROSPECTOR, Models.GENERATED);

        itemModelGenerator.register(ModItems.FIRE_ETHER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FIRE_ETHER_HOE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ICE_ETHER_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ICE_ETHER_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ICE_ETHER_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ICE_ETHER_BOOTS);

        itemModelGenerator.register(ModItems.ICE_ETHER_HORSE_ARMOR, Models.GENERATED);
    }
}
