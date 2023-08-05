package com.Digital.Digital;

import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zaxxer.hikari.HikariDataSource;

@Component
public class MyAppShutdownHook {

    @Autowired
    private HikariDataSource dataSource;

    @PreDestroy
    public void onDestroy() {
        if (dataSource != null) {
            dataSource.close();
        }
    }
}