package com.github.x4096.validator.constants;


/**
 * @author 0x4096.peng@gmail.com
 * @project validator
 * @datetime 2020/4/17 22:41
 * @description 常量集
 * @readme
 */
public class ValidatorConstants {

    /**
     * 小写字母
     */
    public static final String CHAR_LOWERCASE = "^[a-z]+$";

    /**
     * 大写字母
     */
    public static final String CHAR_UPPERCASE = "^[A-Z]+$";

    /**
     * 大小写+数字
     */
    public static final String CHAR_NUM = "^[A-Za-z0-9]+$";


    /**
     * 邮箱
     */
    public static final String EMAIL_REGEX = "^[a-z0-9]([a-z0-9]*[-_\\.\\+]?[a-z0-9]+)*@([a-z0-9]*[-_]?[a-z0-9]+)+[\\.][a-z]{2,3}([\\.][a-z]{2,4})?$";

    /**
     * 汉字
     */
    public static final String CHINA_TEXT_REGEX = "[\\u4e00-\\u9fa5]+";

    /**
     * 中国姓名
     */
    public static final String CHINA_NAME_REGEX = "[\\u4E00-\\u9FA5\\uf900-\\ufa2d·s]{2,20}";

    /**
     * 手机号 简单校验 1字头＋10位数字即可
     */
    public static final String MOBILE_SIMPLE_REGEX = "^[1]\\d{10}$";

    /**
     * 手机号 电信
     */
    public static final String PHONE_CHINA_TELECOM_REGEX = "^1[3578][01379]\\d{8}$";

    /**
     * 手机号 联通
     */
    public static final String PHONE_CHINA_UNION_REGEX = "^1[34578][01256]\\d{8}$";

    /**
     * 手机号 电信
     */
    public static final String PHONE_CHINA_MOBILE_REGEX = "^(134[012345678]\\d{7}|1[34578][012356789]\\d{8})$";

    /**
     * IP地址 IPV4
     */
    public static final String IPV4_REGEX = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";

    /**
     * IP地址 IPV6
     */
    public static final String IPV6_REGEX = "([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)\\:([0-9a-f]+)";

    /**
     * 时间格式 yyyy-MM-dd
     */
    public static final String REGEX_YEAR_MONTH_DAY = "((\\d{2}(([02468][048])|([13579][26]))[\\-/\\s]?((((0?[13578])|(1[02]))[\\-/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-/\\s]?((((0?[13578])|(1[02]))[\\-/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";

    /**
     * 时间格式 yyyy-MM-dd hh:mm:ss
     */
    public static final String REGEX_YEAR_MONTH_DAY_H_M_S_12 = REGEX_YEAR_MONTH_DAY + "(\\s(((0[0-9])|([1][0-2])):([0-5]?[0-9])((\\s)|(:([0-5]?[0-9]))?)))?";

    /**
     * 时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String REGEX_YEAR_MONTH_DAY_H_M_S_24 = REGEX_YEAR_MONTH_DAY + "(\\s(((0[0-9])|([1-2][0-3])):([0-5]?[0-9])((\\s)|(:([0-5]?[0-9]))?)))?";

}
