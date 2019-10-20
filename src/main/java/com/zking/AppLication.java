package com.zking;

import org.apache.coyote.http11.AbstractHttp11JsseProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

/**
 * Created by Administrator on 2017/5/5.
 */

@SpringBootApplication
public class AppLication {
    public static void main(String[] args) {
        SpringApplication.run(AppLication.class, args);
    }
//最大文件上传连接重置问题处理
    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatEmbedded(){
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector ->{
           if ((connector.getProtocolHandler() instanceof AbstractHttp11JsseProtocol<?>)){
               ((AbstractHttp11JsseProtocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
           }
        });
        return tomcat;
    }
}
