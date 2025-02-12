package com.kttt.ethermod.world;

import com.kttt.ethermod.EtherMod;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ICE_ETHER_ORE_PLACED_KEY = of("ice_ether_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_ICE_ETHER_ORE_PLACED_KEY = of("nether_ice_ether_ore_placed");
    public static final RegistryKey<PlacedFeature> FIRE_ETHER_ORE_PLACED_KEY = of("fire_ether_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_FIRE_ETHER_ORE_PLACED_KEY = of("nether_fire_ether_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryEntryLookup = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(featureRegisterable, ICE_ETHER_ORE_PLACED_KEY, registryEntryLookup.getOrThrow(ModConfiguredFeatures.ICE_ETHER_ORE_KEY),
                ModOrePlacements.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(featureRegisterable, NETHER_ICE_ETHER_ORE_PLACED_KEY, registryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_ICE_ETHER_ORE_KEY),
                ModOrePlacements.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(featureRegisterable, FIRE_ETHER_ORE_PLACED_KEY, registryEntryLookup.getOrThrow(ModConfiguredFeatures.FIRE_ETHER_ORE_KEY),
                ModOrePlacements.modifiersWithCount(8,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(featureRegisterable, NETHER_FIRE_ETHER_ORE_PLACED_KEY, registryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_FIRE_ETHER_ORE_KEY),
                ModOrePlacements.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
    }
    public static RegistryKey<PlacedFeature> of(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(EtherMod.MOD_ID, id));
    }
    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            List<PlacementModifier> modifiers
    ) {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            PlacementModifier... modifiers
    ) {
        register(featureRegisterable, key, feature, List.of(modifiers));
    }
}
