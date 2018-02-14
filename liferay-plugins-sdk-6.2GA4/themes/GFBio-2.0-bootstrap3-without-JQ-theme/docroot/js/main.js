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
						// var toggleDockbarIcon = A.one('.icon-toggle-dockbar
						// .fa .fa-user');

						if (toggleDockbar) {
							toggleDockbar.on('click',function() {
								if (portletDockbar.hasClass('over')) {
									portletDockbar.removeClass('over');
									toggleDockbar.removeClass('over');
									body.removeClass('lfr-has-dockbar-vertical');
								} else {
									portletDockbar.addClass('over');
									toggleDockbar.addClass('over');
									body.addClass('lfr-has-dockbar-vertical');
								}

								// this code return error,
								// consider to remove it
								// toggleDockbarIcon.toggleClass('icon-remove');
								// toggleDockbarIcon.toggleClass('fa
								// fa-user');

								// toggle navigation menu when
								// dockbar icon is clicked
								var navigationDiv = $('#nav');
								var navigationHeader = $('#navigation');
								var body = $('body');
								if (navigationDiv.hasClass('open')) {
									navigationDiv.removeClass('open');
									navigationDiv.addClass('hide');
									body.css("overflow-y","unset");
									navigationHeader.css("height","unset");
								}
							});
						}
					};
				});

// ------------- Responsive menu class------------------//
AUI().ready(function() {
	// get our toggle button
	var menuToggleBtn = $('#responsiveMenuToggle'); 
	// get default navigation div element
	var navigationDiv = $('#nav'); 
	var navigationHeader = $('#navigation');
	var body = $('body');
	if (menuToggleBtn && navigationDiv) {
		// do nothing when toggle button not present (user not
		// signed in) or if navigation is not present
		// otherwise assign simple function that'll toggle
		// 'open' menu class on default navigation
		// which will cause it to open, same
		// for menu toggle button
		menuToggleBtn.on('click', function(event) {
			if (navigationDiv.hasClass('open')) {
				// hide menu bar
				menuToggleBtn.removeClass('open');
				navigationDiv.removeClass('open');
				navigationDiv.addClass('hide');
				
				body.removeClass('lfr-has-dockbar-vertical');
				/*https://project.gfbio.org/issues/1288*/
				/*scrolling moves the page in the background*/
				body.css("overflow-y","unset");
				navigationHeader.css("height","unset");
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
				/*https://project.gfbio.org/issues/1288*/
				/*scrolling moves the page in the background*/
				console.log($(document).width());
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
	// clear all the extension class from 
	// mobile responsive layout
	/*window.onresize = function(event) {
		var navigationDiv = $('#nav'); 
		// get default navigation ul element
		navigationDiv.removeClass('hide');
		navigationDiv.removeClass('open');
		var navigationHeader = $('#navigation');
		var body = $('body');
		body.css("overflow-y","unset");
		navigationHeader.css("height","unset");
	};*/
	
    // show citation on printable page
    if (document.getElementById("printOnly") != null){
        var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
                          "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        var n =  new Date();
        var y = n.getFullYear();
        var m = monthNames[n.getMonth()];
        var d = n.getDate();
        var date = d + " " + m + " " + y;
        var url = window.location.href;
        if (url.lastIndexOf('?')>=0){
            url = url.substring(0,url.lastIndexOf('?'));
        }
        url = url.split("/-/")[0];

        var pageTitle = $(document).find("title").text();
        pageTitle = pageTitle.substring(0, pageTitle.indexOf(' - GFBio'));
        var printFooter = "<div class='by-nc'></div>"
        	+"<p>Recommended citation:</br>German Federation for Biological Data ("+y
        	+"). GFBio Training Materials: Data Life Cycle Fact-Sheet: "+pageTitle+"." 
        	+" Retrieved "+date+" from "+url+".</p>";
        document.getElementById("printOnly").innerHTML=printFooter;
    }
}

);



// adds an icon in front of external text links
AUI().use('aui-base','aui-io-request', 'node','selector-css3',function(A){


  A.all('.journal-content-article a[href^="http://"],.journal-content-article a[href^="https://"]').each(function(object) {
    var link= object.html();
    
     if(link){
	
    	 object.html('<span id="extIcon"><i aria-hidden="true" class="fa fa-external-link" style="font-size:12px;"></i></span> ' + link);
	}
  });
});

/*removes external icons from footer*/
AUI().use('aui-base','aui-io-request', 'node','selector-css3',function(A){

	A.all('.footer a[href^="http://"],.footer a[href^="https://"]').each(function(object) {
	    var linkHTML = object.html();
	    var child = object.one('#extIcon');
	    child.remove();
	     
	      });
	});


(function($) {
    $(document).ready(function() {
		var hash = window.location.hash;
		if (hash.length >0){
			// show the accordion that is linked via url
			var index = $(hash).index('div.toggler');
		    $(document).accordion({
			    // Put custom options here
			    heightStyle: 'content',
			    header: 'div.toggler',
			    collapsible: true,
			    active: index,
			 });
			$('html,body').animate({ //auto scroll
			 	scrollTop: $(hash).offset().top-80
			 //minus the menu height
			});
		}else{
	        //if no accordion is called
	        $(document).accordion({
		        // Put custom options here
		        heightStyle: 'content',
		        header: 'div.toggler',
		        collapsible: true,
		        active: false,
		    });
      	}
      var activate = function(tog) {
        var tgs = $('div.toggler');
        
        // read the position for autoscroll
        var togTop = tog.offset().top;
        var pTogTop = $('div.accordion.ui-accordion-content-active').prev().offset().top;
        var pAccordionHeight = 0
        // if the newly open accordion is below the current one,
        // get the previously opened accordion height
        if (pTogTop < togTop) 
        	pAccordionHeight = $('div.accordion.ui-accordion-content-active').height();
        	
        tgs.removeClass('active');
        tog.addClass('active');
        tgs.next('div.accordion').attr('aria-hidden', 'true');
        tog.next('div.accordion').attr('aria-hidden', 'false');
        
         $('html,body').animate({
         	// tog.top alone doesn't work here because the old accordion 
         	// is open, so we have to minus the old accordion height
		     scrollTop: togTop-pAccordionHeight-65
		  });
      };
	
      $('div.toggler').focus(function(e) {
        $('div.toggler').attr('tabindex', 0);
        $(this).attr('tabindex', -1);
      }).blur(function() {
        $(this).attr('tabindex', 0);
      }).click(function() {
        activate($(this));
      }).keypress(function(event) {
        if (event.keyCode == 13) activate($(this));
      });
      
    });
  })(jQuery);
  