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
			() -> new BaseItem(new Item.Properties()).AddToList(RiderTabs.DRIVE_TAB_ITEM));

	public static String[] Can_use_Eyecons = new String[] {"ghost","specter"};

	public static final DeferredItem<Item> ORE_DAMASHII = ITEMS.register("ore_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"ore_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2));

	public static final DeferredItem<Item> ORE_GHOST_EYECON = ITEMS.register("ore_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(ORE_DAMASHII.get()).alsoChange2ndSlot(ORE_DAMASHII.get()).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> SPECTER_DAMASHII = ITEMS.register("specter_damashii",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"specter_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2));

	public static final DeferredItem<Item> SPECTER_GHOST_EYECON = ITEMS.register("specter_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"","ghost","ghostdriver_belt_specter",
					new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 40, 0,true,false)
					,new MobEffectInstance(MobEffects.JUMP, 40, 1,true,false))
					.addAlternative(SPECTER_DAMASHII.get()).alsoChange2ndSlot(SPECTER_DAMASHII.get()).AddToList(RiderTabs.GHOST_TAB_ITEM));


	public static final DeferredItem<Item> MUSASHI_GHOST_EYECON = ITEMS.register("musashi_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"musashi_damashii","ghost","ghostdriver_belt",
					new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0,true,false))
					.AddCompatibilityList(Can_use_Eyecons).ChangeModel("damashii.geo.json").ChangeSlot(2).AddToList(RiderTabs.GHOST_TAB_ITEM));

	public static final DeferredItem<Item> EDISON_GHOST_EYECON = ITEMS.register("edison_ghost_eyecon",
			() -> new RiderFormChangeItem(new Item.Properties(),0,"edison_damashii","ghost","ghostdriver_belt",
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


	public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
