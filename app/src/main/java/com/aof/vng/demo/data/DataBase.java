package com.aof.vng.demo.data;

import java.util.HashMap;

public class DataBase {

    public static final int TYPE_ICON = 1001;
    public static final int TYPE_BG_IMAGE = 1002;
    public static final int TYPE_VOICE = 1003;
    public static final int TYPE_BG_MUSIC = 1004;
    public static final int TYPE_TTF = 1005;

    private HashMap<String, String> icoMap;
    private HashMap<String, String> bgiMap;
    private HashMap<String, String> ttfMap;
    private HashMap<String, String> voiMap;
    private HashMap<String, String> bgmMap;

    public void initiate() {

        // 初始化图标索引表
        icoMap = new HashMap<>();
        icoMap.put("一同", "image/name/cn_name_all.png");
        icoMap.put("广播", "image/name/cn_name_announce.png");
        icoMap.put("红豆", "image/name/cn_name_azuki.png");
        icoMap.put("巧克力", "image/name/cn_name_chocola.png");
        icoMap.put("巧克力&椰子", "image/name/cn_name_chocola_coconut.png");
        icoMap.put("巧克力&香草", "image/name/cn_name_chocola_vanilla.png");
        icoMap.put("桂", "image/name/cn_name_cinnamon.png");
        icoMap.put("椰子", "image/name/cn_name_coconut.png");
        icoMap.put("纸箱", "image/name/cn_name_danboar.png");
        icoMap.put("纸箱2", "image/name/cn_name_danboar_02.png");
        icoMap.put("母亲", "image/name/cn_name_hahaoya.png");
        icoMap.put("虫子", "image/name/cn_name_hamushi.png");
        icoMap.put("搬家公司", "image/name/cn_name_hikkoshi.png");
        icoMap.put("嘉祥", "image/name/cn_name_kasyo.png");
        icoMap.put("警察", "image/name/cn_name_keisatsu.png");
        icoMap.put("枫", "image/name/cn_name_maple.png");
        icoMap.put("座位上的猫", "image/name/cn_name_neko.png");
        icoMap.put("女孩", "image/name/cn_name_onnanoko.png");
        icoMap.put("时雨", "image/name/cn_name_shigure.png");
        icoMap.put("时雨？", "image/name/cn_name_shigure_.png");
        icoMap.put("工作人员", "image/name/cn_name_staff.png");
        // missing element : cn_name_syokki
        icoMap.put("店员", "image/name/cn_name_tenin.png");
        icoMap.put("店主", "image/name/cn_name_tensyu.png");
        icoMap.put("香草", "image/name/cn_name_vanilla.png");
        icoMap.put("女性客人", "image/name/cn_name_zyosei.png");
        icoMap.put("女性客人A", "image/name/cn_name_zyosei_a.png");
        icoMap.put("女性客人B", "image/name/cn_name_zyosei_b.png");

        //初始化背景索引表
        bgiMap = new HashMap<>();
        bgiMap.put("店铺外观_白天_开店后", "bgimage/店舗外観_昼.png");
        bgiMap.put("店铺外观_白天_开店前", "bgimage/店舗外観_昼開店前.png");
        bgiMap.put("店铺外观_傍晚_开店后", "bgimage/店舗外観_夕方.png");
        bgiMap.put("店铺外观_傍晚_开店前", "bgimage/店舗外観_夕方開店前.png");
        bgiMap.put("店铺外观_晚上_熄灯_开店后", "bgimage/店舗外観_消灯.png");
        bgiMap.put("店铺外观_晚上_熄灯_开店前", "bgimage/店舗外観_消灯開店前.png");
        bgiMap.put("店铺外观_晚上_开店后", "bgimage/店舗外観_夜.png");
        bgiMap.put("店铺外观_晚上_开店前", "bgimage/店舗外観_夜開店前.png");
        bgiMap.put("天空_傍晚", "bgimage/空_夕方.png");
        bgiMap.put("天空_夜晚", "bgimage/空_夜.png");
        bgiMap.put("天空_白天", "bgimage/空_昼.png");

        //初始化字体索引表
        ttfMap = new HashMap<>();
        ttfMap.put("MotoyaMaru", "ttf/MTLmr3m.ttf");
        ttfMap.put("MotoyaLCedar", "ttf/MTLc3m.ttf");//GenJyuuGothicX-Bold.ttf
        ttfMap.put("GenJyuuGothicX-Bold", "ttf/GenJyuuGothicX-Bold.ttf");
        ttfMap.put("GenJyuuGothicX-Heavy", "ttf/GenJyuuGothicX-Heavy.ttf");
        ttfMap.put("GenJyuuGothicX-Medium", "ttf/GenJyuuGothicX-Medium.ttf");


    }

    public String getPath(int type, String str) {
        HashMap<String, String> targetMap = null;
        switch (type){
            case TYPE_BG_IMAGE:
                targetMap = bgiMap;
                break;
            case TYPE_BG_MUSIC:
                targetMap = bgmMap;
                break;
            case TYPE_ICON:
                targetMap = icoMap;
                break;
            case TYPE_VOICE:
                targetMap = voiMap;
                break;
            case TYPE_TTF:
                targetMap= ttfMap;
                break;
            default:
                return null;
        }
        return targetMap.get(str);
    }

}
