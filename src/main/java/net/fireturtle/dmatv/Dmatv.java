package net.fireturtle.dmatv;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityDimensions;
public class Dmatv  implements ModInitializer {

    /*
     * Registers our Cube Entity under the ID "entitytesting:cube".
     *
     * The entity is registered under the SpawnGroup#CREATURE category, which is what most animals and passive/neutral mobs use.
     * It has a hitbox size of .75x.75, or 12 "pixels" wide (3/4ths of a block).
     */

    public static final Item DMATV_ITEM = new DmatvItem(new FabricItemSettings());

    public static final EntityType<DmatvEntity> DMATV = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("fireturtle", "dmatv"),
            FabricEntityTypeBuilder.<DmatvEntity>create(SpawnGroup.MISC, DmatvEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM, new Identifier("fireturtle", "halberd"), DMATV_ITEM);
    }
}