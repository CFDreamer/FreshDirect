package com.yearjane.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 得到yyyy-MM-dd HH:dd:ss格式的日期
 * @author 陈小锋
 *
 */
public class CustomDateYMDHDSSerialize extends JsonSerializer<Date> {
	@Override
	public void serialize(Date arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:dd:ss");
		arg1.writeString(format.format(arg0));
		
	}

}
