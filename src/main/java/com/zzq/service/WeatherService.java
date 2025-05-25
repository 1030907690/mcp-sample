package com.zzq.service;


import org.springframework.ai.autoconfigure.mcp.server.McpServerProperties;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @description: 天气服务类
 * @author: zzq
 * @date: 5/25/2025 3:47 PM
 */
@Service
public class WeatherService {




    @Tool(description = "通过城市名字获取温度[伪]")
    public String getWeather(@ToolParam(description = "城市名称") String city) throws UnsupportedEncodingException {
        String deCity = new String(city.getBytes(), StandardCharsets.UTF_8);
        return deCity + "今天的温度是" + deCity.length();
    }
}
