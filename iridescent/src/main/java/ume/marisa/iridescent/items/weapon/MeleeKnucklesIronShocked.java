package ume.marisa.iridescent.items.weapon;

import iridescent.Constants;
import ume.marisa.iridescent.utils.WriteToFile;

/**
 * 电击拳套
 */

public class MeleeKnucklesIronShocked {

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
                    .replace("MarisaWeaponFlag_T3_TAG", i <= 8 ? T1_TAG : T3_TAG_2)
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
                    .replace("MarisaWeaponFlag_dMarisaShockedEffectAmount_1", D_MARISA_EFFECT_AMOUNT_1)
                    .replace("MarisaWeaponFlag_dMarisaShockedEffectAmount_2", D_MARISA_EFFECT_AMOUNT_2)
                    .replace("MarisaWeaponFlag_dMarisaShockedEffectAmount_3", D_MARISA_EFFECT_AMOUNT_3)
                    .replace("MarisaWeaponFlag_dMarisaShockedEffectAmount_4", D_MARISA_EFFECT_AMOUNT_4)
                    .replace("MarisaWeaponFlag_dMarisaShockedEffectAmount_5", D_MARISA_EFFECT_AMOUNT_5)
                    .replace("MarisaWeaponFlag_dMarisaShockedEffectAmount", D_MARISA_EFFECT_AMOUNT)
                    .replace("MarisaWeaponFlag_Extends", i <= 8 ? RANK_MARISA_CUSTOMICON_1 : RANK_MARISA_CUSTOMICON_2)
                    .replace("MarisaWeaponFlag_CustomIcon", i <= 8 ? RANK_MARISA_CUSTOMICON_1 : RANK_MARISA_CUSTOMICON_2)
                    .replace("MarisaWeaponFlag_Prefab", i <= 8 ? RANK_MARISA_PREFAB_1 : RANK_MARISA_PREFAB_2);
            s.append(replace).append("\n");
        }
        WriteToFile.output(s.append(STOP).toString());
        System.out.println(entityDamage);
        System.out.println(blockDamage);
    }

    // 伤害
    public static final int RANK_ENTITY_DAMAGE_S0 = 50;
    public static final int[] RANK_ENTITY_DAMAGE_ARR = new int[]{10, 10, 10, 10, 15, 15, 15, 15, 20, 20, 20, 20, 0};
    public static final String RANK_ENTITY_DAMAGE_TIER = "0,10";
    public static final int RANK_BLOCK_DAMAGE_S0 = 50;
    public static final int[] RANK_BLOCK_DAMAGE_ARR = new int[]{10, 10, 10, 10, 15, 15, 15, 15, 20, 20, 20, 20, 0};
    public static final String RANK_BLOCK_DAMAGE_TIER = "0,0";
    public static final String D_MARISA_EFFECT_AMOUNT = "20";
    public static final String D_MARISA_EFFECT_AMOUNT_1 = "24";
    public static final String D_MARISA_EFFECT_AMOUNT_2 = "28";
    public static final String D_MARISA_EFFECT_AMOUNT_3 = "32";
    public static final String D_MARISA_EFFECT_AMOUNT_4 = "36";
    public static final String D_MARISA_EFFECT_AMOUNT_5 = "40";

    // 体力消耗
    public static final int[] RANK_STAMINA_LOSS_PRIMARY = new int[]{5, 10, 15};

    // 模型
    public static final String RANK_MARISA_CUSTOMICON_1 = "meleeWpnKnucklesT1IronKnuckles";
    public static final String RANK_MARISA_CUSTOMICON_2 = "meleeWpnKnucklesT3SteelKnuckles";
    public static final String RANK_MARISA_PREFAB_1 = "<triggered_effect trigger=\"onSelfEquipStart\" action=\"AddPart\" part=\"LeftKnuckles\" prefab=\"@:Other/Items/Weapons/Melee/Knuckles/knucklesLeft_Prefab.prefab\" parentTransform=\"LeftWeapon\" localPos=\"0,0,0\" localRot=\"0,0,0\" colorTint=\"true\"/>\n" +
            "                <triggered_effect trigger=\"onSelfEquipStop\" action=\"RemovePart\" part=\"LeftKnuckles\"/>";
    public static final String RANK_MARISA_PREFAB_2 = "<triggered_effect trigger=\"onSelfEquipStart\" action=\"AddPart\" part=\"LeftKnuckles\" prefab=\"@:Other/Items/Weapons/Melee/Knuckles/knucklesSpikedLeft_Prefab.prefab\" parentTransform=\"LeftWeapon\" localPos=\"0,0,0\" localRot=\"0,0,0\" colorTint=\"true\"/>\n" +
            "                <triggered_effect trigger=\"onSelfEquipStop\" action=\"RemovePart\" part=\"LeftKnuckles\"/>";

    // 狂化Tag
    public static final String T1_TAG = "";
    public static final String T3_TAG = "\n\t        <property name=\"Tags\" value=\"blunt,melee,grunting,light,perkFlurryOfFortitude,weapon,attFortitude,perkBrawler,noBlades,canHaveCosmetic,knuckleSkill,PerkT3Marisa\"/>\"/>";
    public static final String T3_TAG_2 = "\n\t        <property name=\"Tags\" value=\"blunt,melee,grunting,light,perkFlurryOfFortitude,weapon,attFortitude,perkBrawler,canHaveCosmetic,knuckleSkill,corpseRemoval,PerkT3Marisa\"/>";

    // item
    public static final String MELEE_IRON_AXE_BLEED = "        <item name=\"MeleeKnucklesIronShockedSMarisaWeaponFlag_RANK\">\n" +
            "            <property name=\"UnlockedBy\" value=\"craftingEquipment\"/>\n" +
            "            <property name=\"TraderStageTemplate\" value=\"baseTier2\"/>\n" +
            "            <property name=\"Extends\" value=\"MarisaWeaponFlag_Extends\"/>MarisaWeaponFlag_T3_TAG\n" +
            "            <property name=\"DisplayType\" value=\"ui_weapon_melee_marisa_shocked\"/>\n" +
            "            <property name=\"SellableToTrader\" value=\"false\"/>\n" +
            "            <property name=\"CustomIcon\" value=\"MarisaWeaponFlag_CustomIcon\"/>\n" +
            "            <property name=\"CustomIconTint\" value=\"MarisaWeaponFlag_CustomIconTint\"/>\n" +
            "            <property name=\"EconomicValue\" value=\"MarisaWeaponFlag_EconomicValue\"/>\n" +
            "            <property name=\"Material\" value=\"MarisaWeaponFlag_Material\"/>\n" +
            "            <property name=\"Weight\" value=\"MarisaWeaponFlag_Weight\"/>\n" +
            "\n" +
            "            <effect_group name=\"MeleeKnucklesIronShockedSMarisaWeaponFlag_RANK\">\n" +
            "                <passive_effect name=\"AttacksPerMinute\" operation=\"base_set\" value=\"100\" tags=\"perkBrawler,perkFlurryOfFortitude\"/>\n" +
            "                <passive_effect name=\"StaminaLoss\" operation=\"base_set\" value=\"MarisaWeaponFlag_StaminaLossPrimary\" tags=\"primary,secondary\"/>\n" +
            "                <passive_effect name=\"DegradationMax\" operation=\"base_set\" value=\"300,450\" tier=\"1,6\" tags=\"perkBrawler\"/>\n" +
            "                <passive_effect name=\"DegradationPerUse\" operation=\"base_set\" value=\"1\" tags=\"perkBrawler\"/>\n" +
            "                <passive_effect name=\"MaxRange\" operation=\"base_set\" value=\"2.5\" tags=\"perkBrawler\"/>\n" +
            "                <passive_effect name=\"BlockRange\" operation=\"base_set\" value=\"3\" tags=\"perkBrawler\"/>\n" +
            "                <passive_effect name=\"ModSlots\" operation=\"base_set\" value=\"MarisaWeaponFlag_ModSlots\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_set\" value=\"MarisaWeaponFlag_EntityDamage\" tags=\"perkBrawler\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_EntityDamageTier\" tier=\"1,6\" tags=\"perkBrawler\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"base_set\" value=\"MarisaWeaponFlag_BlockDamage\" tags=\"perkBrawler\"/>\n" +
            "                <passive_effect name=\"BlockDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_BlockDamageTier\" tier=\"1,6\" tags=\"perkBrawler\"/>\n" +
            "                <passive_effect name=\"DamageModifier\" operation=\"perc_add\" value=\"-.5\" tags=\"earth\"/>\n" +
            "                <passive_effect name=\"DamageModifier\" operation=\"perc_add\" value=\"-.5\" tags=\"stone\"/>\n" +
            "                <passive_effect name=\"DamageModifier\" operation=\"perc_add\" value=\"-.5\" tags=\"metal\"/>\n" +
            "\n" +
            "                MarisaWeaponFlag_Prefab\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"subtract entitydamage\" tiered=\"false\">\n" +
            "                <display_value name=\"dMarisaShockedEffectAmount\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"0\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"other\" target_tags=\"animal,zombie\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe1\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"2\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe2\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"4\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_5\"/>\n" +
            "            </effect_group>\n" +
            "\n" +
            "            <effect_group name=\"add effect per0 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"0\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per1 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"1\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_1\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_1\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per2 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"2\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_2\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_2\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per3 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"3\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_3\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per4 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"4\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_4\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_4\"/>\n" +
            "            </effect_group>\n" +
            "            <effect_group name=\"add effect per5 aoe3\" tiered=\"false\">\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaShockedIntensify\" operation=\"Equals\" value=\"5\"/>\n" +
            "                <requirement name=\"ProgressionLevel\" progression_name=\"perkMarisaIntensifyAoe\" operation=\"EQ\" value=\"3\"/>\n" +
            "                <triggered_effect trigger=\"onSelfPrimaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_5\"/>\n" +
            "                <triggered_effect trigger=\"onSelfSecondaryActionRayHit\" action=\"ModifyCVar\" target=\"otherAOE\" target_tags=\"animal,zombie\" range=\"7\" cvar=\"marisaShockedEffectAmount\" operation=\"add\" value=\"MarisaWeaponFlag_dMarisaShockedEffectAmount_5\"/>\n" +
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
