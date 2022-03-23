const usersData = [
  {
    id: 1,
    fullname: "Nguyen Thuy Linh",
    gender: "Female",
    age: 22,
    email: "linh@gmail.com",
    phone: "123456789",
  },
  {
    id: 2,
    fullname: "Le Van Hai",
    gender: "Male",
    age: 30,
    email: "hai@gmail.com",
    phone: "223456789",
  },
  {
    id: 3,
    fullname: "Luong Ngoc Son",
    gender: "Male",
    age: 51,
    email: "son@gmail.com",
    phone: "323456789",
  },
];

function create$user(userData) {
  const $template = $(
    document.querySelector(".user-template").content.firstElementChild
  );
  const $clone = $template.clone();
  $clone.find(".user-id").text(userData.id);
  $clone.find(".user-fullname").text(userData.fullname);
  $clone.find(".user-gender").text(userData.gender);
  $clone.find(".user-age").text(userData.age);
  $clone.find(".user-email").text(userData.email);
  $clone.find(".user-phone").text(userData.phone);

  return $clone;
}

function create$users() {
  const $users = [];
  usersData.forEach((userData) => {
    const $user = create$user(userData);
    $users.push($user);
  });

  return $users;
}

function renderUsers() {
  const $userList = $(".user-list");
  const $users = create$users();
  $.each($users, (index, $user) => {
    $user.appendTo($userList);
  });
}

$(function () {
  renderUsers();
});
