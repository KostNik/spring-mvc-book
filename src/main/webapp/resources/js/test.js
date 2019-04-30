angular.module('testApp', []).controller('testCtrl', function ($scope, $http) {

    //--Refresh--//
    $scope.testIt = function () {
        alert("TEST iT")
        // $http.get('/rest/cart/' + $scope.cartId)
        //     .success(function (data) {
        //         $scope.cart = data;
        //     });
    };


});