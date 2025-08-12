package com.gabriberp.corruption.Entity.Client.Renderer;

import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Entity.Client.Model.SentinelMediumModel;
import com.gabriberp.corruption.Entity.Custom.SentinelMediumEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class SentinelMediumRenderer extends MobRenderer<SentinelMediumEntity, SentinelMediumModel<SentinelMediumEntity>> {

    public SentinelMediumRenderer(EntityRendererProvider.Context context) {
        super(context, new SentinelMediumModel<>(context.bakeLayer(SentinelMediumModel.LAYER_LOCATION)), 1.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(SentinelMediumEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "textures/entity/sentinel.png");
    }

    @Override
    public void render(SentinelMediumEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
