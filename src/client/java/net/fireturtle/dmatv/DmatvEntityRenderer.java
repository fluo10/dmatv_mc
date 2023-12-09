package net.fireturtle.dmatv;
/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.MinecartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.vehicle.AbstractMinecartEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.fireturtle.dmatv.DmatvEntity;
@Environment(value=EnvType.CLIENT)
public class DmatvEntityRenderer
        extends EntityRenderer<DmatvEntity> {
    private static final Identifier TEXTURE = new Identifier("textures/entity/minecart.png");
    protected final EntityModel<DmatvEntity> model;
    private final BlockRenderManager blockRenderManager;

    public DmatvEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer) {
        super(ctx);
        this.shadowRadius = 0.7f;
        this.model = new DmatvEntityModel(ctx.getPart(layer));
        this.blockRenderManager = ctx.getBlockRenderManager();
    }

    @Override
    public void render(DmatvEntity dmatvEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(dmatvEntity, f, g, matrixStack, vertexConsumerProvider, i);
        matrixStack.push();
        long l = (long)dmatvEntity.getId() * 493286711L;
        l = l * l * 4392167121L + l * 98761L;
        float h = (((float)(l >> 16 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        float j = (((float)(l >> 20 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        float k = (((float)(l >> 24 & 7L) + 0.5f) / 8.0f - 0.5f) * 0.004f;
        matrixStack.translate(h, j, k);
        double d = MathHelper.lerp((double)g, (double)dmatvEntity.lastRenderX, (double)dmatvEntity.getX());
        double e = MathHelper.lerp((double)g, (double)dmatvEntity.lastRenderY, (double)dmatvEntity.getY());
        double m = MathHelper.lerp((double)g, (double)dmatvEntity.lastRenderZ, (double)dmatvEntity.getZ());
        double n = 0.3f;
        Vec3d vec3d = dmatvEntity.snapPositionToRail(d, e, m);
        float o = MathHelper.lerp((float)g, (float)dmatvEntity.prevPitch, (float)dmatvEntity.getPitch());
        if (vec3d != null) {
            Vec3d vec3d2 = dmatvEntity.snapPositionToRailWithOffset(d, e, m, (double)0.3f);
            Vec3d vec3d3 = dmatvEntity.snapPositionToRailWithOffset(d, e, m, (double)-0.3f);
            if (vec3d2 == null) {
                vec3d2 = vec3d;
            }
            if (vec3d3 == null) {
                vec3d3 = vec3d;
            }
            matrixStack.translate(vec3d.x - d, (vec3d2.y + vec3d3.y) / 2.0 - e, vec3d.z - m);
            Vec3d vec3d4 = vec3d3.add(-vec3d2.x, -vec3d2.y, -vec3d2.z);
            if (vec3d4.length() != 0.0) {
                vec3d4 = vec3d4.normalize();
                f = (float)(Math.atan2(vec3d4.z, vec3d4.x) * 180.0 / Math.PI);
                o = (float)(Math.atan(vec3d4.y) * 73.0);
            }
        }
        matrixStack.translate(0.0f, 0.375f, 0.0f);
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180.0f - f));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-o));
        float p = (float)dmatvEntity.getDamageWobbleTicks() - g;
        float q = dmatvEntity.getDamageWobbleStrength() - g;
        if (q < 0.0f) {
            q = 0.0f;
        }
        if (p > 0.0f) {
            matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(MathHelper.sin((float)p) * p * q / 10.0f * (float)dmatvEntity.getDamageWobbleSide()));
        }
        int r = dmatvEntity.getBlockOffset();
        BlockState blockState = dmatvEntity.getContainedBlock();
        if (blockState.getRenderType() != BlockRenderType.INVISIBLE) {
            matrixStack.push();
            float s = 0.75f;
            matrixStack.scale(0.75f, 0.75f, 0.75f);
            matrixStack.translate(-0.5f, (float)(r - 8) / 16.0f, 0.5f);
            matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90.0f));
            this.renderBlock(dmatvEntity, g, blockState, matrixStack, vertexConsumerProvider, i);
            matrixStack.pop();
        }
        matrixStack.scale(-1.0f, -1.0f, 1.0f);
        this.model.setAngles(dmatvEntity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        VertexConsumer vertexConsumer = vertexConsumerProvider.getBuffer(this.model.getLayer(this.getTexture(dmatvEntity)));
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0f, 1.0f, 1.0f, 1.0f);
        matrixStack.pop();
    }

    @Override
    public Identifier getTexture(DmatvEntity dmatvEntity) {
        return TEXTURE;
    }

    protected void renderBlock(DmatvEntity entity, float delta, BlockState state, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        this.blockRenderManager.renderBlockAsEntity(state, matrices, vertexConsumers, light, OverlayTexture.DEFAULT_UV);
    }
}

