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
			body.append('<div class="icon-toggle-dockbar vertical-dockbar-close"><i class="fa fa-user"></i></div>');
			body.append('<div class="layer-mobile visible-phone vertical-dockbar-close"></div>');

			var toggleDockbar = A.one('.icon-toggle-dockbar');
			var toggleDockbarClose = A.one('.vertical-dockbar-close');
//			var toggleDockbarIcon = A.one('.icon-toggle-dockbar .fa .fa-user');

			if (toggleDockbar) {
				toggleDockbar.on('click',function() {
						if (portletDockbar.hasClass('over')){
							portletDockbar.removeClass('over');
							toggleDockbar.removeClass('over');	
//							body.removeClass('lfr-has-dockbar-vertical');
						}else{
							portletDockbar.addClass('over');
							toggleDockbar.addClass('over');	
//							body.addClass('lfr-has-dockbar-vertical');
						}
							
						// this code return error, consider to remove it
//						toggleDockbarIcon.toggleClass('icon-remove');
//						toggleDockbarIcon.toggleClass('fa fa-user');

						// toggle navigation menu when dockbar icon is clicked
						var navigationDiv = $('#nav');
						var navigationHeader = $('#navigation');
						var body = $('body');
			          	if (navigationDiv.hasClass('open')){
			          		navigationDiv.removeClass('open');
			          		navigationDiv.addClass('hide');
										body.css("overflow-y","unset");
										navigationHeader.css("height","unset");
			          	}
					});
			}
		};
	});

AUI().ready(function() {
	    	var wow = new WOW({
			    offset: 75,          // distance to the element when triggering the animation (default is 0)
			    mobile: false,       // trigger animations on mobile devices (default is true)
			    animateClass: 'aui animated'
			});
			
			wow.init();
	    }
	);

AUI().ready(function(){
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
	

AUI().ready(function(){
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
			
			
			$(window).scroll(function () {

		        var useTransparent = true;
		        if (typeof transparentNaviOnLoad !== 'undefined') {
		            useTransparent = transparentNaviOnLoad;
		        }
		        if ($(window).scrollTop() > 100) {
		         
		            if (useTransparent) {
		                $(".aui .navbar-fixed-top").addClass("navigation-shadow");
		            }

		        } else {
		            
		            if (useTransparent) {
		                $(".aui .navbar-fixed-top").removeClass("navigation-shadow");
		            }
		        }
		       
		    });
			
});

AUI().ready(
		function(){
			// Set preloader
				$(".loader-box").fadeOut();
				$(".preloader").delay(400).fadeOut("slow");
			// Dropdown Menu Fade
		    $(".aui .dropdown").hover(
		        function () {
		            $('.aui .dropdown-menu', this).stop().fadeIn("slow");
		        },
		        function () {
		            $('.aui .dropdown-menu', this).stop().fadeOut("slow");
		        });
			
});

//------------- Responsive menu class------------------//
AUI().ready(function(){
		var menuToggleBtn = $('#responsiveMenuToggle'); // get our toggle button
		var navigationDiv = $('#nav'); // get default navigation div element
		var navigationHeader = $('#navigation');
		var body = $('body');
		if (menuToggleBtn && navigationDiv) { 
		// do nothing when toggle button not present (user not signed in) or if navigation is not present
		// otherwise assign simple function that'll toggle 'open' menu class on default navigation which will cause it to open, same for menu toggle button
			menuToggleBtn.on('click', function (event) {
		        	if (navigationDiv.hasClass('open')){
		        		menuToggleBtn.removeClass('open');
		        		navigationDiv.removeClass('open');
		        		navigationDiv.addClass('hide');
						body.removeClass('lfr-has-dockbar-vertical');

    				/*https://project.gfbio.org/issues/1288*/
    				/*scrolling moves the page in the background*/
    				body.css("overflow-y","unset");
    				navigationHeader.css("height","unset");
		      }else{
		        		// expand the menu bar 
		        		menuToggleBtn.addClass('open');
		        		navigationDiv.addClass('open');
		        		navigationDiv.removeClass('hide');
		        		// hide dockbar
						var portletDockbar = $('#_145_dockbar');
						if (portletDockbar){
							portletDockbar.removeClass('over');
		        }
				body.removeClass('lfr-has-dockbar-vertical');

				/*https://project.gfbio.org/issues/1288*/
				/*scrolling moves the page in the background*/
				if($(document).width()<768) {
					console.log("Vertical Menu");
					body.css("overflow-y","hidden");
					navigationHeader.css("height","85vh");
				} else {
					console.log("Horizontal Menu");
				}
			}
		});
		
		/*
		 * #965 Responsive layout: second tier menu is not working on mobile
		 * device
		 */
		var isMouse = false;
		$('.dropdown-toggle').on('mouseenter', function() {
			isMouse = true;
			var isMenuItem = ($(this).attr('role')=='menuitem');
			if (isMenuItem){
				var thisIsOpen = $(this).parent().hasClass('open');
				var openDropdown = $('.dropdown.open');
				openDropdown.removeClass('open');
				if (!thisIsOpen){
					$(this).parent().addClass("open");
				}else{
					$(this).parent().removeClass("open");
			  }
      }
		});
		$('.dropdown').on('tap', function() {
			console.log('dropdown tapped.');
		});
		$('.dropdown').on('touchstart', function() {
			console.log('dropdown touchstart.');
		});

		//ignore click event when using a touch device
		$('a.dropdown-toggle').on('click', function(event) {
			console.log('dropdown-toggle clicked.');
			var isMenuItem = ($(this).attr('role')=='menuitem');
			if (isMenuItem){
				if (isMouse){
					console.log('Mouse enabled. Propagate to the link.');
					return true;
				}
				else {
					console.log('Touch eabled.');
					// if this item has no children, propagate to the link
					var attr = $(this).attr('aria-haspopup');
					if (typeof attr == typeof undefined || !attr){
						console.log('This menuitem has no children, propagate to the link');
						console.log('propagate to the link.');
						return true;
					}
					event.preventDefault();
					event.stopPropagation();
				}
			}
		});
		
		var timeout = 0;
		var lastTap = 0;
		$('a.dropdown-toggle').on('touchstart', function(event) {
			isMouse = false;
			console.log('dropdown-toggle touchstart.');
			var isMenuItem = ($(this).attr('role')=='menuitem');
			if (isMenuItem){
	    	// listen to double tap event when using a mobile layout
				var attr = $(this).attr('aria-haspopup');
				if (typeof attr == typeof undefined || !attr){
					return true;
				}
			    var currentTime = new Date().getTime();
			    var tapLength = currentTime - lastTap;
			    clearTimeout(timeout);
		    	
			    if (tapLength < 500 && tapLength > 0) {
			    	// this is two times tap 
			        window.location = this.href;
			        return true; 
			    }else{
			    	// this is one time tap
					//$(this).parent().toggleClass("open");
					var thisIsOpen = $(this).parent().hasClass('open');
					var openDropdown = $('.dropdown.open');
					openDropdown.removeClass('open');
					if (!thisIsOpen){
						$(this).parent().addClass("open");
					}else{
						$(this).parent().removeClass("open");
					}
			    	timeout = setTimeout(function() {
			            // set timeout after the first tap
			            clearTimeout(timeout);
				        return false;
			        }, 500);
			    }
			    lastTap = currentTime; 
		        return false;
			}
			return true;
		});
	}
    }
		// clear all the extension class from
    // mobile responsive layout
		/*window.onresize = function(event) {
		    var navigationDiv = $('#nav'); 
        // get default navigation ul element
		    navigationDiv.removeClass('hide');
		    navigationDiv.removeClass('open');
		};	*/
);
//------------- End responsive menu class------------------//


