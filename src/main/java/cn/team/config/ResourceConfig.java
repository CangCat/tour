package cn.team.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    //图片保存路径
    public static final String PIC_PATH = "/profile/";
    @Autowired
    MyConfig config;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** 图片传路径 */
    	System.out.println(config.getProfile());
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + config.getProfile());

    }
}
