package com.apoptosis.supersteamsystems.data;

import com.apoptosis.supersteamsystems.data.lang.LangHandler;
import com.apoptosis.supersteamsystems.registry.SuperSteamSystemsRegistrate;
import com.tterrag.registrate.providers.ProviderType;

public class SuperSteamSystemsDataGen {

    public static void init() {
        SuperSteamSystemsRegistrate.REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}
