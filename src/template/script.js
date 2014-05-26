$(document).ready(function() {
    $(".tablesorter").tablesorter();
    adjustBoxHeight();
});

function adjustBoxHeight() {
    boxes = $('.box');
    var count = 0;
    var max = 0;
    var first = 0;
    var second = 0;
    boxes.each(function(index) {
        if (count === 0) {
            first = $(this);
            count++;
        } else if (count === 1) {
            second = $(this);
            max = first.height() >= second.height() ? first.height() : second.height();
            first.height(max);
            second.height(max);
            max = 0;
            count = 0;
        }
    });
}