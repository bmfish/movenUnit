package cbj.wc;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * author:   bmfish
 * date: 2022/6/1 10:54
 * description: //模块目的、功能描述
 * version:wksix
 * history: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 */
public class HuaweiDataHandler {

    public static void main(String[] args) throws Exception {


        String filePath = "/Users/caozhiyu/Downloads/HUAWEI_HEALTH_20240218102730/Health detail data & description/health detail data.json";
        File file = new File(filePath);

        //  JSONObject jsonObject = JSONObject.parseObject(fileStr, JSONObject.class);
        List<JSONObject> list = JSONObject.parseArray(FileUtils.readFileToString(file), JSONObject.class);
        for (JSONObject dailyItem : list) {
            Map<String, String> dailyMap = convertJsonObjectToMap(dailyItem);
            String samplePoints =dailyMap.get("samplePoints");
            if(StringUtils.isNotBlank(samplePoints)) {
                List<JSONObject> details = JSONObject.parseArray(samplePoints, JSONObject.class);
                if(null!=details&&details.size()>0){
                    for (JSONObject detail : details) {
                        if(detail.containsValue("WEIGHT_BODYFAT_BROAD")){
                            String value = (String) detail.get("value");
                            saveDailyData(convertJsonObjectToMap(JSONObject.parseObject(value)),  String.valueOf(detail.get("startTime")));
                        }
                    }
                }
            }

        }
    }

    private static Map<String, String> convertJsonObjectToMap(JSONObject obj) {
        Map<String, String> params = JSONObject.parseObject(obj.toJSONString(), new TypeReference<Map<String, String>>() {
        });
        return params;
    }

    private static void saveDailyData(Map<String, String> dailyItemMap,String startTime) throws Exception {
        String timeMilStr = startTime;
        Long timeMinllis = Long.parseLong(timeMilStr);

        String age = dailyItemMap.get("age");
        String basalMetabolism = dailyItemMap.get("basalMetabolism");
        String bmi = dailyItemMap.get("bmi");
        String bodyAge = dailyItemMap.get("bodyAge");
        String bodyFatRate = dailyItemMap.get("bodyFatRate");
        String bodyScore = dailyItemMap.get("bodyScore");
        String bodyWeight = dailyItemMap.get("bodyWeight");
        String boneSalt = dailyItemMap.get("boneSalt");
        String insertSql = "insert into  t_huawei_daily (date_id,age,basalMetabolism,bmi,bodyAge,bodyFatRate,bodyScore,bodyWeight,boneSalt,create_time) "
                + "values ("
                + timeMinllis + ",'"
                + age + "','"
                + basalMetabolism + "','"
                + bmi + "','"
                + bodyAge + "','"
                + bodyFatRate + "','"
                + bodyScore + "','"
                + bodyWeight + "','"
                + boneSalt + "','"
                + timeStamp2Date(timeMilStr, "yyyy-MM-dd") + "');";

        DBUtil.save(insertSql);
        System.out.println(timeStamp2Date(timeMilStr, "yyyy-MM-dd"));
    }


    public static String timeStamp2Date(String time, String format) {
        Long timeLong = Long.parseLong(time);
        SimpleDateFormat sdf = new SimpleDateFormat(format);//要转换的时间格式
        Date date;
        try {
            date = sdf.parse(sdf.format(timeLong));
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
