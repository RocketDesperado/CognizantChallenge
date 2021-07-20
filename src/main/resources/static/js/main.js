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
					description = "Provide Fibonacci algorithm solution for the first 11 outputs. Please, separate every number with one empty space. Output should be trimmed.";
					break;
				case "IS_PALINDROME" :
					description = "Check whether given phrase is palyndrome or not using standart libraries. Output should be true or false. The phrase is: WAS IT A CAR OR A CAT I SAW";
					break;
				case "REVERSE_STRING" :
					description = "Reverse given String using standart libraries. The String is: YOU_ARE_HIRED";
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


