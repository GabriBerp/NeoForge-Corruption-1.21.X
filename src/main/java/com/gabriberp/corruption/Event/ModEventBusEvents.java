package com.gabriberp.corruption.Event;

import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Entity.Client.Model.SentinelEggModel;
import com.gabriberp.corruption.Entity.Client.Model.SentinelMediumModel;
import com.gabriberp.corruption.Entity.Client.Model.SentinelModel;
import com.gabriberp.corruption.Entity.Client.Model.SentinelSmallModel;
import com.gabriberp.corruption.Entity.Custom.SentinelEggEntity;
import com.gabriberp.corruption.Entity.Custom.SentinelEntity;
import com.gabriberp.corruption.Entity.Custom.SentinelMediumEntity;
import com.gabriberp.corruption.Entity.Custom.SentinelSmallEntity;
import com.gabriberp.corruption.Entity.ModEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = CorruptionMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(SentinelModel.LAYER_LOCATION, SentinelModel::createBodyLayer);
        event.registerLayerDefinition(SentinelMediumModel.LAYER_LOCATION, SentinelMediumModel::createBodyLayer);
        event.registerLayerDefinition(SentinelSmallModel.LAYER_LOCATION, SentinelSmallModel::createBodyLayer);
        event.registerLayerDefinition(SentinelEggModel.LAYER_LOCATION, SentinelEggModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.SENTINEL.get(), SentinelEntity.createAttributes().build());
        event.put(ModEntities.SENTINEL_MEDIUM.get(), SentinelMediumEntity.createAttributes().build());
        event.put(ModEntities.SENTINEL_SMALL.get(), SentinelSmallEntity.createAttributes().build());
        event.put(ModEntities.SENTINEL_EGG.get(), SentinelEggEntity.createAttributes().build());
    }
}
