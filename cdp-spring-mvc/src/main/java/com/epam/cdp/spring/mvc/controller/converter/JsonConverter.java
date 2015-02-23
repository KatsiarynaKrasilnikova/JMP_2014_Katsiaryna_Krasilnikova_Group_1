package com.epam.cdp.spring.mvc.controller.converter;

import com.epam.cdp.hibernate.model.BaseEntity;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.io.IOException;
import java.util.List;

/**
 * Created by Ilya_Kukushkin on 2/23/2015
 */
public class JsonConverter implements Converter<List<? extends BaseEntity<Long>>, String> {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convert(List<? extends BaseEntity<Long>> source) {
        String json = null;
        try {
            json =  mapper.writeValueAsString(source);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return json;
    }
}
