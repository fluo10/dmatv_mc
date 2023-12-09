package net.fireturtle.dmatv;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;
/*
 * Decompiled with CFR 0.2.1 (FabricMC 53fa44c9).
 */

        import net.fabricmc.api.EnvType;
        import net.fabricmc.api.Environment;
        import net.minecraft.client.model.ModelData;
        import net.minecraft.client.model.ModelPart;
        import net.minecraft.client.model.ModelPartBuilder;
        import net.minecraft.client.model.ModelPartData;
        import net.minecraft.client.model.ModelTransform;
        import net.minecraft.client.model.TexturedModelData;
        import net.minecraft.client.render.entity.model.SinglePartEntityModel;
        import net.minecraft.entity.Entity;

/**
 * Represents the model of a minecart-like entity.
 *
 * <div class="fabric">
 * <table border=1>
 * <caption>Model parts of this model</caption>
 * <tr>
 *   <th>Part Name</th><th>Parent</th><th>Corresponding Field</th>
 * </tr>
 * <tr>
 *   <td>{@code bottom}</td><td>{@linkplain #root Root part}</td><td></td>
 * </tr>
 * <tr>
 *   <td>{@code front}</td><td>{@linkplain #root Root part}</td><td></td>
 * </tr>
 * <tr>
 *   <td>{@code back}</td><td>{@linkplain #root Root part}</td><td></td>
 * </tr>
 * <tr>
 *   <td>{@code left}</td><td>{@linkplain #root Root part}</td><td></td>
 * </tr>
 * <tr>
 *   <td>{@code right}</td><td>{@linkplain #root Root part}</td><td></td>
 * </tr>
 * </table>
 * </div>
 */
@Environment(value= EnvType.CLIENT)
public class DmatvEntityModel<T extends Entity>
        extends SinglePartEntityModel<T> {
    private final ModelPart root;

    public DmatvEntityModel(ModelPart root) {
        this.root = root;
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        int i = 20;
        int j = 8;
        int k = 16;
        int l = 4;
        modelPartData.addChild("bottom", ModelPartBuilder.create().uv(0, 10).cuboid(-10.0f, -8.0f, -1.0f, 20.0f, 16.0f, 2.0f), ModelTransform.of(0.0f, 4.0f, 0.0f, 1.5707964f, 0.0f, 0.0f));
        modelPartData.addChild("front", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0f, -9.0f, -1.0f, 16.0f, 8.0f, 2.0f), ModelTransform.of(-9.0f, 4.0f, 0.0f, 0.0f, 4.712389f, 0.0f));
        modelPartData.addChild("back", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0f, -9.0f, -1.0f, 16.0f, 8.0f, 2.0f), ModelTransform.of(9.0f, 4.0f, 0.0f, 0.0f, 1.5707964f, 0.0f));
        modelPartData.addChild("left", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0f, -9.0f, -1.0f, 16.0f, 8.0f, 2.0f), ModelTransform.of(0.0f, 4.0f, -7.0f, 0.0f, (float)Math.PI, 0.0f));
        modelPartData.addChild("right", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0f, -9.0f, -1.0f, 16.0f, 8.0f, 2.0f), ModelTransform.pivot(0.0f, 4.0f, 7.0f));
        return TexturedModelData.of(modelData, 64, 32);
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    public ModelPart getPart() {
        return this.root;
    }
}

