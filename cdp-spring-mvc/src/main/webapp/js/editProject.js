(function($) {
		$(function() {
			var projectId = $('#projectId');

			if (projectId.val() !== undefined) {
                $.ajax({
                    'type' : 'GET',
                    'url' : '/cdp-spring-mvc/rest/projects/' + projectId.val() + '/users',
                    'contentType' : 'application/json',
                    'dataType' : 'json',
                    'success' : createUsersTokenInput,
                    'async' : true
                });
			}
		});

		function createUsersTokenInput(users) {
			$("#userIds").tokenInput('/cdp-spring-mvc/rest/users/email', {
				tokenValue : "id",
				propertyToSearch : "email",
				queryParam : "email",
				theme : "facebook",
				prePopulate : users
			});
		}
	})(jQuery);