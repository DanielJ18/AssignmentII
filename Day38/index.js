angular.module("AppMod", ["ngRoute"])
	.controller("AppCtrl", ['$http','$routeParam' ,function($http,$routeParam) {
		var self = this;
		self.id = $routeParam.studentId;

		$http.get('http://localhost:8085/student')
			.then(function(resp){
				self.students = resp.data;
			},function(err) {

			});
			$http.get('http://localhost:8085/student/'+self.id)
			.then(function(resp){
				self.student = resp.data;
			},function(err) {

			});

	}])
	.config(['$routeProvider', function($routeProvider) {

		$routeProvider
		.when('/', {
			templateUrl: 'view/home.html'

		}).when('/student', {
			templateUrl: 'view/student.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'
        }).when('/student/;studentId', {
			templateUrl: 'view/detail.html',
			controller: 'AppCtrl',
			controllerAs: 'ctrl'
		}).when('/about', {
			templateUrl: 'view/about.html'

		})
		.otherwise({redirectTo: '/'});

	}]); // end config