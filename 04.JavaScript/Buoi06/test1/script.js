function createListItem(item) {
  const $h1 = $("<h1 />", {
    class: "heading",
    text: "hello world",
    onclick: function () {
      console.log("click");
    },
  });

  return $h1;
}

$(function () {
  const $username = $(".username");

  $username.on("change", function (e) {
    const value = $username.val().trim();

    if (value.length < 6) {
      $username.addClass("invalid");
    } else {
      $username.removeClass("invalid");
    }
  });

  const $h1 = createListItem("abc");
  $username.after($h1);
});
