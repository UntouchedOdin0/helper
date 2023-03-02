package me.untouchedodin0.helper.chat;

import me.untouchedodin0.helper.Helper;
import net.kyori.adventure.Adventure;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;

public class AdventureUtils {

  public Helper helper = Helper.getHelper();

  public void sendMessage(Player player, String message) {
    if (helper.getAdventure() != null) {
      MiniMessage miniMessage = MiniMessage.miniMessage();
      BukkitAudiences bukkitAudiences = helper.getAdventure();
      Audience audience = bukkitAudiences.player(player);
      Component component = miniMessage.deserialize(message);
      audience.sendMessage(component);
    }
  }
}
