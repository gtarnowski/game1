package com.company.Engine.Base;

import com.company.Engine.Items.ItemEvents;
import com.company.Engine.Items.Items;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

    public ArrayList loadItems(String fileName) {
        List<String> list = new ArrayList<String>();
        ArrayList<Items> itemList = new ArrayList<>();

        File file = new File(fileName);
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {
                //Split reader line
                String[] singleItem = text.split(";");

                //Define ID
                short id = Short.parseShort(singleItem[0]);
                //Define Name
                String name = singleItem[1];
                //Define Type
                String type = singleItem[2];

                //Define Params
                ArrayList<Short> params = new ArrayList<>();
                if (singleItem[3].contains("/")) {
                    String[] attr = singleItem[3].split("/");
                    for (int i = 0; i < attr.length; i++) {
                        params.add(Short.parseShort(String.valueOf(attr[i])));
                    }

                } else {
                    params.add(Short.parseShort(singleItem[3]));
                }

                //Define Drop
                short drop = Short.parseShort(singleItem[4]);


                //Add items to collection
                itemList.add(new Items(id, name, type, params, drop));
            }

            //Back to ItemEvents, with filled ArrayList
            return itemList;

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
        return itemList;
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
