package com.input4hua.PDruidTask.utils;

import java.io.File;

/**
 * Created by jiahua.hu on 2018/1/6.
 */
public class FileUtil {

    public static File parseFileUrl(String originPath) {
        File file = null;
        if(originPath.startsWith("/")){
            //absolutePath
            file = new File(originPath);
        }else{
            String basePath = System.getProperty("user.dir");
            String path = basePath + "/" + originPath;
            file = new File(path);
        }
        return file;
    }

}