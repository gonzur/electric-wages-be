package io.electricwages.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {
        // prepend all rest paths with /api
        pathMatchConfigurer
                .setPatternParser(new PathPatternParser())
                .addPathPrefix("/api", HandlerTypePredicate.forAnnotation(RestController.class));
    }
}
