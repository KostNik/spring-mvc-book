/**
 * Created by SweetHome on 10.07.2017.
 */

angular.module("cartApp", []).controller("cartCtrl", function ($scope, $http) {

    //--Refresh--//
    $scope.refreshCart = function (cartId) {
        $http.get('/rest/cart/' + $scope.cartId)
            .success(function (data) {
                $scope.cart = data;
            });
    };

    //--Clear--//
    $scope.clearCart = function () {
        alert("delete " + $scope.cartId);
        $http.delete('/rest/cart/' + $scope.cartId)
            .success(function (data) {
                $scope.refreshCart($scope.cartId);
            });
    };

    //--Init--//
    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart($scope.cartId);
    };

    //--Add--//
    $scope.addToCart = function (productId) {
        alert("Attempt to add " + productId);
        $http.put('/rest/cart/add/' + productId)
            .success(function (data) {
                alert("Product Successfully added to the Cart!");
            });
    };

    //--Remove from Cart--//
    $scope.removeFromCart = function (productId) {
        $http.put('/rest/cart/remove/' + productId)
            .success(function (data) {
                $scope.refreshCart($scope.cartId);
            });
    };

});