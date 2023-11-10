package concepts.poc;

import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.apache.commons.lang3.StringUtils;

/**
 * @author raag
 */

public class POC {

    public static void main(String[] args) throws Exception {
        POC.jsonToDtoWithInnerChecker();
    }

    private static void jsonToDtoWithInnerChecker() throws Exception {
        JsonToDTOWithInner jsonToDTOWithInner = new JsonToDTOWithInner();
        jsonToDTOWithInner.setExclusionList(Arrays.asList("a","b"));
        jsonToDTOWithInner.setSkipDatatypeCheckColumns(Collections.singletonList("c"));

        jsonToDTOWithInner.setInclusionList(Arrays.asList(new JsonToDTOWithInner.MapperColumn("d","dT", 0), new JsonToDTOWithInner.MapperColumn("e","e",2.0), new JsonToDTOWithInner.MapperColumn("f","f_t",1.0)));
        jsonToDTOWithInner.setIdentifyingColumns(Arrays.asList(new JsonToDTOWithInner.MapperColumn("d","dT", 0)));

        ObjectWriter objectWriter = new ObjectMapper().writer();
        String json = objectWriter.writeValueAsString(jsonToDTOWithInner);

        System.out.println(json);

        ObjectMapper m = new ObjectMapper();
//        String jsonNew = "{\"exclusionList\":[\"a\",\"b\"],\"skipDatatypeCheckColumns\":[\"c\"],\"identifyingColumns\":[{\"source\":\"d\",\"target\":\"dT\"}],\"inclusionList\":[{\"source\":\"d\",\"target\":\"dT\"},{\"source\":\"e\",\"threshold\":2},{\"source\":\"f\",\"target\":\"f_t\"}]}";
        String jsonNew = "{\"exclusionList\":[\"a\",\"b\"],\"skipDatatypeCheckColumns\":[\"c\"],\"identifyingColumns\":[{\"source\":\"d\",\"target\":\"dT\",\"threshold\":0}],\"inclusionList\":[{\"source\":\"\"},{\"target\":\"e\",\"threshold\":2},{\"source\":\"f\",\"target\":\"f_t\",\"threshold\":1}]}";

//        JsonToDTOWithInner js = m.readValue(jsonNew, jsonToDTOWithInner.getClass());
        JsonToDTOWithInner js = convert(jsonNew, jsonToDTOWithInner.getClass());
        System.out.println(js);
//        validateJsonDTO(js);
    }

    private static <T> T convert(String json, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        return m.readValue(json, clazz);
    }

    private static void validateJsonDTO(JsonToDTOWithInner jsonToDTOWithInner) throws Exception {
        if(jsonToDTOWithInner.getIdentifyingColumns() == null || jsonToDTOWithInner.getIdentifyingColumns().isEmpty()) {
            throw new Exception("Null Inclusion");
        }
        if(jsonToDTOWithInner.getInclusionList() !=null) {
            for (JsonToDTOWithInner.MapperColumn mapperColumn : jsonToDTOWithInner.getInclusionList()) {
                if(StringUtils.isBlank(mapperColumn.getSource())) {
                    throw new Exception("Null source");
                }
            }
        }
    }
 }
