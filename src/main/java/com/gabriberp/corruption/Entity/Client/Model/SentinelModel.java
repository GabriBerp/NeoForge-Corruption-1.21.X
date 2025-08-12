package com.gabriberp.corruption.Entity.Client.Model;

import com.gabriberp.corruption.CorruptionMod;
import com.gabriberp.corruption.Entity.Client.Animations.SentinelAnimations;
import com.gabriberp.corruption.Entity.Custom.SentinelEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class SentinelModel<T extends SentinelEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(CorruptionMod.MOD_ID, "sentinel"), "main");
    private final ModelPart Lower_body;
    private final ModelPart Body;
    private final ModelPart Head;
    private final ModelPart Right_arm;
    private final ModelPart Left_arm;

    public SentinelModel(ModelPart root) {
        this.Lower_body = root.getChild("lower_body");
        this.Body = root.getChild("body");
        this.Head = root.getChild("Head");
        this.Right_arm = root.getChild("right_arm");
        this.Left_arm = root.getChild("left_arm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition lower_body = partdefinition.addOrReplaceChild("lower_body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.326F, 3.3901F, -8.5F, 15.0F, 4.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(-6.326F, 0.3901F, -7.5F, 15.0F, 7.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 41).addBox(-7.326F, -6.6099F, -5.5F, 12.0F, 9.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(58, 20).addBox(-9.326F, 4.3901F, -5.5F, 14.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(62, 0).addBox(-2.326F, -12.6099F, -2.5F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.674F, 16.6099F, -0.5F));

        PartDefinition cube_r1 = lower_body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0F, -9.0F, 7.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.326F, -4.6099F, -0.5F, -0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r2 = lower_body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0F, -9.0F, 7.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.326F, 5.3901F, 0.5F, 2.7489F, 0.0F, -3.1416F));

        PartDefinition cube_r3 = lower_body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0F, -9.0F, 7.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.326F, 12.3901F, -0.5F, 0.0F, 1.5708F, -0.3927F));

        PartDefinition cube_r4 = lower_body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0F, -9.0F, 7.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.326F, 2.3901F, -1.5F, 0.0F, 1.5708F, 0.3927F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(82, 65).addBox(-2.0F, -6.0F, 1.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, -2.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0F, -9.0F, 7.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -10.0F, 1.0F, -1.5708F, 0.3054F, -1.5708F));

        PartDefinition bone3 = body.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 64).addBox(-5.0F, -11.0F, -1.0F, 10.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition head = partdefinition.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(52, 41).addBox(-6.0F, -11.2713F, -7.1014F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -17.4754F, -5.5665F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0F, -9.0F, 7.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -6.5246F, -1.4335F, 0.0F, 1.5708F, 0.0F));

        PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(36, 65).addBox(-4.0F, -1.9785F, -2.7591F, 5.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -14.0F, -3.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition cube_r7 = right_arm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(70, 65).addBox(0.0F, -11.0F, 3.0F, 3.0F, 23.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 20.0215F, -9.7591F, -0.7418F, 0.0F, 0.0F));

        PartDefinition cube_r8 = right_arm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0F, -9.0F, 7.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.0215F, -6.7591F, 0.0F, 0.0F, -1.5708F));

        PartDefinition cube_r9 = right_arm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 87).addBox(-5.0F, -9.0F, 7.0F, 10.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.0215F, 7.2409F, 3.1416F, 0.0F, 1.5708F));

        PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(58, 65).addBox(-0.5F, -0.735F, -1.8386F, 3.0F, 23.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -15.9911F, -2.9424F, -0.3491F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(@NotNull SentinelEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animate(entity.idleAnimationState, SentinelAnimations.SENTINEL_IDLE, ageInTicks, 1f);
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.Head.yRot = headYaw * ((float)Math.PI / 180f);
        this.Head.xRot = headPitch *  ((float)Math.PI / 180f);
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        Lower_body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        Left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public @NotNull ModelPart root() {
        return Lower_body;
    }
}
