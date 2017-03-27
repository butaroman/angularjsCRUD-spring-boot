var myApp = angular.module("myApp",[]);
	
var url = "http://localhost:8080/movie";	

myApp.controller('myCtrl', function($scope, $http) {
	
	$scope.addNewMovie = function() {
		$http.post(url, {
			title: $scope.movieTitle,
			director: $scope.movieDirector}
			).success(function (data, status, headers) {
				$scope.movieList.push(data);
			});
			
		$scope.movieTitle = "";
		$scope.movieDirector = "";
	}
	
	$scope.deleteMovie = function(movie) {
		var index = $scope.movieList.indexOf(movie);
		
		$http.delete(url + '/' + movie.id).then(function(response) {
			$scope.movieList.splice(index,1);
		}, function(response){
			console.log("can`t delete movie by id: " + movie.id);
		});
	}
	
	$http.get(url).then(function (response) {
        $scope.movieList = response.data;
    });
});

