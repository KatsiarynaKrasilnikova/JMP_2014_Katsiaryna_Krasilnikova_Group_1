angular.module('exampleApp', ['ngRoute', 'ngCookies', 'exampleApp.services'])
	.config(
		[ '$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {
			
			$routeProvider.when('/create', {
				templateUrl: 'partials/create.html',
				controller: CreateController
			});
			
			$routeProvider.when('/edit/:id', {
				templateUrl: 'partials/edit.html',
				controller: EditController
			});

			$routeProvider.otherwise({
				templateUrl: 'partials/index.html',
				controller: IndexController
			});
			
			$locationProvider.hashPrefix('!');
		} ]
		
	).run(function($rootScope, $location, $cookieStore, NewsService) {});


function IndexController($scope, NewsService) {
	
	$scope.users = NewsService.query();
	
	$scope.deleteEntry = function(user) {
		user.$remove(function() {
			$scope.user = NewsService.query();
		});
	};
};


function EditController($scope, $routeParams, $location, NewsService) {

	$scope.user = NewsService.get({id: $routeParams.id});
	
	$scope.save = function() {
		$scope.user.$save(function() {
			$location.path('/');
		});
	};
};


function CreateController($scope, $location, NewsService) {
	
	$scope.user = new NewsService();
	
	$scope.save = function() {
		$scope.user.$save(function() {
			$location.path('/');
		});
	};
};


var services = angular.module('exampleApp.services', ['ngResource']);

services.factory('NewsService', function($resource) {
	return $resource('rest/users/:id', {id: '@id'});
});