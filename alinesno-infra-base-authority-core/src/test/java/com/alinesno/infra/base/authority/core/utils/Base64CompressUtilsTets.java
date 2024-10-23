package com.alinesno.infra.base.authority.core.utils;

import cn.hutool.core.io.FileTypeUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import org.junit.Test;

import java.io.File;

public class Base64CompressUtilsTets {

    @Test
    public void test() throws Exception {
        //在线图片地址
        String imgPath = "https://pss.bdstatic.com/static/superman/img/logo/logo_redBlue-0a7c20fcaa.png";

        //在线压缩
        String ste2= ImageUtils.getImageAsBase64(imgPath) ;
        System.out.println(ste2);

        imgPath = "http://data.linesno.com/logo_2.png" ;

        //在线压缩
        ste2= ImageUtils.getImageAsBase64(imgPath) ;
        System.out.println(ste2);
    }

    @Test
    public void test2() throws Exception {
        String imgPath = "https://pss.bdstatic.com/static/superman/img/logo/logo_redBlue-0a7c20fcaa.png";

        String de = ImageUtils.downloadImage(imgPath) ;
        System.out.println(de);

        File file = FileUtil.file(de);
        String type = FileTypeUtil.getType(file);

        //输出 jpg则说明确实为jpg文件
        Console.log(type);
    }

}
