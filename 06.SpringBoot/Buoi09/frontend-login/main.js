const usernameInputElement = document.getElementById("username");
const passwordInputElement = document.getElementById("password");
const loginButtonElement = document.getElementById("login");
const loginFormElement = document.getElementById("login-form");

loginFormElement.addEventListener("submit", async function () {
  try {
    const res = await axios.post("http://localhost:8080/login", {
      username: usernameInputElement.value,
      password: passwordInputElement.value,
    });
    const user = res.data;
    const welcomeElement = document.createElement("div");
    welcomeElement.id = "welcome";
    welcomeElement.innerHTML = `
    <p>Xin chào ${user.username}</p>
    <p>Email: ${user.email}</p>
    <p>Avatar: ${user.avatar}</p>
    `;
    loginFormElement.insertAdjacentElement("afterend", welcomeElement);
    loginFormElement.hidden = true;
  } catch (error) {
    const message = error.response.data.message;
    alert(message);
  }
});
