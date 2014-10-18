$(document).ready(function(){
	// Efeito crescimento barra da página de login
	$(".login_form .input_text").on({
		focusin: function() {
			$(this).parent(".login").find(".input_text").addClass("focused")
		},
		focusout: function() {
			$(this).parent(".login").find(".input_text").removeClass("focused")
		}
	});

	// Radio Button formulário de registro
	$(".register_form .radio_group .input_radio").on({
		click: function() {
			$(".register_form .radio_group span").removeClass("checked");
			$(this).parent("span").addClass("checked");
		}
	})

	// Troca das imagens fundo login

	// Submenu usuário
	var submenu = $(".user_submenu");
	submenu.hide();
	$("#header .user, .user_submenu a").on({
		click: function() {
			if ($(submenu).is(":visible")) {
				$("#header .user").removeClass("active");
				$(submenu).fadeOut();
			} else {
				$("#header .user").addClass("active");
				$(submenu).fadeIn();
			}
		}
	});

	$(submenu).on({
		mouseleave: function() {
			$("#header .user").removeClass("active");
			$(submenu).fadeOut();
		}
	});

	// Top 12
	$($("#top12 .bar")).on({
		click: function() {
			$(this).parent("#top12").toggleClass("hidden");
		}
	})

	// // Alerta de erro de login
	// function realizarLogin() {
	// 	var url = ""

	// 	$.ajax ({
	// 		url: root,
	// 		type: "POST",
	// 		dataType: "html",
	// 		success: function(a) {
	// 			if (a) {
	// 				window.location.href = root + "/home/index";
	// 			}  else {
	// 				$(".login_form .input_text").addClass("error");
	// 			}
	// 		}
	// 	})
	// }

	// $(".login_form .button_submit").on({
	// 	click: function() {
	// 		realizarLogin();
	// 	}
	// })
});