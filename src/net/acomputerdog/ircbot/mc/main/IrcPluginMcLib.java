package net.acomputerdog.ircbot.mc.main;

import net.acomputerdog.ircbot.command.CommandManager;
import net.acomputerdog.ircbot.main.IrcBot;
import net.acomputerdog.ircbot.mc.command.CommandDrama;
import net.acomputerdog.ircbot.plugin.IrcPlugin;

public class IrcPluginMcLib implements IrcPlugin {

    private IrcBot bot;

    @Override
    public IrcBot getIrcBot() {
        return bot;
    }

    @Override
    public String getID() {
        return "mclib";
    }

    @Override
    public String getName() {
        return "Minecraft Lib";
    }

    @Override
    public void onLoad(IrcBot ircBot) {
        this.bot = ircBot;
        try {
            CommandManager manager = bot.getCommandManager();
            manager.registerCommand(new CommandDrama(bot));
        } catch (Exception e) {
            getLogger().logError("Exception registering MC commands!", e);
        }
        getLogger().logInfo("Loaded MC commands.");
    }

    @Override
    public void onUnload() {
        getLogger().logInfo("Unloaded MC commands.");
    }
}
