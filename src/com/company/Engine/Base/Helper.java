package com.company.Engine.Base;

import com.company.Engine.Items.ItemEvents;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Helper {

    //Load Player statistics from file,
    //value="fileName" means real path to the FILE and is reference from Method call
    public List<String> readStats(String fileName) {
        List<String> list = new ArrayList<String>();
        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {
                list.add(text);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {

            }
        }
        return list;
    }

    public List<String> loadItems(String fileName) {
        List<String> list = new ArrayList<String>();
        File file = new File(fileName);
        BufferedReader reader = null;
        ItemEvents itemEvents = new ItemEvents();
        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null
                    ;
            while ((text = reader.readLine()) != null) {

                String[] singleItem = text.split(";");



                short id = Short.parseShort(singleItem[0]);
                String name = singleItem[1];
                String type = singleItem[2];


                ArrayList<Short> params = new ArrayList<>();
                if (singleItem[3].contains("/")) {
                    short []attributes = new short[singleItem[3].split("/").length];
                    for(int i : attributes ){
                        params.add(Short.parseShort(String.valueOf(attributes[i])));
                    }
                } else {
                    params.add(Short.parseShort(String.valueOf(singleItem[3])));
                }


                short drop = Short.parseShort(singleItem[4]);

                itemEvents.createItemsData(id, name, type, params, drop);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {

            }
        }
        return list;
    }

    //CONVERTERS:
    //Strings and Bytes to HEX code
    public String stringToHex(String hex) throws UnsupportedEncodingException {
        byte[] bytes = hex.getBytes("UTF-8");
        return DatatypeConverter.printHexBinary(bytes);
    }

    public String byteToHex(byte value) throws UnsupportedEncodingException {
        String hex = String.valueOf(value);
        byte[] bytes = hex.getBytes("UTF-8");
        return DatatypeConverter.printHexBinary(bytes);
    }

    //HEX codes to Strings and Bytes
    public StringBuilder hexToString(String hex) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hex.length(); i += 2) {
            String str = hex.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        return output;
    }

    public byte hexToByte(String hex) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hex.length(); i += 2) {
            String str = hex.substring(i, i + 2);
            output.append((char) Integer.parseInt(str, 16));
        }
        byte finalByte = Byte.parseByte(String.valueOf(output));
        return finalByte;
    }

}
