package com.input4hua.PDruidTask.main;

import com.google.common.base.*;
import com.input4hua.PDruidTask.model.Demo;
import com.input4hua.PDruidTask.utils.FileUtil;
import com.input4hua.PDruidTask.utils.JsonUtil;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by jiahua.hu on 2018/1/6.
 */
public class SubmitTask {

    public static void main(String[] args) {
        String originSource= args[0];
        System.out.println("originSource["+originSource+"]");
        Preconditions.checkArgument(!Strings.isNullOrEmpty(originSource),"请传路径参数");
        Demo demo = null;
        if(originSource.startsWith("@")){
            //file
            demo = JsonUtil.readValue(FileUtil.parseFileUrl(originSource.substring(1)), Demo.class);
        }else{
            //json String
            demo = JsonUtil.readValue(originSource, Demo.class);
        }
        System.out.println(ReflectionToStringBuilder.toString(demo, ToStringStyle.MULTI_LINE_STYLE));
    }
}
