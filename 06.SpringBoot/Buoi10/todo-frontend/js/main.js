const URL_API = "http://localhost:8080/api/v1";

let todos = [];

// Truy cập vào các thành phần
const todoListElement = document.querySelector(".todo-list");
const todoOptionItemElements = document.querySelectorAll(
  ".todo-option-item input"
);

// Danh sách API
const getTodoApi = (status) => {
  switch (status) {
    case "all": {
      return axios.get(`${URL_API}/todos`);
    }
    case "unactive": {
      return axios.get(`${URL_API}/todos?status=false`);
    }
    case "active": {
      return axios.get(`${URL_API}/todos?status=true`);
    }
    default: {
      return axios.get(`${URL_API}/todos`);
    }
  }
};

const deleteTodoApi = (id) => {
  return axios.delete(`${URL_API}/todos/${id}`);
};

const updateTodoApi = (todo) => {
  return axios.put(`${URL_API}/todos/${todo.id}`, {
    title: todo.title,
    status: todo.status,
  });
};

const createTodoApi = (title) => {
  return axios.post(`${URL_API}/todos`, {
    title: title,
  });
};

const getTodos = async (status = "") => {
  try {
    let res = await getTodoApi(status);
    todos = res.data;
    renderTodo(todos);
  } catch (error) {
    console.log(error);
  }
};

const renderTodo = (arr) => {
  todoListElement.innerHTML = "";
  if (arr.length == 0) {
    todoListElement.innerHTML = "Không có công việc nào trong danh sách";
    return;
  }

  let html = "";
  for (const t of arr) {
    html += `<div class="todo-item ${t.status ? "active-todo" : ""}" >
                    <div class="todo-item-title">
                        <input type="checkbox"
                        ${t.status ? "checked" : ""}
                        onclick="toggleStatus(${t.id})"/>
                        <p>${t.title}</p>
                    </div>
                    <div class="option">
                        <button class="btn btn-update"
                        >
                            <img src="./img/pencil.svg" alt="icon" />
                        </button>
                        <button class="btn btn-delete"
                        onclick="deleteTodo(${t.id})">
                            <img src="./img/remove.svg" alt="icon" />
                        </button>
                    </div>
                </div>`;
  }
  todoListElement.innerHTML = html;
};

const deleteTodo = async (id) => {
  try {
    let isConfirm = confirm("Bạn có muốn xoá không?");
    if (isConfirm) {
      // Xoá trên server
      await deleteTodoApi(id);

      // Xoá trong mảng todo
      todos.forEach((todo, index) => {
        if (todo.id == id) {
          todos.splice(index, 1);
        }
      });

      // Render lại giao diện
      renderTodo(todos);
    }
  } catch (error) {
    console.log(error);
  }
};

const toggleStatus = async (id) => {
  try {
    let todo = todos.find((t) => t.id == id);
    todo.status = !todo.status;

    // Thay đổi trên server
    let res = updateTodoApi(todo);

    renderTodo(todos);
  } catch (error) {
    console.log(error);
  }
};

// Lọc công việc theo trạng thái
todoOptionItemElements.forEach((input) => {
  input.addEventListener("change", function () {
    // Lấy ra value
    let status = input.value;
    getTodos(status);
  });
});

getTodos();
