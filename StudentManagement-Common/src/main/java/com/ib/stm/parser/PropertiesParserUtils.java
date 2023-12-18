package com.ib.stm.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * PropertiesInstance.java
 *
 * @author Nandhakumar N (nandhakumarn@nmsworks.co.in)
 * @module in.co.nmsworks.wisdom.core5g.dataprocessing.commons
 * @project 5g-core
 * @created Oct 06, 2023
 */

@Component
public class PropertiesParserUtils
{
    @Autowired
    private PropertiesParser propertiesParser1;

    private static PropertiesParser propertiesParser;

    @PostConstruct
    public void init()
    {
        propertiesParser = propertiesParser1;
    }

    public static PropertiesParser getPropertiesParserInstance()
    {
        return propertiesParser;
    }
}
