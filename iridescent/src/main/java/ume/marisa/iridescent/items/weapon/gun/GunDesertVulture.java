package ume.marisa.iridescent.items.weapon.gun;

import ume.marisa.iridescent.constant.Constants;
import ume.marisa.iridescent.utils.WriteToFile;

/**
 * 沙鹰
 */

public class GunDesertVulture {

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
    public static final int RANK_ENTITY_DAMAGE_S0 = 30;
    public static final int[] RANK_ENTITY_DAMAGE_ARR = new int[]{25, 25, 25, 25, 35, 35, 35, 35, 45, 45, 45, 45, 0};
    public static final String RANK_ENTITY_DAMAGE_TIER = "0,25";

    // 弹药
    public static final String RANK_MAGAZINE_ITEMS_1 = "<property name=\"Magazine_items\" value=\"ammo44MagnumBulletBall,ammo44MagnumBulletHP,ammo44MagnumBulletAP,ammo44MagnumBulletBleed,ammo44MagnumBulletRadiationPool,ammo44MagnumBulletFire,ammo44MagnumBulletShocked\"/>";
    public static final String RANK_MAGAZINE_ITEMS_2 = "<property name=\"Magazine_items\" value=\"ammo44MagnumBulletBall,ammo44MagnumBulletHP,ammo44MagnumBulletAP,ammo44MagnumBulletBleed,ammo44MagnumBulletRadiationPool,ammo44MagnumBulletFire,ammo44MagnumBulletShocked,ammo44MagnumBulletSE\"/>";
    public static final String RANK_MAGAZINE_ITEMS_3 = "<property name=\"Magazine_items\" value=\"ammo44MagnumBulletBall,ammo44MagnumBulletHP,ammo44MagnumBulletAP,ammo44MagnumBulletBleed,ammo44MagnumBulletRadiationPool,ammo44MagnumBulletFire,ammo44MagnumBulletShocked,ammo44MagnumBulletSE,ammo44MagnumBulletSP\"/>";

    // 模型
    public static final String RANK_MARISA_CUSTOMICON_1 = "gunHandgunT3DesertVulture";

    // 狂化Tag
    public static final String T1_TAG = "\n\t        <property name=\"Tags\" value=\"weapon,ranged,revolver,44enforcer,holdBreathAiming,reloadPenalty,gun,shortRange,pistol,barrelAttachments,sideAttachments,smallTopAttachments,magazine,firingMode,attAgility,perkGunslinger,attachmentsIncluded,canHaveCosmetic,handgunSkill,enforcerReload,marisaDesertVulture\"/>";
    public static final String T3_TAG = "\n\t        <property name=\"Tags\" value=\"weapon,ranged,revolver,44enforcer,holdBreathAiming,reloadPenalty,gun,shortRange,pistol,barrelAttachments,sideAttachments,smallTopAttachments,magazine,firingMode,attAgility,perkGunslinger,attachmentsIncluded,canHaveCosmetic,handgunSkill,enforcerReload,marisaDesertVulture,PerkT3Marisa\"/>";

    // 武器合成 星星
    public static final String STAR_DEGRADATION_A = "<passive_effect name=\"DegradationMax\" operation=\"base_set\" value=\"125,175\" tier=\"1,6\" tags=\"perkGunslinger\"/>";
    public static final String STAR_DEGRADATION_B = "<passive_effect name=\"DegradationMax\" operation=\"base_set\" value=\"1,135,145,155,165,175\" tier=\"1,2,3,4,5,6\" tags=\"perkGunslinger\"/>";
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
    public static final String WEAPON_XML = "        <item name=\"GunDesertVultureSMarisaWeaponFlag_RANK\">\n" +
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
            "                MarisaWeaponFlag_Magazine_items\n" +
            "                <property name=\"Sound_start\" value=\"desertvulture_fire\"/>\n" +
            "                <property name=\"Sound_loop\" value=\"desertvulture_fire\"/>\n" +
            "                <property name=\"Sound_end\" value=\"\"/>\n" +
            "                <property name=\"Sound_empty\" value=\"dryfire\"/>\n" +
            "                <property name=\"AutoReload\" value=\"false\"/>\n" +
            "                <property name=\"Particles_muzzle_fire\" value=\"gunfire_pistol_desertvulture\"/>\n" +
            "                <property name=\"triggerEffectTriggerPullDualsense\" value=\"PistolTrigger\"/>\n" +
            "                <property name=\"triggerEffectTriggerPullXbox\" value=\"PistolTrigger\"/>\n" +
            "                <property name=\"triggerEffectShootDualsense\" value=\"PistolShoot\"/>\n" +
            "                <property name=\"triggerEffectShootXbox\" value=\"PistolShoot\"/>\n" +
            "            </property>MarisaWeaponFlag_StarStats\n" +
            "\n" +
            "            <effect_group name=\"GunDesertVultureSMarisaWeaponFlag_RANK\">\n" +
            "                <passive_effect name=\"MaxRange\" operation=\"base_set\" value=\"50\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"DamageFalloffRange\" operation=\"base_set\" value=\"30\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"RoundsPerMinute\" operation=\"base_set\" value=\"160\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"BurstRoundCount\" operation=\"base_set\" value=\"1\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"MagazineSize\" operation=\"base_set\" value=\"7.7\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"ReloadSpeedMultiplier\" operation=\"base_set\" value=\"1\" tags=\"perkGunslinger\"/> <!-- 2s -->\n" +
            "                <passive_effect name=\"ModSlots\" operation=\"base_set\" value=\"MarisaWeaponFlag_ModSlots\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_EntityDamage\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"EntityDamage\" operation=\"base_add\" value=\"MarisaWeaponFlag_EntityDamageTier\" tier=\"1,6\" tags=\"perkGunslinger\"/>\n" +
            "\n" +
            "                <passive_effect name=\"SpreadDegreesVertical\" operation=\"base_set\" value=\"1.3\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"SpreadDegreesHorizontal\" operation=\"base_set\" value=\"1.3\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"SpreadMultiplierAiming\" operation=\"base_set\" value=\".35\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"SpreadMultiplierCrouching\" operation=\"base_set\" value=\".8\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"SpreadMultiplierWalking\" operation=\"base_set\" value=\"1.5\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"SpreadMultiplierRunning\" operation=\"base_set\" value=\"2.2\" tags=\"perkGunslinger\"/>\n" +
            "\n" +
            "                <passive_effect name=\"KickDegreesVerticalMin\" operation=\"base_set\" value=\"3.5\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"KickDegreesVerticalMax\" operation=\"base_set\" value=\"4\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"KickDegreesHorizontalMin\" operation=\"base_set\" value=\"-.3\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"KickDegreesHorizontalMax\" operation=\"base_set\" value=\".15\" tags=\"perkGunslinger\"/>\n" +
            "\n" +
            "                <passive_effect name=\"IncrementalSpreadMultiplier\" operation=\"base_set\" value=\"3.2\" tags=\"perkGunslinger\"/>\n" +
            "                <passive_effect name=\"WeaponHandling\" operation=\"base_set\" value=\".6\" tags=\"perkGunslinger\"/>\n" +
            "\n" +
            "                MarisaWeaponFlag_StarDegradation\n" +
            "                <passive_effect name=\"DegradationPerUse\" operation=\"base_set\" value=\"1\" tags=\"perkGunslinger\"/>\n" +
            "            </effect_group>\n" +
            "        </item>";


}
