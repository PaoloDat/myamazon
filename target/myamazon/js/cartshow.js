$(document).ready(function() {
    var sum = 0;
    $('.newtotal').each(function () {
        var value = $(this).text();
        sum += parseInt(value)
    });
    $('#sum').text(sum);

    $(':button.dbbutton').click(function () {

        $.ajax({
            type: "GET",
            url: "/myamazon/addcart",
            success: function (responseText)
            {
            alert("Заказ добавлен в базу");
            }
        })
    })

});