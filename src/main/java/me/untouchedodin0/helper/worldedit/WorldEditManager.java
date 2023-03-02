package me.untouchedodin0.helper.worldedit;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.WorldEditException;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormats;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.session.ClipboardHolder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.bukkit.World;

public class WorldEditManager {

  public Clipboard getClipboardFromFile(File file) {
    if (file == null) {
      return null;
    }

    ClipboardFormat clipboardFormat = ClipboardFormats.findByFile(file);
    if (clipboardFormat != null) {
      try (ClipboardReader clipboardReader = clipboardFormat.getReader(new FileInputStream(file))) {
        try {
          return clipboardReader.read();
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    return null;
  }

  public EditSession createEditSession(World world) {
    return WorldEdit.getInstance().newEditSessionBuilder().world(BukkitAdapter.adapt(world))
        .build();
  }

  public EditSession createEditSession(World world, boolean fastMode) {
    return WorldEdit.getInstance().newEditSessionBuilder().world(BukkitAdapter.adapt(world))
        .fastMode(fastMode).build();
  }

  public void paste(World world, Clipboard clipboard, BlockVector3 blockVector3) {
    ClipboardHolder clipboardHolder = new ClipboardHolder(clipboard);
    try (EditSession editSession = createEditSession(world)) {
      Operation operation = clipboardHolder.createPaste(editSession).to(blockVector3)
          .build();
      try {
        Operations.complete(operation);
      } catch (WorldEditException e) {
        e.printStackTrace();
      }
    }
  }

  public void paste(World world, Clipboard clipboard, BlockVector3 blockVector3, boolean fastMode) {
    ClipboardHolder clipboardHolder = new ClipboardHolder(clipboard);
    try (EditSession editSession = createEditSession(world, fastMode)) {
      Operation operation = clipboardHolder.createPaste(editSession).to(blockVector3)
          .ignoreAirBlocks(fastMode).build();
      try {
        Operations.complete(operation);
      } catch (WorldEditException e) {
        e.printStackTrace();
      }
    }
  }
}
