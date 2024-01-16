package com.garguir;

import com.garguir.process.ListToFile;
import com.garguir.process.RepoJsonToListNames;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepoJsonToListNames repos = new RepoJsonToListNames();
        List<String> repoList = repos.RepoJson();

        ListToFile listToFile = new ListToFile();
        listToFile.saveUrls(repoList);

        System.out.println("Hello world!");
    }
}