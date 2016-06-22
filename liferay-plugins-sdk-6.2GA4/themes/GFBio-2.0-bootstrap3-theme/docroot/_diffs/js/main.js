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
			body.append('<div class="icon-toggle-dockbar vertical-dockbar-close"><i class="fa fa-bars"></i></div>');
			body.append('<div class="layer-mobile visible-phone vertical-dockbar-close"></div>');

			var toggleDockbar = A.one('.icon-toggle-dockbar');
			var toggleDockbarClose = A.all('.vertical-dockbar-close');
			var toggleDockbarIcon = A.one('.icon-toggle-dockbar .fa fa-bars');

			if (toggleDockbar) {
				toggleDockbarClose.on(
					'click',
					function() {
						portletDockbar.toggleClass('over');
						toggleDockbar.toggleClass('over');
						toggleDockbarIcon.toggleClass('icon-remove');
						toggleDockbarIcon.toggleClass('fa fa-bars');
						body.toggleClass('lfr-has-dockbar-vertical');
					}
				);
			}
		};
		/*
		var parentSearch = A.one('#page-search');
		parentSearch.get('#search').remove(true);
		
		parentSearch.append('<button id="navbar-search-submit" type="submit" class="btn btn-default"><i class="fa fa-search" aria-hidden="true"></i></button>');
	*/	
	}
	
	


);

/* ========================================================================= */
/*	Preloader
 /* ========================================================================= */

jQuery(window).load(function () {

    $("#preloader").fadeOut("slow");

});