package com.kttt.ethermod;

import com.kttt.ethermod.block.ModBlocks;
import com.kttt.ethermod.item.ModItemGroups;
import com.kttt.ethermod.item.ModItems;
import com.kttt.ethermod.world.gen.ModOreGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EtherMod implements ModInitializer {
	public static final String MOD_ID = "ethermod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerModItemGroups();
		ModOreGeneration.generateOres();

		LOGGER.info("Hello Fabric world!");
	}
}