package com.gabriberp.corruption.Entity.Client.Renderer;

import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Entity.Client.Model.SentinelSmallModel;
import com.gabriberp.corruption.Entity.Custom.SentinelSmallEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SentinelSmallRenderer extends MobRenderer<SentinelSmallEntity, SentinelSmallModel<SentinelSmallEntity>> {

    public SentinelSmallRenderer(EntityRendererProvider.Context context) {
        super(context, new SentinelSmallModel<>(context.bakeLayer(SentinelSmallModel.LAYER_LOCATION)), 1.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(SentinelSmallEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "textures/entity/sentinel.png");
    }

    @Override
    public void render(SentinelSmallEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
