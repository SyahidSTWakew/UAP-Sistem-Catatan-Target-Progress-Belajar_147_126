package utils;

import model.StudyTarget;
import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String FILE = "data.csv";

    public static void save(ArrayList<StudyTarget> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (StudyTarget t : list) {
                bw.write(t.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file");
        }
    }

    public static ArrayList<StudyTarget> load() {
        ArrayList<StudyTarget> list = new ArrayList<>();
        File f = new File(FILE);
        if (!f.exists()) return list;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(StudyTarget.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file");
        }
        return list;
    }
}
