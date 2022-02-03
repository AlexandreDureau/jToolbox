package config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonConfigTest {

    public static final String PACKAGE_NAME = "config";
    public static final String PROJECT_DIR = System.getProperty("user.dir");
    public static final String TEST_DIR = PROJECT_DIR + "/src/test";
    public static final String TEST_RESOURCES_DIR = TEST_DIR + "/resources/"+  PACKAGE_NAME;

    @Test
    public void method_set_should_consume_a_JSON_String_to_set_the_instance() throws ConfigException {
        // Given:
        String jsonStr = "{\"key1\":\"value\", \"booleanKey\":true, \"intKey\":17}";

        JsonConfig jsonConfig = new JsonConfig();

        // When:
        jsonConfig.set(jsonStr);

        // Then:
        Assertions.assertEquals("value", jsonConfig.getString("key1"));
        Assertions.assertEquals(true, jsonConfig.getBoolean("booleanKey"));
        Assertions.assertEquals(17, jsonConfig.getInt("intKey"));
    }

    @Test
    public void method_set_should_consume_a_JSON_filepath_to_set_the_instance() throws ConfigException {
        // Given:
        JsonConfig jsonConfig = getJsonConfig("config0.json");

        // When ..
        // Then:
        Assertions.assertEquals("Vingt-Mille Lieues Sous Les Mers", jsonConfig.getString("title"));
        Assertions.assertEquals("Jules Vernes",                     jsonConfig.getString("author"));
        Assertions.assertEquals(1870,                               jsonConfig.getInt("year"));
        Assertions.assertEquals(true,                               jsonConfig.getBoolean("available"));
    }

    @Test
    public void method_getBoolean_should_return_the_value_of_a_key() throws ConfigException {

        // Given:
        JsonConfig jsonConfig = getJsonConfig("config1.json");

        // When ..
        // Then:
        Assertions.assertTrue(jsonConfig.getBoolean("confidential"));

        Assertions.assertTrue(jsonConfig.getBoolean("accounting.0.nice"));
        Assertions.assertTrue(jsonConfig.getBoolean("accounting.0.additionalInfo.presenceLastWeek.Monday"));
        Assertions.assertTrue(jsonConfig.getBoolean("accounting.0.additionalInfo.presenceLastWeek.Tuesday"));
        Assertions.assertTrue(jsonConfig.getBoolean("accounting.0.additionalInfo.presenceLastWeek.Wednesday"));
        Assertions.assertTrue(jsonConfig.getBoolean("accounting.0.additionalInfo.presenceLastWeek.Thursday"));
        Assertions.assertTrue(jsonConfig.getBoolean("accounting.0.additionalInfo.presenceLastWeek.Friday"));
        Assertions.assertFalse(jsonConfig.getBoolean("accounting.0.additionalInfo.presenceLastWeek.Saturday"));
        Assertions.assertFalse(jsonConfig.getBoolean("accounting.0.additionalInfo.presenceLastWeek.Sunday"));

        Assertions.assertFalse(jsonConfig.getBoolean("accounting.1.nice"));
        Assertions.assertTrue(jsonConfig.getBoolean("accounting.1.additionalInfo.presenceLastWeek.Monday"));
        Assertions.assertTrue(jsonConfig.getBoolean("accounting.1.additionalInfo.presenceLastWeek.Tuesday"));
        Assertions.assertFalse(jsonConfig.getBoolean("accounting.1.additionalInfo.presenceLastWeek.Wednesday"));
        Assertions.assertTrue(jsonConfig.getBoolean("accounting.1.additionalInfo.presenceLastWeek.Thursday"));
        Assertions.assertFalse(jsonConfig.getBoolean("accounting.1.additionalInfo.presenceLastWeek.Friday"));
        Assertions.assertFalse(jsonConfig.getBoolean("accounting.1.additionalInfo.presenceLastWeek.Saturday"));
        Assertions.assertFalse(jsonConfig.getBoolean("accounting.1.additionalInfo.presenceLastWeek.Sunday"));

        Assertions.assertTrue(jsonConfig.getBoolean("sales.0.nice"));
        Assertions.assertTrue(jsonConfig.getBoolean("sales.0.additionalInfo.presenceLastWeek.Monday"));
        Assertions.assertFalse(jsonConfig.getBoolean("sales.0.additionalInfo.presenceLastWeek.Tuesday"));
        Assertions.assertFalse(jsonConfig.getBoolean("sales.0.additionalInfo.presenceLastWeek.Wednesday"));
        Assertions.assertFalse(jsonConfig.getBoolean("sales.0.additionalInfo.presenceLastWeek.Thursday"));
        Assertions.assertFalse(jsonConfig.getBoolean("sales.0.additionalInfo.presenceLastWeek.Friday"));
        Assertions.assertFalse(jsonConfig.getBoolean("sales.0.additionalInfo.presenceLastWeek.Saturday"));
        Assertions.assertFalse(jsonConfig.getBoolean("sales.0.additionalInfo.presenceLastWeek.Sunday"));

        Assertions.assertFalse(jsonConfig.getBoolean("sales.1.nice"));
        Assertions.assertTrue(jsonConfig.getBoolean("sales.1.additionalInfo.presenceLastWeek.Monday"));
        Assertions.assertTrue(jsonConfig.getBoolean("sales.1.additionalInfo.presenceLastWeek.Tuesday"));
        Assertions.assertFalse(jsonConfig.getBoolean("sales.1.additionalInfo.presenceLastWeek.Wednesday"));
        Assertions.assertFalse(jsonConfig.getBoolean("sales.1.additionalInfo.presenceLastWeek.Thursday"));
        Assertions.assertTrue(jsonConfig.getBoolean("sales.1.additionalInfo.presenceLastWeek.Friday"));
        Assertions.assertTrue(jsonConfig.getBoolean("sales.1.additionalInfo.presenceLastWeek.Saturday"));
        Assertions.assertFalse(jsonConfig.getBoolean("sales.1.additionalInfo.presenceLastWeek.Sunday"));

        Assertions.assertTrue(jsonConfig.getBoolean("bossHappinessMatrix.0.0"));
        Assertions.assertFalse(jsonConfig.getBoolean("bossHappinessMatrix.0.1"));
        Assertions.assertTrue(jsonConfig.getBoolean("bossHappinessMatrix.0.2"));
        Assertions.assertFalse(jsonConfig.getBoolean("bossHappinessMatrix.0.3"));

        Assertions.assertFalse(jsonConfig.getBoolean("bossHappinessMatrix.1.0"));
        Assertions.assertFalse(jsonConfig.getBoolean("bossHappinessMatrix.1.1"));
        Assertions.assertTrue(jsonConfig.getBoolean("bossHappinessMatrix.1.2"));
        Assertions.assertFalse(jsonConfig.getBoolean("bossHappinessMatrix.1.3"));

        Assertions.assertFalse(jsonConfig.getBoolean("bossHappinessMatrix.2.0"));
        Assertions.assertTrue(jsonConfig.getBoolean("bossHappinessMatrix.2.1"));
        Assertions.assertTrue(jsonConfig.getBoolean("bossHappinessMatrix.2.2"));
        Assertions.assertTrue(jsonConfig.getBoolean("bossHappinessMatrix.2.3"));

        Assertions.assertTrue(jsonConfig.getBoolean("bossHappinessMatrix.3.0"));
        Assertions.assertTrue(jsonConfig.getBoolean("bossHappinessMatrix.3.1"));
        Assertions.assertTrue(jsonConfig.getBoolean("bossHappinessMatrix.3.2"));
        Assertions.assertFalse(jsonConfig.getBoolean("bossHappinessMatrix.3.3"));
    }

    @Test
    public void method_getBoolean_should_throw_an_exception_if_the_value_is_not_boolean() throws ConfigException {

        // Given:
        JsonConfig jsonConfig = getJsonConfig("config1.json");

        // When ..
        // Then:
        Exception exception = assertThrows(ConfigException.class, () -> { jsonConfig.getBoolean("accounting.0.age"); });
    }

    @Test
    public void method_getBoolean_should_throw_an_exception_if_the_key_does_not_exist() throws ConfigException {

        // Given:
        JsonConfig jsonConfig = getJsonConfig("config1.json");

        // When ..
        // Then:
        Exception exception = assertThrows(ConfigException.class, () -> { jsonConfig.getBoolean("accounting.0.isValid"); });
    }

    @Test
    public void method_getBoolean_should_throw_an_exception_if_the_index_of_the_jsonarray_in_the_keypath_is_out_of_bound() throws ConfigException {

        // Given:
        JsonConfig jsonConfig = getJsonConfig("config1.json");

        // When ..
        // Then:
        Exception exception = assertThrows(ConfigException.class, () -> { jsonConfig.getBoolean("accounting.bossHappinessMatrix.0.4"); });
    }



    @Test
    public void method_getString_should_return_the_value_of_a_key() throws ConfigException {

        // Given:
        JsonConfig jsonConfig = getJsonConfig("config1.json");

        // When ..
        // Then:
        Assertions.assertEquals("human resources infos", jsonConfig.getString("title"));
        Assertions.assertEquals("John",                  jsonConfig.getString("accounting.0.firstName"));
        Assertions.assertEquals("Doe",                   jsonConfig.getString("accounting.0.lastName"));
        Assertions.assertEquals("Albert",                jsonConfig.getString("accounting.0.friends.0"));
        Assertions.assertEquals("Mary",                  jsonConfig.getString("accounting.0.friends.1"));
        Assertions.assertEquals("Paul",                  jsonConfig.getString("accounting.0.friends.2"));
        Assertions.assertEquals("Phill Collins",         jsonConfig.getString("accounting.0.additionalInfo.favoriteSinger"));
        Assertions.assertEquals("Jim",                   jsonConfig.getString("sales.1.firstName"));
        Assertions.assertEquals("Galley",                jsonConfig.getString("sales.1.lastName"));
        Assertions.assertEquals("Dave",                  jsonConfig.getString("sales.1.additionalInfo.favoriteSinger"));
    }


    @Test
    public void method_getString_should_throw_an_exception_if_the_value_is_not_string() throws ConfigException {

        // Given:
        JsonConfig jsonConfig = getJsonConfig("config1.json");

        // When ..
        // Then:
        assertThrows(ConfigException.class, () -> jsonConfig.getString("accounting.0.age"));
    }


    @Test
    public void method_getString_should_throw_an_exception_if_the_key_does_not_exist() throws ConfigException {

        // Given:
        JsonConfig jsonConfig = getJsonConfig("config1.json");

        // When ..
        // Then:
        assertThrows(ConfigException.class, () -> jsonConfig.getString("city"));
    }

    @Test
    public void method_getString_should_throw_an_exception_if_the_index_of_the_jsonarray_in_the_keypath_is_out_of_bound() throws ConfigException {

        // Given:
        JsonConfig jsonConfig = getJsonConfig("config1.json");

        // When ..
        // Then:
        assertThrows(ConfigException.class, () -> jsonConfig.getString("accounting.0.friends.4"));
    }


    private JsonConfig getJsonConfig(String fileName) throws ConfigException {

        String jsonConfigFilePath = TEST_RESOURCES_DIR + "/" + fileName;
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.set(jsonConfigFilePath);
        return jsonConfig;
    }
}
