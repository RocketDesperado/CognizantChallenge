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
			let perem = $('#task option:selected').val();
			var description
			switch (perem) {
				case "FIBONACCI":
					description = "FIBB";
					break;
				case "BINARY_SEARCH" :
					description = "BIN SEARCH";
					break;
				default :
					description = "";
			}
			funcCheckTas()
			$("#description").text(description);
		}
		$("#task").change(myMeth)

		var funcCheckTas = function () {
			let perem = $('#task option:selected').val();
			if (perem !== "val321") {
				// $("#btnSubmit").prop("disabled", false)
				$("#btnSubmit").removeAttr("disabled")
			} else {
				$("#btnSubmit").prop("disabled", true)
			}
		}
		funcCheckTas()

	})




})(jQuery);


