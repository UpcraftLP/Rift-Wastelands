package com.github.upcraftlp.wastelands;

import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.IChunkGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dimdev.rift.listener.ChunkGeneratorReplacer;
import org.dimdev.rift.listener.MinecraftStartListener;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
public class WasteLands implements MinecraftStartListener, ChunkGeneratorReplacer {

    /**
     * the ID of the wastelands world type
     */
    private static final int WORLD_TYPE_WASTELANDS_ID = 9;

    public static final Logger log = LogManager.getLogger("wastelands");

    public static final WorldType WASTELANDS = new WorldType(WORLD_TYPE_WASTELANDS_ID, "wastelands");

    @Override
    public void onMinecraftStart() {
        log.info("registered wastelands world type with ID {}!", WORLD_TYPE_WASTELANDS_ID);
    }

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public IChunkGenerator createChunkGenerator(WorldServer world, WorldType worldType, int dimensionID) {
        if(dimensionID == 0 && worldType == WASTELANDS) world.setSeaLevel(150);
        return null;
    }
}
