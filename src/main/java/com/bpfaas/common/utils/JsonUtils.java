/**
* Copyright (c) 2020 Copyright bp All Rights Reserved.
* Author: lipengxiang
* Date: 2020-07-11 12:07
* Desc: 
*/
package com.bpfaas.common.utils;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.bpfaas.common.exception.BpJsonException;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class JsonUtils {

  private static ObjectMapper objectMapper;

  public static ObjectMapper getObjectMapper() {
    return objectMapper;
  }

  static {
    // object mapper
    objectMapper = new ObjectMapper();

    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    objectMapper.setSerializationInclusion(Include.ALWAYS);
    // objectMapper.setDefaultPropertyInclusion(Include.ALWAYS);
    objectMapper.setDefaultPropertyInclusion(Include.NON_NULL);
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.PUBLIC_ONLY);
    // objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
    // ObjectMapper.DefaultTyping.NON_FINAL);

    // //设置null值为""
    // objectMapper.getSerializerProvider().setNullValueSerializer(new
    // JsonSerializer<Object>(){
    // @Override
    // public void serialize(Object value, JsonGenerator gen, SerializerProvider
    // serializers) throws IOException, JsonProcessingException {
    // gen.writeString("");
    // }
    // });

    // date.
    objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    SimpleDateFormat sdFmt = new SimpleDateFormat(DateUtils.DEFAULT_FORMAT);
    objectMapper.setTimeZone(TimeZone.getTimeZone(DateUtils.DEFAULT_TIMEZONE_ID));
    objectMapper.setDateFormat(sdFmt);

    // @JsonFormat -> @DateTimeFormat -> @jsonFormatTime -> global format.
    // this.objectMapper.setAnnotationIntrospector(jacksonAnnotationIntrospector());

    // long -> string
    SimpleModule simpleModule = new SimpleModule();
    simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
    simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
    simpleModule.addSerializer(BigDecimal.class, ToStringSerializer.instance);
    simpleModule.addSerializer(BigInteger.class, ToStringSerializer.instance);
    simpleModule.addSerializer(Float.class, JsonFloatSerializer.instance);
    simpleModule.addSerializer(Float.TYPE, JsonFloatSerializer.instance);
    simpleModule.addSerializer(Double.class, JsonFloatSerializer.instance);
    simpleModule.addSerializer(Double.TYPE, JsonFloatSerializer.instance);
    objectMapper.registerModule(simpleModule);
  }

  /**
   * 解析json字符串.
   * <pre>
   * <code>
   *  
   * Object obj = JsonUtils.parse("{}"); 
   * 
   * </code>
   * </pre>
   * 
   * @param text json字符串
   * @return 返回Object类型的对象.
   * @throws BpJsonException 无法解析或无法构造json时出错.
   */
  public static Object parse(String text) throws BpJsonException {
    try {
      return objectMapper.readValue(text, Object.class);
    } catch (JsonParseException ex) {
      throw new BpJsonException(ex);
    } catch (JsonMappingException ex) {
      throw new BpJsonException(ex);
    } catch (IOException ex) {
      throw new BpJsonException(ex);
    }
  }

  /**
   * 解析json字符串.
   * <pre>
   * <code>
   *  
   * DemoBean obj = JsonUtils.parse("{}", DemoBean.class);
   * 
   * </code>
   * </pre>
   * 
   * @param <T>  泛型类型; 用于接受一个进行泛型转换的类.
   * @param text 要解析的json字符串
   * @param valueType 泛型类型是模板T的泛型信息.
   * @return 返回指定类型的对象.
   * @throws BpJsonException 无法解析或无法构造json时出错.
   */
  public static <T> T parse(String text, Class<T> valueType) throws BpJsonException {
    try {
      return objectMapper.readValue(text, valueType);
    } catch (JsonParseException ex) {
      throw new BpJsonException(ex);
    } catch (JsonMappingException ex) {
      throw new BpJsonException(ex);
    } catch (IOException ex) {
      throw new BpJsonException(ex);
    }
  }

  /**
   * 解析json字符串. 并返回指定泛型类型
   * <pre>
   * <code>
   * 
   * Msg&lt;Object&gt; t = new Msg&lt;Object&gt;(); 
   * Msg&lt;Object&gt; obj = JsonUtils.parse("{}",
   *                             (ParameterizedType)t.getClass().getGenericSuperclass()); 
   * </code>
   * </pre>
   * 
   * @param <T>  泛型类型; 用于接受一个进行泛型转换的类.
   * @param text 要解析的json字符串
   * @param valueType 泛型类型是模板T的泛型信息.
   * @return 返回指定泛型类型的对象.
   * @throws BpJsonException 无法解析或无法构造json时出错.
   */
  public static <T> T parse(String text, final ParameterizedType valueType) throws BpJsonException {
    try {
      TypeReference<T> typeReference = new TypeReference<T>() {
        @Override
        public Type getType() {
          return valueType;
        }
      };

      return objectMapper.readValue(text, typeReference);
    } catch (JsonParseException ex) {
      throw new BpJsonException(ex);
    } catch (JsonMappingException ex) {
      throw new BpJsonException(ex);
    } catch (IOException ex) {
      throw new BpJsonException(ex);
    }
  }

  /**
   * 将对象json化.
   * 
   * @param obj 要字符串化的对象
   * @return json字符串
   * @throws BpJsonException 无法解析或无法构造json时出错.
   */
  public static String stringify(Object obj) throws BpJsonException {
    try {
      return objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new BpJsonException(e);
    }
  }
}
