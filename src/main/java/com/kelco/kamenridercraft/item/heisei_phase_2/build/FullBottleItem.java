package com.kelco.kamenridercraft.item.heisei_phase_2.build;


import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.base_items.RiderFormChangeItem;
import com.kelco.kamenridercraft.item.heisei_phase_2.BuildRiderItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FullBottleItem extends RiderFormChangeItem {

  private Boolean HAZARD = false;
    private Boolean LEGEND = false;
    private String LEGEND_NAME;
    private Item Best_MATCH= BuildRiderItems.FULL_BOTTLE.get();

    public FullBottleItem(Properties properties,  String formName, String ridername, String beltTex, MobEffectInstance... effects) {
        super(properties, formName,  ridername, beltTex, effects);
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

        if(!player.hasEffect(EffectCore.FORM_LOCK)) {
            if (BELT.getItem() instanceof RiderDriverItem belt) {
              if (canChange(player,belt,BELT)) {
                 RiderDriverItem.setFormItem(player.getItemBySlot(EquipmentSlot.FEET), BuildRiderItems.FULL_BOTTLE.get(), 3);
                 super.use(level, player, usedHand);
                }else if(!getAlternative().isEmpty()){
                  super.use(level, player, usedHand);
              }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());

    }
}
