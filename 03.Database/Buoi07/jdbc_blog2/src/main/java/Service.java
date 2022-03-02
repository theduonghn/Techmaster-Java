import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Service {
    ConnectDatabase connectDatabase = new ConnectDatabase();
    Connection conn = connectDatabase.connect();

    public <E> void show(List<E> list) {
        list.forEach(System.out::println);
    }

    public List<Post> getAllPosts() {
        String query = "SELECT * FROM `post`";
        List<Post> list = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                int id_category = resultSet.getInt("id_category");
                int id_author = resultSet.getInt("id_author");
                LocalDate create_at = LocalDate.parse(resultSet.getString("create_at"));
                String status = resultSet.getString("status");

                Post post =
                        new Post(id, title, content, description, thumbnail, id_category, id_author, create_at, status);
                list.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Post> getPublicPosts() {
        String query = "SELECT * FROM `post` WHERE status = 'public'";
        List<Post> list = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                int id_category = resultSet.getInt("id_category");
                int id_author = resultSet.getInt("id_author");
                LocalDate create_at = LocalDate.parse(resultSet.getString("create_at"));
                String status = resultSet.getString("status");

                Post post =
                        new Post(id, title, content, description, thumbnail, id_category, id_author, create_at, status);
                list.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Post getPostById(int findId) {
        String query = "SELECT * FROM `post` WHERE id = " + findId;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                int id_category = resultSet.getInt("id_category");
                int id_author = resultSet.getInt("id_author");
                LocalDate create_at = LocalDate.parse(resultSet.getString("create_at"));
                String status = resultSet.getString("status");

                return new Post(id, title, content, description, thumbnail, id_category, id_author, create_at, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void showPostInfo(Post post) {
        String query =
                "SELECT p.id AS 'post_id', p.title AS 'post_title', p.content AS 'post_content', a.id AS 'author_id', a.name AS 'author_name', JSON_ARRAYAGG(t.name) AS 'tags', p.create_at AS 'post_create_at'\n" +
                        "FROM `post` p INNER JOIN `author` a ON p.id_author = a.id\n" +
                        "INNER JOIN `post_tag` pt ON p.id = pt.id_post\n" + "INNER JOIN `tag` t ON t.id = pt.id_tag\n" +
                        "WHERE p.id = " + post.getId() + "\n" + "GROUP BY p.id";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int post_id = resultSet.getInt("post_id");
                String post_title = resultSet.getString("post_title");
                String post_content = resultSet.getString("post_content");
                String author_name = resultSet.getString("author_name");
                String tags = resultSet.getString("tags");
                LocalDate post_create_at = LocalDate.parse(resultSet.getString("post_create_at"));

                System.out.println("Post id: " + post_id);
                System.out.println("Post title: " + post_title);
                System.out.println("Post content: " + post_content);
                System.out.println("Author: " + author_name);
                System.out.println("Tags: " + tags);
                System.out.println("Create at: " + post_create_at);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addPost(Post post) {
        String query =
                "INSERT INTO `post`(`title`, `content`, `description`, `thumbnail`, `id_category`, `id_author`, `create_at`, `status`)" +
                        "VALUES('" + post.getTitle() + "', '" + post.getContent() + "', '" + post.getDescription() +
                        "', '" + post.getThumbnail() + "', '" + post.getId_category() + "', '" + post.getId_author() +
                        "', CURRENT_DATE(), '" + post.getStatus() + "') ";
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Thêm bài viết thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePost(Post post) {
        String query1 = "DELETE FROM post_tag WHERE id_post = " + post.getId();
        String query2 = "DELETE FROM discuss WHERE id_post = " + post.getId();
        String query3 = "DELETE FROM post WHERE id = " + post.getId();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            System.out.println("Xoá bài viết thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePostTitle(Post post, String newTitle) {
        post.setTitle(newTitle);
        String query = "UPDATE post SET title = '" + newTitle + "' WHERE id = " + post.getId();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Cập nhật tiêu đề bài viết thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePostContent(Post post, String newContent) {
        post.setTitle(newContent);
        String query = "UPDATE post SET content = '" + newContent + "' WHERE id = " + post.getId();
        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Cập nhật nội dung bài viết thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
