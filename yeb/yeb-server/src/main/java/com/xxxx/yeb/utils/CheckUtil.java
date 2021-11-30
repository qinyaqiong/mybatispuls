package com.xxxx.yeb.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  验证邮箱和手机号格式
 */
public class CheckUtil {

    /**
     * 邮箱校验
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        try {
            // 正常邮箱
            // /^\w+((-\w)|(\.\w))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/
//                ^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$
            // 含有特殊 字符的 个人邮箱 和 正常邮箱
            // js: 个人邮箱
            // /^[\-!#\$%&'\*\+\\\.\/0-9=\?A-Z\^_`a-z{|}~]+@[\-!#\$%&'\*\+\\\.\/0-9=\?A-Z\^_`a-z{|}~]+(\.[\-!#\$%&'\*\+\\\.\/0-9=\?A-Z\^_`a-z{|}~]+)+$/

            // java：个人邮箱
            // [\\w.\\\\+\\-\\*\\/\\=\\`\\~\\!\\#\\$\\%\\^\\&\\*\\{\\}\\|\\'\\_\\?]+@[\\w.\\\\+\\-\\*\\/\\=\\`\\~\\!\\#\\$\\%\\^\\&\\*\\{\\}\\|\\'\\_\\?]+\\.[\\w.\\\\+\\-\\*\\/\\=\\`\\~\\!\\#\\$\\%\\^\\&\\*\\{\\}\\|\\'\\_\\?]+

            // 范围 更广的 邮箱验证 “/^[^@]+@.+\\..+$/”
            final String pattern1 = "[\\w.\\\\+\\-\\*\\/\\=\\`\\~\\!\\#\\$\\%\\^\\&\\*\\{\\}\\|\\'\\_\\?]+@[\\w.\\\\+\\-\\*\\/\\=\\`\\~\\!\\#\\$\\%\\^\\&\\*\\{\\}\\|\\'\\_\\?]+\\.[\\w.\\\\+\\-\\*\\/\\=\\`\\~\\!\\#\\$\\%\\^\\&\\*\\{\\}\\|\\'\\_\\?]+";

            final Pattern pattern = Pattern.compile(pattern1);
            final Matcher mat = pattern.matcher(email);
            return mat.matches();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * CJYFIXME搜集号段时间:2017-11-28(这个之后的请自行添加) 手机号:目前全国有27种手机号段。
     * 移动有19个号段：134（0-8）、135、136、137、138、139、147(147（数据卡）)、148(物联网)、150、151、152、
     * 157、158、159、178、182、183、184、187、188、198。
     * 联通有11种号段：130、131、132、--145(数据卡)--、146(物联网)、155、156、166、171、175、176、185、
     * 186。 电信有7个号段：133、--1349--、149、153、173、177、180、181、189、199。 虚拟运营商:
     * (1).移动:1703、1705、1706 (2).联通:1704、1707、1708、1709、171
     * (3).电信:1700、1701、1702 卫星通信:1349
     * <p>
     * 工业和信息化部公示了2017年第10批“电信网码号资源使用证书”颁发结果，批准同意部分单位提出的电信网码号资源有关申请，
     * 其中三大运营商均获得相关物联网号段。 移动: (1).198(0-9)号段(公众移动通信网号) (2).148(0-9)号段(物联网业务专用号段)
     * (3).1440(0-9)号段(物联网网号) (4).(460)13(移动网络识别码) 联通: (1).166(0-9)号段(公众移动通信网号)
     * (2).146(0-9)号段(物联网业务专用号段) 电信: (1).1740(0-5)号段(卫星移动通信业务号)、
     * (2).199(0-9)号段(公众移动通信网号)、 (3).1410(0-9)号段(物联网网号)、 (4).(460)59(移动网络识别码)
     * 由于物联网号段一般用在家用家具上，所以这里不考虑物联网号段,物联网号码的总位数是13或者14还没搞清楚
     * =========================================================================
     * ======================
     * 总结一下:虚拟运营商、数据卡、物联网、卫星通信、移动网络识别码都不作为正常使用的电话号码,所以需要验证的手机号如下:
     * 130、131、132、133、134(0-8)、135、136、137、138、139 149
     * 150、151、152、153、155、156、157、158、159 166、 173、175、176、177、178、
     * 180、181、182、183、184、185、186、187、188、189 198、199
     */
    private static final String REGEX_MOBILE = "(134[0-8]\\d{7})" + "|(" + "((13([0-3]|[5-9]))" + "|149"
            + "|15([0-3]|[5-9])" + "|166" + "|17(3|[5-8])" + "|18[0-9]" + "|19[8-9]" + ")" + "\\d{8}" + ")";

    /**
     * 判断是否是手机号
     *
     * @param tel
     *            手机号
     * @return boolean true:是 false:否
     */
    public static boolean isMobile(String tel) {
        return Pattern.matches(REGEX_MOBILE, tel);
    }

    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            return isMatch;
        }
    }

}
