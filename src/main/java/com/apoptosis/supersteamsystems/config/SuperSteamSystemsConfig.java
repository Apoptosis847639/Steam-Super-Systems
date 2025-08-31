package com.apoptosis.supersteamsystems.config;

import com.apoptosis.supersteamsystems.SuperSteamSystems;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.ConfigHolder;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = SuperSteamSystems.MOD_ID)
public class SuperSteamSystemsConfig {

    public static SuperSteamSystemsConfig INSTANCE;

    public static ConfigHolder<SuperSteamSystemsConfig> CONFIG_HOLDER;

    public static void init() {
        CONFIG_HOLDER = Configuration.registerConfig(SuperSteamSystemsConfig.class, ConfigFormats.yaml());
        INSTANCE = CONFIG_HOLDER.getConfigInstance();
    }

    @Configurable
    public TrappedConfig config = new TrappedConfig();

    public static class TrappedConfig {

        @Configurable
        @Configurable.Comment({ "Whether the example multiblock will register or not" })
        public boolean registerExampleForgeHammerMulti = true;
    }
}
