angular.module('exampleApp', ['ngRoute', 'ngCookies', 'exampleApp.services'])
	.config(
		[ '$routeProvider', '$locationProvider', '$httpProvider', function($routeProvider, $locationProvider, $httpProvider) {
			
			$routeProvider.when('/user/create', {
				templateUrl: 'partials/user/create.html',
				controller: UserCreateController
			});
			
			$routeProvider.when('/user/edit/:id', {
				templateUrl: 'partials/user/edit.html',
				controller: UserEditController
			});

			$routeProvider.otherwise({
				templateUrl: 'partials/user/index.html',
				controller: UserIndexController
			});

			$routeProvider.when('/skill/create', {
                templateUrl: 'partials/skill/create.html',
            	controller: SkillCreateController
            });

            $routeProvider.when('/skill/edit/:id', {
            	templateUrl: 'partials/skill/edit.html',
            	controller: SkillEditController
            });

            $routeProvider.when('/skill', {
                templateUrl: 'partials/skill/index.html',
            	controller: SkillIndexController
            });

            $routeProvider.when('/project/create', {
                templateUrl: 'partials/project/create.html',
                controller: ProjectCreateController
            });

            $routeProvider.when('/project/edit/:id', {
              	templateUrl: 'partials/project/edit.html',
               	controller: ProjectEditController
            });

            $routeProvider.when('/project', {
                templateUrl: 'partials/project/index.html',
               	controller: ProjectIndexController
            });
			
			$locationProvider.hashPrefix('!');
		} ]
		
	).run(function($rootScope, $location, $cookieStore, UserService) {});

function UserIndexController($scope, UserService) {
	
	$scope.users = UserService.query();
	
	$scope.deleteEntry = function(user) {
		user.$remove(function() {
			$scope.users = UserService.query();
		});
	};
};

function UserEditController($scope, $routeParams, $location, UserService) {

	$scope.user = UserService.get({id: $routeParams.id});
	
	$scope.save = function() {
		$scope.user.$save(function() {
			$location.path('/');
		});
	};
};

function UserCreateController($scope, $location, UserService) {
	
	$scope.user = new UserService();
	
	$scope.save = function() {
		$scope.user.$save(function() {
			$location.path('/');
		});
	};
};

function SkillIndexController($scope, SkillService) {

	$scope.skills = SkillService.query();

	$scope.deleteEntry = function(skill) {
		skill.$remove(function() {
			$scope.skills = SkillService.query();
		});
	};
};

function SkillEditController($scope, $routeParams, $location, SkillService) {

	$scope.skill = SkillService.get({id: $routeParams.id});

	$scope.save = function() {
		$scope.skill.$save(function() {
			$location.path('/skill');
		});
	};
};

function SkillCreateController($scope, $location, SkillService) {

	$scope.skill = new SkillService();

	$scope.save = function() {
		$scope.skill.$save(function() {
			$location.path('/skill');
		});
	};
};

function ProjectIndexController($scope, ProjectService) {

	$scope.projects = ProjectService.query();

	$scope.deleteEntry = function(project) {
		project.$remove(function() {
			$scope.projects = ProjectService.query();
		});
	};
};

function ProjectEditController($scope, $routeParams, $location, ProjectService) {

	$scope.project = ProjectService.get({id: $routeParams.id});

	$scope.save = function() {
		$scope.project.$save(function() {
			$location.path('/project');
		});
	};
};


function ProjectCreateController($scope, $location, ProjectService) {

	$scope.project = new ProjectService();

	$scope.save = function() {
		$scope.project.$save(function() {
			$location.path('/project');
		});
	};
};

var services = angular.module('exampleApp.services', ['ngResource']);

services.factory('UserService', function($resource) {
	return $resource('rest/users/:id', {id: '@id'});
});

services.factory('SkillService', function($resource) {
	return $resource('rest/skills/:id', {id: '@id'});
});

services.factory('ProjectService', function($resource) {
	return $resource('rest/projects/:id', {id: '@id'});
});