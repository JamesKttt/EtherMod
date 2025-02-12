package com.kttt.ethermod.world;

import com.kttt.ethermod.EtherMod;
import com.kttt.ethermod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ICE_ETHER_ORE_KEY = of("ice_ether_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_ICE_ETHER_ORE_KEY = of("nether_ice_ether_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FIRE_ETHER_ORE_KEY = of("fire_ether_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_FIRE_ETHER_ORE_KEY = of("nether_fire_ether_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        //规则判断，是否符合
        RuleTest stoneReplace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepSlateReplace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplace = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> overWorldTargets = List.of(
                OreFeatureConfig.createTarget(stoneReplace, ModBlocks.ICE_ETHER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepSlateReplace, ModBlocks.ICE_ETHER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> overWorldTargets_Fire = List.of(
                OreFeatureConfig.createTarget(stoneReplace, ModBlocks.FIRE_ETHER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepSlateReplace, ModBlocks.FIRE_ETHER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherTargets = List.of(
                OreFeatureConfig.createTarget(netherReplace, ModBlocks.ICE_ETHER_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(netherReplace, ModBlocks.FIRE_ETHER_ORE.getDefaultState()));

        register(featureRegisterable, ICE_ETHER_ORE_KEY, Feature.ORE, new OreFeatureConfig(overWorldTargets, 4));
        register(featureRegisterable, FIRE_ETHER_ORE_KEY, Feature.ORE, new OreFeatureConfig(overWorldTargets_Fire, 4));
        register(featureRegisterable, NETHER_FIRE_ETHER_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherTargets, 12));
        register(featureRegisterable, NETHER_ICE_ETHER_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherTargets, 4));
    }
    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(EtherMod.MOD_ID, id));
    }
    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config
    ) {
        registerable.register(key, new ConfiguredFeature<FC, F>(feature, config));
    }
}
