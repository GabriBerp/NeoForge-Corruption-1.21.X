package com.gabriberp.corruption.Entity.Client.Model;

import com.gabriberp.corruption.CorruptionMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;

public class CorruptionBugModel<T extends Entity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "corruption_bug"), "main");
    private final ModelPart head;
    private final ModelPart body;

    public CorruptionBugModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 37).addBox(-5.0F, -5.0F, -5.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 24.0F, -13.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(30, 24).addBox(-1.0F, -9.0F, -9.0F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.0F, -4.0F, -0.7417F, -0.3747F, 0.2291F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(30, 24).addBox(-1.0F, -9.0F, -9.0F, 0.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 3.0F, -5.0F, -0.7417F, 0.3747F, -0.2291F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -8.0F, -7.0F, 12.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(1, 40).addBox(-1.0F, -12.0F, -7.0F, 0.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(7, 46).addBox(-1.0F, -11.0F, 4.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(7, 46).addBox(-1.0F, -9.0F, 9.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(7, 46).addBox(-1.0F, -8.0F, 14.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(7, 46).addBox(-1.0F, -6.0F, 19.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(2, 51).addBox(-1.0F, -1.0F, 24.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(-6.0F, -7.0F, 4.0F, 10.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(26, 43).addBox(-5.0F, -5.0F, 9.0F, 8.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(46, 0).addBox(-4.0F, -4.0F, 14.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(46, 12).addBox(-3.0F, -2.0F, 19.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 24.0F, -6.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}