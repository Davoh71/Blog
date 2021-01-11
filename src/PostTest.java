
import model.Category;
import model.Commands;
import model.Post;
import storage.impl.PostStorigeImpl;

import java.util.Date;
import java.util.Scanner;


public class PostTest implements Commands {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PostStorigeImpl postStorage = new PostStorigeImpl();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            Commands.printCommands();
            int command;
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_POST:
                    addpost();
                    break;
                case SARCH_POST:
                    sarchPost();
                    break;
                case POSTS_BY_CATEGORY:
                    postsByCategory();
                    break;
                case PRINT_POST:
                    postStorage.printAllPost();
                    break;
                default:
                    System.out.println("Wroong command");

            }
        }
    }

    private static void postsByCategory() {
        System.out.println("Ples enter category");
        String category = scanner.nextLine();
        postStorage.printPostsByCategory(Category.valueOf(category));
    }

    private static void sarchPost() {
        System.out.println("Plis enter keyword");
        String keyword = scanner.nextLine();
        postStorage.serchByKeyword(keyword);

    }

    private static void addpost() {
        System.out.println("Ples input Title,Text,Category");
        String postDataStr = scanner.nextLine();
        String[] postData = postDataStr.split(",");
        try {

            try {
                Post post = new Post(postData[0], postData[1], Category.valueOf(postData[2]), new Date());
                postStorage.add(post);
                System.out.println("Post added !");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid data");

            }
        } catch (IllegalArgumentException e) {
            System.out.println(-1);
        }

    }
}