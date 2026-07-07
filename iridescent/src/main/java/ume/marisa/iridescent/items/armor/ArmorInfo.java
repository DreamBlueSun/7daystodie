package ume.marisa.iridescent.items.armor;

import ume.marisa.iridescent.constant.Constants;

/**
 *
 */

public class ArmorInfo {

    public int offset;
    public String zombiesName;
    public String zombiesLocation;
    public String slot1;
    public String slot2;
    public String slot3;
    public String slot4;
    public String skillHelmet;
    public String skillOutfit;
    public String skillGloves;
    public String skillBoots;
    public String skillHelmetDesc;
    public String skillOutfitDesc;
    public String skillGlovesDesc;
    public String skillBootsDesc;

    public ArmorInfo(int offset, String zombiesName, String zombiesLocation, String slot1, String slot2, String slot3, String slot4, String[] skill1, String[] skill2, String[] skill3, String[] skill4) {
        this.offset = offset;
        this.zombiesName = zombiesName;
        this.zombiesLocation = zombiesLocation;
        this.slot1 = slot1;
        this.slot2 = slot2;
        this.slot3 = slot3;
        this.slot4 = slot4;

        this.skillHelmet = "";
        if (!"——".equals(skill1[0])) this.skillHelmet += IRIDESCENT_PERKS_HELMET.replace("MarisaArmorFlag_IridescentPerks_Helmet", Constants.SKILLS_LOCATION.get(skill1[0]).getName()).replace("MarisaArmorFlag_IridescentPerks_Value_Helmet", skill1[1]);
        if (!"——".equals(skill1[2])) this.skillHelmet += IRIDESCENT_PERKS_HELMET.replace("MarisaArmorFlag_IridescentPerks_Helmet", Constants.SKILLS_LOCATION.get(skill1[2]).getName()).replace("MarisaArmorFlag_IridescentPerks_Value_Helmet", skill1[3]);
        this.skillOutfit = "";
        if (!"——".equals(skill2[0])) this.skillOutfit += IRIDESCENT_PERKS_OUTFIT.replace("MarisaArmorFlag_IridescentPerks_Outfit", Constants.SKILLS_LOCATION.get(skill2[0]).getName()).replace("MarisaArmorFlag_IridescentPerks_Value_Helmet", skill2[1]);
        if (!"——".equals(skill2[2])) this.skillOutfit += IRIDESCENT_PERKS_OUTFIT.replace("MarisaArmorFlag_IridescentPerks_Outfit", Constants.SKILLS_LOCATION.get(skill2[2]).getName()).replace("MarisaArmorFlag_IridescentPerks_Value_Helmet", skill2[3]);
        this.skillGloves = "";
        if (!"——".equals(skill3[0])) this.skillGloves += IRIDESCENT_PERKS_GLOVES.replace("MarisaArmorFlag_IridescentPerks_Gloves", Constants.SKILLS_LOCATION.get(skill3[0]).getName()).replace("MarisaArmorFlag_IridescentPerks_Value_Helmet", skill3[1]);
        if (!"——".equals(skill3[2])) this.skillGloves += IRIDESCENT_PERKS_GLOVES.replace("MarisaArmorFlag_IridescentPerks_Gloves", Constants.SKILLS_LOCATION.get(skill3[2]).getName()).replace("MarisaArmorFlag_IridescentPerks_Value_Helmet", skill3[3]);
        this.skillBoots = "";
        if (!"——".equals(skill4[0])) this.skillBoots += IRIDESCENT_PERKS_BOOTS.replace("MarisaArmorFlag_IridescentPerks_Boots", Constants.SKILLS_LOCATION.get(skill4[0]).getName()).replace("MarisaArmorFlag_IridescentPerks_Value_Helmet", skill4[1]);
        if (!"——".equals(skill4[2])) this.skillBoots += IRIDESCENT_PERKS_BOOTS.replace("MarisaArmorFlag_IridescentPerks_Boots", Constants.SKILLS_LOCATION.get(skill4[2]).getName()).replace("MarisaArmorFlag_IridescentPerks_Value_Helmet", skill4[3]);

        this.skillHelmetDesc = "";
        if (!"——".equals(skill1[0])) this.skillHelmetDesc += IRIDESCENT_PERKS_DESC.replace("FLAG_PERK", Constants.SKILLS_LOCATION.get(skill1[0]).getLocation()).replace("FLAG_COUNT_PERK", perkCount(Integer.parseInt(skill1[1])));
        if (!"——".equals(skill1[2])) this.skillHelmetDesc += IRIDESCENT_PERKS_DESC.replace("FLAG_PERK", Constants.SKILLS_LOCATION.get(skill1[2]).getLocation()).replace("FLAG_COUNT_PERK", perkCount(Integer.parseInt(skill1[3])));
        if (this.skillHelmetDesc.isEmpty()) this.skillHelmetDesc = "\\n无";
        this.skillOutfitDesc = "";
        if (!"——".equals(skill2[0])) this.skillOutfitDesc += IRIDESCENT_PERKS_DESC.replace("FLAG_PERK", Constants.SKILLS_LOCATION.get(skill2[0]).getLocation()).replace("FLAG_COUNT_PERK", perkCount(Integer.parseInt(skill2[1])));
        if (!"——".equals(skill2[2])) this.skillOutfitDesc += IRIDESCENT_PERKS_DESC.replace("FLAG_PERK", Constants.SKILLS_LOCATION.get(skill2[2]).getLocation()).replace("FLAG_COUNT_PERK", perkCount(Integer.parseInt(skill2[3])));
        if (this.skillOutfitDesc.isEmpty()) this.skillOutfitDesc = "\\n无";
        this.skillGlovesDesc = "";
        if (!"——".equals(skill3[0])) this.skillGlovesDesc += IRIDESCENT_PERKS_DESC.replace("FLAG_PERK", Constants.SKILLS_LOCATION.get(skill3[0]).getLocation()).replace("FLAG_COUNT_PERK", perkCount(Integer.parseInt(skill3[1])));
        if (!"——".equals(skill3[2])) this.skillGlovesDesc += IRIDESCENT_PERKS_DESC.replace("FLAG_PERK", Constants.SKILLS_LOCATION.get(skill3[2]).getLocation()).replace("FLAG_COUNT_PERK", perkCount(Integer.parseInt(skill3[3])));
        if (this.skillGlovesDesc.isEmpty()) this.skillGlovesDesc = "\\n无";
        this.skillBootsDesc = "";
        if (!"——".equals(skill4[0])) this.skillBootsDesc += IRIDESCENT_PERKS_DESC.replace("FLAG_PERK", Constants.SKILLS_LOCATION.get(skill4[0]).getLocation()).replace("FLAG_COUNT_PERK", perkCount(Integer.parseInt(skill4[1])));
        if (!"——".equals(skill4[2])) this.skillBootsDesc += IRIDESCENT_PERKS_DESC.replace("FLAG_PERK", Constants.SKILLS_LOCATION.get(skill4[2]).getLocation()).replace("FLAG_COUNT_PERK", perkCount(Integer.parseInt(skill4[3])));
        if (this.skillBootsDesc.isEmpty()) this.skillBootsDesc = "\\n无";
    }

    // 虹彩技能
    public static final String IRIDESCENT_PERKS_HELMET = "\n" +
            "            <effect_group name=\"IridescentPerks Helmet\">\n" +
            "                <passive_effect name=\"PerkLevel\" operation=\"base_add\" value=\"MarisaArmorFlag_IridescentPerks_Value_Helmet\" tags=\"MarisaArmorFlag_IridescentPerks_Helmet\"/>\n" +
            "            </effect_group>";
    public static final String IRIDESCENT_PERKS_OUTFIT = "\n" +
            "            <effect_group name=\"IridescentPerks Outfit\">\n" +
            "                <passive_effect name=\"PerkLevel\" operation=\"base_add\" value=\"MarisaArmorFlag_IridescentPerks_Value_Outfit\" tags=\"MarisaArmorFlag_IridescentPerks_Outfit\"/>\n" +
            "            </effect_group>";
    public static final String IRIDESCENT_PERKS_GLOVES = "\n" +
            "            <effect_group name=\"IridescentPerks Gloves\">\n" +
            "                <passive_effect name=\"PerkLevel\" operation=\"base_add\" value=\"MarisaArmorFlag_IridescentPerks_Value_Gloves\" tags=\"MarisaArmorFlag_IridescentPerks_Gloves\"/>\n" +
            "            </effect_group>";
    public static final String IRIDESCENT_PERKS_BOOTS = "\n" +
            "            <effect_group name=\"IridescentPerks Boots\">\n" +
            "                <passive_effect name=\"PerkLevel\" operation=\"base_add\" value=\"MarisaArmorFlag_IridescentPerks_Value_Boots\" tags=\"MarisaArmorFlag_IridescentPerks_Boots\"/>\n" +
            "            </effect_group>";

    // 虹彩技能Desc
    public static final String IRIDESCENT_PERKS_DESC = "\\nFLAG_PERK[FF985E]FLAG_COUNT_PERK[-]";

    private static String perkCount(int x) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < x; i++) {
            s.append("▉");
        }
        return s.toString();
    }
}
