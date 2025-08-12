package com.gabriberp.corruption.Entity.Client.Renderer;

import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Entity.Client.Model.SentinelEggModel;
import com.gabriberp.corruption.Entity.Custom.SentinelEggEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SentinelEggRenderer extends MobRenderer<SentinelEggEntity, SentinelEggModel<SentinelEggEntity>> {

    public SentinelEggRenderer(EntityRendererProvider.Context context) {
        super(context, new SentinelEggModel<>(context.bakeLayer(SentinelEggModel.LAYER_LOCATION)), 1.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(SentinelEggEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "textures/entity/sentinel.png");
    }

    @Override
    public void render(SentinelEggEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
