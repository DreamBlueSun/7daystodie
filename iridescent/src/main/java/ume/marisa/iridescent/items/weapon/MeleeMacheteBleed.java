package ume.marisa.iridescent.items.weapon;

import iridescent.Constants;
import ume.marisa.iridescent.utils.WriteToFile;

/**
 * 流血砍刀
 */

public class MeleeMacheteBleed {

    // 开始
    public static final String START = "    <append xpath=\"/items\">\n" + "\n";
    // 结束
    public static final String STOP = "\n" + "    </append>";

    public static void main(String[] args) {
        int de = RANK_ENTITY_DAMAGE_S0;
        int db = RANK_BLOCK_DAMAGE_S0;
        StringBuilder s = new StringBuilder(START);
        StringBuilder entityDamage = new StringBuilder("EntityDamage");
        StringBuilder blockDamage = new StringBuilder("BlockDamage");
        for (int i = 1; i <= 13; i++) {
            de += RANK_ENTITY_DAMAGE_ARR[i - 1];
            db += RANK_BLOCK_DAMAGE_ARR[i - 1];
            entityDamage.append(",").append(de);
            blockDamage.append(",").append(db);
            String replace = MELEE_IRON_AXE_BLEED.replace("MarisaWeaponFlag_RANK", String.valueOf(i))
                    .replace("MarisaWeaponFlag_T3_TAG", i >= 9 ? T3_TAG : T1_TAG)
                    .replace("MarisaWeaponFlag_CustomIconTint", Constants.RANK_COLOR_LIST.get(i - 1))
                    .replace("MarisaWeaponFlag_EconomicValue", Constants.RANK_ECONOMIC_LIST.get(i - 1))
                    .replace("MarisaWeaponFlag_Material", Constants.RANK_MATERIAL_LIST.get(i - 1))
                    .replace("MarisaWeaponFlag_Weight", Constants.RANK_WEIGHT_LIST.get(i - 1))
                    .replace("MarisaWeaponFlag_ModSlots", Constants.RANK_MOD_SLOTS_LIST.get(i - 1))
                    .replace("MarisaWeaponFlag_EntityDamageTier", RANK_ENTITY_DAMAGE_TIER)
                    .replace("MarisaWeaponFlag_EntityDamage", String.valueOf(de))
                    .replace("MarisaWeaponFlag_BlockDamageTier", RANK_BLOCK_DAMAGE_TIER)
                    .replace("MarisaWeaponFlag_BlockDamage", String.valueOf(db))
                    .replace("MarisaWeaponFlag_StaminaLossPrimary", String.valueOf(RANK_STAMINA_LOSS_PRIMARY[Math.min((i - 1) / 4, 2)]))
                    .replace("MarisaWeaponFlag_StaminaLossSecondary", String.valueOf(RANK_STAMINA_LOSS_SECONDARY[Math.min((i - 1) / 4, 2)]))
                    .replace("MarisaWeaponFlag_dMarisaBleedEffectAmount_1", D_MARISA_EFFECT_AMOUNT_1)
                    .replace("MarisaWeaponFlag_dMarisaBleedEffectAmount_2", D_MARISA_EFFECT_AMOUNT_2)
                    .replace("MarisaWeaponFlag_dMarisaBleedEffectAmount_3", D_MARISA_EFFECT_AMOUNT_3)
                    .replace("MarisaWeaponFlag_dMarisaBleedEffectAmount_4", D_MARISA_EFFECT_AMOUNT_4)
                    .replace("MarisaWeaponFlag_dMarisaBleedEffectAmount_5", D_MARISA_EFFECT_AMOUNT_5)
                    .replace("MarisaWeaponFlag_dMarisaBleedEffectAmount", D_MARISA_EFFECT_AMOUNT)
                    .replace("MarisaWeaponFlag_StarDegradation", i == 13 ? STAR_DEGRADATION_B : STAR_DEGRADATION_A)
                    .replace("MarisaWeaponFlag_StarStats", i == 13 ? STAR_STATS : "");
            s.append(replace).append("\n");
        }
        WriteToFile.output(s.append(STOP).toString());
        System.out.println(entityDamage);
        System.out.println(blockDamage);
    }

    // 伤害
    public static final int RANK_ENTITY_DAMAGE_S0 = 50;
    public static final int[] RANK_ENTITY_DAMAGE_ARR = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
    public static final String RANK_ENTITY_DAMAGE_TIER = "0,10";
    public static final int RANK_BLOCK_DAMAGE_S0 = 50;
    public static final int[] RANK_BLOCK_DAMAGE_ARR = new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0};
    public static final String RANK_BLOCK_DAMAGE_TIER = "0,10";
    public static final String D_MARISA_EFFECT_AMOUNT = "20";
    public static final String D_MARISA_EFFECT_AMOUNT_1 = "24";
    public static final String D_MARISA_EFFECT_AMOUNT_2 = "28";
    public static final String D_MARISA_EFFECT_AMOUNT_3 = "32";
    public static final String D_MARISA_EFFECT_AMOUNT_4 = "36";
    public static final String D_MARISA_EFFECT_AMOUNT_5 = "40";

    // 体力消耗
    public static final int[] RANK_STAMINA_LOSS_PRIMARY = new int[]{10, 20, 30};
    public static final int[] RANK_STAMINA_LOSS_SECONDARY = new int[]{20, 40, 60};

    // 武器合成 星星
    public static final String STAR_DEGRADATION_A = "<passive_effect name=\"DegradationMax\" operation=\"base_set\" value=\"200,300\" tier=\"1,6\" tags=\"perkDeepCuts\"/>";
    public static final String STAR_DEGRADATION_B = "<passive_effect name=\"DegradationMax\" operation=\"base_set\" value=\"1,220,240,260,280,300\" tier=\"1,2,3,4,5,6\" tags=\"perkDeepCuts\"/>";
    public static final String STAR_STATS = "\n\n" +
            "            <stats>\n" +
            "                <!-- Base_Random_Roll -->\n" +
            "                <stat name=\"EntityDamage\" value=\"0,0,1,0,0\"/>\n" +
            "                <stat name=\"BlockDamage\" value=\"0,0,1,0,0\"/>\n" +
            "                <stat name=\"AttacksPerMinute\" value=\"0,0,1,0,0\"/>\n" +
            "                <stat name=\"StaminaLoss\" value=\"0,0,1,0,0\"/>\n" +
            "                <!-- Q1_Boosted_Rolls -->\n" +
            "                <stat name=\"EntityDamage\" value=\"1,0,1,.01,.1\"/>\n" +
            "                <stat name=\"BlockDamage\" value=\"1,0,1,.01,.1\"/>\n" +
            "                <stat name=\"AttacksPerMinute\" value=\"1,0,1,.01,.2\"/>\n" +
            "                <stat name=\"StaminaLoss\" value=\"1,0,1,.01,.2\"/>\n" +
            "            </stats>";

    // 狂化Tag
    public static final String T1_TAG = "\n\t        <property name=\"Tags\" value=\"machete,melee,grunting,light,longShaft,perkFlurryOfAgility,weapon,meleeWeapon,attAgility,perkDeepCuts,perkTheHuntsman,canHaveCosmetic,bladeSkill,corpseRemoval\"/>";
    public static final String T3_TAG = "\n\t        <property name=\"Tags\" value=\"machete,melee,grunting,light,longShaft,perkFlurryOfAgility,weapon,meleeWeapon,attAgility,perkDeepCuts,perkTheHuntsman,canHaveCosmetic,bladeSkill,corpseRemoval,PerkT3Marisa\"/>";

    // item
    public static final String MELEE_IRON_AXE_BLEED = "        <item name=\"MeleeMacheteBleedSMarisaWeaponFlag_RANK\">\n" +
            "            <property name=\"UnlockedBy\" value=\"craftingEquipment\"/>\n" +
            "            <property name=\"TraderStageTemplate\" value=\"baseTier2\"/>\n" +
            "            <property name=\"Extends\" value=\"meleeWpnBladeT3Machete\"/>MarisaWeaponFlag_T3_TAG\n" +
            "            <property name=\"DisplayType\" value=\"ui_weapon_melee_marisa_bleed\"/>\n" +
            "            <property name=\"SellableToTrader\" value=\"false\"/>\n" +
            "            <property name=\"CustomIcon\" value=\"meleeWpnBladeT3Machete\"/>\n" +
            "            <property name=\"CustomIconTint\" value=\"MarisaWeaponFlag_CustomIconTint\"/>\n" +
            "            <property name=\"EconomicValue\" value=\"MarisaWeaponFlag_EconomicValue\"/>\n" +
            "            <property name=\"Material\" value=\"MarisaWeaponFlag_Material\"/>\n" +
            "            <property name=\"Weight\" value=\"MarisaWeaponFlag_Weight\"/>MarisaWeaponFlag_StarStats\n" +
            "\n" +
            "            <effect_group name=\"MeleeMacheteBleedSMarisaWeaponFlag_RANK\">\n" +
            "                <passive_effect name=\"AttacksPerMinute\" operation=\"base_set\" value=\"80\" tags=\"perkDeepCuts,perkFlurryOfAgility\"/>\n" +
            "                <passive_effect name=\"StaminaLoss\" operation=\"base_set\" value=\"MarisaWeaponFlag_StaminaLossPrimary\" tags=\"primary\"/>\n" +
            "                MarisaWeaponFlag_StarDegradation\n" +
            "                <passive_effect name=\"DegradationPerUse\" operation=\"base_set\" value=\"1\" tags=\"perkDeepCuts\"/>\n" +
            "                <passive_effect name=\"MaxRange\" operation=\"base_set\" value=\"2.3\" tags=\"perkDeepCuts\"/>\n" +
            "                <passive_effect name=\"BlockRange\" operation=\"base_set\" value=\"3.5\" tags=\"perkDeepCuts\"/>\n" +
            "                <passive_effect name=\"ModSlots\" operation=\"base_set\" value=\"MarisaWeaponFlag_ModSlots\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_set\" value=\"MarisaWeaponFlag_EntityDamage\" tags=\"perkDeepCuts\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_EntityDamageTier\" tier=\"1,6\" tags=\"perkDeepCuts\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"base_set\" value=\"MarisaWeaponFlag_BlockDamage\" tags=\"perkDeepCuts\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_BlockDamageTier\" tier=\"1,6\" tags=\"perkDeepCuts\"/>\n" +
            "                <passive_effect name=\"DamageModifier\" operation=\"perc_add\" value=\"-.8\" tags=\"earth\"/>\n" +
            "                <passive_effect name=\"DamageModifier\" operation=\"perc_add\" value=\"-.8\" tags=\"stone\"/>\n" +
            "                <passive_effect name=\"DamageModifier\" operation=\"perc_add\" value=\"-.8\" tags=\"metal\"/>\n" +
            "                <passive_effect name=\"HarvestCount\" operation=\"base_set\" value=\"1\" tags=\"butcherHarvest\"/>\n" +
            "                <passive_effect name=\"DismemberChance\" operation=\"base_add\" value=\"1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"Power Attack\">\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"perc_add\" value=\"1\" tags=\"secondary\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"perc_add\" value=\"1\" tags=\"secondary\"/>\n" +
            "                <passive_effect name=\"StaminaLoss\" operation=\"base_set\" value=\"MarisaWeaponFlag_StaminaLossSecondary\" tags=\"secondary\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"subtract entitydamage\" tiered=\"false\">\n" +
            "                <display_value name=\"dMarisaBleedEffectAmount\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaBleedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect buff\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"other\" target_tags=\"animal,zombie\" buff=\"buffMarisaBuffBleedEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"other\" target_tags=\"animal,zombie\" buff=\"buffMarisaBuffBleedEffect\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect buff aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" buff=\"buffMarisaBuffBleedEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" buff=\"buffMarisaBuffBleedEffect\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect buff aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" buff=\"buffMarisaBuffBleedEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" buff=\"buffMarisaBuffBleedEffect\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect buff aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" buff=\"buffMarisaBuffBleedEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" buff=\"buffMarisaBuffBleedEffect\"/>\n" +
            "            </effect_group>\n" +
            "        </item>";


}
