package com.example.sd_41.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

	//Cấu hình cho file ảnh
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/resources/**")
          .addResourceLocations("/resources/");	
        registry
        .addResourceHandler("/upload/**")
        .addResourceLocations("/upload/");
    }


    //Todo code quên mật khẩu khách hàng



    //Todo code phân quyền

}
