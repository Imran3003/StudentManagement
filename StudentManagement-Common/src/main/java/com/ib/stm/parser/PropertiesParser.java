package com.ib.stm.parser;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * PropertiesParser.java
 *
 * @author Nandhakumar N (nandhakumarn@nmsworks.co.in)
 * @module in.co.nmsworks.wisdom.core5g.dataprocessing.commons
 * @project 5g-core
 * @created Oct 06, 2023
 */

@Service
public class PropertiesParser
{
    @Value("${fe.server.port}")
    private String fePort;

    @Value("${fe.server.host}")
    private String feHost;

    @Value("${be.server.port}")
    private String bePort;

    @Value("${be.server.host}")
    private String beHost;

    public String getFeBaseURL()
    {
        return "http://" + feHost + ":" + fePort;
    }

    public String getBeBaseURL()
    {
        return "http://" + beHost + ":" + bePort;
    }
}
