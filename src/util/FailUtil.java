package util;

import model.Post;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FailUtil implements Serializable {

private static final String post_list_path = "C:\\Blog\\src\\File";
    public static void serializeAdList(List<Post> adList) {
        createFileIfNotExists(post_list_path);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(post_list_path))) {
            outputStream.writeObject(adList);
        } catch (IOException e) {
            System.out.println(post_list_path + " does not exists/or empty");
        }
    }


    public static List<Post> deserializeAdList() {
        createFileIfNotExists(post_list_path);
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(post_list_path))) {
            return (List<Post>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(post_list_path + " does not exists/or empty");
            return new LinkedList<>();
        }
    }
    private static void createFileIfNotExists(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(path + " File can not be created");
            }
        }
    }
}
