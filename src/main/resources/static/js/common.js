
function doPost(url,data){
    let resultData;
    console.log("doPost:" + url)
    $.ajax({
        url:url,
        type:"post",
        contentType:"application/json",
        dataType:"json",
        async:false,
        data: data,
        success:function (result) {
            console.log(result)
            resultData = result;
        },
        error:function (result) {
            resultData = result;
        }
    })
    return resultData
}

function doFormPost(url,data){
    let resultData;
    console.log("doFormPost:" + url)
    $.ajax({
        url:url,
        type:"post",
        contentType:false,
        processData: false,
        dataType:"json",
        async:false,
        data: data,
        success:function (result) {
            console.log(result)
            resultData = result;
        },
        error:function (result) {
            resultData = result;
        }
    })
    return resultData
}