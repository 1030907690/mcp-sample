package com.zzq;


import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.ServerParameters;
import io.modelcontextprotocol.client.transport.StdioClientTransport;
import io.modelcontextprotocol.spec.McpSchema;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zzq
 * @date: 5/25/2025 4:48 PM
 */
public class CommonTest extends McpSampleApplicationTests{


    @Test
    public void test() {

        ServerParameters serverParameters = new ServerParameters.Builder("java")
                .args("-jar", "D:\\work\\self\\mcp-sample\\target\\mcp-sample-0.0.1-SNAPSHOT.jar").build();
        McpSyncClient mcpSyncClient = McpClient.sync(new StdioClientTransport(serverParameters)).build();
        McpSchema.ListToolsResult toolsResult = mcpSyncClient.listTools();
        System.out.println("toolsResult:"+ toolsResult);
        mcpSyncClient.closeGracefully();
    }


    @Test
    public void get(){
        ServerParameters serverParameters = new ServerParameters.Builder("java")
                .args("-jar", "D:\\work\\self\\mcp-sample\\target\\mcp-sample-0.0.1-SNAPSHOT.jar").build();
        McpSyncClient mcpClient = McpClient.sync(new StdioClientTransport(serverParameters)).build();
        McpSchema.CallToolResult callToolResult = mcpClient.callTool(new McpSchema.CallToolRequest("getWeather", Map.of("city", "南京")));
        List<McpSchema.Content> content = callToolResult.content();

        System.out.println("content:" + content.get(0));
        mcpClient.closeGracefully();

    }

}
