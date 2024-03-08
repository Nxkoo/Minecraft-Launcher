package com.github.nxkoo.launcher;

import fr.flowarg.flowlogger.ILogger;
import fr.flowarg.flowlogger.Logger;
import fr.flowarg.flowupdater.FlowUpdater;
import fr.flowarg.flowupdater.versions.AbstractForgeVersion;
import fr.flowarg.flowupdater.versions.ForgeVersionBuilder;
import fr.flowarg.flowupdater.versions.ForgeVersionType;
import fr.flowarg.flowupdater.versions.VanillaVersion;
import fr.flowarg.openlauncherlib.NoFramework;
import fr.theshark34.openlauncherlib.minecraft.AuthInfos;
import fr.theshark34.openlauncherlib.minecraft.GameFolder;
import fr.theshark34.openlauncherlib.minecraft.util.GameDirGenerator;


import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import static com.github.nxkoo.gui.consts.MINECRAFT_VANILLA_VERSION;


public class Launcher {
    private static final Path gameDir = GameDirGenerator.createGameDir("myLauncher", false);
    private static final File gameLog = new File(gameDir.toFile() + File.separator + "logs.txt");
    public static final ILogger logger = new Logger("[MyLauncher]", gameLog.toPath());

    public static void update() throws Exception {
        final VanillaVersion vanillaVersion = new VanillaVersion.VanillaVersionBuilder()
                .withName("1.7.10")
                .build();

        final AbstractForgeVersion forgeVersion = new ForgeVersionBuilder(ForgeVersionType.OLD)
                .withForgeVersion("1.7.10-10.13.4.1614-1.7.10")
                .build();

        final FlowUpdater updater = new FlowUpdater.FlowUpdaterBuilder()
                .withVanillaVersion(vanillaVersion)
                .withModLoaderVersion(forgeVersion)
                .withLogger(logger)
                .build();
        updater.update(gameDir);
    }

    public static void launch(String nickname) {
        try {
            NoFramework.ModLoader.OLD_FORGE.setJsonFileNameProvider((vanilla, modLoader) -> "1.7.10-Forge10.13.4.1614-1.7.10.json");
            NoFramework noFramework = new NoFramework(
                    gameDir,
                    new AuthInfos(
                            nickname,
                            UUID.randomUUID().toString(),
                            UUID.randomUUID().toString()
                    ),
                    GameFolder.FLOW_UPDATER
            );
            logger.info("Iniciando o minecraft com o nickname: " + nickname);

            Process mineProc = noFramework
                    .launch("1.7.10",
                    "1.7.10-Forge10.13.4.1614-1.7.10",
                    NoFramework.ModLoader.OLD_FORGE);
            mineProc.waitFor();

        } catch (Exception e) {
            logger.printStackTrace(e);
        }
    }
}
