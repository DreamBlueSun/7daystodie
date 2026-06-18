package ume.marisa.iridescent.items.weapon;

import iridescent.Constants;
import ume.marisa.iridescent.utils.WriteToFile;

/**
 * 辐射大锤
 */

public class MeleeSledgehammerIronRadiationPool {

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
                    .replace("MarisaWeaponFlag_T3_TAG", i >= 9 ? T3_TAG_2 : T1_TAG)
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
                    .replace("MarisaWeaponFlag_Extends", i <= 8 ? RANK_MARISA_CUSTOMICON_1 : RANK_MARISA_CUSTOMICON_2)
                    .replace("MarisaWeaponFlag_CustomIcon", i <= 8 ? RANK_MARISA_CUSTOMICON_1 : RANK_MARISA_CUSTOMICON_2);
            s.append(replace).append("\n");
        }
        WriteToFile.output(s.append(STOP).toString());
        System.out.println(entityDamage);
        System.out.println(blockDamage);
    }

    // 伤害
    public static final int RANK_ENTITY_DAMAGE_S0 = 100;
    public static final int[] RANK_ENTITY_DAMAGE_ARR = new int[]{15, 15, 15, 15, 25, 25, 25, 25, 35, 35, 35, 35, 0};
    public static final String RANK_ENTITY_DAMAGE_TIER = "0,10";
    public static final int RANK_BLOCK_DAMAGE_S0 = 100;
    public static final int[] RANK_BLOCK_DAMAGE_ARR = new int[]{15, 15, 15, 15, 25, 25, 25, 25, 35, 35, 35, 35, 0};
    public static final String RANK_BLOCK_DAMAGE_TIER = "0,10";
    public static final String D_MARISA_EFFECT_AMOUNT = "50";
    public static final String D_MARISA_EFFECT_AMOUNT_1 = "60";
    public static final String D_MARISA_EFFECT_AMOUNT_2 = "70";
    public static final String D_MARISA_EFFECT_AMOUNT_3 = "80";
    public static final String D_MARISA_EFFECT_AMOUNT_4 = "90";
    public static final String D_MARISA_EFFECT_AMOUNT_5 = "100";

    // 体力消耗
    public static final int[] RANK_STAMINA_LOSS_PRIMARY = new int[]{25, 50, 75};
    public static final int[] RANK_STAMINA_LOSS_SECONDARY = new int[]{50, 100, 150};

    // 模型
    public static final String RANK_MARISA_CUSTOMICON_1 = "meleeWpnSledgeT1IronSledgehammer";
    public static final String RANK_MARISA_CUSTOMICON_2 = "meleeWpnSledgeT3SteelSledgehammer";

    // 狂化Tag
    public static final String T1_TAG = "\n\t        <property name=\"Tags\" value=\"blunt,melee,grunting,heavy,sledge,weapon,meleeWeapon,longShaft,attStrength,perkSkullCrusher,perkFlurryOfStrength,canHaveCosmetic,sledgeSkill,scrap100\"/>";
    public static final String T3_TAG = "\n\t        <property name=\"Tags\" value=\"blunt,melee,grunting,heavy,sledge,weapon,meleeWeapon,longShaft,attStrength,perkSkullCrusher,perkFlurryOfStrength,canHaveCosmetic,sledgeSkill,scrap100,PerkT3Marisa\"/>";
    public static final String T3_TAG_2 = "\n\t        <property name=\"Tags\" value=\"blunt,melee,grunting,heavy,sledge,weapon,meleeWeapon,longShaft,attStrength,perkSkullCrusher,perkFlurryOfStrength,canHaveCosmetic,sledgeSkill,PerkT3Marisa\"/>";

    // item
    public static final String MELEE_IRON_AXE_BLEED = "        <item name=\"MeleeSledgehammerIronRadiationPoolSMarisaWeaponFlag_RANK\">\n" +
            "            <property name=\"UnlockedBy\" value=\"craftingEquipment\"/>\n" +
            "            <property name=\"TraderStageTemplate\" value=\"baseTier2\"/>\n" +
            "            <property name=\"Extends\" value=\"MarisaWeaponFlag_Extends\"/>MarisaWeaponFlag_T3_TAG\n" +
            "            <property name=\"DisplayType\" value=\"ui_weapon_melee_marisa_radiation\"/>\n" +
            "            <property name=\"SellableToTrader\" value=\"false\"/>\n" +
            "            <property name=\"CustomIcon\" value=\"MarisaWeaponFlag_CustomIcon\"/>\n" +
            "            <property name=\"CustomIconTint\" value=\"MarisaWeaponFlag_CustomIconTint\"/>\n" +
            "            <property name=\"EconomicValue\" value=\"MarisaWeaponFlag_EconomicValue\"/>\n" +
            "            <property name=\"Material\" value=\"MarisaWeaponFlag_Material\"/>\n" +
            "            <property name=\"Weight\" value=\"MarisaWeaponFlag_Weight\"/>\n" +
            "\n" +
            "            <effect_group name=\"MeleeSledgehammerIronRadiationPoolSMarisaWeaponFlag_RANK\">\n" +
            "                <passive_effect name=\"AttacksPerMinute\" operation=\"base_set\" value=\"40\" tags=\"perkSkullCrusher,perkFlurryOfStrength\"/>\n" +
            "                <passive_effect name=\"StaminaLoss\" operation=\"base_set\" value=\"MarisaWeaponFlag_StaminaLossPrimary\" tags=\"primary\"/>\n" +
            "                <passive_effect name=\"DegradationMax\" operation=\"base_set\" value=\"150,225\" tier=\"1,6\" tags=\"perkSkullCrusher\"/>\n" +
            "                <passive_effect name=\"DegradationPerUse\" operation=\"base_set\" value=\"1\" tags=\"perkSkullCrusher\"/>\n" +
            "                <passive_effect name=\"MaxRange\" operation=\"base_set\" value=\"2.7\" tags=\"perkSkullCrusher\"/>\n" +
            "                <passive_effect name=\"BlockRange\" operation=\"base_set\" value=\"3.5\" tags=\"perkSkullCrusher\"/>\n" +
            "                <passive_effect name=\"ModSlots\" operation=\"base_set\" value=\"MarisaWeaponFlag_ModSlots\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_set\" value=\"MarisaWeaponFlag_EntityDamage\" tags=\"perkSkullCrusher\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_EntityDamageTier\" tier=\"1,6\" tags=\"perkSkullCrusher\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"base_set\" value=\"MarisaWeaponFlag_BlockDamage\" tags=\"perkSkullCrusher\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_BlockDamageTier\" tier=\"1,6\" tags=\"perkSkullCrusher\"/>\n" +
            "                <passive_effect name=\"HarvestCount\" operation=\"base_add\" value=\"-.75\" tags=\"allHarvest\"/>\n" +
            "                <passive_effect name=\"HarvestCount\" operation=\"base_add\" value=\"-.75\" tags=\"allToolsHarvest\"/>\n" +
            "                <passive_effect name=\"HarvestCount\" operation=\"base_add\" value=\"-.75\" tags=\"oreWoodHarvest\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"Power Attack\">\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"perc_add\" value=\"1\" tags=\"secondary\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"perc_add\" value=\"1\" tags=\"secondary\"/>\n" +
            "                <passive_effect name=\"StaminaLoss\" operation=\"base_set\" value=\"MarisaWeaponFlag_StaminaLossSecondary\" tags=\"secondary\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"crippled morale\"><!-- SLEDGE_SAGA_VOLUME_03_CRIPPLED_MORALE -->\n" +
            "                <!-- initialize metadata for \"sledge2ndHit\" on sledges, don't change value if already exists -->\n" +
            "                <triggered_effect trigger=\"onSelfEquipStart\" action=\"SetItemMetaFloat\" change=\"0\" relative=\"true\" key=\"sledge2ndHit\"/>\n" +
            "\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"SetItemMetaFloat\" change=\"1\" relative=\"false\" key=\"sledge2ndHit\">\n" +
            "                    <requirement name=\"IsAlive\" target=\"other\"/>\n" +
            "                    <requirement name=\"!EntityTagCompare\" target=\"other\" tags=\"trader\"/>\n" +
            "                </triggered_effect>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"subtract entitydamage\" tiered=\"false\">\n" +
            "                <display_value name=\"dMarisaRadiationPoolEffectAmount\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaRadiationPoolEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaBleedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect buff\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"other\" target_tags=\"animal,zombie\" buff=\"buffRadiationPoolEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"other\" target_tags=\"animal,zombie\" buff=\"buffRadiationPoolEffect\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect buff aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" buff=\"buffRadiationPoolEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" buff=\"buffRadiationPoolEffect\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect buff aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" buff=\"buffRadiationPoolEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" buff=\"buffRadiationPoolEffect\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect buff aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaEffectAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" buff=\"buffRadiationPoolEffect\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"AddBuff\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" buff=\"buffRadiationPoolEffect\"/>\n" +
            "            </effect_group>\n" +
            "        </item>";


}
