package com.gabriberp.corruption.Entity.Client.Renderer;

import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Entity.Client.Model.CorruptionBugModel;
import com.gabriberp.corruption.Entity.Custom.CorruptionBugEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CorruptionBugRenderer extends MobRenderer<CorruptionBugEntity, CorruptionBugModel<CorruptionBugEntity>> {

    public CorruptionBugRenderer(EntityRendererProvider.Context context) {
        super(context, new CorruptionBugModel<>(context.bakeLayer(CorruptionBugModel.LAYER_LOCATION)), 1.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(CorruptionBugEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "textures/entity/corruption_spider.png");
    }

    @Override
    public void render(CorruptionBugEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}