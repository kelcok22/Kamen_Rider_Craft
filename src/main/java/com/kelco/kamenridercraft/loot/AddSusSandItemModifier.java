package com.kelco.kamenridercraft.loot;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class AddSusSandItemModifier extends LootModifier {
	    public static final Supplier<MapCodec<AddSusSandItemModifier>> CODEC_SUPPLIER = Suppliers.memoize(()
	            -> RecordCodecBuilder.mapCodec(addItemModifierInstance -> AddSusSandItemModifier.codecStart(addItemModifierInstance).and(BuiltInRegistries.ITEM.byNameCodec()
	            .fieldOf("item").forGetter(addItemModifierInstance1 -> addItemModifierInstance1.item)).apply(addItemModifierInstance, AddSusSandItemModifier::new)));

	    private final Item item;

	    public AddSusSandItemModifier(LootItemCondition[] conditionsIn, Item item) {
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

			if(context.getRandom().nextFloat() < 0.5f) {
				generatedLoot.clear();
				generatedLoot.add(new ItemStack(this.item));

			}

			return generatedLoot;
		}

	    @Override
	    public MapCodec<? extends IGlobalLootModifier> codec() {
	        return CODEC_SUPPLIER.get();
	    }
	}

