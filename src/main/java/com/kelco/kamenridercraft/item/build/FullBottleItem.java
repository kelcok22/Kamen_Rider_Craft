package com.kelco.kamenridercraft.item.build;


import com.google.common.collect.Lists;
import com.kelco.kamenridercraft.KamenRiderCraftCore;
import com.kelco.kamenridercraft.effect.Effect_core;
import com.kelco.kamenridercraft.item.BaseItems.BaseItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.BaseItems.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.Modded_item_core;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.GeckoLibCache;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static net.minecraft.util.parsing.packrat.Term.alternative;

public class FullBottleItem extends RiderFormChangeItem {

  private Boolean HAZARD = false;
    private Boolean LEGEND = false;
    private String LEGEND_NAME;
    private Item Best_MATCH= Build_Rider_Items.FULL_BOTTLE.get();

    public FullBottleItem(Properties properties, int belt, String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super(properties, belt,  formName,  ridername, beltTex, effects);
    }


    public RiderFormChangeItem get_Best_Match() {
        return (RiderFormChangeItem) Best_MATCH;
    }
    public Boolean Get_Can_Hazard() {
        return HAZARD;
    }
    public Boolean get_Is_Legend() {return LEGEND;}
    public String get_Is_Legend_Name() {return LEGEND_NAME;}

    public FullBottleItem BestMatch(Item item) {
        Best_MATCH= item;
        return this;
    }

    public FullBottleItem IsLegend(String formName) {
        LEGEND_NAME=formName;
        LEGEND=true;
        return this;
    }

    public FullBottleItem CanHazard() {
        HAZARD=true;
        return this;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {

        ItemStack itemstack = player.getItemInHand(usedHand);

        ItemStack BELT = player.getItemBySlot(EquipmentSlot.FEET);

        if(!player.hasEffect(Effect_core.FORM_LOCK)) {
            if (BELT.getItem() instanceof RiderDriverItem belt) {
              if (CanChange(player,belt,BELT)) {
                 RiderDriverItem.set_Form_Item(player.getItemBySlot(EquipmentSlot.FEET),Build_Rider_Items.FULL_BOTTLE.get(), 3);
                 super.use(level, player, usedHand);
                }else if(!getAlternative().isEmpty()){
                  super.use(level, player, usedHand);
              }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());

    }
}
