import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        List<Post> posts = service.getAllPosts();
        List<Post> publicPosts = service.getPublicPosts();
        service.show(publicPosts);

        System.out.println("Lấy post có id=1");
        Post post = service.getPostById(1);
        System.out.println(post);

        System.out.println("Hiển thị thông tin");
        service.showPostInfo(post);
    }
}
