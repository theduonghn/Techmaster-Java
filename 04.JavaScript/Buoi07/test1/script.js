const products = [
  {
    id: 1,
    name: "Đồng hồ Casio",
    category: "Đồng hồ",
    price: 300000,
    quantity: 89,
  },
  {
    id: 2,
    name: "iPhone 14",
    category: "Điện thoại",
    price: 30000000,
    quantity: 0,
  },
  {
    id: 3,
    name: "iPhone 13",
    category: "Điện thoại",
    price: 15000000,
    quantity: 101,
  },
  {
    id: 4,
    name: "Macbook",
    category: "Máy tính",
    price: 25500000,
    quantity: 12,
  },
  {
    id: 5,
    name: "Dell",
    category: "Máy tính",
    price: 15000000,
    quantity: 0,
  },
];

function createProduct($template, product) {
  let $clone = $template.clone();
  $clone.find(".product-name").text(product.name);
  $clone.find(".product-category").text(product.category);
  $clone.find(".product-price").text(product.price);
  $clone.find(".product-quantity").text(product.quantity);

  // Gắn dữ liệu product và $clone
  $clone.data(product);

  return $clone;
}

function createList$product($template, products) {
  const list = [];
  products.forEach((product) => {
    let $product = createProduct($template, product);
    list.push($product);
  });
  return list;
}

function renderProducts($template, $productList, products) {
  let list$product = createList$product($template, products);
  $.each(list$product, function (index, $product) {
    $product.appendTo($productList);
  });
}

function toggleAvailable(e) {
  const isChecked = e.target.checked;
  $.each($(".product"), function (index, product) {
    const $product = $(product);
    if ($product.data().quantity == 0 && isChecked) {
      $product.hide();
    } else {
      $product.show();
    }
  });
}

function sortBy(option) {
  // key, isAscending
  const products = $(".product").get();
  products.sort(function (productA, productB) {
    const dataOfProductA = $(productA).data();
    const dataOfProductB = $(productB).data();
    if (option.isAscending) {
      return dataOfProductA[option.key] - dataOfProductB[option.key];
    } else {
      return dataOfProductB[option.key] - dataOfProductA[option.key];
    }
  });
  $.each(products, function (item, product) {
    $(product).appendTo();
  });
}

function sortProducts(e) {
  const option = e.target.value;
  switch (option) {
    case "1":
      sortBy({ key: "price", isAscending: true });
      break;
    case "2":
      sortBy({ key: "price", isAscending: false });
      break;
    case "3":
      sortBy({ key: "quantity", isAscending: true });
      break;
    case "4":
      sortBy({ key: "quantity", isAscending: false });
      break;
  }
}

$(function () {
  const $template = $(
    document.querySelector(".product-template").content.firstElementChild
  );
  const $productList = $(".product-list");
  const $checkboxAvailable = $("#checkbox-available");
  $checkboxAvailable.on("change", toggleAvailable);
  const $selectSort = $("#select-sort");
  $selectSort.on("change", sortProducts);

  renderProducts($template, $productList, products);
});
