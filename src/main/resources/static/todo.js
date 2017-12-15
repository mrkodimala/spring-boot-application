var app = angular.module("myApp",[]);

app.controller("myCtrl",function($scope,$http){

    $scope.todos = [];

    getAllTodos();
    function getAllTodos(){
        $http.get("http://localhost:8080/api/v1/todo/").
        then(function mySuccess(response){
            var data = response.data;
            var size = data.length;
            for(var i = 0; i < size; i++){
                $scope.todos.push(data[i]);
            }
        },function myError(response){
            console.error(response);
        });    
    }

    $scope.addTodo = function(){
        $scope.todos.push({"todoName":$scope.todoName});
        $http.post("http://localhost:8080/api/v1/todo/",{"name":$scope.todoName}).
        then(function mySuccess(response){
        },function myError(response){});
        $scope.todoName = "";
    }

});