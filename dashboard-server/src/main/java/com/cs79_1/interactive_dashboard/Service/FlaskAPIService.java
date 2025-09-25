package com.cs79_1.interactive_dashboard.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FlaskAPIService {
    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://heatmap";
}
