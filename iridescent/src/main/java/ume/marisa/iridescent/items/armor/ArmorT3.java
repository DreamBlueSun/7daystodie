package ume.marisa.iridescent.items.armor;

import ume.marisa.iridescent.constant.Constants;
import ume.marisa.iridescent.utils.KV;
import ume.marisa.iridescent.utils.WriteToFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 护甲T3
 */

public class ArmorT3 {

    private static final Map<String, ArmorInfo> SKILL_INFO;

    static {
        try {
            String armorT3Skill = Files.readString(Paths.get("D:\\workspace-idea\\7daystodie\\iridescent\\src\\main\\java\\ume\\marisa\\iridescent\\items\\armor\\ArmorT3Skill.txt"));
            SKILL_INFO = new HashMap<>();
            for (String skill : armorT3Skill.split("\r\n")) {
                String[] s = skill.split("\t");
                SKILL_INFO.put(s[1], new ArmorInfo(Integer.parseInt(s[0]), s[1], s[2], s[3], s[8], s[13], s[18], new String[]{s[4], s[5], s[6], s[7]}, new String[]{s[9], s[10], s[11], s[12]}, new String[]{s[14], s[15], s[16], s[17]}, new String[]{s[19], s[20], s[21], s[22]}));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder s = new StringBuilder();
        String armor = Files.readString(Paths.get("D:\\workspace-idea\\7daystodie\\iridescent\\src\\main\\java\\ume\\marisa\\iridescent\\items\\armor\\Armor.txt"));
        List<KV<String, Constants.Zombie>> list = new ArrayList<>(Constants.ZOMBIES);
        for (KV<String, Constants.Zombie> zombie : list) {
            String name = zombie.getK().replace("zombie", "");
            ArmorInfo info = SKILL_INFO.get(name);
            String replace = armor
                    .replace("T1", "T3")
                    .replace("Arlene", name)
                    .replace("阿琳", zombie.getV().getLocation())
                    .replace("MarisaArmorFlag_ModSlots_1", info.slot1)
                    .replace("MarisaArmorFlag_ModSlots_2", info.slot2)
                    .replace("MarisaArmorFlag_ModSlots_3", info.slot3)
                    .replace("MarisaArmorFlag_ModSlots_4", info.slot4)
                    .replace("MarisaArmorFlag_IridescentPerks_Replace_Helmet", info.skillHelmet)
                    .replace("MarisaArmorFlag_IridescentPerks_Replace_Outfit", info.skillOutfit)
                    .replace("MarisaArmorFlag_IridescentPerks_Replace_Gloves", info.skillGloves)
                    .replace("MarisaArmorFlag_IridescentPerks_Replace_Boots", info.skillBoots)
                    ;
            s.append(replace);
        }
        WriteToFile.output(s.toString());
    }


}
