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
    private final List<String> urlList = Arrays.asList("https://3hvy3ei8qx.eu-west-1.awsapprunner.com/ping",
                                                 "http://indeedbotvirginia-env.eba-4sf63gic.us-east-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotohio-env.eba-niszmpdp.us-east-2.elasticbeanstalk.com/ping",
                                                 "http://indeedbotcalifornia-env.eba-mhqpsqdy.us-west-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotoregon-env.eba-daaqgedz.us-west-2.elasticbeanstalk.com/ping",
                                                 "http://indeedbottokyo-env.eba-xmsejbh8.ap-northeast-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotireland-env.eba-cckhqftf.eu-west-1.elasticbeanstalk.com/ping"
            );

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
