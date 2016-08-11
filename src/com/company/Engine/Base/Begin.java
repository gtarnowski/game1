package com.company.Engine.Base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.out;

/**
 * Created by hexen on 09.08.16.
 */
public class Begin {
    public void readStats(){
        List<String> list = new ArrayList<String>();
        File file = new File("player.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {
                list.add(text);
            }

        }catch (IOException ex){
            ex.printStackTrace();
        }finally {
            try {
                if(reader != null){
                    reader.close();
                }
            }catch (IOException ex){

            }
        }
        out.println(list);
    }
}
