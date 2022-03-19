let tasks = [
  { id: 1, content: "Java" },
  { id: 2, content: "HTML" },
  { id: 3, content: "CSS" },
  { id: 4, content: "JS" },
  { id: 5, content: "SQL" },
];

function createTask($template, task) {
  const $clone = $template.clone();
  $clone.find(".task-content").text(task.content);
  $clone.find(".btn-delete-task").on("click", function () {
    deleteTask(task.id);
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

function renderTaskFooter() {}

function deleteTask(id) {}

$(function () {
  const $taskList = $(".task-list");
  const $template = $(
    document.querySelector(".task-template").content.firstElementChild
  );

  renderTasks($taskList, $template);
});
