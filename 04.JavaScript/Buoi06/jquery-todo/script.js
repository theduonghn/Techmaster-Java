let tasks = loadTasks();

function loadTasks() {
  let data = localStorage.getItem("tasks");
  if (data) {
    return JSON.parse(data);
  } else {
    return [];
  }
}

function saveTasks() {
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
  saveTasks();
  console.log(tasks);
  let $task = createTask($template, newTask);
  $task.appendTo($taskList);
  renderNumTasks();
}

function deleteTask(id) {
  let index = tasks.findIndex((task) => task.id == id);
  if (index != -1) {
    tasks.splice(index, 1);
    saveTasks();
    renderNumTasks();
  }
}

function clearAllTasks($taskList) {
  tasks.length = 0; // Remove all elements
  saveTasks();
  $taskList.html("");
  renderNumTasks();
}

$(function () {
  // Prevent form submit when press enter key
  $(window).keydown(function (event) {
    if (event.keyCode == 13) {
      event.preventDefault();
      return false;
    }
  });

  const $taskList = $(".task-list");
  const $template = $(
    document.querySelector(".task-template").content.firstElementChild
  );
  const $inputNewTask = $(".input-new-task");
  const $btnAddNewTask = $(".btn-add-new-task");
  const $btnClearAllTasks = $(".btn-clear-all-tasks");

  renderTasks($taskList, $template);
  renderNumTasks();

  $btnAddNewTask.on("click", function (e) {
    e.preventDefault();
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
