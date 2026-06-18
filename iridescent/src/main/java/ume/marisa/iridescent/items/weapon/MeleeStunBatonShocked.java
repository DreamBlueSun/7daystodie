package ume.marisa.iridescent.items.weapon;

import iridescent.Constants;
import ume.marisa.iridescent.utils.WriteToFile;

/**
 * 电击棒
 */

public class MeleeStunBatonShocked {

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
                    .replace("MarisaWeaponFlag_dMarisaBleedEffectAmount", D_MARISA_EFFECT_AMOUNT);
            s.append(replace).append("\n");
        }
        WriteToFile.output(s.append(STOP).toString());
        System.out.println(entityDamage);
        System.out.println(blockDamage);
    }

    // 伤害
    public static final int RANK_ENTITY_DAMAGE_S0 = 50;
    public static final int[] RANK_ENTITY_DAMAGE_ARR = new int[]{10, 10, 10, 10, 20, 20, 20, 20, 30, 30, 30, 30, 0};
    public static final String RANK_ENTITY_DAMAGE_TIER = "0,10";
    public static final int RANK_BLOCK_DAMAGE_S0 = 50;
    public static final int[] RANK_BLOCK_DAMAGE_ARR = new int[]{10, 10, 10, 10, 20, 20, 20, 20, 30, 30, 30, 30, 0};
    public static final String RANK_BLOCK_DAMAGE_TIER = "0,10";
    public static final String D_MARISA_EFFECT_AMOUNT = "20";
    public static final String D_MARISA_EFFECT_AMOUNT_1 = "24";
    public static final String D_MARISA_EFFECT_AMOUNT_2 = "28";
    public static final String D_MARISA_EFFECT_AMOUNT_3 = "32";
    public static final String D_MARISA_EFFECT_AMOUNT_4 = "36";
    public static final String D_MARISA_EFFECT_AMOUNT_5 = "40";

    // 体力消耗
    public static final int[] RANK_STAMINA_LOSS_PRIMARY = new int[]{5, 10, 15};
    public static final int[] RANK_STAMINA_LOSS_SECONDARY = new int[]{10, 20, 30};

    // 狂化Tag
    public static final String T1_TAG = "\n\t        <property name=\"Tags\" value=\"melee,grunting,light,perkFlurryOfIntellect,weapon,meleeWeapon,attIntellect,perkElectrocutioner,canHaveCosmetic,roboticsSkill,stunBaton,meleeIntellect,batonJunkie\"/>";
    public static final String T3_TAG = "\n\t        <property name=\"Tags\" value=\"melee,grunting,light,perkFlurryOfIntellect,weapon,meleeWeapon,attIntellect,perkElectrocutioner,canHaveCosmetic,roboticsSkill,stunBaton,meleeIntellect,batonJunkie,PerkT3Marisa\"/>";

    // item
    public static final String MELEE_IRON_AXE_BLEED = "        <item name=\"MeleeStunBatonShockedSMarisaWeaponFlag_RANK\">\n" +
            "            <property name=\"UnlockedBy\" value=\"craftingEquipment\"/>\n" +
            "            <property name=\"TraderStageTemplate\" value=\"baseTier2\"/>\n" +
            "            <property name=\"Extends\" value=\"meleeWpnBatonT2StunBaton\"/>MarisaWeaponFlag_T3_TAG\n" +
            "            <property name=\"DisplayType\" value=\"ui_weapon_melee_marisa_shocked\"/>\n" +
            "            <property name=\"SellableToTrader\" value=\"false\"/>\n" +
            "            <property name=\"CustomIcon\" value=\"meleeWpnBatonT2StunBaton\"/>\n" +
            "            <property name=\"CustomIconTint\" value=\"MarisaWeaponFlag_CustomIconTint\"/>\n" +
            "            <property name=\"EconomicValue\" value=\"MarisaWeaponFlag_EconomicValue\"/>\n" +
            "            <property name=\"Material\" value=\"MarisaWeaponFlag_Material\"/>\n" +
            "            <property name=\"Weight\" value=\"MarisaWeaponFlag_Weight\"/>\n" +
            "\n" +
            "            <effect_group name=\"MeleeStunBatonShockedSMarisaWeaponFlag_RANK\">\n" +
            "                <passive_effect name=\"AttacksPerMinute\" operation=\"base_set\" value=\"80\" tags=\"perkElectrocutioner,perkFlurryOfIntellect\"/>\n" +
            "                <passive_effect name=\"StaminaLoss\" operation=\"base_set\" value=\"MarisaWeaponFlag_StaminaLossPrimary\" tags=\"primary\"/>\n" +
            "                <passive_effect name=\"DegradationMax\" operation=\"base_set\" value=\"200,300\" tier=\"1,6\" tags=\"perkElectrocutioner\"/>\n" +
            "                <passive_effect name=\"DegradationPerUse\" operation=\"base_set\" value=\"1\" tags=\"perkElectrocutioner\"/>\n" +
            "                <passive_effect name=\"MaxRange\" operation=\"base_set\" value=\"2.4\" tags=\"perkElectrocutioner\"/>\n" +
            "                <passive_effect name=\"BlockRange\" operation=\"base_set\" value=\"3\" tags=\"perkElectrocutioner\"/>\n" +
            "                <passive_effect name=\"ModSlots\" operation=\"base_set\" value=\"MarisaWeaponFlag_ModSlots\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_set\" value=\"MarisaWeaponFlag_EntityDamage\" tags=\"perkElectrocutioner\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_EntityDamageTier\" tier=\"1,6\" tags=\"perkElectrocutioner\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"base_set\" value=\"MarisaWeaponFlag_BlockDamage\" tags=\"perkElectrocutioner\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_BlockDamageTier\" tier=\"1,6\" tags=\"perkElectrocutioner\"/>\n" +
            "                <passive_effect name=\"DamageModifier\" operation=\"perc_add\" value=\"-.9\" tags=\"earth\"/>\n" +
            "                <passive_effect name=\"DamageModifier\" operation=\"perc_add\" value=\"-.9\" tags=\"stone\"/>\n" +
            "                <passive_effect name=\"DamageModifier\" operation=\"perc_add\" value=\"-.9\" tags=\"metal\"/>\n" +
            "                <passive_effect name=\"HarvestCount\" operation=\"base_set\" value=\"1\" tags=\"butcherHarvest\"/>\n" +
            "                <passive_effect name=\"HarvestCount\" operation=\"base_add\" value=\"-.75\" tags=\"allHarvest\"/>\n" +
            "                <passive_effect name=\"HarvestCount\" operation=\"base_add\" value=\"-.75\" tags=\"allToolsHarvest\"/>\n" +
            "                <passive_effect name=\"HarvestCount\" operation=\"base_add\" value=\"-.75\" tags=\"oreWoodHarvest\"/>\n" +
            "\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"Power Attack\">\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"perc_add\" value=\"1\" tags=\"secondary\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"perc_add\" value=\"1\" tags=\"secondary\"/>\n" +
            "                <passive_effect name=\"StaminaLoss\" operation=\"base_set\" value=\"MarisaWeaponFlag_StaminaLossSecondary\" tags=\"secondary\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"subtract entitydamage\" tiered=\"false\">\n" +
            "                <display_value name=\"dMarisaShockedEffectAmount\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect buff\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"other\" target_tags=\"animal,zombie\" buff=\"buffShockedEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"other\" target_tags=\"animal,zombie\" buff=\"buffShockedEffect\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect buff aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" buff=\"buffShockedEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" buff=\"buffShockedEffect\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect buff aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" buff=\"buffShockedEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" buff=\"buffShockedEffect\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect buff aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" buff=\"buffShockedEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" buff=\"buffShockedEffect\"/>\n" +
            "            </effect_group>\n" +
            "        </item>";


}
