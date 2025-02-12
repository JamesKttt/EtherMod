package com.kttt.ethermod.item;

import com.kttt.ethermod.EtherMod;
import com.kttt.ethermod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    // 利用返回值为ItemGroup，直接使用static final变量进行注册
    public static final ItemGroup ETHERMOD_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(EtherMod.MOD_ID, "ethermod_group"),
            ItemGroup.create(null, -1).displayName(Text.translatable("itemGroup.ethermod_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.ICE_ETHER);
                        entries.add(ModItems.RAW_ICE_ETHER);
                        entries.add(ModItems.FIRE_ETHER);
                        entries.add(ModItems.RAW_FIRE_ETHER);

                        entries.add(ModBlocks.ICE_ETHER_BLOCK);
                        entries.add(ModBlocks.ICE_ETHER_ORE);
                        entries.add(ModBlocks.RAW_ICE_ETHER_BLOCK);
                        entries.add(ModBlocks.FIRE_ETHER_BLOCK);
                        entries.add(ModBlocks.FIRE_ETHER_ORE);
                        entries.add(ModBlocks.RAW_FIRE_ETHER_BLOCK);

                        entries.add(ModBlocks.ICE_ETHER_WALL);
                        entries.add(ModBlocks.ICE_ETHER_STAIRS);
                        entries.add(ModBlocks.ICE_ETHER_SLAB);
                        entries.add(ModBlocks.ICE_ETHER_DOOR);
                        entries.add(ModBlocks.ICE_ETHER_TRAPDOOR);
                        entries.add(ModBlocks.ICE_ETHER_FENCE);
                        entries.add(ModBlocks.ICE_ETHER_FENCE_GATE);
                        entries.add(ModBlocks.ICE_ETHER_PRESSURE_PLATE);
                        entries.add(ModBlocks.ICE_ETHER_BUTTON);

                        entries.add(ModItems.FIRE_ETHER_SWORD);
                        entries.add(ModItems.FIRE_ETHER_SHOVEL);
                        entries.add(ModItems.FIRE_ETHER_PICKAXE);
                        entries.add(ModItems.FIRE_ETHER_AXE);
                        entries.add(ModItems.FIRE_ETHER_HOE);

                        entries.add(ModItems.ICE_ETHER_HELMET);
                        entries.add(ModItems.ICE_ETHER_CHESTPLATE);
                        entries.add(ModItems.ICE_ETHER_LEGGINGS);
                        entries.add(ModItems.ICE_ETHER_BOOTS);
                        entries.add(ModItems.ICE_ETHER_HORSE_ARMOR);

                        entries.add(ModItems.PROSPECTOR);
                    }).build());
    // 初始化方法
    public static void registerModItemGroups() {
        EtherMod.LOGGER.info("Registering Item Groups");
    }
}
