package net.fireturtle.dmatv;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class DmatvClient implements ClientModInitializer {
	public static final EntityModelLayer MODEL_DMATV_LAYER = new EntityModelLayer(new Identifier("fireturtle", "dmatv"), "main");
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.INSTANCE.register(Dmatv.DMATV, (context) -> {
			return new DmatvEntityRenderer(context, MODEL_DMATV_LAYER);
		});


		EntityModelLayerRegistry.registerModelLayer(MODEL_DMATV_LAYER, DmatvEntityModel::getTexturedModelData);	}
}