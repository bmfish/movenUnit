package cbj.wc;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class WcDataHandler {

    public static void main(String[] args) throws Exception {

        String filePath = "E:\\360MoveData\\Users\\zyc\\Desktop\\wacai\\wacai\\wacai2209-2302.txt";
        File file = new File(filePath);

        //  JSONObject jsonObject = JSONObject.parseObject(fileStr, JSONObject.class);
        Map allMap = JSONObject.parseObject(FileUtils.readFileToString(file), Map.class);
        Map<String, String> dataDetial = convertJsonObjectToMap((JSONObject) allMap.get("data"));

        List<JSONObject> list = JSONObject.parseArray(dataDetial.get("dailyItems"), JSONObject.class);

        for (JSONObject dailyItem : list) {
            saveDailyData(convertJsonObjectToMap(dailyItem));

        }
    }

    private static Map<String, String> convertJsonObjectToMap(JSONObject obj) {
        Map<String, String> params = JSONObject.parseObject(obj.toJSONString(), new TypeReference<Map<String, String>>() {
        });
        return params;
    }

    private static void saveDailyData(Map<String, String> dailyItemMap) throws Exception {
        String timeMilStr = dailyItemMap.get("date");
        Long timeMinllis = Long.parseLong(timeMilStr);

        String income = dailyItemMap.get("income");
        String incomeAmount = dailyItemMap.get("incomeAmount");
        String outgo = dailyItemMap.get("outgo");
        String outgoAmount = dailyItemMap.get("outgoAmount");
        int flowCount = 0;
        List<JSONObject> flowList = JSONObject.parseArray(dailyItemMap.get("flowList"), JSONObject.class);
        if (null != flowList) {
            flowCount = flowList.size();
        }
        String insertSql = "insert into  t_wc_daily (date_id,in_come,in_come_amount,out_go,out_go_amount,flow_size,date) "
                + "values ("
                + timeMinllis + ",'"
                + income + "',"
                + incomeAmount + ",'"
                + outgo + "',"
                + outgoAmount + ","
                + flowCount + ",'"
                + timeStamp2Date(timeMilStr, "yyyy-MM-dd") + "');";

        DBUtil.save(insertSql);
        System.out.println(timeStamp2Date(timeMilStr, "yyyy-MM-dd"));

        for (JSONObject jsonObject : flowList) {
            Map<String, String> dailyDetailMap = convertJsonObjectToMap(jsonObject);

            String comment = dailyDetailMap.get("comment");
            String projectName = dailyDetailMap.get("projectName");
            String categoryName = dailyDetailMap.get("categoryName");
            String createStr = dailyDetailMap.get("bizTime");
            String recType = dailyDetailMap.get("recType");
            String recStr = "收入";
            if (recType.contains("1")) {
                recStr = "支出";
            }
            String insertDetail = "insert into  t_wc_daily_detail (date_id,amount,rec_type,rec_com," +
                    " comment,project_name,category_name,type,create_time) "
                    + "values ("
                    + timeMinllis + ","
                    + dailyDetailMap.get("amount") + ","
                    + recType + ",'"
                    + recStr + "','"
                    + comment + "','"
                    + projectName + "','"
                    + categoryName + "','"
                    + dailyDetailMap.get("type") + "','"
                    + timeStamp2Date(createStr, "yyyy-MM-dd HH:mm:ss") + "');";
            try {
                DBUtil.save(insertDetail);
            }catch (Exception e){
                e.printStackTrace();
                System.out.println(insertDetail);
            }

        }
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
