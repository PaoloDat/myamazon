function go() {
    // window.location = 'cartshow';
    window.open("/myamazon/cartshow", "hello", "width=900, height=600, location=no, left=150, top=50");
};



$(document).ready(function() {

    $(':button.bun').click(function() {
        var name = $(this).data('name'),
            value = $("input[name='" +name+ "']").val();
        pr = $("td[id='" +name+ "']").html();
        $.ajax({
            type: "GET",
            url: "/myamazon/cart",
            data: {id: Number(name), price: pr, quantity: Number(value) },
            success:function (responseText) {
            var pos = responseText.indexOf('=');
            var total_q = responseText.substring(0, pos);
            var total_p = responseText.substring(pos+1, responseText.length);
            $("#quantity").text(total_q);
            $("#total").text(total_p);
             }
        })
    });
});











// $.post("/cart", {price: pr, quantity: Number(value)}, function (responseJson) {
//
// var $select = $('#cart_tr');
// $select.find("td").remove();
// $.each(responseJson, function (key, value) {
//
//     $("<td>").val(key).text(value).appendTo($select);
//
// })
//
// })


//
// var $select = $('#cart_tr');
// $select.find("td").remove();
// $.each(responseJson, function (key, value) {
//
//     $("<td>").val(key).text(value).appendTo($select);
//
// })
//
// })



// var $select = $('#cart');
// $select.find("p").remove();
// $.each(responseJson, function (key, value) {
//     $("<p>").val(key).text(value).appendTo($select);
//
//
// })

// var $ul = $("<ul>").appendTo($("#cart"));
// $("<li>").text(';dedede').appendTo($ul);

// $.post("/cart", {price: pr, quantity: Number(value)}, function (responseText) {
//
//     $("#total").text(responseText);
// })








// $.post("/cart", {price: pr, quantity: Number(value)}, function (responseJson) {
//
// var $select = $('#cart_tr');
// $select.find("td").remove();
// $.each(responseJson, function (key, value) {
//
//     $("<td>").val(key).text(value).appendTo($select);
//
// })
//
// })


//
// var $select = $('#cart_tr');
// $select.find("td").remove();
// $.each(responseJson, function (key, value) {
//
//     $("<td>").val(key).text(value).appendTo($select);
//
// })
//
// })



// var $select = $('#cart');
// $select.find("p").remove();
// $.each(responseJson, function (key, value) {
//     $("<p>").val(key).text(value).appendTo($select);
//
//
// })

// var $ul = $("<ul>").appendTo($("#cart"));
// $("<li>").text(';dedede').appendTo($ul);

// $.post("/cart", {price: pr, quantity: Number(value)}, function (responseText) {
//
//     $("#total").text(responseText);
// })



// function PopUpShow(){
//     $("#popup1").show();
// }
// function PopUpHide(){
//     $("#popup1").hide();
// }


// $('#window_start').click(function (e) {
//     e.preventDefault();
//     $("#popup1").show();
// })
// $('#window-end').click(function (e) {
//     e.preventDefault();
//     $("#popup1").hide();
// })