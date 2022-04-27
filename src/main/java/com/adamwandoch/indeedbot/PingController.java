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
    private final List<String> urlList = Arrays.asList("http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotvirginia-env.eba-4sf63gic.us-east-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotohio-env.eba-niszmpdp.us-east-2.elasticbeanstalk.com/ping",
                                                 "http://indeedbotcalifornia-env.eba-mhqpsqdy.us-west-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotoregon-env.eba-daaqgedz.us-west-2.elasticbeanstalk.com/ping",
                                                 "http://indeedbottokyo-env.eba-xmsejbh8.ap-northeast-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotireland-env.eba-cckhqftf.eu-west-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotcapetown-env.eba-md74kpmh.af-south-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbothongkong-env.eba-swjz6jbt.ap-east-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotmumbai-env.eba-k83bwiia.ap-south-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotosaka-env.eba-7cpbujbn.ap-northeast-3.elasticbeanstalk.com/ping",
                                                 "http://indeedbotseoul-env.eba-e5uicp37.ap-northeast-2.elasticbeanstalk.com/ping",
                                                 "http://indeedbotsingapore-env.eba-5m52rter.ap-southeast-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotsydney-env.eba-rp7xuxxm.ap-southeast-2.elasticbeanstalk.com/ping",
                                                 "http://indeedbotcanada-env.eba-jxu6x6ue.ca-central-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotfrankfurt-env.eba-qpbqcwxw.eu-central-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotlondon-env.eba-cevpj4x9.eu-west-2.elasticbeanstalk.com/ping",
                                                 "http://indeedbotmilan-env.eba-emvxupbh.eu-south-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotparis-env.eba-qdcmu7p2.eu-west-3.elasticbeanstalk.com/ping",
                                                 "http://indeedbotstockholm-env.eba-y6zw9bvv.eu-north-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotbahrain-env.eba-tzhqvrds.me-south-1.elasticbeanstalk.com/ping",
                                                 "http://indeedbotsaopaulo-env.eba-3kg9h3bq.sa-east-1.elasticbeanstalk.com/ping"
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
