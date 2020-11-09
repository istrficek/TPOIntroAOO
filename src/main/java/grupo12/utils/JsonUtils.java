package grupo12.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class JsonUtils {
    public static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts an object to a Json String
     * @param obj the object to convert to Json
     * @return the Json String
     * @throws IOException
     */
    public static String toJson(Object obj) throws IOException{
        try{
            StringWriter stringWriter = new StringWriter();
            objectMapper.writeValue(stringWriter, obj);
            return stringWriter.toString();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Converts Json String to given object
     * @param json a Json String
     * @param c the class of the object to return
     * @return the parsed object which is an instance of the class passed
     * @throws IOException
     */
    public static <C> C parse(String json, Class<? extends  C> c) throws IOException {
        if(json == null)
            return  null;
        return  objectMapper.readValue(json, c);
    }



}
