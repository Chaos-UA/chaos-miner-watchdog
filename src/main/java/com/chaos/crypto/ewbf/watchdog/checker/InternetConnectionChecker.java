package com.chaos.crypto.ewbf.watchdog.checker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;

@Component
public class InternetConnectionChecker implements MinerChecker {

    private static final Logger LOGGER = LoggerFactory.getLogger(InternetConnectionChecker.class);

    @Autowired
    private RestTemplate restTemplate ;

    @Override
    public String getName() {
        return "Internet connection checker";
    }

    @Override
    public String detectIssue() {
        String pingError = pingPublicGoogleDns();
        if (pingError != null) {
            return pingError;
        }

        /*
        String webPageDownloadError = downloadWebPage();
        if (webPageDownloadError != null) {
            return webPageDownloadError;

        */

        return null;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    private String pingPublicGoogleDns() {
        try {
            InetAddress inetAddress = InetAddress.getByAddress(new byte[]{8, 8, 8, 8});
            if (!inetAddress.isReachable(5000)) {
                return "Connection error. 8.8.8.8 is not reachable";
            }
            return null;
        } catch (Exception e) {
            String error = "Connection error. Failed to ping 8.8.8.8";
            LOGGER.error(error, e);
            return error;
        }
    }

    private String downloadWebPage() {
        String webPageUrl = "https://www.whatismyip.com";
        try {
            ResponseEntity<String> result = restTemplate.getForEntity(webPageUrl, String.class);
            if (result.getStatusCode() != HttpStatus.OK) {
                return String.format("Failed to download web page '%s', invalid status code: %s", webPageUrl, result.getStatusCodeValue());
            }
            return null;
        } catch (Exception e) {
            String error = String.format("Failed to download web page '%s', exception: %s", webPageUrl, e);
            LOGGER.error(error, e);
            return error;
        }
    }
}
