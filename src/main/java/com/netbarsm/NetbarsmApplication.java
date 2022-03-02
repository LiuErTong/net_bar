package com.netbarsm;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Log4j2
public class NetbarsmApplication {

    private static final String SERVER_SSL_KEY_STORE = "server.ssl.key-store";

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableEnvironment env = SpringApplication.run(NetbarsmApplication.class, args).getEnvironment();
        String protocol = "http";
        if (env.getProperty(SERVER_SSL_KEY_STORE) != null) {
            protocol = "https";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}" +
                        "\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port"),
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"));
    }

}
