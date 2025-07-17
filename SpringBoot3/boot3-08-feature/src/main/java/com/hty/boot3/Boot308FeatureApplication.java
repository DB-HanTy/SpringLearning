package com.hty.boot3;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Boot308FeatureApplication {

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(Boot308FeatureApplication.class);
//
//        app.setBannerMode(Banner.Mode.OFF);
//
//        app.run(args);

        new SpringApplicationBuilder()
                .main(Boot308FeatureApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
                .sources(Boot308FeatureApplication.class)
                .run(args);
    }

}
