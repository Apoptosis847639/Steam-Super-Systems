package com.apoptosis.supersteamsystems.machines.multi;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.network.chat.Component;

import com.apoptosis.supersteamsystems.machines.SteamParallelMultiblockMultiRecipeTypeMachine;
import com.apoptosis.supersteamsystems.registry.SuperSteamSystemsRegistrate;

import static com.gregtechceu.gtceu.api.pattern.Predicates.blocks;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_BRONZE_BRICKS;
import static com.gregtechceu.gtceu.common.data.GTBlocks.CASING_BRONZE_GEARBOX;
import static net.minecraft.world.level.block.Blocks.IRON_BLOCK;

public class ForgeHammerMultiExample {

    public static final MachineDefinition STEAM_MEGA_HAMMER_MULTI = SuperSteamSystemsRegistrate.REGISTRATE
            .multiblock("steam_mega_hammer_multi", SteamParallelMultiblockMultiRecipeTypeMachine::new)
            .rotationState(RotationState.NON_Y_AXIS)
            .appearanceBlock(CASING_BRONZE_BRICKS)
            .recipeTypes(GTRecipeTypes.BENDER_RECIPES, GTRecipeTypes.EXTRACTOR_RECIPES,
                    GTRecipeTypes.COMPRESSOR_RECIPES, GTRecipeTypes.FORGE_HAMMER_RECIPES)
            .recipeModifier(SteamParallelMultiblockMultiRecipeTypeMachine::recipeModifier, true)
            .pattern(multiblockMachineDefinition -> FactoryBlockPattern.start()
                    .aisle("BBBBB", "BBBBB", "BBBBB", "BBBBB", "BBBBB")
                    .aisle("BCCCB", "BCCCB", "BBCBB", "BBCBB", "BBDBB")
                    .aisle("CCCCC", "CFFFC", "BAAAB", "BAAAB", "BBDBB")
                    .aisle("CCCCC", "CFFFC", "CAFAC", "CAFAC", "DDDDD")
                    .aisle("CCCCC", "CFFFC", "BAAAB", "BAAAB", "BBDBB")
                    .aisle("BCCCB", "BCGCB", "BBCBB", "BBCBB", "BBDBB")
                    .where("A", Predicates.air())
                    .where("B", Predicates.any())
                    .where("C", blocks(CASING_BRONZE_BRICKS.get()).setMinGlobalLimited(6)
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1)))
                    .where("D", blocks(CASING_BRONZE_GEARBOX.get()))
                    .where("F", blocks(IRON_BLOCK))
                    .where("G", Predicates.controller(blocks(multiblockMachineDefinition.getBlock())))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/machines/forge_hammer"))
            .tooltips(Component.translatable("block.supersteamsystems.forge_hammer_multi.tooltip"))
            .register();

    public static void init() {}
}
