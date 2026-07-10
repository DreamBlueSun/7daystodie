package ume.marisa.iridescent.items.armor.desc;

import ume.marisa.iridescent.constant.Constants;
import ume.marisa.iridescent.items.armor.ArmorInfo;
import ume.marisa.iridescent.utils.KV;
import ume.marisa.iridescent.utils.WriteToFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 护甲DescT1
 */

public class ArmorDescT1 {

    private static final Map<String, ArmorInfo> SKILL_INFO;

    static {
        try {
            String armorT1Skill = Files.readString(Paths.get("D:\\workspace-idea\\7daystodie\\iridescent\\src\\main\\java\\ume\\marisa\\iridescent\\items\\armor\\ArmorT1Skill.txt"));
            SKILL_INFO = new HashMap<>();
            for (String skill : armorT1Skill.split("\r\n")) {
                String[] s = skill.split("\t");
                SKILL_INFO.put(s[1], new ArmorInfo(Integer.parseInt(s[0]), s[1], s[2], s[3], s[8], s[13], s[18], new String[]{s[4], s[5], s[6], s[7]}, new String[]{s[9], s[10], s[11], s[12]}, new String[]{s[14], s[15], s[16], s[17]}, new String[]{s[19], s[20], s[21], s[22]}));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder s = new StringBuilder();
        String armor = Files.readString(Paths.get("D:\\workspace-idea\\7daystodie\\iridescent\\src\\main\\java\\ume\\marisa\\iridescent\\items\\armor\\desc\\ArmorDesc.txt"));
        for (KV<String, Constants.Zombie> zombie : Constants.ZOMBIES) {
            String name = zombie.getK().replace("zombie", "");
            ArmorInfo info = SKILL_INFO.get(name);
            if ("ResearchInstituteLeader".equals(name)) break;
            String replace = armor
                    .replace("Arlene", name)
                    .replace("阿琳", zombie.getV().getLocation())
                    .replace("RANK 1", zombie.getV().getRankT1())
                    .replace("999498", Constants.RANK_COLOR_MAP.get(zombie.getV().getRankT1().replace("RANK ", "")).replace("#", ""))
                    .replace("FLAG_SLOT_1", info.slot1)
                    .replace("FLAG_SLOT_2", info.slot2)
                    .replace("FLAG_SLOT_3", info.slot3)
                    .replace("FLAG_SLOT_4", info.slot4)
                    .replace("FLAG_PERK_1", info.skillHelmetDesc)
                    .replace("FLAG_PERK_2", info.skillOutfitDesc)
                    .replace("FLAG_PERK_3", info.skillGlovesDesc)
                    .replace("FLAG_PERK_4", info.skillBootsDesc);
            s.append(replace).append("\n");
        }
        WriteToFile.output(s.toString());
    }

}
