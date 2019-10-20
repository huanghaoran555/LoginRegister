package com.zking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfiguration extends WebMvcConfigurerAdapter {
//注册拦截器
    @Override
  public void addInterceptors(InterceptorRegistry registry){
      //添加拦截的请求，并排除几个不拦截的请求
        super.addInterceptors(registry);
      registry.addInterceptor(new LoginHandlerInterceptor() ).addPathPatterns("/**")
              .excludePathPatterns("/Home.html","/auth","/auth.html","/reg","/reg.html","/static/**");
  }
  @Override
  /**
   * 排除不拦截的样式路径
   */
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
  }

}
