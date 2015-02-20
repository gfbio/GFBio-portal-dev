

/////////////////////////////////////////////////// tabs ////////////////////////////////////////////////////


function showSection( sectionID ) {
    $('div.section').css( 'display', 'none' );
    $('div'+sectionID).css( 'display', 'block' );
    $('ul#verticalNav li a').removeClass('active');
    $('a#link'.concat(sectionID.substring(4))).addClass('active');

}

$(document).ready(function(){
    if ($('ul#verticalNav li a').length && $('div.section').length ) {
        $('div.section').css( 'display', 'none' );
        $('ul#verticalNav li a').click(function() {
            showSection( $(this).attr('href') );
        });
        if(window.location.hash) 
           showSection( window.location.hash);
        else 
            $('ul#verticalNav li:first-child a').click();
    }
});
