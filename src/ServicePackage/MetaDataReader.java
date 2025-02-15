package ServicePackage;

import Exceptions.WrongInputException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;

public class MetaDataReader {
    static final ObjectMapper metaDataMapper = new ObjectMapper(new YAMLFactory());

    public static <T> T readMetaData(Class<T> clazz, String pathName) throws WrongInputException {
        try {
            return metaDataMapper.readValue(new File(pathName), clazz);
        } catch (IOException e) {
            throw new WrongInputException ("PLease check your input by path " + pathName+ ". It may be empty or contain inappropriate data.");
        }

    }
}
