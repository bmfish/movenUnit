package cbj.cpt;

import com.mysql.jdbc.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class YingCptReaderTest {

    static String[] preTableNames = {"bdp.", "finereport."};

    public static void main(String[] args) throws Exception {
        String projectFilePath = "D:\\cpt";
        File projectFile = new File(projectFilePath);
        readFile(projectFile);
    }

    public static void readFile(File file) throws Exception {
        if (file.isDirectory()) {
            File files[] = file.listFiles();
            for (File subFile : files) {
                readFile(subFile);
            }
        } else {
            readCpt(file);
        }

    }

    public static void readCpt(File file) throws Exception {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file.getPath())); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = br.readLine();
        while (line != null) {
            line = br.readLine(); // 一次读入一行数据
            if (!StringUtils.isNullOrEmpty(line)) {
                for (String preTableName : preTableNames) {
                    if (line.contains(preTableName)) {
                        readTableName(line, preTableName, file.getName());
                    }
                }
            }
        }
    }

    public static StringBuffer readTableName(String line, String preName, String fileName) {
        StringBuffer strBuf = new StringBuffer();
        while (line.contains(preName)) {
            line = line.substring(line.indexOf(preName), line.length());
            String tableName = line;
            if (line.contains(" ")) {
                tableName = line.substring(0, line.indexOf(" "));
            }
            line = line.replace(preName, "");
            strBuf.append(tableName);
            System.out.println(tableName + "            " + fileName);
        }
        ;
        return strBuf;
    }
}
