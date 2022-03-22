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

function create$product(product) {
  const $template = $(
    document.querySelector(".product-template").content.firstElementChild
  );
  let $clone = $template.clone();
  $clone.find(".product-name").text(product.name);
  $clone.find(".product-category").text(product.category);
  $clone.find(".product-price").text(product.price);
  $clone.find(".product-quantity").text(product.quantity);

  // Gắn dữ liệu product và $clone
  $clone.data(product);

  return $clone;
}

function create$products() {
  const list = [];
  products.forEach((product) => {
    let $product = create$product(product);
    list.push($product);
  });
  return list;
}

function renderProducts() {
  const $productList = $(".product-list");
  let $products = create$products();
  $.each($products, function (_index, $product) {
    $product.appendTo($productList);
  });
}

function toggleAvailable(e) {
  const isChecked = e.target.checked;
  $.each($(".product"), function (_index, product) {
    const $product = $(product);
    if ($product.data().quantity == 0 && isChecked) {
      $(product).addClass("hidden-by-status");
    } else {
      $(product).removeClass("hidden-by-status");
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
  const $productList = $(".product-list");
  $.each(products, function (_item, product) {
    $(product).appendTo($productList);
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

function createCategories() {
  let categories = [];
  products.forEach((product) => {
    const category = product.category;
    if (!categories.includes(category)) {
      categories.push(category);
    }
  });
  return categories;
}

function create$category(category) {
  let $template = $(
    document.querySelector(".category-template").content.firstElementChild
  );
  let $clone = $template.clone();
  $clone.text(category);
  $clone.val(category);

  return $clone;
}

function render$categories() {
  const categories = createCategories();
  const $selectCategory = $("#select-category");
  categories.forEach((category) => {
    const $category = create$category(category);
    $category.appendTo($selectCategory);
  });
}

function filterByCategory(e) {
  const option = e.target.value;
  const $products = $(".product");
  if (option == "") {
    $.each($products, function (_index, product) {
      $(product).removeClass("hidden-by-category");
    });
  } else {
    $.each($products, function (_index, product) {
      if ($(product).data().category != option) {
        $(product).addClass("hidden-by-category");
      } else {
        $(product).removeClass("hidden-by-category");
      }
    });
  }
}

$(function () {
  const $checkboxAvailable = $("#checkbox-available");
  $checkboxAvailable.on("change", toggleAvailable);
  const $selectSort = $("#select-sort");
  $selectSort.on("change", sortProducts);
  const $selectCategory = $("#select-category");
  $selectCategory.on("change", filterByCategory);

  renderProducts();
  render$categories();
});
