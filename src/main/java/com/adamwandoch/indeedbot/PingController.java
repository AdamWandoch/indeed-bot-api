package com.adamwandoch.indeedbot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * @author Adam Wandoch
 */

@RestController
public class PingController {
    private static final Logger LOG = LoggerFactory.getLogger(IndeedBotApplication.class);
    private final List<String> urlList = Arrays.asList("http://indeed-bot-api.herokuapp.com/ping",
                                                       "http://indeed-bot.herokuapp.com/ping");

    @GetMapping("/ping")
    public String ping() {
        return "PING SUCCESSFUL";
    }

    void pingAll() {
        //combines ping operations to multiple instances
        urlList.forEach(this::ping);
    }

    void ping(String url_string) {
        // prevents free instances from going to sleep by sending a ping request in a regular time interval
        LOG.info("PINGING URL : " + url_string);
        try {
            URL url = new URL(url_string);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
            String message = "";
            while (message != null) {
                message = inputStream.readLine();
                if (message != null) {
                    LOG.info("RESPONSE RECEIVED : " + message);
                }
            }
            inputStream.close();
        }
        catch (MalformedURLException e) {
            LOG.error("MALFORMED URL EXCEPTION : " + e.getMessage());
            e.printStackTrace();
        }
        catch (IOException e) {
            LOG.error("IOEXCEPTION EXCEPTION : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
