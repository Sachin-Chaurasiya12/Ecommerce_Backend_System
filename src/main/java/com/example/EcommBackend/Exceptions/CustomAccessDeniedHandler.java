package com.example.EcommBackend.Exceptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomAccessDeniedHandler implements AccessDeniedHandler{

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException, ServletException {
        
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);

            Map<String,Object> map = new HashMap<>();

            map.put("status", 403);
            map.put("error", "Access denied");
            map.put("message", "You do not have permission to access this resource.");

            response.setContentType("application/json");

            new ObjectMapper().writeValue(response.getOutputStream(), map);
    }
    
}
