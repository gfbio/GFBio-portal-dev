/////////////////////////////////////////   hide/show scripts  //////////////////////////////////////////////

//
function hideswitch(i,j) {
	visibleStateChoose(i);
	visibleStateChoose(j);
};


//
function showhide(j) {
	visibleStateChoose(j);
};

//
function visibleStateChoose(j) {
	(document.getElementById(j).className=="swHide") ? visibleShow(j) : visibleHide(j);
}


//
function visibleShow(j) {
	document.getElementById(j).className = "swMain";
};


//
function visibleHide(j) {
	document.getElementById(j).className = "swHide";
	var ele = document.getElementsByName(j);
    for(var i=0;i<ele.length;i++) {
        ele[i].checked = false;
    }
};

//
function visibleHideMore(elements) {
    elements = elements.length ? elements : [elements];
    for (var index = 0; index < elements.length; index++) {
        visibleHide(elements[index]);
    }
}

//
function hideFirstLevelLeft() {
    visibleHideMore(['taxon', 'alive', 'material', 'selection2']);
}

//
function hideSecondLevelLeft() {
    visibleHideMore(['alive', 'material']);
}

//
function hideFirstLevelRight() {
    visibleHideMore(['sequenced', 'selection2']);
}

//
function hideCategory(selection) {
	if (selection == "noselection") {
		document.getElementById("categories").className = "swHide";
	}
}

//
function categoryalert(label) {
	document.getElementById(label).setAttribute("style", "font-weight: bold");
	
	var searchEles = document.getElementById("categorylist").children;
	for(var i = 0; i < searchEles.length; i++) {
		var insidediv = searchEles[i].children;
		for(var j = 0; j < insidediv.length; j++) {
			if (insidediv(j).getAttribute("id") != label) {
				insidediv[j].setAttribute("style", "font-weight: normal");
			}
		}
	}
}
