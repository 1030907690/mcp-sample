package com.zzq.config;


import com.zzq.service.WeatherService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 注册服务提供商
 * @author: zzq
 * @date: 5/25/2025 3:58 PM
 */
@Configuration
public class ProviderRegister {

    @Bean
    public ToolCallbackProvider weatherTools(WeatherService weatherService){
        return MethodToolCallbackProvider.builder().toolObjects(weatherService).build();
    }
}
