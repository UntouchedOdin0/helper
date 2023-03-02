package me.untouchedodin0.helper.chat;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;

public class ColorUtils {

  public static String color(String string) {
    return ChatColor.translateAlternateColorCodes('&', string);
  }

  public List<String> color(List<String> list) {
    List<String> newList = new ArrayList<>(list.size());
    list.forEach(s -> newList.add(color(s)));
    return newList;
  }
}
