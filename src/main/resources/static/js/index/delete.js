function feed_deleteBtn(index) {
    $.ajax({
        type: 'POST',
        url: '/feed/delete',
        data: {
            'Feed_index': index
        },
        success: function (data) {
            $('#feed-feedTable').html(data)
        },
        error: function (err) {
            console.log(err)
            alert("操作失败，请刷新重新尝试！")
        }
    })
}

function feedIngredient_deleteBtn(id) {
    $.ajax({
        type: 'POST',
        url: '/feedIngredient/delete',
        data: {
            'id': id
        },
        success: function (data) {
            $('#FeedIngredientTable').html(data)
        },
        error: function (err) {
            console.log(err)
            alert("操作失败，请刷新重新尝试！")
        }
    })
}

function con_deleteBtn(id) {
    $.ajax({
        type: 'POST',
        url: '/contract/delete',
        data: {
            'id': id
        },
        success: function (data) {
            $('#feedNutritionTable').html(data)
        },
        error: function (err) {
            console.log(err)
            alert("操作失败，请刷新重新尝试！")
        }
    })
}

function metabolism_deleteBtn(id) {
    $.ajax({
        type: 'POST',
        url: '/metabolism/delete',
        data: {
            'id': id
        },
        success: function (data) {
            $('#MetabolismTable').html(data)
        },
        error: function (err) {
            console.log(err)
            alert("操作失败，请刷新重新尝试！")
        }
    })
}

function word_deleteBtn(id) {
    $.ajax({
        type: 'POST',
        url: '/word/delete',
        data: {
            'id': id
        },
        success: function (data) {
            $('#WordTable').html(data)
        },
        error: function (err) {
            console.log(err)
            alert("操作失败，请刷新重新尝试！")
        }
    })
}

function microbe_deleteBtn(id) {
    $.ajax({
        type: 'POST',
        url: '/microbe/delete',
        data: {
            'id': id
        },
        success: function (data) {
            $('#MicrobeTable').html(data)
        },
        error: function (err) {
            console.log(err)
            alert("操作失败，请刷新重新尝试！")
        }
    })
}
