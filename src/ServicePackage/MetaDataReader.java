package ServicePackage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class MetaDataReader {
    static ObjectMapper metaDataMapper = new ObjectMapper(new YAMLFactory());

    public static <T> T readMetaData(Class <T> clazz, String pathName) throws IOException {
        return metaDataMapper.readValue(new File(pathName), clazz);

    }
}
