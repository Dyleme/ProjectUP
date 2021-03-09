package Dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDao<T> extends AbstractDao<T> {

    @Override
    public void write(List<T> list) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), list);
    }
//
//    @Override
//    public void write(T object) throws IOException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.enable(SerializationFeature.INDENT_OUTPUT);
//
//        JsonNode node = mapper.valueToTree(object);
//
//            File jsonFile = new File(fileName);
//            JsonNode tmp = mapper.readTree(jsonFile);
//            if(tmp.isMissingNode()) {
//                mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, node);
//            } else {
//                ArrayNode root = (ArrayNode) tmp;
//                root.add(node);
//                mapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, root);
//            }
//
//    }

    @Override
    public List<T> read() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), new TypeReference<List<T>>() {});
    }

    public JsonDao(String fileName){
        super(fileName);
    }
}
