package com.kttt.ethermod.datagen;

import com.kttt.ethermod.EtherMod;
import com.kttt.ethermod.block.ModBlocks;
import com.kttt.ethermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends FabricRecipeProvider {
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private static final List<ItemConvertible> RAW_ICE_ETHER = List.of(ModBlocks.ICE_ETHER_ORE);
    private static final List<ItemConvertible> ICE_ETHER = List.of(ModItems.RAW_ICE_ETHER);
    private static final List<ItemConvertible> RAW_FIRE_ETHER = List.of(ModBlocks.FIRE_ETHER_ORE);
    private static final List<ItemConvertible> FIRE_ETHER = List.of(ModItems.RAW_FIRE_ETHER);

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ICE_ETHER,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_ETHER_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_ICE_ETHER,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_ICE_ETHER_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.FIRE_ETHER,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.FIRE_ETHER_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_FIRE_ETHER,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_FIRE_ETHER_BLOCK);

        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PROSPECTOR, 1)
                    .pattern("TXT")
                    .pattern("#K#")
                    .pattern("#Z#")
                    .input('#', Ingredient.ofItems(Items.NETHERITE_INGOT))
                    .input('X', Ingredient.ofItems(Items.COMPASS))
                    .input('K', Ingredient.ofItems(Items.REDSTONE))
                    .input('Z', Ingredient.ofItems(Items.GOLD_INGOT))
                    .input('T', Ingredient.ofItems(Items.IRON_INGOT))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(Items.IRON_INGOT))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(Items.COMPASS))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(Items.REDSTONE))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(Items.NETHERITE_INGOT))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "prospector"));
        } //探矿器
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ICE_ETHER_SLAB, 6)
                    .pattern("###")
                    .input('#', Ingredient.ofItems(ModBlocks.ICE_ETHER_BLOCK))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModBlocks.ICE_ETHER_BLOCK))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_slab"));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ICE_ETHER_STAIRS, 4)
                    .pattern("  #")
                    .pattern(" ##")
                    .pattern("###")
                    .input('#', Ingredient.ofItems(ModBlocks.ICE_ETHER_BLOCK))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModBlocks.ICE_ETHER_BLOCK))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_stairs"));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ICE_ETHER_BUTTON, 1)
                    .pattern("#")
                    .input('#', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_button"));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ICE_ETHER_FENCE, 6)
                    .pattern("#X#")
                    .pattern("#X#")
                    .input('#', Ingredient.ofItems(ModBlocks.ICE_ETHER_BLOCK))
                    .input('X', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_fence"));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ICE_ETHER_FENCE_GATE, 1)
                    .pattern("X#X")
                    .pattern("X#X")
                    .input('#', Ingredient.ofItems(ModBlocks.ICE_ETHER_BLOCK))
                    .input('X', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_fence_gate"));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ICE_ETHER_PRESSURE_PLATE, 1)
                    .pattern("## ")
                    .input('#', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_pressure_gplate"));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ICE_ETHER_TRAPDOOR, 2)
                    .pattern("## ")
                    .pattern("## ")
                    .input('#', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_trapdoor"));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ICE_ETHER_WALL, 6)
                    .pattern("###")
                    .pattern("###")
                    .input('#', Ingredient.ofItems(ModBlocks.ICE_ETHER_BLOCK))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModBlocks.ICE_ETHER_BLOCK))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_wall"));

            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.ICE_ETHER_DOOR, 1)
                    .pattern("## ")
                    .pattern("## ")
                    .pattern("## ")
                    .input('#', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_door"));
        } //建筑类合成
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FIRE_ETHER_SWORD, 1)
                    .pattern(" # ")
                    .pattern(" # ")
                    .pattern(" X ")
                    .input('#', Ingredient.ofItems(ModItems.FIRE_ETHER))
                    .input('X', Ingredient.ofItems(Items.STICK))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(Items.STICK))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "fire_ether_sword"));
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FIRE_ETHER_PICKAXE, 1)
                    .pattern("###")
                    .pattern(" X ")
                    .pattern(" X ")
                    .input('#', Ingredient.ofItems(ModItems.FIRE_ETHER))
                    .input('X', Ingredient.ofItems(Items.STICK))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(Items.STICK))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "fire_ether_pickaxe"));
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FIRE_ETHER_AXE, 1)
                    .pattern("## ")
                    .pattern("#X ")
                    .pattern(" X ")
                    .input('#', Ingredient.ofItems(ModItems.FIRE_ETHER))
                    .input('X', Ingredient.ofItems(Items.STICK))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(Items.STICK))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "fire_ether_axe"));
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FIRE_ETHER_HOE, 1)
                    .pattern("## ")
                    .pattern(" X ")
                    .pattern(" X ")
                    .input('#', Ingredient.ofItems(ModItems.FIRE_ETHER))
                    .input('X', Ingredient.ofItems(Items.STICK))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(Items.STICK))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "fire_ether_hoe"));
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.FIRE_ETHER_SHOVEL, 1)
                    .pattern(" # ")
                    .pattern(" X ")
                    .pattern(" X ")
                    .input('#', Ingredient.ofItems(ModItems.FIRE_ETHER))
                    .input('X', Ingredient.ofItems(Items.STICK))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(Items.STICK))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "fire_ether_shovel"));
        } //工具类合成
        {
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_ETHER_HELMET, 1)
                    .pattern("###")
                    .pattern("# #")
                    .input('#', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_helmet"));
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_ETHER_CHESTPLATE, 1)
                    .pattern("# #")
                    .pattern("###")
                    .pattern("###")
                    .input('#', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_chestplate"));
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_ETHER_LEGGINGS, 1)
                    .pattern("###")
                    .pattern("# #")
                    .pattern("# #")
                    .input('#', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_leggings"));
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_ETHER_BOOTS, 1)
                    .pattern("# #")
                    .pattern("# #")
                    .input('#', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_boots"));
            ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ICE_ETHER_HORSE_ARMOR, 1)
                    .pattern("  #")
                    .pattern("# #")
                    .pattern("#X#")
                    .input('#', Ingredient.ofItems(ModItems.ICE_ETHER))
                    .input('X', Ingredient.ofItems(Items.LIME_WOOL))
                    .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.ICE_ETHER))
                    .offerTo(exporter, Identifier.of(EtherMod.MOD_ID, "ice_ether_horse_armor"));
        } //盔甲类合成

        offerSmelting(exporter, RAW_ICE_ETHER, RecipeCategory.MISC, ModItems.RAW_ICE_ETHER,
                0.7f, 200, "raw_ice_ether");
        offerSmelting(exporter, ICE_ETHER, RecipeCategory.MISC, ModItems.ICE_ETHER,
                0.7f, 200, "ice_ether");
        offerSmelting(exporter, RAW_FIRE_ETHER, RecipeCategory.MISC, ModItems.RAW_FIRE_ETHER,
                0.7f, 200, "raw_fire_ether");
        offerSmelting(exporter, FIRE_ETHER, RecipeCategory.MISC, ModItems.FIRE_ETHER, 
                0.7f, 200, "fire_ether");

        offerBlasting(exporter, RAW_ICE_ETHER, RecipeCategory.MISC, ModItems.RAW_ICE_ETHER,
                0.7f, 100, "raw_ice_ether");
        offerBlasting(exporter, ICE_ETHER, RecipeCategory.MISC, ModItems.ICE_ETHER,
                0.7f, 100, "ice_ether");
        offerBlasting(exporter, RAW_FIRE_ETHER, RecipeCategory.MISC, ModItems.RAW_FIRE_ETHER,
                0.7f, 100, "raw_fire_ether");
        offerBlasting(exporter, FIRE_ETHER, RecipeCategory.MISC, ModItems.FIRE_ETHER,
                0.7f, 100, "fire_ether");
    }
}
