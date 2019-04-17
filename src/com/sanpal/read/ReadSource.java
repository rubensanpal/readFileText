package com.sanpal.read;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadSource implements ReadSourceRemote {


    @Override
    public String buildMacro(String path) {
        return readText(path);
    }


    @Override
    public String changeBatParameters(String path, String user, String pass, String macroName) {

        Path pathDoc = Paths.get(path);
        Charset charset = StandardCharsets.UTF_8;
        String batContent = null;
        try {
            batContent = new String(Files.readAllBytes(pathDoc),charset);
            batContent = batContent.replaceAll("INFO_CLIENT_USER",user);
            batContent = batContent.replace("INFO_CLIENT_PASS",pass);
            batContent = batContent.replace("INFO_NAME_MACRO",macroName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return batContent;
    }


    @Override
    public String readText(String path) {
        String doc = null;
        URL url = getClass().getResource(path);
        File file = new File(url.getPath());
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null){
                doc += line + "\n";
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
