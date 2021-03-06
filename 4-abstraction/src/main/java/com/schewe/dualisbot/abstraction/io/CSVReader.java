package com.schewe.dualisbot.abstraction.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {

    public static String SEPARATOR = ";";

    private String[] header = new String[]{};
    private final List<String[]> lines = new ArrayList<>();

    public CSVReader(File file) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(SEPARATOR);
                if(i > 0)
                    lines.add(values);
                else
                    header = values;
                i++;
            }
        }
    }

    public Map<String, String> getValueMapForLine(int i){
        Map<String, String> values = new HashMap<>();
        String[] line = this.getLine(i);
        for(int j = 0; j < line.length; j++) {
            String value = line[j].trim();
            values.put(header[j], value);
        }
        return values;
    }

    public String[] getHeader() {
        return header;
    }

    public List<String[]> getLines() {
        return lines;
    }

    public String[] getLine(int i) {
        return lines.get(i);
    }

    private int getKeyIndex(String key) {
        return Arrays.asList(header).indexOf(key);
    }

    public List<String> getValues(String key) {
        List<String> values = new ArrayList<>();
        int keyIndex = getKeyIndex(key);
        for(String[] line : lines){
            values.add(line[keyIndex]);
        }
        return values;
    }

    public String getValue(int i, String key) {
        return getValues(key).get(i);
    }

}