package com.kelco.kamenridercraft.entities.bosses;

import com.kelco.kamenridercraft.entities.footSoldiers.BaseHenchmenEntity;
import com.kelco.kamenridercraft.item.BaseItems.RiderDriverItem;
import com.kelco.kamenridercraft.item.Build_Rider_Items;
import com.kelco.kamenridercraft.item.Drive_Rider_Items;
import com.kelco.kamenridercraft.item.Zero_One_Rider_Items;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GordDriveEntity extends BaseHenchmenEntity {

    private static final EntityDataAccessor<Byte> DATA_FLAGS_ID = SynchedEntityData.defineId(AncientOOOEntity.class, EntityDataSerializers.BYTE);
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS));

    public static List<Item> THINGS_AND_STUFF= new ArrayList<Item>();


    public GordDriveEntity(EntityType<? extends BaseHenchmenEntity> type, Level level) {
        super(type, level);
        NAME="gord_drive";
        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Drive_Rider_Items.DRIVE_HELMET.get()));
        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Drive_Rider_Items.DRIVE_CHESTPLATE.get()));
        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Drive_Rider_Items.DRIVE_LEGGINGS.get()));
        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(Drive_Rider_Items.BANNO_DRIVER_GORD_DRIVE.get()));
    }
    protected void customServerAiStep() {
        super.customServerAiStep();
        this.bossEvent.setName(Component.translatable("entity.kamenridercraft.gord_drive").withStyle(ChatFormatting.GOLD));;
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }

    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }
    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        this.bossEvent.setName(this.getDisplayName());
    }

    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }



    public void tick() {
        if (this.getHealth()<150) {
            if(getItemBySlot(EquipmentSlot.FEET).getItem()==Drive_Rider_Items.BANNO_DRIVER_GORD_DRIVE.get()){
                ItemStack belt = getItemBySlot(EquipmentSlot.FEET);

                Random generator = new Random();
                int rand = generator.nextInt(THINGS_AND_STUFF.size());
                int rand2 = generator.nextInt(200);
                if (rand2==1)this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(THINGS_AND_STUFF.get(rand)));
            }

        }
        super.tick();
    }

	public static AttributeSupplier.Builder setAttributes() {
		return Monster.createMonsterAttributes()
        		.add(Attributes.FOLLOW_RANGE, 128.0D)
        		.add(Attributes.MOVEMENT_SPEED,(double)0.30F)
        		.add(Attributes.ATTACK_DAMAGE, 7.0D)
        		.add(Attributes.MAX_HEALTH, 130.0D);
     }
    

}