(function($) {

	"use strict";

	$(document).ready(function () {
		// Form
		var contactForm = function() {
			if ($('#form').length > 0 ) {
				$( "#form" ).validate( {
					rules: {
						name: "required",
						solution: "required"
					},
					messages: {
						name: "Please enter your name",
						solution: "Please check your solution code",
					},

				});
			}
		};
		contactForm();

		var myMeth = function () {
			var description
			switch ($('#task option:selected').val()) {
				case "FIBONACCI":
					description = "Provide Fibonacci algorithm solution for the first 11 outputs. Please, separate every number with one empty space. Result should be trimmed.";
					break;
				case "BINARY_SEARCH" :
					description = "Provide Binary Search algorithm solution";
					break;
				default :
					description = "";
			}
			funcCheckTas()
			$("#description").text(description);
		}
		$("#task").change(myMeth)

		var funcCheckTas = function () {
			if ($('#task option:selected').val() !== "val321") {
				$("#btnSubmit").removeAttr("disabled")
			} else {
				$("#btnSubmit").prop("disabled", true)
			}
		}
		funcCheckTas()

	})

})(jQuery);


