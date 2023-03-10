package me.untouchedodin0.helper;

import me.untouchedodin0.helper.time.CooldownManager;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;

public class Helper {

  public static Helper helper;
  public Plugin plugin;
  private final BukkitAudiences adventure;
  private final CooldownManager cooldownManager;

  public Helper(Plugin plugin) {
    helper = this;
    this.plugin = plugin;
    this.adventure = BukkitAudiences.create(plugin);
    this.cooldownManager = new CooldownManager();
  }

  public static Helper getHelper() {
    return helper;
  }

  public static Server getServer() {
    return Bukkit.getServer();
  }

  public static ConsoleCommandSender getConsole() {
    return getServer().getConsoleSender();
  }

  public BukkitAudiences getAdventure() {
    return adventure;
  }

  public CooldownManager getCooldownManager() {
    return cooldownManager;
  }
}
