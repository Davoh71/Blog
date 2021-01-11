package storage;

import exeption.PostNotFaundExeption;
import model.Category;
import model.Post;

public interface PostStoriges {

    void add(Post post);

    Post getPostByTitle(String title) throws PostNotFaundExeption;

    void serchByKeyword (String keyword);

    void printAllPost();

    void printPostsByCategory(Category category);



}
