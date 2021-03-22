package Dao;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDao<T> extends AbstractDao<T> {

    private final Class<T> tClass;


    public JsonDao(String fileName, Class<T> clazz){
        super(fileName);
        tClass = clazz;
    }

    @Override
    public void write(List<T> list) throws IOException {
        log.info(JsonDao.class.getName() + " writing");
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), list);
    }

    @Override
    public List<T> read() throws IOException {
        log.info(JsonDao.class.getName() + " reading");
        final ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().
                constructCollectionType(List.class, tClass);
        return mapper.readValue(new File(fileName), type);
    }
}
