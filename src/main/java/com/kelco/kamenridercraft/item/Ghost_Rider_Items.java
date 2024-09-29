package com.kelco.kamenridercraft.item;

import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderArmorItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.drive.DriveDriverItem;
import com.kelco.kamenridercraft.item.ghost.GhostDriverItem;
import com.kelco.kamenridercraft.item.tabs.RiderTabs;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Ghost_Rider_Items {

	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(KamenRiderCraftCore.MOD_ID);

	public static final DeferredItem<Item> GHOST_LOGO = ITEMS.register("ghost_logo",
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static String[] Can_use_Eyecons = new String[] {"ghost","specter","necrom","zero_specter","dark_necrom","dark_ghost","kanon_specter"};

	public static final DeferredItem<Item> ORE_DAMASHII = ITEMS.register("ore_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ore_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2));

	public static final DeferredItem<Item> ORE_GHOST_EYECON = ITEMS.register("ore_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(ORE_DAMASHII.get()).alsoChange2ndSlot(ORE_DAMASHII.get()).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> BOOST_DAMASHII = ITEMS.register("boost_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"boost_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddNum(3).ChangeModel("damashii.geo.json").ChangeSlot(2));

	public static final DeferredItem<Item> BOOST_GHOST_EYECON = ITEMS.register("boost_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_boost","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(BOOST_DAMASHII.get()).alsoChange2ndSlot(BOOST_DAMASHII.get()).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SPECTER_DAMASHII = ITEMS.register("specter_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"specter_damashii","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddNum(2).AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2));

	public static final DeferredItem<Item> SPECTER_GHOST_EYECON = ITEMS.register("specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","specter","ghostdriver_belt_specter",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(SPECTER_DAMASHII.get()).alsoChange2ndSlot(SPECTER_DAMASHII.get()).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DEEP_SPECTER_DAMASHII = ITEMS.register("deep_specter_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"deep_damashii","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddNum(0).ChangeModel("damashii.geo.json").ChangeSlot(2));

	public static final DeferredItem<Item> DEEP_SPECTER_GHOST_EYECON = ITEMS.register("deep_specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"_deep","specter","ghostdriver_belt_specter",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(DEEP_SPECTER_DAMASHII.get()).alsoChange2ndSlot(DEEP_SPECTER_DAMASHII.get()).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NECROM_DAMASHII = ITEMS.register("necrom_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"necrom_damashii","necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddNum(0).AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2));

	public static final DeferredItem<Item> NECROM_GHOST_EYECON = ITEMS.register("necrom_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","necrom","necrom_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(NECROM_DAMASHII.get()).alsoChange2ndSlot(NECROM_DAMASHII.get()).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARK_DAMASHII = ITEMS.register("dark_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dark_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2));

	public static final DeferredItem<Item> DARK_GHOST_EYECON = ITEMS.register("dark_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","dark_ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(ORE_DAMASHII.get()).alsoChange2ndSlot(ORE_DAMASHII.get()).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> ZERO_SPECTER_DAMASHII = ITEMS.register("zero_specter_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"zero_specter_damashii","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddNum(2).AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2));

	public static final DeferredItem<Item> ZERO_SPECTER_GHOST_EYECON = ITEMS.register("zero_specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","zero_specter","ghostdriver_belt_specter",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(ZERO_SPECTER_DAMASHII.get()).alsoChange2ndSlot(ZERO_SPECTER_DAMASHII.get()).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> KANON_SPECTER_DAMASHII = ITEMS.register("kanon_specter_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kanon_specter_damashii","specter","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddNum(2).AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2));

	public static final DeferredItem<Item> KANON_SPECTER_GHOST_EYECON = ITEMS.register("kanon_specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","kanon_specter","ghostdriver_belt_specter",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(KANON_SPECTER_DAMASHII.get()).alsoChange2ndSlot(KANON_SPECTER_DAMASHII.get()).AddToList(RiderTabs.GHOST_TAB_ITEM));


	public static final DeferredItem<Item> DARK_NECROM_RED_GHOST_EYECON = ITEMS.register("dark_necrom_red_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dark_necrom_red_damashii","dark_necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddNum(0).AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARK_NECROM_BLUE_GHOST_EYECON = ITEMS.register("dark_necrom_blue_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dark_necrom_blue_damashii","dark_necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddNum(0).AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARK_NECROM_YELLOW_GHOST_EYECON = ITEMS.register("dark_necrom_yellow_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dark_necrom_yellow_damashii","dark_necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddNum(0).AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARK_NECROM_PINK_GHOST_EYECON = ITEMS.register("dark_necrom_pink_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"dark_necrom_pink_damashii","dark_necrom","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddNum(0).AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NEW_ORE_GHOST_EYECON = ITEMS.register("new_ore_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"new_ore_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> MUSASHI_GHOST_EYECON = ITEMS.register("musashi_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"musashi_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> EDISON_GHOST_EYECON = ITEMS.register("edison_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"edison_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> ROBIN_GHOST_EYECON = ITEMS.register("robin_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"robin_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NEWTON_GHOST_EYECON = ITEMS.register("newton_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"newton_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> BILLY_THE_KID_GHOST_EYECON = ITEMS.register("billy_the_kid_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"billy_the_kid_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> BEETHOVEN_GHOST_EYECON = ITEMS.register("beethoven_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"beethoven_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> BENKEI_GHOST_EYECON = ITEMS.register("benkei_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"benkei_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));


	public static final DeferredItem<Item> GOEMON_GHOST_EYECON = ITEMS.register("goemon_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"goemon_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).AddNum(3).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> RYOMA_GHOST_EYECON = ITEMS.register("ryoma_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ryoma_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).AddNum(3).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> HIMIKO_GHOST_EYECON = ITEMS.register("himiko_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"himiko_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).AddNum(3).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> TUTANKHAMUN_GHOST_EYECON = ITEMS.register("tutankhamun_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"tutankhamun_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).AddNum(2).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NOBUNAGA_GHOST_EYECON = ITEMS.register("nobunaga_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"nobunaga_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).AddNum(2).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> HOUDINI_GHOST_EYECON = ITEMS.register("houdini_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"houdini_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).AddNum(2).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> GRIMM_GHOST_EYECON = ITEMS.register("grimm_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"grimm_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).AddNum(0).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SANZO_GHOST_EYECON = ITEMS.register("sanzo_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"sanzo_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).AddNum(0).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NAPOLEON_GHOST_EYECON = ITEMS.register("napoleon_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"napoleon_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARWIN_GHOST_EYECON = ITEMS.register("darwin_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"darwin_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> IKKYU_GHOST_EYECON = ITEMS.register("ikkyu_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ikkyu_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> PYTHAGORAS_GHOST_EYECON = ITEMS.register("pythagoras_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"pythagoras_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SANTA_GHOST_EYECON = ITEMS.register("santa_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"santa_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NIGHTINGALE_GHOST_EYECON = ITEMS.register("nightingale_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"nightingale_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SPECIAL_ORE_GHOST_EYECON = ITEMS.register("special_ore_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"special_ore_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> ORE_SPECTER_GHOST_EYECON = ITEMS.register("ore_specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ore_specter_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));
	//ishinomori_ghost_icon
	public static final DeferredItem<Item> COLUMBUS_GHOST_EYECON = ITEMS.register("columbus_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"columbus_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SHAKEPEARE_GHOST_EYECON = ITEMS.register("shakespeare_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"shakespeare_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> KAMEHAMEHA_GHOST_EYECON = ITEMS.register("kamehameha_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"kamehameha_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> GALILEO_GHOST_EYECON = ITEMS.register("galileo_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"galileo_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DA_VINCI_GHOST_EYECON = ITEMS.register("da_vinci_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"da_vinci_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> TENKATOITSU_GHOST_EYECON = ITEMS.register("tenkatoitsu_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"tenkatoitsu_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SHINSENGUMI_GHOST_EYECON = ITEMS.register("shinsengumi_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"shinsengumi_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> GHOST_HELMET = ITEMS.register("ghost_head",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Properties()).AddToTabList(RiderTabs.GHOST_TAB_ITEM));
	public static final DeferredItem<Item> GHOST_CHESTPLATE = ITEMS.register("ghost_troso",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Properties()).AddToTabList(RiderTabs.GHOST_TAB_ITEM));
	public static final DeferredItem<Item> GHOST_LEGGINGS = ITEMS.register("ghost_legs",
			() -> new RiderArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Properties()).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> GHOST_DRIVER = ITEMS.register("ghost_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"ghost",ORE_GHOST_EYECON ,1, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(ORE_DAMASHII).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SPECTER_DRIVER = ITEMS.register("specter_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"specter",SPECTER_GHOST_EYECON ,2, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(SPECTER_DAMASHII).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> MEGA_ULORDER = ITEMS.register("mega_ulorder",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"necrom",NECROM_GHOST_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(NECROM_DAMASHII).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> DARK_GHOST_DRIVER = ITEMS.register("dark_ghost_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_ghost",DARK_GHOST_EYECON ,1, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(DARK_DAMASHII).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> ZERO_SPECTER_DRIVER = ITEMS.register("zero_specter_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"zero_specter",ZERO_SPECTER_GHOST_EYECON ,2, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(ZERO_SPECTER_DAMASHII).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> KANON_SPECTER_DRIVER = ITEMS.register("kanon_specter_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"kanon_specter",KANON_SPECTER_GHOST_EYECON ,2, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(KANON_SPECTER_DAMASHII).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_MEGA_ULORDER_RED = ITEMS.register("proto_mega_ulorder_red",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_necrom",NECROM_GHOST_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(DARK_NECROM_RED_GHOST_EYECON).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_MEGA_ULORDER_BLUE = ITEMS.register("proto_mega_ulorder_blue",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_necrom",NECROM_GHOST_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(DARK_NECROM_BLUE_GHOST_EYECON).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_MEGA_ULORDER_YELLOW = ITEMS.register("proto_mega_ulorder_yellow",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_necrom",NECROM_GHOST_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(DARK_NECROM_YELLOW_GHOST_EYECON).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> PROTO_MEGA_ULORDER_PINK = ITEMS.register("proto_mega_ulorder_pink",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_necrom",NECROM_GHOST_EYECON ,0, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(DARK_NECROM_PINK_GHOST_EYECON).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> NEW_GHOST_DRIVER = ITEMS.register("new_ghost_driver",
			() -> new GhostDriverItem(ArmorMaterials.DIAMOND,"dark_ghost",DARK_GHOST_EYECON ,1, GHOST_HELMET,GHOST_CHESTPLATE,GHOST_LEGGINGS , new Item.Properties())
					.Add_Extra_Base_Form_Items(NEW_ORE_GHOST_EYECON).AddToTabList(RiderTabs.GHOST_TAB_ITEM));

	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
