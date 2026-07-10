package ume.marisa.iridescent.items.armor;

import ume.marisa.iridescent.constant.Constants;
import ume.marisa.iridescent.utils.KV;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */

public class ArmorCheckHelper {

    public static void check(Constants.Zombie zombie, ArmorInfo info, int numSlot, int numOne, int numAll, int offsetOne) {
        // 校验
        StringBuilder error = new StringBuilder();
        // 校验点数
        int sum1 = (Integer.parseInt(info.slot1) * numSlot) + info.skillHelmetKV.stream().map(kv -> Constants.SKILL_MAP.get(kv.getK()).getTire() * kv.getV()).mapToInt(Integer::intValue).sum();
        int sum2 = (Integer.parseInt(info.slot2) * numSlot) + info.skillOutfitKV.stream().map(kv -> Constants.SKILL_MAP.get(kv.getK()).getTire() * kv.getV()).mapToInt(Integer::intValue).sum();
        int sum3 = (Integer.parseInt(info.slot3) * numSlot) + info.skillGlovesKV.stream().map(kv -> Constants.SKILL_MAP.get(kv.getK()).getTire() * kv.getV()).mapToInt(Integer::intValue).sum();
        int sum4 = (Integer.parseInt(info.slot4) * numSlot) + info.skillBootsKV.stream().map(kv -> Constants.SKILL_MAP.get(kv.getK()).getTire() * kv.getV()).mapToInt(Integer::intValue).sum();
        int sum = sum1 + sum2 + sum3 + sum4;
        if (info.offset != (sum - numAll)) error.append("总点数偏移设计值：").append(info.offset).append(" != 校验计算值为：").append(sum - numAll).append("   各部位点数：").append(Arrays.toString(new int[]{sum1, sum2, sum3, sum4}));
        if (sum1 < numOne - offsetOne || sum1 > numOne + offsetOne) error.append("   头盔点数偏移过多：").append(sum1 - numOne);
        if (sum2 < numOne - offsetOne || sum2 > numOne + offsetOne) error.append("   胸甲点数偏移过多：").append(sum2 - numOne);
        if (sum3 < numOne - offsetOne || sum3 > numOne + offsetOne) error.append("   护腿点数偏移过多：").append(sum3 - numOne);
        if (sum4 < numOne - offsetOne || sum4 > numOne + offsetOne) error.append("   鞋子点数偏移过多：").append(sum4 - numOne);
        // 校验技能合计等级超默认最大等级
        Map<String, Integer> mapSkill = Stream.of(info.skillHelmetKV, info.skillOutfitKV, info.skillGlovesKV, info.skillBootsKV).flatMap(List::stream).collect(Collectors.toMap(KV::getK, KV::getV, Integer::sum));
        for (Map.Entry<String, Integer> entry : mapSkill.entrySet()) {
            Constants.Skill skill = Constants.SKILL_MAP.get(entry.getKey());
            int lvMax = Integer.parseInt(skill.getMaxLevel());
            Integer lv = entry.getValue();
            if (lv > lvMax) error.append("   校验技能合计等级").append(lv).append(" 超过 ").append(lvMax).append("   ").append(skill.getLocation());
        }
        // 校验槽位数
        if (Integer.parseInt(info.slot1) > 9) error.append("   ").append(info.slot1).append(" 超过最大槽位9");
        if (Integer.parseInt(info.slot2) > 9) error.append("   ").append(info.slot2).append(" 超过最大槽位9");
        if (Integer.parseInt(info.slot3) > 9) error.append("   ").append(info.slot3).append(" 超过最大槽位9");
        if (Integer.parseInt(info.slot4) > 9) error.append("   ").append(info.slot4).append(" 超过最大槽位9");
        if (!"".contentEquals(error)) System.err.println(error.append("   ").append(zombie.getLocation()));
    }

}
