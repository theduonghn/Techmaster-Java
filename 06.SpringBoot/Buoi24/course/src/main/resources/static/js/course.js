const searchElement = document.querySelector(".seach-form .seach-form-input");

searchElement.addEventListener("keydown", (e) => {
  if (e.keyCode == 13) {
    let url = new URL(window.location.href);
    let name = e.target.value.trim();
    if (name == "") {
      url.searchParams.delete("name");
    } else {
      url.searchParams.set("name", name);
    }
    window.location.href = url;
  }
});

function filterByTopic(topic) {
  let url = new URL(window.location.href);
  url.searchParams.set("topic", topic);
  window.location.href = url;
}

function clearFilterByTopic() {
  let url = new URL(window.location.href);
  url.searchParams.delete("topic");
  window.location.href = url;
}
