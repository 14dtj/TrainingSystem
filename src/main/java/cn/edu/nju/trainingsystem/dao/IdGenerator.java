package cn.edu.nju.trainingsystem.dao;

/**
 * Created by tjDu on 2017/3/6.
 * <p>
 * 自动生成编号
 */
public class IdGenerator {
    public static String generateId(int num, char head) {
        String number = num + "";
        String result = head + "";
        while (number.length() < 6) {
            number = '0' + number;
        }
        return result + number;
    }
}
