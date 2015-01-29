package net.acomputerdog.ircbot.mc.command;

import com.sorcix.sirc.structure.Channel;
import com.sorcix.sirc.structure.User;
import com.sorcix.sirc.util.Chattable;
import net.acomputerdog.ircbot.command.Command;
import net.acomputerdog.ircbot.command.util.CommandLine;
import net.acomputerdog.ircbot.main.IrcBot;

import java.lang.Override;import java.lang.String;import java.lang.StringBuilder;import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CommandDrama extends Command {
    private final List<String> people = getPeopleList();
    private final List<String> actions = getActionsList();
    private final List<String> targets = getTargetsList();
    private final List<String> results = getResultsList();

    private final Random random;

    public CommandDrama(IrcBot bot) {
        super(bot, "drama", "drama");
        random = new Random();
    }

    @Override
    public String getDescription() {
        return "Generates minecraft-related drama.";
    }

    @Override
    public boolean processCommand(Channel channel, User user, Chattable chattable, CommandLine commandLine) {
        StringBuilder drama = new StringBuilder();
        drama.append(randomItem(people));
        drama.append(' ');
        drama.append(randomItem(actions));
        drama.append(' ');
        drama.append(randomItem(targets));
        if (random.nextBoolean()) {
            drama.append(" and ");
            drama.append(randomItem(results));
        }
        chattable.send(drama.toString());
        return true;
    }

    private String randomItem(List<String> list) {
        return list.get(random.nextInt(list.size()));
    }

    private static List<String> getPeopleList() {
        return Arrays.asList("acomputerdog", "big_Xplosion", "Asie", "Searge", "LexManos", "Eloraam", "Pahimar", "cpw", "coolsquid", "sp614x", "FlowerChild", "Curse", "Mojang", "Notch", "Jeb", "Dinnerbone", "iChun", "ljfa", "Pahimar", "bspkrs", "StrikingWolf");
    }

    private static List<String> getActionsList() {
        return Arrays.asList("removes support for", "bans", "breaks compatibility with", "DMCAs", "removes", "removes compatibility with", "causes crash when using", "steals code from", "releases fork of", "DDoSes", "speaks out against", "expresses support for", "hates on", "sues", "targets", "adds trojan to", "adds backdoor to");
    }

    private static List<String> getTargetsList() {
        return Arrays.asList("BetterSnow", "Timber", "LumberJack", "BlazeLoader", "LiteLoader", "M3L", "Enigma", "FML", "ModLoader", "MCP", "Optifine", "TooManyItems", "NotEnoughItems", "Pixelmon", "Forge Multipart", "Minecraft Forge", "Minecraft", "the Minecraft launcher", "Minecraft clones", "Java", "RedPower", "Hexxit", "Bukkit", "Sponge", "Tekkit", "Tinkers Construct");
    }

    private static List<String> getResultsList() {
        return Arrays.asList("causes community backlash", "is sued", "causes anti-mod movement", "triggers Minecraft exodus", "creates a hostile modding community", "triggers backlash by Mojang", "causes legal battle");
    }
}
