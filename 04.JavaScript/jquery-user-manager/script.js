let usersData = [];

function create$user(userData) {
  const $template = $(
    document.querySelector(".user-template").content.firstElementChild
  );
  const $clone = $template.clone();
  $clone.find(".user-id").text(userData.id);
  $clone.find(".user-fullname").text(userData.name);
  $clone.find(".user-address").text(`
      ${userData.address.suite} ${userData.address.street}, ${userData.address.city}
    `);
  $clone.find(".user-website").text(userData.website);
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
  $btnAddUser = $(".btn-add-user");

  $.ajax("https://jsonplaceholder.typicode.com/users", {
    success(response) {
      usersData = usersData.concat(response);
      // console.log(usersData);
      renderUsers();
    },
    error(error) {
      console.log(error);
    },
  });
});
