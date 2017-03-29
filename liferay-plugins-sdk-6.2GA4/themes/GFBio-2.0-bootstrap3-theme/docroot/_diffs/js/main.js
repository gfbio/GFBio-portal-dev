AUI().ready(
				'liferay-navigation-interaction',
				'liferay-sign-in-modal',
				function(A) {
					var navigationNode = A.one('#navigation');

					if (navigationNode) {
						navigationNode.plug(Liferay.NavigationInteraction);
					}

					var signIn = A.one('#sign-in');

					if (signIn && signIn.getData('redirect') !== 'true') {
						signIn.plug(Liferay.SignInModal);
					}

					// Dockbar vertical JS, if dockbar is present

					var portletDockbar = A.one('#_145_dockbar');

					if (portletDockbar) {
						var body = A.one('.aui body');
						body
								.append('<div class="icon-toggle-dockbar vertical-dockbar-close"><i class="fa fa-user"></i></div>');
						body
								.append('<div class="layer-mobile visible-phone vertical-dockbar-close"></div>');

						var toggleDockbar = A.one('.icon-toggle-dockbar');
						var toggleDockbarClose = A
								.one('.vertical-dockbar-close');
						// var toggleDockbarIcon = A.one('.icon-toggle-dockbar
						// .fa .fa-user');

						if (toggleDockbar) {
							toggleDockbar
									.on(
											'click',
											function() {
												if (portletDockbar
														.hasClass('over')) {
													portletDockbar
															.removeClass('over');
													toggleDockbar
															.removeClass('over');
													body
															.removeClass('lfr-has-dockbar-vertical');
												} else {
													portletDockbar
															.addClass('over');
													toggleDockbar
															.addClass('over');
													body
															.addClass('lfr-has-dockbar-vertical');
												}

												// this code return error,
												// consider to remove it
												// toggleDockbarIcon.toggleClass('icon-remove');
												// toggleDockbarIcon.toggleClass('fa
												// fa-user');

												// toggle navigation menu when
												// dockbar icon is clicked
												var navigationDiv = $('#nav');
												if (navigationDiv
														.hasClass('open')) {
													navigationDiv
															.removeClass('open');
													navigationDiv
															.addClass('hide');
												}
											});
						}
					}
					;
				});

// ------------- Responsive menu class------------------//
AUI().ready(function() {
	var menuToggleBtn = $('#responsiveMenuToggle'); // get our
	// toggle
	// button
	var navigationDiv = $('#nav'); // get default navigation
	// div element
	var body = $('.aui body');
	if (menuToggleBtn && navigationDiv) {
		// do nothing when toggle button not present (user not
		// signed in) or if
		// navigation is not present
		// otherwise assign simple function that'll toggle
		// 'open' menu class on
		// default navigation which will cause it to open, same
		// for menu toggle
		// button
		menuToggleBtn.on('click', function(event) {
			if (navigationDiv.hasClass('open')) {
				menuToggleBtn.removeClass('open');
				navigationDiv.removeClass('open');
				navigationDiv.addClass('hide');
				body.removeClass('lfr-has-dockbar-vertical');
			} else {
				// expand the menu bar
				menuToggleBtn.addClass('open');
				navigationDiv.addClass('open');
				navigationDiv.removeClass('hide');
				// hide dockbar
				var portletDockbar = $('#_145_dockbar');
				if (portletDockbar) {
					portletDockbar.removeClass('over');
				}
				body.removeClass('lfr-has-dockbar-vertical');
			}
		}

		);
		/*
		 * #965 Responsive layout: second tier menu is not working on mobile
		 * device
		 */
		$('.dropdown').on('mouseenter mouseleave', function() {
			if ($(document).width() > 979){
				$(this).toggleClass("open");
			}
		});
		$('.dropdown').on('tap', function() {
			if ($(document).width() <= 979){
			$(this).toggleClass("open");
			}
		});
		$('.dropdown').on('click', function() {
			if ($(document).width() <= 979){
			$(this).toggleClass("open");
			}
		});
	}
	// clear all the extension class from mobile responsive
	// layout
	window.onresize = function(event) {
		var navigationDiv = $('#nav'); // get default
		// navigation ul element
		navigationDiv.removeClass('hide');
		navigationDiv.removeClass('open');
	};
}

);

// adds an icon in front of external text links
AUI().use('aui-base','aui-io-request', 'node','selector-css3',function(A){


  A.all('.journal-content-article a[href^="http://"],.journal-content-article a[href^="https://"]').each(function(object) {
    var link= object.html();
    


     if(link){
	
    	 object.html('<i aria-hidden="true" class="fa fa-external-link" style="font-size:12px;"></i> ' + link);
	}
  });
});

/*removes external icons from footer*/
AUI().use('aui-base','aui-io-request', 'node','selector-css3',function(A){

	A.all('.journal-content-article .footer a[href^="http://"],.journal-content-article .footer a[href^="https://"]').each(function(object) {
	    var linkText= object.text();

	     if(linkText){
	       object.html(linkText);
		}
	      });
	});
