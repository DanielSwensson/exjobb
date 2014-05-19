$(document).ready(function() {
    $(".tablesorter").tablesorter();

    boxes = $('.box');
    maxHeight = Math.max.apply(
        Math, boxes.map(function() {
            return $(this).height();
        }).get());
    boxes.height(maxHeight);
});