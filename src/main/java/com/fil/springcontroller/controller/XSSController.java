package com.fil.springcontroller.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xss")
public class XSSController {
    @RequestMapping("/unsafe")
    public String unsafe(@RequestParam("name") String name) {
        return "<html><body>Hello " + name + "!</body></html>";
    }

    @RequestMapping("/safe")
    public String safe(String input) {
        return "<html><body><h1>" + escapeHtml(input) + "</h1></body></html>";
    }

    private static String escapeHtml(String text) {
        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#x27;");
    }

}
