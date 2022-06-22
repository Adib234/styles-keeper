package com.example.demo2;

import com.google.common.collect.Maps;
import com.hubspot.jinjava.Jinjava;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Hello world!
 */
public class RenderHTML {
    public RenderHTML() {
    }

    /**
     * Says hello to the world.
     */
    public void render() {
        Jinjava jinjava = new Jinjava();
        Map<String, String> context = Maps.newHashMap();
        context.put("name", "Jared");
        context.put("occupation", "gardener");

        String template;
        try {
            String fileName = "src/main/resources/static/my-template.html";
            template = Files.readString(Paths.get(fileName));
            String rendered = jinjava.render(template, context);
            System.out.println(rendered);
            try {
                FileWriter myWriter = new FileWriter("src/main/resources/static/final.html");
                myWriter.write(rendered);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

