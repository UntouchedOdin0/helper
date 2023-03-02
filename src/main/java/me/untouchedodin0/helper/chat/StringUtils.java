package me.untouchedodin0.helper.chat;

import com.cryptomorin.xseries.XMaterial;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;

public class StringUtils {

  public static String formatMaterial(Material material) {
    return WordUtils.capitalize(material.name().toLowerCase().replaceAll("_", " "));
  }

  public static String formatMaterial(XMaterial xMaterial) {
    return WordUtils.capitalize(xMaterial.name().toLowerCase().replaceAll("_", " "));
  }
}
