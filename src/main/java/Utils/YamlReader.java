package Utils;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class YamlReader {
    private static final String DOT_SEPARATOR = "\\.";
    private Map<?, ?> functionalTestYaml;

    public YamlReader(String filePath) {
        InputStream inputStream = this.getClass()
                                      .getClassLoader()
                                      .getResourceAsStream(filePath);
        Yaml testConfigYaml = new Yaml();
        this.functionalTestYaml = testConfigYaml.load(inputStream);
    }

    public <T> Optional<T> read(String path) {
        if (path != null && !path.isEmpty()) {
            List<String> keys = Arrays.asList(path.trim().split("\\."));

            if (keys.isEmpty()) {
                return Optional.empty();
            } else {
                Object current = this.functionalTestYaml;

                String key;
                for(Iterator var4 = keys.iterator(); var4.hasNext(); current = ((Map)current).get(key)) {
                    key = (String)var4.next();
                    if (current == null) {
                        return Optional.empty();
                    }

                    if (!(current instanceof Map)) {
                        System.out.println("Wrong Path to file");
                    }
                }

                return Optional.ofNullable((T) current);
            }
        } else {
            return Optional.empty();
        }
    }
}
