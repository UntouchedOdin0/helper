package me.untouchedodin0.helper.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.World;

public class WorldAdapter extends TypeAdapter<World> {

  @Override
  public World read(JsonReader jsonReader) throws IOException {
    if (jsonReader.peek() == JsonToken.NULL) {
      jsonReader.nextNull();
      return null;
    }
    return Bukkit.getWorld(jsonReader.nextString());
  }

  @Override
  public void write(JsonWriter out, World world) throws IOException {
    if (world == null) {
      out.nullValue();
      return;
    }
    out.value(world.getName());
  }
}
