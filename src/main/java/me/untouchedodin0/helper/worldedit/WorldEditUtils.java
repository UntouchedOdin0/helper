package me.untouchedodin0.helper.worldedit;

import com.sk89q.worldedit.math.BlockVector3;
import org.bukkit.Location;
import org.bukkit.World;

public class WorldEditUtils {

  public static Location toBukkitLocation(BlockVector3 vector3, World world) {
    return new Location(world, vector3.getX(), vector3.getY(), vector3.getZ());
  }
}
