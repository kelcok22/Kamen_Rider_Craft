package com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.custom;

import com.kelco.kamenridercraft.client.renderer.armor.render_layer.render_layer_info.RenderLayerInfo;
import com.kelco.kamenridercraft.world.attribute.KRCAttributes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;


public class GaimArmsRenderLayerInfo extends RenderLayerInfo {
    String Model;

    public GaimArmsRenderLayerInfo(String texture, String model) {
        super("transforming/"+texture, "transforming/"+model);
        this.Model = model;
    }

    private float xOffset(float tickCount) {
        return tickCount * 0.2F;
    }

    public void ApplyRenderLayer(BakedGeoModel model, ItemStack stack, LivingEntity entity, float partialTick,
                                 MultiBufferSource bufferSource, PoseStack poseStack, int packedLight) {
        GeoBone bone = model.getBone("body").orElse(null);
        double henshin_tick = entity.getAttribute(KRCAttributes.IS_TRANSFORMING).getValue() - partialTick;

        if (bone != null) {
            double drop =henshin_tick;
            if (henshin_tick < 10) {
                drop = 10;
            }
            bone.setPosY((float) (drop- 10) * 3);
        }


        if (Model.contains("orange") || Model.contains("ringo") || Model.contains("melon")) {
            GeoBone orange_1 = model.getBone("orange_1").orElse(null);
            GeoBone orange_1_upper = model.getBone("orange_1_upper").orElse(null);
            GeoBone orange_2 = model.getBone("orange_2").orElse(null);
            GeoBone orange_2_upper = model.getBone("orange_2_upper").orElse(null);
            GeoBone orange_3 = model.getBone("orange_3").orElse(null);
            GeoBone orange_3_upper = model.getBone("orange_3_upper").orElse(null);
            GeoBone orange_4 = model.getBone("orange_4").orElse(null);
            GeoBone orange_4_upper = model.getBone("orange_4_upper").orElse(null);

            if (orange_1 != null && henshin_tick < 8) {
                orange_1.setRotZ(Mth.clamp(orange_1.getRotZ() + 10f * Mth.DEG_TO_RAD, 0, 140 * Mth.DEG_TO_RAD));
                if (orange_1_upper != null && henshin_tick < 4) {
                    orange_1_upper.setRotZ(Mth.clamp(orange_1_upper.getRotZ() - 20f * Mth.DEG_TO_RAD, -150 * Mth.DEG_TO_RAD, 0));
                }
            } else if (orange_1 != null && henshin_tick >= 8) {
                orange_1.setRotZ(0);
                if (orange_1_upper != null) {
                    orange_1_upper.setRotZ(0);
                }
            }

            if (orange_2 != null && henshin_tick < 8) {
                orange_2.setRotZ(Mth.clamp(orange_2.getRotZ() - 10f * Mth.DEG_TO_RAD, -140 * Mth.DEG_TO_RAD, 0));
                if (orange_2_upper != null && henshin_tick < 4) {
                    orange_2_upper.setRotZ(Mth.clamp(orange_2_upper.getRotZ() + 20f * Mth.DEG_TO_RAD, 0, 150 * Mth.DEG_TO_RAD));
                }
            } else if (orange_2 != null && henshin_tick >= 8) {
                orange_2.setRotZ(0);
                if (orange_2_upper != null) {
                    orange_2_upper.setRotZ(0);
                }
            }

            if (orange_3 != null && henshin_tick < 8) {
                orange_3.setRotX(Mth.clamp(orange_3.getRotX() + 10f * Mth.DEG_TO_RAD, 0, 180 * Mth.DEG_TO_RAD));
                if (orange_3_upper != null && henshin_tick < 6) {
                    orange_3_upper.setRotX(Mth.clamp(orange_3_upper.getRotX() - 40f * Mth.DEG_TO_RAD, -145 * Mth.DEG_TO_RAD, 0));
                }
            } else if (orange_3 != null && henshin_tick >= 8) {
                orange_3.setRotX(0);
                if (orange_3_upper != null) {
                    orange_3_upper.setRotX(0);
                }
            }

            if (orange_4 != null && henshin_tick < 8) {
                orange_4.setRotX(Mth.clamp(orange_4.getRotX() - 10f * Mth.DEG_TO_RAD, -155 * Mth.DEG_TO_RAD, 0));
                if (orange_4_upper != null && henshin_tick < 6) {
                    orange_4_upper.setRotX(Mth.clamp(orange_4_upper.getRotX() + 20f * Mth.DEG_TO_RAD, 0, 125 * Mth.DEG_TO_RAD));
                }
            } else if (orange_4 != null && henshin_tick >= 8) {
                orange_4.setRotX(0);
                if (orange_4_upper != null) {
                    orange_4_upper.setRotX(0);
                }
            }
            return;
        }

        if (Model.contains("pine")) {
            System.err.println("is pine");
            GeoBone pine_1 = model.getBone("pine_1").orElse(null);
            GeoBone pine_1_upper = model.getBone("pine_1_upper").orElse(null);
            GeoBone pine_2 = model.getBone("pine_2").orElse(null);
            GeoBone pine_2_upper = model.getBone("pine_2_upper").orElse(null);
            GeoBone orange_3 = model.getBone("orange_3").orElse(null);
            GeoBone orange_3_upper = model.getBone("orange_3_upper").orElse(null);
            GeoBone orange_4 = model.getBone("orange_4").orElse(null);
            GeoBone orange_4_upper = model.getBone("orange_4_upper").orElse(null);

            if (pine_1 != null && henshin_tick < 8) {
                pine_1.setRotZ(Mth.clamp(pine_1.getRotZ() + 10f * Mth.DEG_TO_RAD, 0, 90 * Mth.DEG_TO_RAD));
                if (pine_1_upper != null && henshin_tick < 4) {
                    pine_1_upper.setRotZ(Mth.clamp(pine_1_upper.getRotZ() - 20f * Mth.DEG_TO_RAD, -90 * Mth.DEG_TO_RAD, 0));
                }
            } else if (pine_1 != null && henshin_tick >= 8) {
                pine_1.setRotZ(0);
                if (pine_1_upper != null) {
                    pine_1_upper.setRotZ(0);
                }
            }

            if (pine_2 != null && henshin_tick < 8) {
                pine_2.setRotZ(Mth.clamp(pine_2.getRotZ() - 10f * Mth.DEG_TO_RAD, -90 * Mth.DEG_TO_RAD, 0));
                if (pine_2_upper != null && henshin_tick < 4) {
                    pine_2_upper.setRotZ(Mth.clamp(pine_2_upper.getRotZ() + 20f * Mth.DEG_TO_RAD, 0, 90 * Mth.DEG_TO_RAD));
                }
            } else if (pine_2 != null && henshin_tick >= 8) {
                pine_2.setRotZ(0);
                if (pine_2_upper != null) {
                    pine_2_upper.setRotZ(0);
                }
            }

            if (orange_3 != null && henshin_tick < 8) {
                orange_3.setRotX(Mth.clamp(orange_3.getRotX() + 10f * Mth.DEG_TO_RAD, 0, 180 * Mth.DEG_TO_RAD));
                if (orange_3_upper != null && henshin_tick < 6) {
                    orange_3_upper.setRotX(Mth.clamp(orange_3_upper.getRotX() - 40f * Mth.DEG_TO_RAD, -145 * Mth.DEG_TO_RAD, 0));
                }
            } else if (orange_3 != null && henshin_tick >= 8) {
                orange_3.setRotX(0);
                if (orange_3_upper != null) {
                    orange_3_upper.setRotX(0);
                }
            }

            if (orange_4 != null && henshin_tick < 8) {
                orange_4.setRotX(Mth.clamp(orange_4.getRotX() - 10f * Mth.DEG_TO_RAD, -155 * Mth.DEG_TO_RAD, 0));
                if (orange_4_upper != null && henshin_tick < 6) {
                    orange_4_upper.setRotX(Mth.clamp(orange_4_upper.getRotX() + 20f * Mth.DEG_TO_RAD, 0, 125 * Mth.DEG_TO_RAD));
                }
            } else if (orange_4 != null && henshin_tick >= 8) {
                orange_4.setRotX(0);
                if (orange_4_upper != null) {
                    orange_4_upper.setRotX(0);
                }
            }
            return;
        }

        if (Model.contains("kachidoki")) {
            GeoBone kachidoki_legs_1 = model.getBone("kachidoki_legs_1").orElse(null);
            GeoBone kachidoki_legs_2 = model.getBone("kachidoki_legs_2").orElse(null);
            GeoBone kachidoki_arms_1 = model.getBone("kachidoki_arms_1").orElse(null);
            GeoBone kachidoki_arms_2 = model.getBone("kachidoki_arms_2").orElse(null);
            GeoBone kachidoki_back_1 = model.getBone("kachidoki_back_1").orElse(null);
            GeoBone kachidoki_back_2 = model.getBone("kachidoki_back_2").orElse(null);
            GeoBone kachidoki_back_3 = model.getBone("kachidoki_back_3").orElse(null);
            GeoBone kachidoki_chest = model.getBone("kachidoki_chest").orElse(null);

            if (kachidoki_back_1 != null && kachidoki_back_2 != null && henshin_tick < 20) {
                kachidoki_back_2.setRotX(Mth.clamp(kachidoki_back_2.getRotX() + 5f * Mth.DEG_TO_RAD, 0, 240 * Mth.DEG_TO_RAD));
                if (kachidoki_back_3 != null && henshin_tick < 18) {
                    kachidoki_back_3.setRotX(Mth.clamp(kachidoki_back_3.getRotX() + 5f * Mth.DEG_TO_RAD, 0, 240 * Mth.DEG_TO_RAD));
                }
            } else if (kachidoki_back_1 != null && kachidoki_back_2 != null && henshin_tick >= 20) {
                kachidoki_back_2.setRotX(0);
                if (kachidoki_back_3 != null) {
                    kachidoki_back_3.setRotX(0);
                }
            }

            if (kachidoki_arms_1 != null && kachidoki_arms_2 != null && henshin_tick < 15) {
                kachidoki_arms_1.setRotX(Mth.clamp(kachidoki_arms_1.getRotX() - 10f * Mth.DEG_TO_RAD, -90 * Mth.DEG_TO_RAD, 0));
                kachidoki_arms_2.setRotX(Mth.clamp(kachidoki_arms_2.getRotX() - 10f * Mth.DEG_TO_RAD, -90 * Mth.DEG_TO_RAD, 0));
                kachidoki_arms_1.setPosX(Mth.clamp(kachidoki_arms_1.getPosX() - 0.3f, -5, 0));
                kachidoki_arms_2.setPosX(Mth.clamp(kachidoki_arms_2.getPosX() + 0.3f, 0, 5));
                kachidoki_arms_1.setPosY(Mth.clamp(kachidoki_arms_1.getPosY() - 0.3f, -6f, 0));
                kachidoki_arms_2.setPosY(Mth.clamp(kachidoki_arms_2.getPosY() - 0.3f, -6f, 0));
            } else if (kachidoki_arms_1 != null && kachidoki_arms_2 != null && henshin_tick >= 15) {
                kachidoki_arms_1.setRotX(0);
                kachidoki_arms_2.setRotX(0);
                kachidoki_arms_1.setPosX(0);
                kachidoki_arms_2.setPosX(0);
                kachidoki_arms_1.setPosY(0);
                kachidoki_arms_2.setPosY(0);
                for (GeoBone boneReset : model.topLevelBones()) {
                    boneReset.resetStateChanges();
                }
            }

            if (kachidoki_legs_1 != null && kachidoki_legs_2 != null && henshin_tick < 20) {
                kachidoki_legs_1.setRotX(Mth.clamp(kachidoki_legs_1.getRotX() + 10f * Mth.DEG_TO_RAD, 0, 90 * Mth.DEG_TO_RAD));
                kachidoki_legs_2.setRotX(Mth.clamp(kachidoki_legs_2.getRotX() + 10f * Mth.DEG_TO_RAD, 0, 90 * Mth.DEG_TO_RAD));
            } else if (kachidoki_legs_1 != null && kachidoki_legs_2 != null && henshin_tick >= 20) {
                kachidoki_legs_1.setRotX(0);
                kachidoki_legs_2.setRotX(0);
            }

            if (kachidoki_chest != null && henshin_tick < 20) {
                kachidoki_chest.setPosY(Mth.clamp(kachidoki_chest.getPosY() - 0.3f, -6f, 0));
                kachidoki_chest.setPosZ(Mth.clamp(kachidoki_chest.getPosZ() - 0.3f, -1f, 0));
            } else if (kachidoki_chest != null && henshin_tick >= 20) {
                kachidoki_chest.setPosY(0);
                kachidoki_chest.setPosZ(0);
            }
            return;
        }
    }


    public float getScaleX() {
        return 1f;
    }

    public float getScaleY() {
        return 1f;
    }

    public float getScaleZ() {
        return 1f;
    }

    public float getX() {
        return 0f;
    }

    public float getY() {
        return 0f;
    }

    public float getZ() {
        return 0f;
    }


}