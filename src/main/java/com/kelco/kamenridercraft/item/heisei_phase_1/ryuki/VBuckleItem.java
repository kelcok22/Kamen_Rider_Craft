package com.kelco.kamenridercraft.item.heisei_phase_1.ryuki;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom.GodaRenderLayerInfo;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom.RyukiRenderLayerInfo;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom.oooHenshinRenderLayerInfo;
import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom.oooSuperHenshinRenderLayerInfo;
import com.kelco.kamenridercraft.item.base_items.RiderDriverItem;
import com.kelco.kamenridercraft.item.heisei_phase_1.FaizRiderItems;
import com.kelco.kamenridercraft.item.heisei_phase_2.OOORiderItems;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.List;

public class VBuckleItem extends RiderDriverItem {
    public VBuckleItem(Holder<ArmorMaterial> material, String rider, DeferredItem<Item> baseFormItem, DeferredItem<Item> head, DeferredItem<Item> torso, DeferredItem<Item> legs, Properties properties) {
        super(material, rider, baseFormItem, head, torso, legs, properties);
    }

    public void SetUnlimitedModels(List<RenderLayerInfo> layerInfo, ItemStack itemStack, LivingEntity rider, EquipmentSlot slot) {
        super.SetUnlimitedModels(layerInfo,itemStack,rider,slot);
        if (slot == EquipmentSlot.HEAD) {
            double henshin =rider.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue();

            if ( RiderDriverItem.isTransforming(rider) && henshin < 10) {
                layerInfo.add(new RyukiRenderLayerInfo(getFormItem(itemStack, 1).getRiderName(riderName) + getFormItem(itemStack, 1).getFormName(false),getFormItem(itemStack, 1).getModel(this.riderName),1));
                layerInfo.add(new RyukiRenderLayerInfo(getFormItem(itemStack, 1).getRiderName(riderName) + getFormItem(itemStack, 1).getFormName(false),getFormItem(itemStack, 1).getModel(this.riderName),2));
                layerInfo.add(new RyukiRenderLayerInfo(getFormItem(itemStack, 1).getRiderName(riderName) + getFormItem(itemStack, 1).getFormName(false),getFormItem(itemStack, 1).getModel(this.riderName),3));

            }
        }
    }

    public double getBaseHenshinTick(ItemStack stack, LivingEntity rider){
        return 40;
    }


    @Override
    public String getText(ItemStack itemstack, EquipmentSlot equipmentSlot, LivingEntity rider, String riderName) {
        double henshin_tick = getHenshinTick(itemstack, rider);
        if (equipmentSlot == EquipmentSlot.FEET) {
            if (isTransforming(rider) && henshin_tick > 15) {
                if (riderName.contains("odin"))return "belts/v_buckle_belt_empty_odin";
                return "belts/v_buckle_belt_empty";
            }
        }
         return super.getText(itemstack,  equipmentSlot, rider,riderName);
    }


}