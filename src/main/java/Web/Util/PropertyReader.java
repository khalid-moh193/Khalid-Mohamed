package Web.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {

    static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();
    static FileInputStream fs;

    static {
        try {
            String userDir = System.getProperty("user.dir");
            fs = new FileInputStream(userDir + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Execution.properties");
            property.load(fs);
            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String getProperty(String key) {

        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key))) {
            throw new RuntimeException("Property name " + key + " is not found, please check Environment.prop file");
        }
        if (System.getProperty(key) == null) {
            return CONFIGMAP.get(key);
        } else {
            return System.getProperty(key);
        }
    }

}