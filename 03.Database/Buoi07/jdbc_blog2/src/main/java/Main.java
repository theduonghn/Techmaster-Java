import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        System.out.println("Các bài viết công khai:");
        List<Post> publicPosts = service.getPublicPosts();
        service.show(publicPosts);
        System.out.println();

        Post post = service.getPostById(1);
        System.out.println("Thông tin của bài viết có id = 1");
        service.showPostInfo(post);
        System.out.println();

        service.updatePostTitle(post, "Introduction to MySQL");
        service.updatePostContent(post, "MySQL is a widely used relational database management system (RDBMS).");
        System.out.println();

        Post postTest = service.getPostById(1);
        service.deletePost(postTest);
        System.out.println();

        Post newPost = new Post("Hello World", "Hello", "Post about greeting the world", "hello.png", 4, 25, "draft");
        service.addPost(newPost);
    }
}
