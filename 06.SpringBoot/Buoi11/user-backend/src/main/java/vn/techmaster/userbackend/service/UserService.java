package vn.techmaster.userbackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import vn.techmaster.userbackend.dto.UserDto;
import vn.techmaster.userbackend.exception.NotFoundException;
import vn.techmaster.userbackend.mapper.UserMapper;
import vn.techmaster.userbackend.model.User;

@Service
public class UserService {
    private List<User> users;

    public UserService() {
        initData();
    }

    public void initData() {
        users = new ArrayList<>();
        users.add(new User(1, "Nguyễn Văn A", "a@gmail.com", "0123456789", "Tỉnh Thái Bình", null, "111"));
        users.add(new User(2, "Trần Văn B", "b@gmail.com", "0123456789", "Tỉnh Nam Định", null, "222"));
        users.add(new User(3, "Ngô Thị C", "c@gmail.com", "0123456789", "Tỉnh Hưng Yên", null, "333"));
    }

    // Lấy danh sách user
    public List<UserDto> getUsers() {
        return users.stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    // Tìm kiếm user theo tên
    public List<UserDto> searchUsers(String name) {
        return users.stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    // Xoá user theo id
    public void deleteUser(int id) {
        if (findUser(id).isEmpty()) {
            throw new NotFoundException("Không tồn tại user có id = " + id);
        }
        users.removeIf(user -> user.getId() == id);
    }

    public Optional<User> findUser(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }
}
