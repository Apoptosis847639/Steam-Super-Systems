package com.apoptosis.supersteamsystems;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.apoptosis.supersteamsystems.config.SuperSteamSystemsConfig;
import com.apoptosis.supersteamsystems.data.SuperSteamSystemsDataGen;
import com.apoptosis.supersteamsystems.machines.multi.ForgeHammerMultiExample;
import com.apoptosis.supersteamsystems.registry.SuperSteamSystemsRegistrate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SuperSteamSystems.MOD_ID)
@SuppressWarnings("removal")
public class SuperSteamSystems {

    public static final String MOD_ID = "supersteamsystems";
    public static final Logger LOGGER = LogManager.getLogger();

    public SuperSteamSystems() {
        SuperSteamSystemsConfig.init();
        SuperSteamSystemsDataGen.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addGenericListener(MachineDefinition.class, this::registerMachines);

        // Most other events are fired on Forge's bus.
        // If we want to use annotations to register event listeners,
        // we need to register our object like this!
        MinecraftForge.EVENT_BUS.register(this);

        SuperSteamSystemsRegistrate.REGISTRATE.registerRegistrate();
    }

    /**
     * Create a ResourceLocation in the format "modid:path"
     *
     * @param path
     * @return ResourceLocation with the namespace of your mod
     */
    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    /**
     * Used to register your own new machines.
     * Call init() from your Machine class(es) here
     *
     * @param event
     */
    private void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        if (SuperSteamSystemsConfig.INSTANCE.config.registerExampleForgeHammerMulti) {
            ForgeHammerMultiExample.init();
        }
    }
}
