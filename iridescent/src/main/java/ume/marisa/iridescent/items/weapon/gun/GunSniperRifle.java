package ume.marisa.iridescent.items.weapon.gun;

import ume.marisa.iridescent.constant.Constants;
import ume.marisa.iridescent.utils.WriteToFile;

/**
 * 精准猎枪
 */

public class GunSniperRifle {

    // 开始
    public static final String START = "    <append xpath=\"/items\">\n" + "\n";
    // 结束
    public static final String STOP = "\n" + "    </append>";

    public static void main(String[] args) {
        int de = RANK_ENTITY_DAMAGE_S0;
        StringBuilder s = new StringBuilder(START);
        StringBuilder entityDamage = new StringBuilder("EntityDamage");
        for (int i = 1; i <= 13; i++) {
            de += RANK_ENTITY_DAMAGE_ARR[i - 1];
            entityDamage.append(",").append(de);
            String replace = WEAPON_XML.replace("MarisaWeaponFlag_RANK", String.valueOf(i))
                    .replace("MarisaWeaponFlag_T3_TAG", i >= 9 ? T3_TAG : T1_TAG)
                    .replace("MarisaWeaponFlag_CustomIconTint", Constants.RANK_COLOR_LIST.get(i - 1))
                    .replace("MarisaWeaponFlag_EconomicValue", Constants.RANK_ECONOMIC_LIST.get(i - 1))
                    .replace("MarisaWeaponFlag_Material", Constants.RANK_MATERIAL_LIST.get(i - 1))
                    .replace("MarisaWeaponFlag_Weight", Constants.RANK_WEIGHT_LIST.get(i - 1))
                    .replace("MarisaWeaponFlag_ModSlots", Constants.RANK_MOD_SLOTS_LIST.get(i - 1))
                    .replace("MarisaWeaponFlag_EntityDamageTier", RANK_ENTITY_DAMAGE_TIER)
                    .replace("MarisaWeaponFlag_EntityDamage", String.valueOf(de))
                    .replace("MarisaWeaponFlag_Magazine_items", i <= 4 ? RANK_MAGAZINE_ITEMS_1 : i <= 8 ? RANK_MAGAZINE_ITEMS_2 : RANK_MAGAZINE_ITEMS_3)
                    .replace("MarisaWeaponFlag_Extends", RANK_MARISA_CUSTOMICON_1)
                    .replace("MarisaWeaponFlag_CustomIcon", RANK_MARISA_CUSTOMICON_1)
                    .replace("MarisaWeaponFlag_StarDegradation", i == 13 ? STAR_DEGRADATION_B : STAR_DEGRADATION_A)
                    .replace("MarisaWeaponFlag_StarStats", i == 13 ? STAR_STATS : "");
            s.append(replace).append("\n");
        }
        WriteToFile.output(s.append(STOP).toString());
        System.out.println(entityDamage);
    }

    // 伤害
    public static final int RANK_ENTITY_DAMAGE_S0 = 60;
    public static final int[] RANK_ENTITY_DAMAGE_ARR = new int[]{25, 25, 25, 40, 40, 40, 55, 55, 55, 70, 70, 70, 0};
    public static final String RANK_ENTITY_DAMAGE_TIER = "0,25";

    // 弹药
    public static final String RANK_MAGAZINE_ITEMS_1 = "<property name=\"Magazine_items\" value=\"ammo762mmBulletBall,ammo762mmBulletHP,ammo762mmBulletAP,ammo762mmBulletBleed,ammo762mmBulletRadiationPool,ammo762mmBulletFire,ammo762mmBulletShocked\"/>";
    public static final String RANK_MAGAZINE_ITEMS_2 = "<property name=\"Magazine_items\" value=\"ammo762mmBulletBall,ammo762mmBulletHP,ammo762mmBulletAP,ammo762mmBulletBleed,ammo762mmBulletRadiationPool,ammo762mmBulletFire,ammo762mmBulletShocked,ammo762mmBulletSE\"/>";
    public static final String RANK_MAGAZINE_ITEMS_3 = "<property name=\"Magazine_items\" value=\"ammo762mmBulletBall,ammo762mmBulletHP,ammo762mmBulletAP,ammo762mmBulletBleed,ammo762mmBulletRadiationPool,ammo762mmBulletFire,ammo762mmBulletShocked,ammo762mmBulletSE,ammo762mmBulletSP\"/>";

    // 模型
    public static final String RANK_MARISA_CUSTOMICON_1 = "gunRifleT3SniperRifle";

    // 狂化Tag
    public static final String T1_TAG = "\n\t        <property name=\"Tags\" value=\"weapon,ranged,holdBreathAiming,reloadPenalty,gun,barrelAttachments,sideAttachments,smallTopAttachments,mediumTopAttachments,largeTopAttachments,stock,magazine,firingMode,bottomAttachments,attPerception,perkDeadEye,attachmentsIncluded,canHaveCosmetic,rifleSkill\"/>";
    public static final String T3_TAG = "\n\t        <property name=\"Tags\" value=\"weapon,ranged,holdBreathAiming,reloadPenalty,gun,barrelAttachments,sideAttachments,smallTopAttachments,mediumTopAttachments,largeTopAttachments,stock,magazine,firingMode,bottomAttachments,attPerception,perkDeadEye,attachmentsIncluded,canHaveCosmetic,rifleSkill,PerkT3Marisa\"/>";

    // 武器合成 星星
    public static final String STAR_DEGRADATION_A = "<passive_effect name=\"DegradationMax\" operation=\"base_set\" value=\"150,200\" tier=\"1,6\" tags=\"perkDeadEye\"/>";
    public static final String STAR_DEGRADATION_B = "<passive_effect name=\"DegradationMax\" operation=\"base_set\" value=\"1,160,170,180,190,200\" tier=\"1,2,3,4,5,6\" tags=\"perkDeadEye\"/>";
    public static final String STAR_STATS = "\n\n" +
            "            <stats>\n" +
            "                <!-- Base_Random_Roll -->\n" +
            "                <stat name=\"EntityDamage\" value=\"0,0,1,0,0\"/>\n" +
            "                <stat name=\"RoundsPerMinute\" value=\"0,0,1,0,0\"/>\n" +
            "                <stat name=\"DamageFalloffRange\" value=\"0,0,1,0,0\"/>\n" +
            "                <!-- Q1_Boosted_Rolls -->\n" +
            "                <stat name=\"EntityDamage\" value=\"1,0,1,.01,.3\"/>\n" +
            "                <stat name=\"RoundsPerMinute\" value=\"1,0,1,.01,.3\"/>\n" +
            "                <stat name=\"DamageFalloffRange\" value=\"1,0,1,.01,.3\"/>\n" +
            "            </stats>";

    // item
    public static final String WEAPON_XML = "        <item name=\"GunSniperRifleSMarisaWeaponFlag_RANK\">\n" +
            "            <property name=\"UnlockedBy\" value=\"craftingEquipment\"/>\n" +
            "            <property name=\"TraderStageTemplate\" value=\"baseTier2\"/>\n" +
            "            <property name=\"Extends\" value=\"MarisaWeaponFlag_Extends\"/>MarisaWeaponFlag_T3_TAG\n" +
            "            <property name=\"SellableToTrader\" value=\"false\"/>\n" +
            "            <property name=\"CustomIcon\" value=\"MarisaWeaponFlag_CustomIcon\"/>\n" +
            "            <property name=\"CustomIconTint\" value=\"MarisaWeaponFlag_CustomIconTint\"/>\n" +
            "            <property name=\"EconomicValue\" value=\"MarisaWeaponFlag_EconomicValue\"/>\n" +
            "            <property name=\"Material\" value=\"MarisaWeaponFlag_Material\"/>\n" +
            "            <property name=\"Weight\" value=\"MarisaWeaponFlag_Weight\"/>\n" +
            "\n" +
            "            <property class=\"Action0\">\n" +
            "                <property name=\"Class\" value=\"Ranged\"/>\n" +
            "                <property name=\"Delay\" value=\".5\"/>\n" +
            "                MarisaWeaponFlag_Magazine_items\n" +
            "                <property name=\"Reload_time\" value=\"2.5\"/>\n" +
            "                <property name=\"Sound_start\" value=\"sharpshooter_fire\"/>\n" +
            "                <property name=\"Sound_loop\" value=\"sharpshooter_fire\"/>\n" +
            "                <property name=\"Sound_repeat\" value=\"\"/>\n" +
            "                <property name=\"Sound_end\" value=\"\"/>\n" +
            "                <property name=\"Sound_empty\" value=\"dryfire\"/>\n" +
            "                <property name=\"AutoReload\" value=\"false\"/>\n" +
            "                <property name=\"Particles_muzzle_fire\" value=\"gunfire_rifle_sniper\"/>\n" +
            "                <property name=\"triggerEffectTriggerPullDualsense\" value=\"RifleTrigger\"/>\n" +
            "                <property name=\"triggerEffectTriggerPullXbox\" value=\"PistolTrigger\"/>\n" +
            "                <property name=\"triggerEffectTriggerShootDualsense\" value=\"RifleShoot\"/>\n" +
            "                <property name=\"triggerEffectTriggerShootXbox\" value=\"PistolShoot\"/>\n" +
            "            </property>MarisaWeaponFlag_StarStats\n" +
            "\n" +
            "            <effect_group name=\"GunSniperRifleSMarisaWeaponFlag_RANK\">\n" +
            "                <passive_effect name=\"MaxRange\" operation=\"base_set\" value=\"150\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"DamageFalloffRange\" operation=\"base_set\" value=\"80\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"RoundsPerMinute\" operation=\"base_set\" value=\"160\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"BurstRoundCount\" operation=\"base_set\" value=\"1\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"MagazineSize\" operation=\"base_set\" value=\"5.5\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"ReloadSpeedMultiplier\" operation=\"base_set\" value=\"0.8\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"ModSlots\" operation=\"base_set\" value=\"MarisaWeaponFlag_ModSlots\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_EntityDamage\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_EntityDamageTier\" tier=\"1,6\" tags=\"perkDeadEye\"/>\n" +
            "\n" +
            "                <passive_effect name=\"SpreadDegreesVertical\" operation=\"base_set\" value=\"6\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"SpreadDegreesHorizontal\" operation=\"base_set\" value=\"6\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"SpreadMultiplierAiming\" operation=\"base_set\" value=\".06\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"SpreadMultiplierCrouching\" operation=\"base_set\" value=\".8\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"SpreadMultiplierWalking\" operation=\"base_set\" value=\"1.5\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"SpreadMultiplierRunning\" operation=\"base_set\" value=\"2\" tags=\"perkDeadEye\"/>\n" +
            "\n" +
            "                <passive_effect name=\"KickDegreesVerticalMin\" operation=\"base_set\" value=\"1.5\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"KickDegreesVerticalMax\" operation=\"base_set\" value=\"3.0\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"KickDegreesHorizontalMin\" operation=\"base_set\" value=\"-.2\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"KickDegreesHorizontalMax\" operation=\"base_set\" value=\".2\" tags=\"perkDeadEye\"/>\n" +
            "\n" +
            "                <passive_effect name=\"IncrementalSpreadMultiplier\" operation=\"base_set\" value=\"11\" tags=\"perkDeadEye\"/>\n" +
            "                <passive_effect name=\"WeaponHandling\" operation=\"base_set\" value=\".75\" tags=\"perkDeadEye\"/>\n" +
            "\n" +
            "                MarisaWeaponFlag_StarDegradation\n" +
            "                <passive_effect name=\"DegradationPerUse\" operation=\"base_set\" value=\"1\" tags=\"perkDeadEye\"/>\n" +
            "            </effect_group>\n" +
            "        </item>";


}
