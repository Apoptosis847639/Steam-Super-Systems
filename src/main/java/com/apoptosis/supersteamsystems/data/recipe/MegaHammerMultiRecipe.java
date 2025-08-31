package com.apoptosis.supersteamsystems.data.recipe;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMachines;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;

import com.apoptosis.supersteamsystems.SteamSuperSystems;
import com.apoptosis.supersteamsystems.machines.multi.ForgeHammerMultiExample;

import java.util.function.Consumer;

public class MegaHammerMultiRecipe {

    public static void init(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, true, SteamSuperSystems.id("megahammer"),
                ForgeHammerMultiExample.STEAM_MEGA_HAMMER_MULTI.asStack(1), "CGC", "PBO", "EHE",
                'C', GTBlocks.CASING_BRONZE_BRICKS,
                'G', GTBlocks.CASING_BRONZE_GEARBOX,
                'P', GTMachines.STEAM_COMPRESSOR.left().asStack(),
                'B', GTMachines.BENDER[GTValues.LV].asStack(),
                'O', GTMachines.STEAM_HAMMER.left().asStack(),
                'E', new MaterialEntry(TagPrefix.gear, GTMaterials.Bronze),
                'H', GTMachines.STEAM_EXTRACTOR.left().asStack());
    }
}
