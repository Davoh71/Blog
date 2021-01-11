package storage.impl;

import exeption.PostNotFaundExeption;
import model.Category;
import model.Post;
import storage.PostStoriges;
import util.FailUtil;

import java.util.List;

public class PostStorigeImpl implements PostStoriges {


    private List<Post> postList;

    public PostStorigeImpl() {
        postList = FailUtil.deserializeAdList();
    }

    @Override
    public void add(Post post) {
        postList.add(post);
        FailUtil.serializeAdList(postList);
    }

    @Override
    public Post getPostByTitle(String title) throws PostNotFaundExeption {
        for (Post post : postList){
            if (post.getTitle().equals(title)){
                return post;
            }
        }
        throw new PostNotFaundExeption("Post not Faund");
    }

    @Override
    public void serchByKeyword(String keyword) {
        for (Post post : postList){
            if (post.getTitle().contains(keyword) || post.getText().contains(keyword)){
                System.out.println(post);
            }
        }
    }

    @Override
    public void printAllPost() {
        System.out.println(postList);

    }

    @Override
    public void printPostsByCategory(Category category) {
        for (Post post : postList){
            if (post.getCategory() == category){
                System.out.println(post);
            }
        }
    }
}
