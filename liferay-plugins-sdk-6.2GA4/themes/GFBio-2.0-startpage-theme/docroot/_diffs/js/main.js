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
		
		}
);

AUI().ready(


	    function() {
	    	var wow = new WOW({
			    offset: 75,          // distance to the element when triggering the animation (default is 0)
			    mobile: false,       // trigger animations on mobile devices (default is true)
			    animateClass: 'aui animated'
			});
			
			wow.init();
	    }
	);

AUI().ready(
		
		function(){
			/* TODO: put this back in if slider */
			$("#works, #testimonial").owlCarousel({
			    navigation: true,
			    pagination: false,
			    slideSpeed: 700,
			    paginationSpeed: 400,
			    singleItem: true,
			    navigationText: ["<i class='fa fa-angle-left fa-lg'></i>", "<i class='fa fa-angle-right fa-lg'></i>"]
			});	
		}
		
);
	

AUI().ready(
		
		function(){
			
			 /* ========================================================================= */
		    /*	Featured Project Lightbox
		     /* ========================================================================= */

		    $(".fancybox").fancybox({
		        padding: 0,

		        openEffect: 'elastic',
		        openSpeed: 650,

		        closeEffect: 'elastic',
		        closeSpeed: 550,

		        closeClick: true,

		        beforeShow: function () {
		            this.title = $(this.element).attr('title');
		            this.title = '<h3>' + this.title + '</h3>' + '<p>' + $(this.element).parents('.portfolio-item').find('img').attr('alt') + '</p>';
		        },

		        helpers: {
		            title: {
		                type: 'inside'
		            },
		            overlay: {
		                css: {
		                    'background': 'rgba(0,0,0,0.8)'
		                }
		            }
		        }
		    });
		}
);
		

AUI().ready(
		function(){
	
	/* ========================================================================= */
    /*	Menu item highlighting
     /* ========================================================================= */

    jQuery('.aui #nav-left').singlePageNav({
        offset: jQuery('.aui #nav-left').outerHeight(),
        filter: ':not(.external)',
        speed: 2000,
        currentClass: 'current',
        easing: 'easeInOutExpo',
        updateHash: true,
        beforeStart: function () {
            console.log('begin scrolling');
        },
        onComplete: function () {
            console.log('done scrolling');
        }
    });


    // yamm megamenu
    $(document).on('click', '.aui .yamm .dropdown-menu', function (e) {
        e.stopPropagation()
    });


    // Dropdown Menu Fade
    $(".dropdown").hover(
        function () {
            $('.aui .dropdown-menu', this).stop().fadeIn("slow");
        },
        function () {
            $('.aui .dropdown-menu', this).stop().fadeOut("slow");
        });


    //$(".navbar-fixed-top").hide();


    $(window).scroll(function () {

        // TODO: FIXME: remove this diry hack ... it prevents shadow-class for submissio page ....
        var useTransparent = true;
        if (typeof transparentNaviOnLoad !== 'undefined') {
            useTransparent = transparentNaviOnLoad;
        }
        if ($(window).scrollTop() > 100) {
            if (useTransparent) {
                $(".navbar-fixed-top").addClass("navigation-shadow");
            }


         } else {
       
              if (useTransparent) {
                $(".navbar-fixed-top").removeClass("navigation-shadow");
            }
        }
       
    });
	
}
		
);



