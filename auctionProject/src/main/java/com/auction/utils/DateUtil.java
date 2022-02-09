package com.auction.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil extends StdDeserializer<Date> {

    public DateUtil(){
        this((Class<?>) null);

    }

    protected DateUtil(Class<?> vc) {
        super(vc);
    }

    protected DateUtil(JavaType valueType) {
        super(valueType);
    }

    protected DateUtil(StdDeserializer<?> src) {
        super(src);
    }

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            return simpleDateFormat.parse(jsonParser.getText());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
