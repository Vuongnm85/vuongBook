app = angular.module("admin-app", ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/product", {
            templateUrl: "/assests/admin/product/index.html",
            controller: "product-ctrl"
        })
        .when("/account", {
            templateUrl: "/assests/admin/username/index.html",
            controller: "user-ctrl"
        })
        .when("/amout", {
            templateUrl: "/assests/admin/thongKe/index.html",
            controller: "amount-ctrl"
        })
        .when("/cate", {
            templateUrl: "/assests/admin/thongKe/cate.html",
            controller: "amount-ctrl"
        })
        .when("/unauthorized", {
            templateUrl: "/assets/admin/authority/unauthorized.html",
            controller: "authority-ctrl"
        })
        .otherwise({
            templateUrl: "<h1 class='text-center'>FPT Polytechnic Administration</h1>"
        });
})