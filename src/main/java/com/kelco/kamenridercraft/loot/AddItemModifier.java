package com.kelco.kamenridercraft.loot;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class AddItemModifier extends LootModifier {
	    public static final Supplier<MapCodec<AddItemModifier>> CODEC_SUPPLIER = Suppliers.memoize(()
	            -> RecordCodecBuilder.mapCodec(addItemModifierInstance -> AddItemModifier.codecStart(addItemModifierInstance).and(BuiltInRegistries.ITEM.byNameCodec()
	            .fieldOf("item").forGetter(addItemModifierInstance1 -> addItemModifierInstance1.item)).apply(addItemModifierInstance, AddItemModifier::new)));

	    private final Item item;

	    public AddItemModifier(LootItemCondition[] conditionsIn, Item item) {
	        super(conditionsIn);
	        this.item = item;
	    }

	    @Override
	    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
			for (LootItemCondition condition : this.conditions) {
				if (!condition.test(context)) {
	        		return generatedLoot;
				}
			}
			generatedLoot.add(new ItemStack(this.item));

			return generatedLoot;
		}

	    @Override
	    public MapCodec<? extends IGlobalLootModifier> codec() {
	        return CODEC_SUPPLIER.get();
	    }
	}

