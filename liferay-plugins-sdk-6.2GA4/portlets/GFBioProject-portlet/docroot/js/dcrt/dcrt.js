/*global $*/

//
function show(j) {
	'use strict';
	
	$(j).show();
}

//
function hide(j) {
    'use strict';
    
	$(j).hide();
	$('[name="' + j + '"]').each(function () {
        this.checked = false;
    });
}

//
function hideswitch(i, j) {
    'use strict';
    
	$(i).toggle();
	$(j).toggle();
}


//
function showhide(j) {
    'use strict';
    
	$(j).toggle();
}

//
function hideFirstLevelLeft() {
    'use strict';
    
	hide('#materialSelection');
	hide('#taxon');
	hide('#alive');
}


//
function hideFirstLevelRight() {
    'use strict';
    
	hide('#categorySelection');
    hide('#sequenced');
}

//
//function hideCategory(selection) {
//    'use strict';
//    
//	if (selection === "noselection") {
//		hide('#categories');
//	}
//}

//
//function categoryalert(label) {
//	document.getElementById(label).setAttribute("style", "font-weight: bold");
//	
//	var searchEles = document.getElementById("categorylist").children;
//	for(var i = 0; i < searchEles.length; i++) {
//		var insidediv = searchEles[i].children;
//		for(var j = 0; j < insidediv.length; j++) {
//			if (insidediv(j).getAttribute("id") != label) {
//				insidediv[j].setAttribute("style", "font-weight: normal; color: red;");
//			}
//		}
//	}
//}