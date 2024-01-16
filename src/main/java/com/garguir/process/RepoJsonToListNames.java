package com.garguir.process;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RepoJsonToListNames {
    private static final String PATH_RESOURCES = System.getProperty("user.dir")+"/src/main/resources";
    private static final String PATH_JSON_FILE = "/repo.json";

    public List<String> RepoJson(){
        List<String> repoList = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader(PATH_RESOURCES + PATH_JSON_FILE));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject jsonRepos;

            JSONArray jsonArray = (JSONArray) jsonObject.get("repos");
            Iterator iterator = jsonArray.iterator();

            while(iterator.hasNext()){
                jsonRepos = (JSONObject) iterator.next();
                repoList.add(jsonRepos.get("name").toString());
            }

        }catch (Exception ex){
            System.err.println("Error: "+ex);
        }

        return repoList;
    }
}
