package Dao;

import com.company.Rentable;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDao extends AbstractDao {

    @Override
    public void addToFile(List<Rentable> list) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), list);
    }

    @Override
    public void addToFile(Rentable rentable) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        JsonNode node = mapper.valueToTree(rentable);

            File xmlFile = new File(fileName);
            JsonNode tmp = mapper.readTree(xmlFile);
            if(tmp.isMissingNode()) {
                mapper.writerWithDefaultPrettyPrinter().writeValue(xmlFile, node);
            } else {
                ArrayNode root = (ArrayNode) tmp;
                root.add(node);
                mapper.writerWithDefaultPrettyPrinter().writeValue(xmlFile, root);
            }

    }

    @Override
    public List<Rentable> getFromFile() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(fileName), new TypeReference<List<Rentable>>() {});
    }

    public JsonDao(String fileName){
        super(fileName);
    }
}
