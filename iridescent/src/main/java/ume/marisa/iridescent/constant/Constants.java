package ume.marisa.iridescent.constant;

import ume.marisa.iridescent.utils.KV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * 常量
 */

public abstract class Constants {

    // 丧尸
    public static final List<KV<String, Zombie>> ZOMBIES;

    public static class Zombie {

        protected String marisaPerkT3Location;
        protected String rankT1;
        protected String rankT2;
        protected String rankT3;
        protected String name;
        protected String location;

        public Zombie(String marisaPerkT3Location, String rankT1, String rankT2, String rankT3, String name, String location) {
            this.marisaPerkT3Location = marisaPerkT3Location;
            this.rankT1 = rankT1;
            this.rankT2 = rankT2;
            this.rankT3 = rankT3;
            this.name = name;
            this.location = location;
        }

        public String getMarisaPerkT3Location() {
            return marisaPerkT3Location;
        }

        public String getRankT1() {
            return rankT1;
        }

        public String getRankT2() {
            return rankT2;
        }

        public String getRankT3() {
            return rankT3;
        }

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }
    }

    static {
        try {
            String zombiesTxt = Files.readString(Paths.get("D:\\workspace-idea\\7daystodie\\iridescent\\src\\main\\java\\ume\\marisa\\iridescent\\constant\\zombies.txt"));
            ZOMBIES = new ArrayList<>();
            for (String zombie : zombiesTxt.split("\r\n")) {
                String[] z = zombie.split(",");
                ZOMBIES.add(KV.of(z[4], new Zombie(z[0], z[1], z[2], z[3], z[4], z[5])));
            }
            ZOMBIES.add(KV.of("ResearchInstituteLeader", new Constants.Zombie("晶石系统加倍", "RANK 4", "RANK 8", "RANK 12", "ResearchInstituteLeader", "院长")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 虹彩技能
    public static final Map<String, Skill> SKILL_MAP;
    public static final Map<String, Skill> SKILL_MAP_LOCATION;

    public static class Skill {

        protected String location;
        protected String name;
        protected String maxLevel;
        protected String maxHighLevel;
        protected String cost;
        protected int tire;

        public Skill(String location, String name, String maxLevel, String maxHighLevel, String cost) {
            this.location = location;
            this.name = name;
            this.maxLevel = maxLevel;
            this.maxHighLevel = maxHighLevel;
            this.cost = cost;
            this.tire = Integer.parseInt(cost) / 10;
        }

        public String getLocation() {
            return location;
        }

        public String getName() {
            return name;
        }

        public String getMaxLevel() {
            return maxLevel;
        }

        public String getCost() {
            return cost;
        }

        public int getTire() {
            return tire;
        }
    }

    static {
        try {
            String skillsTxt = Files.readString(Paths.get("D:\\workspace-idea\\7daystodie\\iridescent\\src\\main\\java\\ume\\marisa\\iridescent\\constant\\skills.txt"));
            SKILL_MAP_LOCATION = new HashMap<>();
            for (String skill : skillsTxt.split("\r\n")) {
                String[] s = skill.split(",");
                SKILL_MAP_LOCATION.put(s[0], new Skill(s[0], s[1], s[2], s[3], s[4]));
            }
            SKILL_MAP = new HashMap<>();
            for (String skill : skillsTxt.split("\r\n")) {
                String[] s = skill.split(",");
                SKILL_MAP.put(s[1], new Skill(s[0], s[1], s[2], s[3], s[4]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // 颜色
    public static final String RANK_COLOR_1 = "#999498";
    public static final String RANK_COLOR_2 = "#CCECFF";
    public static final String RANK_COLOR_3 = "#F5F918";
    public static final String RANK_COLOR_4 = "#67C483";
    public static final String RANK_COLOR_5 = "#84E1EC";
    public static final String RANK_COLOR_6 = "#7EA8FB";
    public static final String RANK_COLOR_7 = "#7555E1";
    public static final String RANK_COLOR_8 = "#FF985E";
    public static final String RANK_COLOR_9 = "#00FF00";
    public static final String RANK_COLOR_10 = "#00BFFF";
    public static final String RANK_COLOR_11 = "#BA55D3";
    public static final String RANK_COLOR_12 = "#FFA500";
    public static final String RANK_COLOR_12_S = "#6D0F0F";
    public static final List<String> RANK_COLOR_LIST = new ArrayList<>(Arrays.asList(RANK_COLOR_1, RANK_COLOR_2, RANK_COLOR_3, RANK_COLOR_4, RANK_COLOR_5, RANK_COLOR_6, RANK_COLOR_7, RANK_COLOR_8, RANK_COLOR_9, RANK_COLOR_10, RANK_COLOR_11, RANK_COLOR_12, RANK_COLOR_12_S));
    public static final Map<String, String> RANK_COLOR_MAP;

    static {
        RANK_COLOR_MAP = new HashMap<>();
        for (int i = 0; i < RANK_COLOR_LIST.size(); i++) {
            RANK_COLOR_MAP.put(String.valueOf(i + 1), RANK_COLOR_LIST.get(i));
        }
    }

    // 价格
    public static final String RANK_ECONOMIC_1 = "250";
    public static final String RANK_ECONOMIC_2 = "500";
    public static final String RANK_ECONOMIC_3 = "1000";
    public static final String RANK_ECONOMIC_4 = "1500";
    public static final String RANK_ECONOMIC_5 = "3000";
    public static final String RANK_ECONOMIC_6 = "5000";
    public static final String RANK_ECONOMIC_7 = "7500";
    public static final String RANK_ECONOMIC_8 = "10000";
    public static final String RANK_ECONOMIC_9 = "15000";
    public static final String RANK_ECONOMIC_10 = "20000";
    public static final String RANK_ECONOMIC_11 = "30000";
    public static final String RANK_ECONOMIC_12 = "40000";
    public static final String RANK_ECONOMIC_12_S = "50000";
    public static final List<String> RANK_ECONOMIC_LIST = new ArrayList<>(Arrays.asList(RANK_ECONOMIC_1, RANK_ECONOMIC_2, RANK_ECONOMIC_3, RANK_ECONOMIC_4, RANK_ECONOMIC_5, RANK_ECONOMIC_6, RANK_ECONOMIC_7, RANK_ECONOMIC_8, RANK_ECONOMIC_9, RANK_ECONOMIC_10, RANK_ECONOMIC_11, RANK_ECONOMIC_12, RANK_ECONOMIC_12_S));

    // 分解材料
    public static final String RANK_MATERIAL_1 = "MIridescentCube";
    public static final String RANK_MATERIAL_2 = "MIridescentCube";
    public static final String RANK_MATERIAL_3 = "MIridescentCube";
    public static final String RANK_MATERIAL_4 = "MIridescentCube";
    public static final String RANK_MATERIAL_5 = "MIridescentCube";
    public static final String RANK_MATERIAL_6 = "MIridescentCube";
    public static final String RANK_MATERIAL_7 = "MIridescentCube";
    public static final String RANK_MATERIAL_8 = "MIridescentCube";
    public static final String RANK_MATERIAL_9 = "MIridescentCubeSuper";
    public static final String RANK_MATERIAL_10 = "MIridescentCubeSuper";
    public static final String RANK_MATERIAL_11 = "MIridescentCubeSuper";
    public static final String RANK_MATERIAL_12 = "MIridescentCubeSuper";
    public static final String RANK_MATERIAL_12_S = "MCrimsonGold";
    public static final List<String> RANK_MATERIAL_LIST = new ArrayList<>(Arrays.asList(RANK_MATERIAL_1, RANK_MATERIAL_2, RANK_MATERIAL_3, RANK_MATERIAL_4, RANK_MATERIAL_5, RANK_MATERIAL_6, RANK_MATERIAL_7, RANK_MATERIAL_8, RANK_MATERIAL_9, RANK_MATERIAL_10, RANK_MATERIAL_11, RANK_MATERIAL_12, RANK_MATERIAL_12_S));

    // 分解权重
    public static final String RANK_WEIGHT_1 = "3";
    public static final String RANK_WEIGHT_2 = "6";
    public static final String RANK_WEIGHT_3 = "11";
    public static final String RANK_WEIGHT_4 = "22";
    public static final String RANK_WEIGHT_5 = "43";
    public static final String RANK_WEIGHT_6 = "86";
    public static final String RANK_WEIGHT_7 = "171";
    public static final String RANK_WEIGHT_8 = "342";
    public static final String RANK_WEIGHT_9 = "43";
    public static final String RANK_WEIGHT_10 = "86";
    public static final String RANK_WEIGHT_11 = "171";
    public static final String RANK_WEIGHT_12 = "342";
    public static final String RANK_WEIGHT_12_S = "2";
    public static final List<String> RANK_WEIGHT_LIST = new ArrayList<>(Arrays.asList(RANK_WEIGHT_1, RANK_WEIGHT_2, RANK_WEIGHT_3, RANK_WEIGHT_4, RANK_WEIGHT_5, RANK_WEIGHT_6, RANK_WEIGHT_7, RANK_WEIGHT_8, RANK_WEIGHT_9, RANK_WEIGHT_10, RANK_WEIGHT_11, RANK_WEIGHT_12, RANK_WEIGHT_12_S));

    // 槽位
    public static final String RANK_MOD_SLOTS_1 = "2";
    public static final String RANK_MOD_SLOTS_2 = "2";
    public static final String RANK_MOD_SLOTS_3 = "2";
    public static final String RANK_MOD_SLOTS_4 = "3";
    public static final String RANK_MOD_SLOTS_5 = "3";
    public static final String RANK_MOD_SLOTS_6 = "3";
    public static final String RANK_MOD_SLOTS_7 = "4";
    public static final String RANK_MOD_SLOTS_8 = "4";
    public static final String RANK_MOD_SLOTS_9 = "4";
    public static final String RANK_MOD_SLOTS_10 = "5";
    public static final String RANK_MOD_SLOTS_11 = "5";
    public static final String RANK_MOD_SLOTS_12 = "5";
    public static final String RANK_MOD_SLOTS_12_S = "6";
    public static final List<String> RANK_MOD_SLOTS_LIST = new ArrayList<>(Arrays.asList(RANK_MOD_SLOTS_1, RANK_MOD_SLOTS_2, RANK_MOD_SLOTS_3, RANK_MOD_SLOTS_4, RANK_MOD_SLOTS_5, RANK_MOD_SLOTS_6, RANK_MOD_SLOTS_7, RANK_MOD_SLOTS_8, RANK_MOD_SLOTS_9, RANK_MOD_SLOTS_10, RANK_MOD_SLOTS_11, RANK_MOD_SLOTS_12, RANK_MOD_SLOTS_12_S));

}
