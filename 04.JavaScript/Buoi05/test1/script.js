$(function () {
  let $tr = $("tr");
  for (let i = 0; i < $tr.length; i++) {
    const tr = $tr[i];
    // let $td = $(tr).children();
    // for (let j = 0; j < $td.length; j++) {
    //   if (i == j) {
    //     console.log($td[j]);
    //     $($td[j]).css({ backgroundColor: "red" });
    //   }
    // }

    const $td = $(tr).children().eq(i);
    $td.css({ backgroundColor: "red" });

    const $td2 = $(tr)
      .children()
      .eq($tr.length - 1 - i);
    $td2.css({ backgroundColor: "red" });
  }
});
