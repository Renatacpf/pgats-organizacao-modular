package utils;

import org.yaml.snakeyaml.Yaml;
import java.io.InputStream;
import java.util.Map;

public class TestDataLoader {

    private static Map<String, Object> testData;

    static {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = TestDataLoader.class.getClassLoader().getResourceAsStream("testdata.yaml")) {
            if (inputStream == null) {
                // Melhorar a mensagem de erro para o caminho de recurso esperado
                throw new RuntimeException("Arquivo testdata.yaml não encontrado em src/test/resources/ ou no classpath.");
            }
            testData = yaml.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao carregar testdata.yaml: " + e.getMessage());
        }
    }

    public static String getLoginData(String type, String key) {
        Map<String, Object> loginMap = (Map<String, Object>) testData.get("login");
        if (loginMap == null) {
            throw new IllegalArgumentException("Seção 'login' não encontrada em testdata.yaml");
        }

        Map<String, Object> specificTypeMap = (Map<String, Object>) loginMap.get(type);
        if (specificTypeMap == null) {
            throw new IllegalArgumentException("Tipo de login '" + type + "' não encontrado em testdata.yaml");
        }
        Object value = specificTypeMap.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Chave '" + key + "' não encontrada para o tipo '" + type + "' de login.");
        }
        return value.toString();
    }

    public static String getRegisterData(String section, String key) {
        Map<String, Object> registerMap = (Map<String, Object>) testData.get("register");
        if (registerMap == null) {
            throw new IllegalArgumentException("Seção 'register' não encontrada em testdata.yaml");
        }

        Map<String, Object> specificSectionMap = (Map<String, Object>) registerMap.get(section);
        if (specificSectionMap == null) {
            throw new IllegalArgumentException("Subseção '" + section + "' não encontrada na seção 'register' em testdata.yaml");
        }
        Object value = specificSectionMap.get(key);
        if (value == null) {
            throw new IllegalArgumentException("Chave '" + key + "' não encontrada na subseção '" + section + "' de registro.");
        }
        return value.toString();
    }
}