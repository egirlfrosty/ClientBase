package me.frosty.client.mixin;


import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tweaker implements ITweaker {

    private final List<String> arguments = new ArrayList<>();

    @Override
    public final void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        this.arguments.addAll(args);

        final String version = "--version";
        final String assetDir = "--assetDir";
        final String gamesDir = "--gameDir";

        if (!args.contains(version) && profile != null) {
            this.arguments.add(version);
            this.arguments.add(profile);
        }

        if (!args.contains(assetDir) && profile != null) {
            this.arguments.add(assetDir);
            this.arguments.add(profile);
        }

        if (!args.contains(gamesDir) && profile != null) {
            this.arguments.add(gamesDir);
            this.arguments.add(profile);
        }
    }

    @Override
    public final void injectIntoClassLoader(LaunchClassLoader classLoader) {
        MixinBootstrap.init();

        MixinEnvironment environment = MixinEnvironment.getDefaultEnvironment();

        //noinspection deprecation
        environment.addConfiguration("mixins.client.json");

        if (environment.getObfuscationContext() == null) {
            environment.setObfuscationContext("notch");
        }

        environment.setSide(MixinEnvironment.Side.CLIENT);
    }

    @Override
    public String getLaunchTarget() {
        return MixinBootstrap.getPlatform().getLaunchTarget();
    }

    @Override
    public String[] getLaunchArguments() {
        return this.arguments.toArray(new String[0]);
    }
}