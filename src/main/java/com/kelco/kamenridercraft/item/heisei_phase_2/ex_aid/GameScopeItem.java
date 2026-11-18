package com.kelco.kamenridercraft.item.heisei_phase_2.ex_aid;

import com.kelco.kamenridercraft.attachments.AttachmentTypes;
import com.kelco.kamenridercraft.effects.EffectCore;
import com.kelco.kamenridercraft.entity.mobs.MobsCore;
import com.kelco.kamenridercraft.entity.mobs.bosses.BugsterBossEntity;
import com.kelco.kamenridercraft.item.base_items.BaseItem;
import com.kelco.kamenridercraft.util.GeneralUtil;
import com.kelco.kamenridercraft.util.MiscUtil;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class GameScopeItem extends BaseItem {
    public GameScopeItem(Properties prop) {
        super(prop);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (level instanceof ServerLevel serverLevel && player instanceof ServerPlayer serverPlayer &&
                !serverLevel.getDifficulty().equals(Difficulty.PEACEFUL)) {
            List<Villager> nearbyVillagers = serverLevel.getEntitiesOfClass(Villager.class,
                    serverPlayer.getBoundingBox().inflate(4), Objects::nonNull);
            boolean data = false;
            for (Villager villager : nearbyVillagers) {
                if (serverPlayer.hasLineOfSight(villager) && !villager.hasEffect(EffectCore.BUGSTER)) {
                    if (villager.getData(AttachmentTypes.MOB_STATE).equalsIgnoreCase("infected")) {
                        villager.addEffect(new MobEffectInstance(EffectCore.BUGSTER, 500, 0, true, false));
                        villager.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60, 0, true, false));
                        BugsterBossEntity bugster = MobsCore.BUGSTER_BOSS.get().create(serverPlayer.level());
                        bugster.setData(AttachmentTypes.UUID_STORE, villager.getStringUUID());
                        MiscUtil.spawnEnemy(serverPlayer, bugster, 10);
                        bugster.setData(AttachmentTypes.UUID_STORE, villager.getStringUUID());
                        data = true;
                        break;
                    }
                }
            }
            if (!data) {
                GeneralUtil.sendMessage(serverPlayer, "vicinity_actionbar", "item.kamenridercraft.game_scope.fail");
            }
            serverPlayer.setItemInHand(usedHand, serverPlayer.getItemInHand(usedHand));
            serverPlayer.getCooldowns().addCooldown(this, 100);
        }
        return super.use(level, player, usedHand);
    }
}