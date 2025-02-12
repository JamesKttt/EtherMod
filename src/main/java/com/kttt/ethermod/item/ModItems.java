package com.kttt.ethermod.item;

import com.kttt.ethermod.EtherMod;
import com.kttt.ethermod.item.custom.Prospecter;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ICE_ETHER = registerItems("ice_ether", new Item(new Item.Settings()));
    public static final Item RAW_ICE_ETHER = registerItems("raw_ice_ether", new Item(new Item.Settings()));

    public static final Item FIRE_ETHER = registerItems("fire_ether", new Item(new Item.Settings()));
    public static final Item RAW_FIRE_ETHER = registerItems("raw_fire_ether", new Item(new Item.Settings()));

    public static final Item PROSPECTOR = registerItems("prospector", new Prospecter(new Item.Settings()));

    public static final Item FIRE_ETHER_SWORD = registerItems("fire_ether_sword", new SwordItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 3, -2.0f))));
    public static final Item FIRE_ETHER_SHOVEL = registerItems("fire_ether_shovel", new ShovelItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 1.5f, -3.0f))));
    public static final Item FIRE_ETHER_PICKAXE = registerItems("fire_ether_pickaxe", new PickaxeItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 1.5f, -2.8f))));
    public static final Item FIRE_ETHER_AXE = registerItems("fire_ether_axe", new AxeItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().fireproof().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, 6.0f, -3.2f))));
    public static final Item FIRE_ETHER_HOE = registerItems("fire_ether_hoe", new HoeItem(ModToolMaterials.FIRE_ETHER,
            new Item.Settings().fireproof().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.FIRE_ETHER, -4.0f, 0.0f))));

    public static final Item ICE_ETHER_HELMET = registerItems("ice_ether_helmet", new ArmorItem(ModArmorMaterials.ICE_ETHER, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item ICE_ETHER_CHESTPLATE = registerItems("ice_ether_chestplate", new ArmorItem(ModArmorMaterials.ICE_ETHER, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item ICE_ETHER_LEGGINGS = registerItems("ice_ether_leggings", new ArmorItem(ModArmorMaterials.ICE_ETHER, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item ICE_ETHER_BOOTS = registerItems("ice_ether_boots", new ArmorItem(ModArmorMaterials.ICE_ETHER, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));
    public static final Item ICE_ETHER_HORSE_ARMOR = registerItems("ice_ether_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.ICE_ETHER, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));

    private static Item registerItems(String id, Item item) {
        // 由原版整合的方法
        //return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.ofVanilla(id)), item);
        return Registry.register(Registries.ITEM, Identifier.of(EtherMod.MOD_ID, id), item);
    }

    public static void registerModItems() {
        EtherMod.LOGGER.info("Registering Items");
    }
}
