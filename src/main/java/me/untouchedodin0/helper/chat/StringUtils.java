package me.untouchedodin0.helper.chat;

import com.cryptomorin.xseries.XMaterial;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;

public class StringUtils {

  public static String formatMaterial(Material material) {
    return WordUtils.capitalize(material.name().toLowerCase().replaceAll("_", " "));
  }

  public static String formatMaterial(XMaterial xMaterial) {
    return WordUtils.capitalize(xMaterial.name().toLowerCase().replaceAll("_", " "));
  }

  public static String materialsMapToString(Map<Material, Double> map) {
    StringBuilder stringBuilder = new StringBuilder("{");
    for (Entry<Material, Double> entry : map.entrySet()) {
      stringBuilder.append(entry.getKey());
      stringBuilder.append("=");
      stringBuilder.append(entry.getValue());
      stringBuilder.append(", ");
    }
    stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
    stringBuilder.append("}");
    return stringBuilder.toString();
  }
}
