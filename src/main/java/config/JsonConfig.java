package config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.IllegalFormatException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonConfig {

    protected JSONObject config;

    public  JsonConfig(){

    }


    public JsonConfig(Object config) throws ConfigException {
        this.set(config);
    }


    public void set(Object config) throws ConfigException {

        if(config instanceof String){
            this.setFromString((String) config);
        }
        else if(config instanceof File){
            this.setFromFile((File) config);
        }
        else if(config instanceof JSONObject){
            this.setFromJSON((JSONObject) config);
        }
        else{
            throw new ConfigObjectException("configuration is expected to be JSONObject or JSON string or JSON file path and not <" + config.getClass().getSimpleName() + ">");
        }
    }


    public JSONObject getJSONObject(String keyPath) throws ConfigException{
        JSONObject value = null;
        Object parsedConfigNode = this.config;
        String[] pathElements = keyPath.split("\\.");

        for (int i=0; i< pathElements.length; i++){
            String key = pathElements[i];

            if(i == pathElements.length-1){
                if(parsedConfigNode instanceof JSONObject){
                    try{
                        value = ((JSONObject)parsedConfigNode).getJSONObject(key);
                    }
                    catch(JSONException exception){
                        throw new ConfigException("Invalid Format : <" + keyPath + "> is not a boolean value", exception);
                    }
                }
                else if(parsedConfigNode instanceof JSONArray){
                    try{
                        value = ((JSONArray)parsedConfigNode).getJSONObject(Integer.parseInt(key));
                    }
                    catch(NumberFormatException exception){
                        throw new ConfigException("Invalid Format : '" + key + "'was expected as being the index of an array", exception);
                    }
                }
            }
            else {
                String next_key = pathElements[i+1];
                parsedConfigNode = this.getNextConfigNode(parsedConfigNode, key, next_key);
            }
        }

        return value;
    }


    public JSONArray getJSONArray(String keyPath) throws ConfigException {
        JSONArray value = null;
        Object parsedConfigNode = this.config;
        String[] pathElements = keyPath.split("\\.");

        for (int i=0; i< pathElements.length; i++){
            String key = pathElements[i];

            if(i == pathElements.length-1){
                if(parsedConfigNode instanceof JSONObject){
                    try{
                        value = ((JSONObject)parsedConfigNode).getJSONArray(key);
                    }
                    catch(JSONException exception){
                        throw new ConfigException("Invalid Format : <" + keyPath + "> is not a boolean value", exception);
                    }
                }
                else if(parsedConfigNode instanceof JSONArray){
                    try{
                        value = ((JSONArray)parsedConfigNode).getJSONArray(Integer.parseInt(key));
                    }
                    catch(NumberFormatException exception){
                        throw new ConfigException("Invalid Format : '" + key + "'was expected as being the index of an array", exception);
                    }
                }
            }
            else {
                String next_key = pathElements[i+1];
                parsedConfigNode = this.getNextConfigNode(parsedConfigNode, key, next_key);
            }
        }

        return value;
    }


    public boolean getBoolean(String keyPath) throws ConfigException {
        Boolean value = null;
        Object parsedConfigNode = this.config;
        String[] pathElements = keyPath.split("\\.");

        for (int i=0; i< pathElements.length; i++){
            String key = pathElements[i];

            if(i == pathElements.length-1){
                if(parsedConfigNode instanceof JSONObject){
                    try{
                        value = ((JSONObject)parsedConfigNode).getBoolean(key);
                    }
                    catch(JSONException exception){
                        throw new ConfigException("Invalid Format : <" + keyPath + "> is not a boolean value", exception);
                    }
                }
                else if(parsedConfigNode instanceof JSONArray){
                    try{
                        value = ((JSONArray)parsedConfigNode).getBoolean(Integer.parseInt(key));
                    }
                    catch(NumberFormatException exception){
                        throw new ConfigException("Invalid Format : '" + key + "'was expected as being the index of an array", exception);
                    }
                }
            }
            else {
                String next_key = pathElements[i+1];
                parsedConfigNode = this.getNextConfigNode(parsedConfigNode, key, next_key);
            }
        }

        return value;
    }


    public String getString(String keyPath) throws ConfigException {
        String value = null;
        Object parsedConfigNode = this.config;
        String[] pathElements = keyPath.split("\\.");

        for (int i=0; i< pathElements.length; i++){
            String key = pathElements[i];

            if(i == pathElements.length-1){
                if(parsedConfigNode instanceof JSONObject){
                    try{
                        value = ((JSONObject)parsedConfigNode).getString(key);
                    }
                    catch(JSONException exception){
                        throw new ConfigException("Invalid Format : <" + keyPath + "> is not a boolean value", exception);
                    }
                }
                else if(parsedConfigNode instanceof JSONArray){
                    try{
                        value = ((JSONArray)parsedConfigNode).getString(Integer.parseInt(key));
                    }
                    catch(JSONException exception){
                        throw new ConfigException(exception.getMessage(), exception);
                    }
                    catch(NumberFormatException exception){
                        throw new ConfigException("Invalid Format : '" + key + "'was expected as being the index of an array", exception);
                    }
                }
            }
            else {
                String next_key = pathElements[i+1];
                parsedConfigNode = this.getNextConfigNode(parsedConfigNode, key, next_key);
            }
        }

        return value;
    }


    public int getInt(String keyPath) throws ConfigException {
        Integer value = null;
        Object parsedConfigNode = this.config;
        String[] pathElements = keyPath.split("\\.");

        for (int i=0; i< pathElements.length; i++){
            String key = pathElements[i];

            if(i == pathElements.length-1){
                if(parsedConfigNode instanceof JSONObject){
                    try{
                        value = ((JSONObject)parsedConfigNode).getInt(key);
                    }
                    catch(JSONException exception){
                        throw new ConfigException("Invalid Format : <" + keyPath + "> is not a boolean value", exception);
                    }
                }
                else if(parsedConfigNode instanceof JSONArray){
                    try{
                        value = ((JSONArray)parsedConfigNode).getInt(Integer.parseInt(key));
                    }
                    catch(NumberFormatException exception){
                        throw new ConfigException("Invalid Format : '" + key + "'was expected as being the index of an array", exception);
                    }
                }
            }
            else {
                String next_key = pathElements[i+1];
                parsedConfigNode = this.getNextConfigNode(parsedConfigNode, key, next_key);
            }
        }

        return value;
    }


    public float getFloat(String keyPath) throws ConfigException {
        Float value = null;
        Object parsedConfigNode = this.config;
        String[] pathElements = keyPath.split("\\.");

        for (int i=0; i< pathElements.length; i++){
            String key = pathElements[i];

            if(i == pathElements.length-1){
                if(parsedConfigNode instanceof JSONObject){
                    try{
                        value = ((JSONObject)parsedConfigNode).getFloat(key);
                    }
                    catch(JSONException exception){
                        throw new ConfigException("Invalid Format : <" + keyPath + "> is not a boolean value", exception);
                    }
                }
                else if(parsedConfigNode instanceof JSONArray){
                    try{
                        value = ((JSONArray)parsedConfigNode).getFloat(Integer.parseInt(key));
                    }
                    catch(NumberFormatException exception){
                        throw new ConfigException("Invalid Format : '" + key + "'was expected as being the index of an array", exception);
                    }
                }
            }
            else {
                String next_key = pathElements[i+1];
                parsedConfigNode = this.getNextConfigNode(parsedConfigNode, key, next_key);
            }
        }

        return value;
    }


    protected void setFromString(String config) throws ConfigException {
        config = config.trim();

        if(isFilePath(config)){
            this.setFromFile(new File(config));
        }
        else if(isJSON(config)){
            this.setFromJSON(new JSONObject(config));
        }
        else{
            throw new ConfigObjectException("<" + config + "> has invalid format ; JSON String or JSON file path expected");
        }
    }


    protected void setFromFile(File config) throws ConfigException {

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(config));
            StringBuilder content = new StringBuilder();
            String line = "";
            while (null != line) {
                line = fileReader.readLine();
                if (null != line) {
                    content.append(line.trim());
                }
            }

            this.setFromString(content.toString());
        }
        catch (IOException exception){
            throw  new ConfigException("Fail to load config", exception);
        }
    }


    protected void setFromJSON(JSONObject config){
        this.config = config;
    }


    private boolean isFilePath(String str){
        File file = new File(str);
        return file.exists() && file.isFile();
    }


    private boolean isJSON(String str){
        try{
            JSONObject json = new JSONObject(str);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


    private int getArrayIndex(String entry){
        int index = -1;
        try {
            index = Integer.valueOf(entry);

        }
        catch (Exception e){

        }
        return index;
    }

    private Object getNextConfigNode(Object node, String key, String nextKey) throws ConfigException {

        Object parsedConfigNode = node;

        if(parsedConfigNode instanceof  JSONArray){
            try {
                // Si la prochaine clé est un index de tableau,
                if (nextKey.matches("^\\d+$")) {
                    parsedConfigNode = ((JSONArray) parsedConfigNode).getJSONArray(Integer.parseInt(key));
                }
                // Sinon,
                else {
                    parsedConfigNode = ((JSONArray) parsedConfigNode).getJSONObject(Integer.parseInt(key));
                }
            }
            catch(JSONException exception){
                throw new ConfigException(exception.getMessage());
            }
            catch(NumberFormatException exception){
                throw new ConfigException("Invalid Format : '" + key + "'was expected as being the index of an array", exception);
            }
        }
        // Cas où nous n'avons pas le dernier élément du chemin et nous parcourions un objet json
        else if(parsedConfigNode instanceof  JSONObject){
            try {
                // Si la prochaine clé est un index de tableau,
                if(nextKey.matches("^\\d+$")){
                    parsedConfigNode = ((JSONObject)parsedConfigNode).getJSONArray(key);
                }
                // Sinon,
                else {
                    parsedConfigNode = ((JSONObject)parsedConfigNode).getJSONObject(key);
                }
            }
            catch(JSONException exception){
                throw new ConfigException(exception.getMessage());
            }
        }
        else{
            throw new ConfigObjectException("" + parsedConfigNode + " object is expected to be JSONObject or JSONArray");
        }

        return parsedConfigNode;
    }
}
