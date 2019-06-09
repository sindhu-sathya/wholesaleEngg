/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.utils;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * GSCON data converter Utility file.
 *
 */
public class JsonUtils
{
   private static final String DEFAULT_DATE_FORMAT = "dd-MM-yyyy";

   public static String toJson(Object obj, final String dateFormat, final boolean isPrettyPrint)
   {
      GsonBuilder builder = new GsonBuilder();
      builder.setDateFormat(dateFormat);
      builder.serializeNulls();
      if (isPrettyPrint)
      {
         builder.setPrettyPrinting();
      }
      return builder.create().toJson(obj);
   }

   public static String prettyPrint(Object obj, final String dateFormat)
   {
      return toJson(obj, dateFormat, true);
   }

   public static String prettyPrint(Object obj)
   {
      return toJson(obj, DEFAULT_DATE_FORMAT, true);
   }

   public static String toJson(Object obj, final String dateFormat)
   {
      return toJson(obj, dateFormat, false);
   }

   public static String toJson(Object obj)
   {
      return toJson(obj, DEFAULT_DATE_FORMAT, false);
   }

   @SuppressWarnings("unchecked")
   public static Map<String, String> toMap(String json)
   {
      Gson gson = new Gson();
      Map<String, String> map = new HashMap<String, String>();
      map = (Map<String, String>) gson.fromJson(json, map.getClass());
      return map;
   }

}
