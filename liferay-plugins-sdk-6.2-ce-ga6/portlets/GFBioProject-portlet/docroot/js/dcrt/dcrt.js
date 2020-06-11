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
