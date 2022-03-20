let tasks = initTasks();

function initTasks() {
  let tasks;
  let localStorageTasks = localStorage.getItem("tasks");
  if (localStorageTasks == null) {
    tasks = [
      { id: 1, content: "Java" },
      { id: 2, content: "HTML" },
      { id: 3, content: "CSS" },
      { id: 4, content: "JS" },
      { id: 5, content: "SQL" },
    ];
  } else {
    tasks = JSON.parse(localStorageTasks);
  }
  return tasks;
}

function getTasks() {
  return JSON.parse(localStorage.getItem("tasks"));
}

function setTasks() {
  localStorage.setItem("tasks", JSON.stringify(tasks));
}

function createTask($template, task) {
  const $clone = $template.clone();
  $clone.find(".task-content").text(task.content);
  $clone.find(".btn-delete-task").on("click", function () {
    deleteTask(task.id);
    $clone.remove();
  });

  return $clone;
}

function createList($template, tasks) {
  const list = [];

  tasks.forEach((task) => {
    const $task = createTask($template, task);
    list.push($task);
  });

  return list;
}

function renderTasks($taskList, $template) {
  let taskList = createList($template, tasks);
  $.each(taskList, function (index, $item) {
    $item.appendTo($taskList);
  });
}

function renderNumTasks() {
  const $numTasks = $(".num-tasks");
  $numTasks.text(tasks.length);
}

function addTask(content, $taskList, $template) {
  let id = Math.floor(Math.random() * 900000);
  let newTask = { id: id, content: content };
  tasks.push(newTask);
  setTasks();
  console.log(tasks);
  let $task = createTask($template, newTask);
  $task.appendTo($taskList);
  renderNumTasks();
}

function deleteTask(id) {
  let index = tasks.findIndex((task) => task.id == id);
  if (index != -1) {
    tasks.splice(index, 1);
    setTasks();
    renderNumTasks();
  }
}

function clearAllTasks($taskList) {
  tasks.length = 0; // Remove all elements
  setTasks();
  $taskList.html("");
  renderNumTasks();
}

$(function () {
  const $taskList = $(".task-list");
  const $template = $(
    document.querySelector(".task-template").content.firstElementChild
  );
  const $inputNewTask = $(".input-new-task");
  const $btnAddNewTask = $(".btn-add-new-task");
  const $btnClearAllTasks = $(".btn-clear-all-tasks");

  renderTasks($taskList, $template);
  renderNumTasks();

  $btnAddNewTask.on("click", function () {
    let content = $inputNewTask.val().trim();
    if (content != "") {
      addTask(content, $taskList, $template);
      $inputNewTask.val(""); // Clear input after adding new task
    }
  });

  $btnClearAllTasks.on("click", function () {
    clearAllTasks($taskList);
  });
});
