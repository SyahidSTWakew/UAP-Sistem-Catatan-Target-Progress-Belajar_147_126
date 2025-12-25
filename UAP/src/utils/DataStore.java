package utils;

import model.StudyTarget;
import java.util.ArrayList;

public class DataStore {
    public static ArrayList<StudyTarget> targets = FileManager.load();
}