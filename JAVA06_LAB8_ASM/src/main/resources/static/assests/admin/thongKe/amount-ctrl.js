app.controller("amount-ctrl", function ($scope, $http) {
alert("Luot mua");
	$scope.items = [];
	$scope.cates = [];
	$scope.form = {};

	$scope.intialize = function () {
		//load products
		$http.get("/rest/products/amount").then(resp => {
			$scope.items = resp.data;
		});
		$http.get("/rest/products/cate").then(resp => {
			$scope.cate = resp.data;
		});
	}

	//khởi đầu
	$scope.intialize();

});